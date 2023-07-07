package org.sid.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.sid.app.repository.TeacherRepository;
import org.sid.app.dto.TeacherDto;
import org.sid.app.entities.Teacher;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

	private final TeacherRepository teacherRepository;

	public TeacherService(TeacherRepository teacherRepository) {
		super();
		this.teacherRepository = teacherRepository;
	}

	public TeacherDto add(TeacherDto teacherDto) {
		return mapToDto(teacherRepository.save(new Teacher(teacherDto.getTeacherId(), teacherDto.getFirstName(),
				teacherDto.getLastName(), teacherDto.getAge(), teacherDto.getEmail(), teacherDto.getTel(),
				teacherDto.getCountry(), teacherDto.getCity(), teacherDto.getZip())));
	}

	public void deleteById(Long teacherId) {
		teacherRepository.deleteById(teacherId);
	}

	public TeacherDto findById(Long teacherId) {
		return teacherRepository.findById(teacherId).map(TeacherService::mapToDto).orElse(null);
	}

	public List<TeacherDto> findAll() {
		return teacherRepository.findAll().stream().map(TeacherService::mapToDto).collect(Collectors.toList());
	}

	public static TeacherDto mapToDto(Teacher teacher) {
		if (teacher != null) {
			return new TeacherDto(teacher.getTeacherId(), teacher.getFirstName(), teacher.getLastName(),
					teacher.getAge(), teacher.getEmail(), teacher.getTel(), teacher.getCountry(), teacher.getCity(),
					teacher.getZip());
		}
		return null;
	}

	public static Teacher mapToEntity(TeacherDto teacherDto) {
		if (teacherDto != null) {
			return new Teacher(teacherDto.getTeacherId(), teacherDto.getFirstName(), teacherDto.getLastName(),
					teacherDto.getAge(), teacherDto.getEmail(), teacherDto.getTel(), teacherDto.getCountry(),
					teacherDto.getCity(), teacherDto.getZip());
		}
		return null;
	}
}
