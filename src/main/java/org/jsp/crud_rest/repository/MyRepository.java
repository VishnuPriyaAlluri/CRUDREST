package org.jsp.crud_rest.repository;

import org.jsp.crud_rest.dto.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<StudentDto, Integer> {

}
