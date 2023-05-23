package com.diplom.repository;

import com.diplom.entity.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByUsername(String username);

    Optional<Doctor> findByUsername(String username);

    @Query("SELECT d.sessionDuration from Doctor d where d.id = :id")
    Integer getSessionDuration(Long id);

}
