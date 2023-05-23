package com.diplom.service;

import com.diplom.dto.security.VisitRequest;

import javax.validation.constraints.NotNull;

public interface VisitService {

    void reserve(Long pid, VisitRequest visitRequest);

    void delete(@NotNull Long visitId);
}
