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
     
}
