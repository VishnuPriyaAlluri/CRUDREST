package org.jsp.crud_rest.dao;

import java.util.List;

import org.jsp.crud_rest.dto.StudentDto;
import org.jsp.crud_rest.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

	@Autowired
	MyRepository repository;
	public StudentDto save(StudentDto dto) {
		return repository.save(dto);
	}
	public List<StudentDto> save(List<StudentDto> dto) {
		return repository.saveAll(dto);
	}
	public List<StudentDto> fetchAll() {
		return repository.findAll();
		
	}
	public StudentDto findById(int id) {
		return repository.findById(id).orElse(null);		
	}
	public List<StudentDto> findByName(String name) {
		return repository.findByName(name);
	}
	public StudentDto findByMobile(long mobile) {
		return repository.findByMobile(mobile);
	}
	public List<StudentDto> findByResult(String result) {
		return repository.findByResult(result);
	}
	public List<StudentDto> findByPercentageGreater(double percentage) {
		return repository.findByPercentageGreaterThan(percentage);
	}
	public List<StudentDto> findByPercentageLess(double percentage) {
		return repository.findByPercentageLessThan(percentage);
	}
	public List<StudentDto> findByPercentageBetween(double percentage1, double percentage2) {
		return repository.findByPercentageBetween(percentage1,percentage2);
	}
	public List<StudentDto> findByMarks(int marks) {
		return repository.findByMathsGreaterThanEqualAndEnglishGreaterThanEqual(marks,marks);
	}
	public List<StudentDto> fetchByNameOrMobile(String name, long parseLong) {
		return repository.findByNameOrMobile(name, parseLong);
	}
	public void deleteById(int id) {
		 repository.deleteById(id);
	}
	public void deleteByName(String name) {
		repository.removeByName(name);
		
	}
		
    
	
}
