package org.sid.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.sid.app.repository.DefenseRepository;
import org.sid.app.dto.DefenseDto;
import org.sid.app.entities.Defense;
import org.springframework.stereotype.Service;

@Service
public class DefenseService implements DefenceServices{

	private final DefenseRepository defenseRepository;

	public DefenseService(DefenseRepository defenseRepository) {
		super();
		this.defenseRepository = defenseRepository;
	}

	public DefenseDto add(DefenseDto defenseDto) {
		return mapToDto(defenseRepository
				.save(new Defense(defenseDto.getDefenseId(), defenseDto.getDate(), defenseDto.getClassroom(),
						defenseDto.getJuries().stream().map(TeacherService::mapToEntity).collect(Collectors.toSet()),
						StudentService.mapToEntity(defenseDto.getStudent()))));
	}

	public void deleteById(Long defenseId) {
		defenseRepository.deleteById(defenseId);
	}

	public DefenseDto findById(Long defenseId) {
		return defenseRepository.findById(defenseId).map(DefenseService::mapToDto).orElse(null);
	}

	public Optional<DefenseDto> findById(int defenseId) {
		return Optional.ofNullable(defenseRepository.findById((long) defenseId).map(DefenseService::mapToDto).orElse(null));
	}

	public List<DefenseDto> findAll() {
		return defenseRepository.findAll().stream().map(DefenseService::mapToDto).collect(Collectors.toList());
	}

	public static DefenseDto mapToDto(Defense defense) {
		if (defense != null) {
			return new DefenseDto(defense.getDefenseId(), defense.getDate(), defense.getClassroom(),
					defense.getJuries().stream().map(TeacherService::mapToDto).collect(Collectors.toSet()),
					StudentService.mapToDto(defense.getStudent()));
		}
		return null;
	}

	public Defense mapToEntity(DefenseDto defenseDto) {
		if (defenseDto != null) {
			return new Defense(defenseDto.getDefenseId(), defenseDto.getDate(), defenseDto.getClassroom(),
					defenseDto.getJuries().stream().map(TeacherService::mapToEntity).collect(Collectors.toSet()),
					StudentService.mapToEntity(defenseDto.getStudent()));
		}
		return null;
	}
}
