package com.school.students.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.school.students.dtos.Student;
import com.school.students.enums.MaritalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

// Takes in the Entity and the primary Key
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findById(Optional<Integer> id);

	List<Student> findAllByDateOfBirthBetween(Date dateOfBirthStart, Date dateOfBirthEnd);

	Optional<Student> findByStudentNumber(String studentNumber);

	List<Student> findAllByMaritalStatus(MaritalStatus martialStatus);

	long deleteByStudentNumber(String studentNumber);
}
