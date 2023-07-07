package org.sid.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpecialityDto {

	private Long specialityId;
	private String name;
	private TeacherDto departmentHead;

}
