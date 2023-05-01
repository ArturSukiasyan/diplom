package com.jobick.dto.employee.response;

import com.jobick.dto.employee.EmployeeDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeResponseDto extends EmployeeDto {

    private String firstName;

    private String lastName;

    private String email;

    private Long id;

    private List<LanguageResponseDto> languages = new ArrayList<>();

    private List<EducationResponseDto> educations = new ArrayList<>();

    private List<ExperienceResponseDto> experiences = new ArrayList<>();

    private List<CertificateResponseDto> certificates = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeResponseDto)) return false;
        if (!super.equals(o)) return false;
        EmployeeResponseDto that = (EmployeeResponseDto) o;
        return getFirstName().equals(that.getFirstName()) && getLastName().equals(that.getLastName()) && getEmail().equals(that.getEmail()) && getId().equals(that.getId()) && Objects.equals(getLanguages(), that.getLanguages()) && Objects.equals(getEducations(), that.getEducations()) && Objects.equals(getExperiences(), that.getExperiences()) && Objects.equals(getCertificates(), that.getCertificates());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFirstName(), getLastName(), getEmail(), getId(), getLanguages(), getEducations(), getExperiences(), getCertificates());
    }
}
