package dev.controller;

import dev.exception.ItemNotFoundException;
import dev.model.Mission;
import dev.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/missions")
@CrossOrigin
public class MissionController {

    @Autowired
    private MissionRepository missionRepository;

    @GetMapping
    public List<Mission> getMissions(){
        return this.missionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mission getMissionById(@PathVariable Integer id) throws ItemNotFoundException {
        if (this.missionRepository.findOne(id) == null) {
            throw new ItemNotFoundException();
        }
        return this.missionRepository.findOne(id);
    }

    @PostMapping
    public void postMission(@RequestBody Mission mission){
        this.missionRepository.save(mission);
    }

    @DeleteMapping("/{id}")
    public void deleteMission(@PathVariable Integer id) throws ItemNotFoundException, DataIntegrityViolationException {

        if (this.missionRepository.findOne(id) == null) {
            throw new ItemNotFoundException();
        }

        this.missionRepository.delete(id);
    }

    @PutMapping("/{id}")
    public void updateMission(@PathVariable Integer id, @RequestBody Mission mission) throws ItemNotFoundException {
        if (this.missionRepository.findOne(id) == null) {
            throw new ItemNotFoundException();
        }

        mission.setId(this.missionRepository.findOne(id).getId());
        this.missionRepository.save(mission);
    }
}
