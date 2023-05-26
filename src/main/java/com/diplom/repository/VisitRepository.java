package com.diplom.repository;

import com.diplom.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    @Query(
        "select " +
        "case when count(v)> 0 then true " +
        "else false end " +
        "from Visit v where v.doctorId = :doctorId " +
        "and v.visitingDate >= :visitDate AND v.visitingDate <= :sessionEndDate"
    )
    boolean existsSessionByDoctorBetweenDates(
        Long doctorId,
        LocalDateTime visitDate,
        LocalDateTime sessionEndDate
    );

    @Query(
        "select " +
        "case when count(v)> 0 then true " +
        "else false end " +
        "from Visit v " +
        "where v.visitingDate >= :visitDate AND v.visitingDate <= :sessionEndDate"
    )
    List<Visit> findTodayVisits(
        LocalDateTime visitDate,
        LocalDateTime sessionEndDate
    );

    List<Visit> findAllByDoctorId(Long did);

    List<Visit> findAllByPatientId(Long pid);

}
