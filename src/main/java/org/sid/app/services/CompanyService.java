package org.sid.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.sid.app.repository.CompanyRepository;
import org.sid.app.dto.CompanyDto;
import org.sid.app.entities.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

	private final CompanyRepository companyRepository;

	public CompanyService(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	public CompanyDto add(CompanyDto companyDto) {
		return mapToDto(companyRepository.save(new Company(companyDto.getCompanyId(), companyDto.getName(),
				companyDto.getAddress(), companyDto.getEmail(), companyDto.getCountry(), companyDto.getCity(),
				companyDto.getZip(), companyDto.getTel())));
	}

	public void deleteById(Long companyId) {
		companyRepository.deleteById(companyId);
	}

	public CompanyDto findById(Long companyId) {
		return companyRepository.findById(companyId).map(CompanyService::mapToDto).orElse(null);
	}

	public List<CompanyDto> findAll() {
		return companyRepository.findAll().stream().map(CompanyService::mapToDto).collect(Collectors.toList());
	}

	public static CompanyDto mapToDto(Company company) {
		if (company != null) {
			return new CompanyDto(company.getCompanyId(), company.getName(), company.getAddress(), company.getEmail(),
					company.getCountry(), company.getCity(), company.getZip(), company.getTel());
		}
		return null;
	}

	public static Company mapToEntity(CompanyDto companyDto) {
		if (companyDto != null) {
			return new Company(companyDto.getCompanyId(), companyDto.getName(), companyDto.getAddress(),
					companyDto.getEmail(), companyDto.getCountry(), companyDto.getCity(), companyDto.getZip(),
					companyDto.getTel());
		}
		return null;
	}

}
