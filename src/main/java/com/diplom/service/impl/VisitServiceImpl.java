package com.diplom.service.impl;

import com.diplom.dto.security.VisitDoctorResponse;
import com.diplom.dto.security.VisitPatientResponse;
import com.diplom.dto.security.VisitRequest;
import com.diplom.entity.Visit;
import com.diplom.exception.BusyDoctorException;
import com.diplom.repository.DoctorRepository;
import com.diplom.repository.VisitRepository;
import com.diplom.service.DoctorService;
import com.diplom.service.EmailService;
import com.diplom.service.PatientService;
import com.diplom.service.VisitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static com.diplom.enums.EmailConstans.VISIT_CONFIRM_SUBJECT;

@Slf4j
@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final DoctorService doctorService;
    private final DoctorRepository doctorRepository;
    private final PatientService patientService;
    private final EmailService emailService;

    @Override
    public void reserve(Long pid, VisitRequest visitRequest) {
        var did = visitRequest.getDoctorId();
        var visitDate = visitRequest.getVisitingDate();
        var doctorSessionDuration = doctorRepository.getSessionDuration(did);
        var sessionEndDate = visitDate.plusMinutes(doctorSessionDuration);

        if (visitRepository.existsSessionByDoctorBetweenDates(did, visitDate, sessionEndDate)) {
            throw new BusyDoctorException(
                "Doctor is busy in that time by this id : " + did + ". His session duration is:" +
                doctorSessionDuration);
        } else {
            log.info("Doctor is free, and start reserving visit.");
            var visit = new Visit();
            visit.setVisitingDate(visitDate);
            visit.setDoctorId(did);
            visit.setPatientId(pid);
            var savedVisit = visitRepository.save(visit);
            sendMessageNotifications(pid, did, visitDate);
            log.info("Visit saved by this data:" + savedVisit);
        }
    }

    private void sendMessageNotifications(Long pid, Long did, LocalDateTime visitDate) {

        var doctor = doctorService.getById(did);
        var patient = patientService.getById(pid);
        String emailMessageForPatient =
            "You reserved visit in " + visitDate +
            " with doctor " + doctor.getFirstName() + " " + doctor.getLastName();
        String emailMessageForDoctor =
            "You have reservation visit in " + visitDate +
            " with patient " + patient.getFirstName() + " " + patient.getLastName();

        emailService.sendMessage(doctor.getEmail(), VISIT_CONFIRM_SUBJECT, emailMessageForDoctor);
        emailService.sendMessage(patient.getEmail(), VISIT_CONFIRM_SUBJECT, emailMessageForPatient);

    }

    @Override
    public void delete(@NotNull Long vid) {
        log.info("Delete visit by id :" + vid);
        visitRepository.deleteById(vid);
    }

    @Override
    public List<VisitDoctorResponse> getDoctorVisits(Long did) {
        var visits = visitRepository.findAllByDoctorId(did);
        var doctorVisits = new LinkedList<VisitDoctorResponse>();
        visits.forEach(visit -> doctorVisits.add(VisitDoctorResponse.builder()
                                                     .visitingDate(visit.getVisitingDate())
                                                     .patientId(visit.getPatientId())
                                                     .build())
        );

        return doctorVisits;
    }

    @Override
    public List<VisitPatientResponse> getPatientVisits(Long pid) {
        var visits = visitRepository.findAllByPatientId(pid);
        var patientVisits = new LinkedList<VisitPatientResponse>();
        visits.forEach(visit -> patientVisits.add(VisitPatientResponse.builder()
                                                      .visitingDate(visit.getVisitingDate())
                                                      .doctorId(visit.getDoctorId())
                                                      .build())
        );

        return patientVisits;
    }
}
