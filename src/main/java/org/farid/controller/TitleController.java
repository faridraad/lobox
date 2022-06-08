package org.farid.controller;

import org.farid.service.CrewService;
import org.farid.service.PrincipalsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/title")
public class TitleController {

    final CrewService crewService;
    final PrincipalsService principalsService;
    public TitleController(CrewService crewService,PrincipalsService principalsService) {
        this.crewService = crewService;
        this.principalsService = principalsService;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getTitleDirectorWriterAreSame(){
        return new ResponseEntity<>(principalsService.getTitleDirectorWriterAreSame(), HttpStatus.OK);
    }

}
