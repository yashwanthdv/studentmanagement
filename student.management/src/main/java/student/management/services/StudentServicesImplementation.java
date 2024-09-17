package student.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.management.entities.Student;
import student.management.repositories.StudentRepository;

@Service
public class StudentServicesImplementation
implements StudentService{
	
	@Autowired
	StudentRepository repo;
	public String addStudent(Student st) {
		
		repo.save(st);
		return "student added";
	}
	
	public Student searchStudent(int roll) {
		return repo.findById(roll).orElse(null);
		
	}
	
	public String updateStudent(Student st) {
		repo.save(st);
		return "student updated ";
	}
	
	public boolean deleteStudent(int roll) {
		 if (repo.existsById(roll)) {
		        repo.deleteById(roll);
		        return true;  // Student found and deleted
		    } else {
		        return false; // Student not found
		    }
	}
	
	
	public List<Student> fetchAllStudents()
	{
		return repo.findAll();
	}
	
	
	
	public String deleteAllStudents() {
		 repo.deleteAll();
		 return "All students deleted";
	}

	
}
