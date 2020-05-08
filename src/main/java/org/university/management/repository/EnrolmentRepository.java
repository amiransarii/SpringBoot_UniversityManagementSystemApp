package org.university.management.repository;

import org.university.management.entity.Enrolment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrolmentRepository extends JpaRepository<Enrolment,String> {
    List<Enrolment> findAllByModuleId(String moduleId);
    List<Enrolment> findAllByStudentId(String studentId);

}
