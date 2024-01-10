package org.jsp.crud_rest.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class StudentDto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
	String name;
	@Column(unique = true)
	long mobile;
	int english;
	int science;
	int maths;
	double percentage;
	String result;
	LocalDate dob;
	

	
}
