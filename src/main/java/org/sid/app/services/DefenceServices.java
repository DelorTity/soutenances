package org.sid.app.services;

import org.sid.app.dto.DefenseDto;
import org.sid.app.entities.Defense;

import java.util.List;
import java.util.Optional;

public interface DefenceServices {
    DefenseDto add(DefenseDto defenseDto);
    void deleteById(Long defenseId);
    List<DefenseDto> findAll();
    Defense mapToEntity(DefenseDto defenseDto);
    DefenseDto findById(Long defenseId);
    Optional<DefenseDto> findById(int defenseId);
}
