package org.sid.app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue
	private Long studentId;
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private int tel;
	private String country;
	private String city;
	private int zip;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Speciality speciality;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Topic topic;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Teacher supervisor;
}
