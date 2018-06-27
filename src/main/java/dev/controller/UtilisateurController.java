package dev.controller;

import dev.exception.ItemNotFoundException;
import dev.model.Utilisateur;
import dev.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
@CrossOrigin
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping
    public List<Utilisateur> getUtilisateurs(){return this.utilisateurRepository.findAll();}

    @GetMapping("/{id}")
    public Utilisateur getUtilisateurById(@PathVariable Integer id) throws ItemNotFoundException {
        if (this.utilisateurRepository.findOne(id) == null){
            throw new ItemNotFoundException();
        }
        return this.utilisateurRepository.findOne(id);
    }
}
