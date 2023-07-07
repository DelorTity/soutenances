package org.sid.app.controllers;

import java.util.List;

import org.sid.app.dto.DefenseDto;
import org.sid.app.services.DefenseService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/defenses")
public class DefenseController {

	private final DefenseService defenseService;

	public DefenseController(DefenseService defenseService) {
		super();
		this.defenseService = defenseService;
	}

	@PostMapping("/addDefense")
	public DefenseDto add(@RequestBody DefenseDto defenseDto) {
		return defenseService.add(defenseDto);
	}

	@DeleteMapping("/deleteDefense/{defenseId}")
	public void deleteById(@PathVariable Long defenseId) {
		defenseService.deleteById(defenseId);
	}

	@GetMapping("/deleteDefense/{defenseId}")
	public DefenseDto findById(@PathVariable Long defenseId) {
		return defenseService.findById(defenseId);
	}

	@GetMapping("/getaAllDefenses")
	public List<DefenseDto> findAll() {
		return defenseService.findAll();
	}
}
