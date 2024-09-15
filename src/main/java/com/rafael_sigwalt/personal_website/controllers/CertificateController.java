package com.rafael_sigwalt.personal_website.controllers;

import com.rafael_sigwalt.personal_website.dtos.GetCertificateDTO;
import com.rafael_sigwalt.personal_website.dtos.GetCertificateListDTO;
import com.rafael_sigwalt.personal_website.models.Certificate;
import com.rafael_sigwalt.personal_website.services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @GetMapping
    public ResponseEntity<Page<GetCertificateListDTO>> getCertificateList(@RequestParam int numPerPage, @RequestParam int page) {
        Page<Certificate> certificateList = certificateService.getCertificateList(numPerPage, page);

        return ResponseEntity.ok(certificateList.map(GetCertificateListDTO::new));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<GetCertificateDTO> getCertificateById(@PathVariable int id) {
        Certificate certificate = certificateService.getCertificateById(id);
        return ResponseEntity.ok(new GetCertificateDTO(certificate));
    }
}
