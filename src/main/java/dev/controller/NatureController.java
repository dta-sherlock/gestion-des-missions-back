package dev.controller;

import dev.exception.ItemNotFoundException;
import dev.model.Nature;
import dev.repository.NatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/natures")
@CrossOrigin
public class NatureController {

    @Autowired
    private NatureRepository natureRepository;

    @GetMapping
    public List<Nature> getNatures(){return this.natureRepository.findAll();}

    @GetMapping("/{id}")
    public Nature getNatureById(@PathVariable Integer id) throws ItemNotFoundException {
        if (this.natureRepository.findOne(id) == null){
            throw new ItemNotFoundException();
        }
        return  this.natureRepository.findOne(id);
    }

    @PostMapping
    public void postNature(@RequestBody Nature nature){this.natureRepository.save(nature);}

    @DeleteMapping("/{id}")
    public void deleteNature(@PathVariable Integer id) throws ItemNotFoundException {
        if (this.natureRepository.findOne(id) == null){
            throw new ItemNotFoundException();
        }
        this.natureRepository.delete(id);
    }

    @PutMapping("/{id}")
    public void updateNature(@PathVariable Integer id, @RequestBody Nature nature) throws ItemNotFoundException {
        if (this.natureRepository.findOne(id) == null){
            throw new ItemNotFoundException();
        }

        nature.setId((this.natureRepository.findOne(id).getId()));
        this.natureRepository.save(nature);
    }
}
