package org.sid.app.dto;

import java.util.Date;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DefenseDto {

	private Long defenseId;
	private Date date;
	private String classroom;
	private Set<TeacherDto> juries;
	private StudentDto student;

}
