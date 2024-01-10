package org.jsp.crud_rest.service;

import java.util.List;

import org.jsp.crud_rest.dao.StudentDao;
import org.jsp.crud_rest.dto.StudentDto;
import org.jsp.crud_rest.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
    StudentDao dao;
	@Autowired
	ResponseStructure<StudentDto> structure;
	@Autowired
	ResponseStructure<List<StudentDto>> structure1;
	public ResponseEntity<ResponseStructure<StudentDto>> insert(StudentDto dto) {
		 dto.setPercentage((dto.getEnglish()+dto.getMaths()+dto.getScience())/3.0);
		    if(dto.getEnglish()<35 || dto.getMaths()<35 || dto.getScience()<35) {
		    	dto.setResult("fail");
		    }else {
		    	if(dto.getPercentage()>=85) {
		    		dto.setResult("Distinction");
		    	}else if(dto.getPercentage()>=70) {
		    		dto.setResult("First Class");
		    	}else if(dto.getPercentage()>=55) {
		    		dto.setResult("Second Class");
		    	}else {
		    		dto.setResult("Third Class");
		    	}
		    }
		    
		    
		    structure.setMessage("Data Saved Success");
		    structure.setStatus(HttpStatus.CREATED.value());
		    structure.setData(dao.save(dto));
		    
		    return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<List<StudentDto>>> insert(List<StudentDto> dto) {
		for(StudentDto student:dto) {
			 student.setPercentage((student.getEnglish()+student.getMaths()+student.getScience())/3.0);
			    if(student.getEnglish()<35 || student.getMaths()<35 || student.getScience()<35) {
			    	student.setResult("fail");
			    }else {
			    	if(student.getPercentage()>=85) {
			    		student.setResult("Distinction");
			    	}else if(student.getPercentage()>=70) {
			    		student.setResult("First Class");
			    	}else if(student.getPercentage()>=55) {
			    		student.setResult("Second Class");
			    	}else {
			    		student.setResult("Third Class");
			    	}
			    }
			    
		}
		structure1.setMessage("Data Saved Success");
	    structure1.setStatus(HttpStatus.CREATED.value());
	    structure1.setData(dao.save(dto));
		
		return new ResponseEntity<ResponseStructure<List<StudentDto>>>(structure1,HttpStatus.CREATED);    
		
	}
    
}
