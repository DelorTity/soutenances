package org.sid.app.controllers;

import java.util.List;

import org.sid.app.dto.SpecialityDto;
import org.sid.app.services.SpecialityService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/specialities")
public class SpecialityController {

	private final SpecialityService specialityService;

	public SpecialityController(SpecialityService specialityService) {
		super();
		this.specialityService = specialityService;
	}

	@PostMapping("/addspeciality")
	public SpecialityDto add(@RequestBody SpecialityDto specialityDto) {
		return specialityService.add(specialityDto);
	}

	@DeleteMapping("/deletespeciality/{specialityId}")
	public void deleteById(Long specialityId) {
		specialityService.deleteById(specialityId);
	}

	@GetMapping("/getspeciality/{specialityId}")
	public SpecialityDto findById(@PathVariable Long specialityId) {
		return specialityService.findById(specialityId);
	}

	@GetMapping("/getallspecialities")
	public List<SpecialityDto> findAll() {
		return specialityService.findAll();
	}
}
