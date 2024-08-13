package com.rafael_sigwalt.personal_website.controllers;

import com.rafael_sigwalt.personal_website.dtos.GetCertificateDTO;
import com.rafael_sigwalt.personal_website.dtos.GetCertificateListDTO;
import com.rafael_sigwalt.personal_website.models.Certificate;
import com.rafael_sigwalt.personal_website.services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @GetMapping
    public ResponseEntity<List<GetCertificateListDTO>> getCertificateList() {
        List<Certificate> certificateList = certificateService.getCertificateList();

        return ResponseEntity.ok(certificateList.stream().map(GetCertificateListDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<GetCertificateDTO> getCertificateById(@PathVariable int id) {
        Certificate certificate = certificateService.getCertificateById(id);
        return ResponseEntity.ok(new GetCertificateDTO(certificate));
    }
}
