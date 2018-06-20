package dev.controller;

import dev.model.Mission;
import dev.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MissionController {

    @Autowired
    private MissionRepository missionRepository;

    @GetMapping("/missions")
    public List<Mission> getMissions(){
        return this.missionRepository.findAll();
    }

    @GetMapping("missions/{id}")
    public Mission getMissionById(@PathVariable Integer id){
        return this.missionRepository.findOne(id);
    }
}
