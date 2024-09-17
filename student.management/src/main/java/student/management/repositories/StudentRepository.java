package student.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import student.management.entities.Student;

public interface StudentRepository
extends JpaRepository<Student, Integer>{

}
