package org.sid.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

	private Long studentId;
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private int tel;
	private String country;
	private String city;
	private int zip;
	private SpecialityDto speciality;
	private TopicDto topic;
	private TeacherDto supervisor;

}
