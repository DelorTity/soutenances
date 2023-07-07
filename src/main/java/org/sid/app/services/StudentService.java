package org.sid.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.sid.app.repository.StudentRepository;
import org.sid.app.dto.StudentDto;
import org.sid.app.entities.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	public StudentDto add(StudentDto studentDto) {
		return mapToDto(studentRepository.save(new Student(studentDto.getStudentId(), studentDto.getFirstName(),
				studentDto.getLastName(), studentDto.getAge(), studentDto.getEmail(), studentDto.getTel(),
				studentDto.getCountry(), studentDto.getCity(), studentDto.getZip(),
				SpecialityService.mapToEntity(studentDto.getSpeciality()),
				TopicService.mapToEntity(studentDto.getTopic()),
				TeacherService.mapToEntity(studentDto.getSupervisor()))));
	}

	public void deleteById(Long studentId) {
		studentRepository.deleteById(studentId);
	}

	public StudentDto findById(Long studentId) {
		return studentRepository.findById(studentId).map(StudentService::mapToDto).orElse(null);
	}

	public List<StudentDto> findAll() {
		return studentRepository.findAll().stream().map(StudentService::mapToDto).collect(Collectors.toList());
	}

	public static StudentDto mapToDto(Student student) {
		if (student != null) {
			return new StudentDto(student.getStudentId(), student.getFirstName(), student.getLastName(),
					student.getAge(), student.getEmail(), student.getTel(), student.getCountry(), student.getCity(),
					student.getZip(), SpecialityService.mapToDto(student.getSpeciality()),
					TopicService.mapToDto(student.getTopic()), TeacherService.mapToDto(student.getSupervisor()));
		}
		return null;
	}

	public static Student mapToEntity(StudentDto studentDto) {
		if (studentDto != null) {
			return new Student(studentDto.getStudentId(), studentDto.getFirstName(), studentDto.getLastName(),
					studentDto.getAge(), studentDto.getEmail(), studentDto.getTel(), studentDto.getCountry(),
					studentDto.getCity(), studentDto.getZip(),
					SpecialityService.mapToEntity(studentDto.getSpeciality()),
					TopicService.mapToEntity(studentDto.getTopic()),
					TeacherService.mapToEntity(studentDto.getSupervisor()));
		}
		return null;
	}
}
