package com.diplom.service;

import com.diplom.dto.security.VisitDoctorResponse;
import com.diplom.dto.security.VisitPatientResponse;
import com.diplom.dto.security.VisitRequest;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface VisitService {

    void reserve(Long pid, VisitRequest visitRequest);

    void delete(@NotNull Long visitId);

    List<VisitDoctorResponse> getDoctorVisits(Long did);

    List<VisitPatientResponse> getPatientVisits(Long pid);
}
