package org.sid.app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

	@Id
	@GeneratedValue
	private Long teacherId;
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private int tel;
	private String country;
	private String city;
	private int zip;

}
