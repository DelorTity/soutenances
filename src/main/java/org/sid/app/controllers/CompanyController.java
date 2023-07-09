package org.sid.app.controllers;

import java.util.List;

import org.sid.app.dto.CompanyDto;
import org.sid.app.services.CompanyServiceImpl;
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

	private final CompanyServiceImpl companyServiceImpl;

	public CompanyController(CompanyServiceImpl companyServiceImpl) {
		super();
		this.companyServiceImpl = companyServiceImpl;
	}

	@PostMapping("/addCompany")
	public CompanyDto add(@RequestBody CompanyDto companyDto) {
		return companyServiceImpl.add(companyDto);
	}

	@DeleteMapping("/deleteCompany/{companyId}")
	public void delete(@PathVariable Long companyId) {
		companyServiceImpl.deleteById(companyId);
	}

	@GetMapping("/getCompany/{companyId}")
	public CompanyDto findById(@PathVariable Long companyId) {
		return companyServiceImpl.findById(companyId);
	}

	@GetMapping("/getAllCompanies")
	public List<CompanyDto> findAll() {
		return companyServiceImpl.findAll();
	}

}
