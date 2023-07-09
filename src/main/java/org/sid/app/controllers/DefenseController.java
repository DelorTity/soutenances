package org.sid.app.controllers;

import java.util.List;
import java.util.Optional;

import org.sid.app.dto.DefenseDto;
import org.sid.app.services.DefenceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/defenses")
public class DefenseController {

	@Autowired
	private DefenceServices defenseService;

	@PostMapping("/addDefense")
	public DefenseDto add(@RequestBody DefenseDto defenseDto) {
		return defenseService.add(defenseDto);
	}

	@DeleteMapping("/deleteDefense/{defenseId}")
	public void deleteById(@PathVariable Long defenseId) {
		defenseService.deleteById(defenseId);
	}

	@GetMapping("/getDefense/{defenseId}")
	public DefenseDto findById(@PathVariable Long defenseId) {
		return defenseService.findById(defenseId);
	}

	@GetMapping("/getAllDefenses")
	public List<DefenseDto> findAll() {
		return defenseService.findAll();
	}

	@PutMapping("/defense/{defenseId}")
	public ResponseEntity<DefenseDto> update(@PathVariable long defenseId, @RequestBody DefenseDto defenseDto) {
		Optional<DefenseDto> defenseOptional = Optional.ofNullable(defenseService.findById(defenseId));

		if (defenseOptional.isPresent()) {
			DefenseDto _defense = defenseOptional.get();
			_defense.setClassroom(defenseDto.getClassroom());
			_defense.setDate(defenseDto.getDate());
			_defense.setStudent(defenseDto.getStudent());
			return new ResponseEntity<>(defenseService.add(_defense), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getDefense")
	public String getDefense(Model model){
		List<DefenseDto> defenses = defenseService.findAll();
		model.addAttribute("defenses", defenses);
		return "getDefenses";
	}
}
