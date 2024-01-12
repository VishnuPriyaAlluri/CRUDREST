package org.jsp.crud_rest.controller;

import java.util.List;

import org.jsp.crud_rest.dto.StudentDto;
import org.jsp.crud_rest.helper.ResponseStructure;
import org.jsp.crud_rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MyController {
	
	@Autowired
	StudentService service;
	
	//saving one record
	@PostMapping("/students")
	 public ResponseEntity<ResponseStructure<StudentDto>> insert(@RequestBody StudentDto student) {
    	 return service.insert(student);
     }
	
	//saving multiple records at a time
	@PostMapping("/students/many")
	public ResponseEntity<ResponseStructure<List<StudentDto>>> insert(@RequestBody List<StudentDto> student){
		return service.insert(student);
	}
	
	//handling exceptions
	@GetMapping("/hello")
	public String hello() {
		int a=1/0;
		return a+"hello";
	}
	
	//fetch all the data
	@GetMapping("/students")
	public ResponseEntity<ResponseStructure<List<StudentDto>>> fetchAll(){
		return service.fetchAll();
	}
	
	//fetch by id query param
	@GetMapping("/students/id")
	public ResponseEntity<ResponseStructure<StudentDto>> findById1(@RequestParam int id){
		return service.findById(id);
	}
	 
	//fetch by id by path 
	@GetMapping("/students/id/{id}")
	public ResponseEntity<ResponseStructure<StudentDto>> findById2(@PathVariable int id){
		return service.findById(id);
	}
	
	//fetch by name
	@GetMapping("/students/name/{name}")
	public ResponseEntity<ResponseStructure<List<StudentDto>>> findByName(@PathVariable String name){
		return service.findByName(name);
	}
	
	//fetch by mobile
	@GetMapping("/students/mobile/{mobile}")
	public ResponseEntity<ResponseStructure<StudentDto>> findByMobile(@PathVariable long mobile){
		return service.findByMobile(mobile);
	}
	
	//fetch by result 
	@GetMapping("/students/result/{result}")
	public ResponseEntity<ResponseStructure<List<StudentDto>>> findByResult(@PathVariable String result){
		return service.findByResult(result);
	}
	
	//fetch by percentage greater than
	@GetMapping("/students/percentage/greater/{percentage}")
	public ResponseEntity<ResponseStructure<List<StudentDto>>> findByPercentageGreater(@PathVariable double percentage){
		return service.findByPercentageGreater(percentage);
	}
	
	//fetch by percentage less than
		@GetMapping("/students/percentage/less/{percentage}")
		public ResponseEntity<ResponseStructure<List<StudentDto>>> findByPercentageLess(@PathVariable double percentage){
			return service.findByPercentageLess(percentage);
		}
		
    //fetch by percentage between by query param
		@GetMapping("/students/percentage/between")
		public ResponseEntity<ResponseStructure<List<StudentDto>>> findByPercentageBetween1(@RequestParam double percentage1,double percentage2){
			return service.findByPercentageBetween(percentage1,percentage2);
		}
		
		 //fetch by percentage between by path variables
	@GetMapping("/students/percentage/between/{percentage1}/{percentage2}")
	public ResponseEntity<ResponseStructure<List<StudentDto>>> findByPercentageBetween2(@PathVariable double percentage1,@PathVariable double percentage2){
		return service.findByPercentageBetween(percentage1,percentage2);
	}
		
		//fetch by marks greater than 70 in english and maths
		@GetMapping("/students/marks/{marks}")
		public ResponseEntity<ResponseStructure<List<StudentDto>>> findByMarks(@PathVariable int marks){
			return service.findByMarks(marks);
		}
		
		//fetch by name or mobile
		@GetMapping("/students/nameormobile/{data}")
		public ResponseEntity<ResponseStructure<List<StudentDto>>> findByNameOrMobile(@PathVariable String data){
			return service.findByNameOrMobile(data);
		}
		
		//delete by id
		@DeleteMapping("/students/deleteby/id/{id}")
		public ResponseEntity<ResponseStructure<StudentDto>> deleteById(@PathVariable int id){
			return service.deleteById(id);
		}
		
		//update all the data present in the record
		@PutMapping("/students")
		public ResponseEntity<ResponseStructure<StudentDto>> update(@RequestBody StudentDto dto){
			return service.update(dto);
		}
		
		//update particular data present in the record
		@PatchMapping("/students/id/{id}")
		public ResponseEntity<ResponseStructure<StudentDto>> update(@PathVariable int id,@RequestBody StudentDto dto){
			return service.update(id,dto);
		}
		
		@DeleteMapping("/students/deleteby/name/{name}")
		public ResponseEntity<ResponseStructure<StudentDto>> deleteByName(@PathVariable String name){
			return service.deleteByName(name);
		}
		
}
