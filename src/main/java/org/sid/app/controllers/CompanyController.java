package org.sid.app.controllers;

import java.util.List;

import org.sid.app.dto.CompanyDto;
import org.sid.app.services.CompanyService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	private final CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}

	@PostMapping("/addCompany")
	public CompanyDto add(@RequestBody CompanyDto companyDto) {
		return companyService.add(companyDto);
	}

	@DeleteMapping("/deleteCompany/{companyId}")
	public void delete(@PathVariable Long companyId) {
		companyService.deleteById(companyId);
	}

	@GetMapping("/getCompany/{companyId}")
	public CompanyDto findById(@PathVariable Long companyId) {
		return companyService.findById(companyId);
	}

	@GetMapping("/getAllCompanies")
	public List<CompanyDto> findAll() {
		return companyService.findAll();
	}

}
