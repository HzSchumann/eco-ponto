package com.hackawar.ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackawar.ps.domain.company.dto.CompanyDto;
import com.hackawar.ps.services.CompanyService;

@RequestMapping("/company")
@RestController
public class CompanyController {
    
    @Autowired
    CompanyService companyService;

    @PostMapping
    public void sendCompanyMail(@RequestBody CompanyDto companyDto) {
        companyService.sendCompanyToEmail(companyDto);
    }
}
