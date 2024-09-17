package student.management.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class NavigationController {
	
	@GetMapping("/openAddStudentPage")
	public String openAddStudentPage() {
		return "addStudent";
	}
	
	@GetMapping("/openUpdateStudentPage")
	public String openUpdateStudentPage() {
		return "updateStudent";
	}
	
	@GetMapping("/openDeleteStudentPage")
	public String openDeleteStudentPage() {
		return "deleteStudent";
	}
	
	@GetMapping("/openSearchStudentPage")
	public String openSearchStudentPage() {
		return "searchStudent";
	}
	
	
	
	
	

}
