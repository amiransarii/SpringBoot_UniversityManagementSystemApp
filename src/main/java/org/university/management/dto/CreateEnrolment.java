package org.university.management.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class CreateEnrolment {
    @NonNull
    String studentId;
    @NonNull
    String moduleId;
}
