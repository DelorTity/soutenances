package org.sid.app.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

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
