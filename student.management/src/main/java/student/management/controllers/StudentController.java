package student.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import student.management.entities.Student;
import student.management.services.StudentService;

@Controller
public class StudentController {
	
	
	
	@GetMapping("/acceptStudent")
	public String acceptStudent(
			@RequestParam int roll,
			@RequestParam String name,
			@RequestParam String branch,
			@RequestParam int yop,
			@RequestParam double cgpa
			) {
		Student st=new Student(roll,name,branch,yop,cgpa);
		System.out.println(st);
		return "student data recieved";
	}
	
	
	
	@Autowired
	StudentService service;
	
	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute Student st, Model model) {
		service.addStudent(st);
		model.addAttribute("mssg","Student added succesfully");
		return "index";
	}
	
	@GetMapping("/searchStudent")
	public String searchStudent(@RequestParam int roll, Model model) {
		Student st=service.searchStudent(roll);
		model.addAttribute("student", st);
		return "displayStudent";
	}
	
	@PostMapping("/updateStudent")
	public String updateStudent(@ModelAttribute Student st,Model model) {
		service.updateStudent(st);
		model.addAttribute("mssg", "Student updated successfully");
	
		return "index";
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam int roll, Model model) {
		service.deleteStudent(roll);
		model.addAttribute("mssg","Student deleted succesfully");
		
		return "index";
		
	}
	
		
	@GetMapping("/fetchAllStudents")
	public String fetchAllStudents(Model model){
		List<Student> stList=service.fetchAllStudents();
		model.addAttribute("studentList", stList);
		return "displayAllStudents";
	}
	
	@GetMapping("/deleteAllStudents")
	public String deleteAllStudents(Model model){
		 service.deleteAllStudents();
		 model.addAttribute("mssg","All Students deleted..!");
		 return "index";
	}
	
	
	
	

}
