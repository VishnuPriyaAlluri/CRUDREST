package org.jsp.crud_rest.repository;

import java.util.List;

import org.jsp.crud_rest.dto.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<StudentDto, Integer> {

	
	//spring jpa will give implementation for these methods
	List<StudentDto> findByName(String name);

	StudentDto findByMobile(long mobile);

	List<StudentDto> findByResult(String result);

	List<StudentDto> findByPercentageGreaterThan(double percentage);

	List<StudentDto> findByPercentageLessThan(double percentage);

	List<StudentDto> findByPercentageBetween(double percentage1, double percentage2);

	List<StudentDto> findByMathsGreaterThanEqualAndEnglishGreaterThanEqual(int i, int j);

	List<StudentDto> findByNameOrMobile(String data, long l);

	
	void removeByName(String name);
	

//	List<StudentDto> findByNameOrMobile(long mobile);

}
