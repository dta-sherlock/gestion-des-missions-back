package dev.controller;

import dev.service.InitialiserDonneesService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions/testData")
@CrossOrigin
public class MissionTestController {

    @Autowired
    private InitialiserDonneesService initialiserDonneesService;

    @PostMapping
    public void postMissionTest(){
        initialiserDonneesService.initialiser();
    }

    @DeleteMapping
    public void deleteMissionTest() throws JpaObjectRetrievalFailureException, InvalidDataAccessApiUsageException {
        initialiserDonneesService.supprimer();
    }
}
