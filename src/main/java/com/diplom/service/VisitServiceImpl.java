package com.diplom.service;

import com.diplom.dto.security.VisitRequest;
import com.diplom.entity.Visit;
import com.diplom.exception.BusyDoctorException;
import com.diplom.repository.DoctorRepository;
import com.diplom.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public void reserve(Long pid, VisitRequest visitRequest) {
        var did = visitRequest.getDoctorId();
        var visitDate = visitRequest.getVisitingDate();
        var doctorSessionDuration = doctorRepository.getSessionDuration(did);
        var sessionEndDate = visitDate.plusMinutes(doctorSessionDuration);

        if (visitRepository.existsSessionByDoctorBetweenDates(did, visitDate, sessionEndDate)){
            throw new BusyDoctorException(
                "Doctor is busy in that time by this id : " + did + ". His session duration is:" + doctorSessionDuration);
        } else {
            log.info("Doctor is free, and start reserving visit.");
            var visit = new Visit();
            visit.setVisitingDate(visitDate);
            visit.setDoctorId(did);
            visit.setPatientId(pid);
            var savedVisit = visitRepository.save(visit);
            log.info("Visit saved by this data:" + savedVisit);
        }
    }

    @Override
    public void delete(@NotNull Long vid) {
        log.info("Delete visit by id :" + vid);
        visitRepository.deleteById(vid);
    }
}
