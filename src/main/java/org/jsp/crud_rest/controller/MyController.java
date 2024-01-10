package org.jsp.crud_rest.controller;

import java.util.List;

import org.jsp.crud_rest.dto.StudentDto;
import org.jsp.crud_rest.helper.ResponseStructure;
import org.jsp.crud_rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MyController {
	
	@Autowired
	StudentService service;
	
	@PostMapping("/students")
	 public ResponseEntity<ResponseStructure<StudentDto>> insert(@RequestBody StudentDto student) {
    	 return service.insert(student);
     }
	
	@PostMapping("/students/many")
	public ResponseEntity<ResponseStructure<List<StudentDto>>> insert(@RequestBody List<StudentDto> student){
		return service.insert(student);
	}
	
	@GetMapping("/hello")
	public String hello() {
		int a=1/0;
		return a+"hello";
	}
}
