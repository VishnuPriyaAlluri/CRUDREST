package org.jsp.crud_rest.service;

import java.util.List;
import java.util.NoSuchElementException;

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
	public ResponseEntity<ResponseStructure<List<StudentDto>>> fetchAll() {
		 List<StudentDto> dto = dao.fetchAll();
		 if(dto.isEmpty()) {
			 throw new NoSuchElementException("No Such Elements Present");
		 }
		 structure1.setMessage("Data Found Success");
		 structure1.setStatus(HttpStatus.FOUND.value());
		 structure1.setData(dto);
			
			return new ResponseEntity<ResponseStructure<List<StudentDto>>>(structure1,HttpStatus.FOUND);    
	}
	public ResponseEntity<ResponseStructure<StudentDto>> findById(int id) {
		StudentDto dto = dao.findById(id);
		if(dto==null) {
			throw new NoSuchElementException("Data Is Not Found With The ID :"+id);
		}
		 structure.setMessage("Data Found Success");
		 structure.setStatus(HttpStatus.FOUND.value());
		 structure.setData(dto);
		    
		    return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.FOUND);
	}
	public ResponseEntity<ResponseStructure<List<StudentDto>>> findByName(String name) {
		 List<StudentDto> dto = dao.findByName(name);
		 if(dto.isEmpty()) {
			 throw new NoSuchElementException("Data is not found with that name :"+name);
		 }
		 structure1.setMessage("Data Found Success");
		 structure1.setStatus(HttpStatus.FOUND.value());
		 structure1.setData(dto);
			
			return new ResponseEntity<ResponseStructure<List<StudentDto>>>(structure1,HttpStatus.FOUND);    
	}
	public ResponseEntity<ResponseStructure<StudentDto>> findByMobile(long mobile) {
		StudentDto dto = dao.findByMobile(mobile);
		if(dto==null) {
			throw new NoSuchElementException("Data Is Not Found With The mobile :"+mobile);
		}
		 structure.setMessage("Data Found Success");
		 structure.setStatus(HttpStatus.FOUND.value());
		 structure.setData(dto);
		    
		    return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.FOUND);
	}
	public ResponseEntity<ResponseStructure<List<StudentDto>>> findByResult(String result) {
		 List<StudentDto> dto = dao.findByResult(result);
		 if(dto.isEmpty()) {
			 throw new NoSuchElementException("Data is not found with that result :"+result);
		 }
		 structure1.setMessage("Data Found Success");
		 structure1.setStatus(HttpStatus.FOUND.value());
		 structure1.setData(dto);
			
			return new ResponseEntity<ResponseStructure<List<StudentDto>>>(structure1,HttpStatus.FOUND);   
	}
	public ResponseEntity<ResponseStructure<List<StudentDto>>> findByPercentageGreater(double percentage) {
		List<StudentDto> dto = dao.findByPercentageGreater(percentage);
		 if(dto.isEmpty()) {
			 throw new NoSuchElementException("Data is not found with that percentage greater than :"+percentage);
		 }
		 structure1.setMessage("Data Found Success");
		 structure1.setStatus(HttpStatus.FOUND.value());
		 structure1.setData(dto);
			
			return new ResponseEntity<ResponseStructure<List<StudentDto>>>(structure1,HttpStatus.FOUND);   
	}
	public ResponseEntity<ResponseStructure<List<StudentDto>>> findByPercentageLess(double percentage) {
		List<StudentDto> dto = dao.findByPercentageLess(percentage);
		 if(dto.isEmpty()) {
			 throw new NoSuchElementException("Data is not found with that percentage less than :"+percentage);
		 }
		 structure1.setMessage("Data Found Success");
		 structure1.setStatus(HttpStatus.FOUND.value());
		 structure1.setData(dto);
			
			return new ResponseEntity<ResponseStructure<List<StudentDto>>>(structure1,HttpStatus.FOUND);  
	}
	public ResponseEntity<ResponseStructure<List<StudentDto>>> findByPercentageBetween(double percentage1,
			double percentage2) {
		List<StudentDto> dto = dao.findByPercentageBetween(percentage1,percentage2);
		 if(dto.isEmpty()) {
			 throw new NoSuchElementException("Data is not found with percentage greater than "+percentage1+" and less than "+percentage2);
		 }
		 structure1.setMessage("Data Found Success");
		 structure1.setStatus(HttpStatus.FOUND.value());
		 structure1.setData(dto);
			
			return new ResponseEntity<ResponseStructure<List<StudentDto>>>(structure1,HttpStatus.FOUND); 
	}
	public ResponseEntity<ResponseStructure<List<StudentDto>>> findByMarks(int marks) {
		List<StudentDto> dto = dao.findByMarks(marks);
		 if(dto.isEmpty()) {
			 throw new NoSuchElementException("Data is not found with marks greater than  :"+marks+" in maths and english");
		 }
		 structure1.setMessage("Data Found Success");
		 structure1.setStatus(HttpStatus.FOUND.value());
		 structure1.setData(dto);
			
			return new ResponseEntity<ResponseStructure<List<StudentDto>>>(structure1,HttpStatus.FOUND);  
	}
	public ResponseEntity<ResponseStructure<List<StudentDto>>> findByNameOrMobile(String data) {
		List<StudentDto> dto=null;
		try {
			dto=dao.fetchByNameOrMobile(null,Long.parseLong(data));
		}catch(NumberFormatException e) {
			dto=dao.fetchByNameOrMobile(data,0);
		}
		
	    if(dto.isEmpty()) {
			 throw new NoSuchElementException("Data is not found with that");
		 }
		 structure1.setMessage("Data Found Success");
		 structure1.setStatus(HttpStatus.FOUND.value());
		 structure1.setData(dto);
			
			return new ResponseEntity<ResponseStructure<List<StudentDto>>>(structure1,HttpStatus.FOUND);  
	}
	public ResponseEntity<ResponseStructure<StudentDto>> deleteById(int id) {
		StudentDto dto = dao.findById(id);
		if(dto==null) {
			throw new NoSuchElementException("Data Is Not Found With The ID :"+id);
		}else {
			dao.deleteById(id);
		}
		 structure.setMessage("Data Deleted Success");
		 structure.setStatus(HttpStatus.GONE.value());
		 structure.setData(dto);
		 return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.GONE);

	}
	public ResponseEntity<ResponseStructure<StudentDto>> update(StudentDto dto) {
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
		    structure.setStatus(HttpStatus.OK.value());
		    structure.setData(dao.save(dto));
		    return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<StudentDto>> update(int id, StudentDto dto) {
		StudentDto dto1 = dao.findById(id);
		if(dto.getName()!=null) {
			dto1.setName(dto.getName());
		}
		if(dto.getMobile()!=0)
			dto1.setMobile(dto.getMobile());
		if(dto.getDob()!=null)
			dto1.setDob(dto.getDob());
		if(dto.getEnglish()!=0)
			dto1.setEnglish(dto.getEnglish());
		if(dto.getMaths()!=0)
			dto1.setMaths(dto.getMaths());
		if(dto.getScience()!=0)
			dto1.setScience(dto.getScience());
		
		
		 dto1.setPercentage((dto1.getEnglish()+dto1.getMaths()+dto1.getScience())/3.0);
		    if(dto1.getEnglish()<35 || dto1.getMaths()<35 || dto1.getScience()<35) {
		    	dto1.setResult("fail");
		    }else {
		    	if(dto1.getPercentage()>=85) {
		    		dto1.setResult("Distinction");
		    	}else if(dto1.getPercentage()>=70) {
		    		dto1.setResult("First Class");
		    	}else if(dto1.getPercentage()>=55) {
		    		dto1.setResult("Second Class");
		    	}else {
		    		dto1.setResult("Third Class");
		    	}
		    }
		    
		    
		    structure.setMessage("Data Updated Success");
		    structure.setStatus(HttpStatus.OK.value());
		    structure.setData(dao.save(dto1));
		    
		    return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.OK);
		
	}
	public ResponseEntity<ResponseStructure<StudentDto>> deleteByName(String name) {
		
		 List<StudentDto> dto = dao.findByName(name);
		 if(dto.isEmpty()) {
			 throw new NoSuchElementException("Data is not found with that name :"+name);
		 }else {
		
		 dao.deleteByName(name);
		}
		 structure1.setData(dao.findByName(name));
		 structure1.setMessage("Data Deleted Success");
		 structure1.setStatus(HttpStatus.GONE.value());

		 return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.GONE);

	}
    
}
