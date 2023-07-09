package org.sid.app.services;

import org.sid.app.dto.CompanyDto;
import org.sid.app.entities.Company;

import java.util.List;

public interface CompanyService {
    CompanyDto add(CompanyDto companyDto);
    void deleteById(Long companyId);
    CompanyDto findById(Long companyId);
    List<CompanyDto> findAll();
    
}
