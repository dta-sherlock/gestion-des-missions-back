package dev.service;

import dev.exception.ItemNotFoundException;
import dev.model.Mission;
import dev.model.Nature;
import dev.model.Utilisateur;
import dev.repository.MissionRepository;
import dev.repository.NatureRepository;
import dev.repository.UtilisateurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;

@Service
@Transactional
public class InitialiserDonneesServiceImpl implements InitialiserDonneesService{

    private static final Logger LOG = LoggerFactory.getLogger(InitialiserDonneesService.class);

    @Autowired
    MissionRepository missionRepository;
    @Autowired
    NatureRepository natureRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    Nature nature1;
    Nature nature2;
    Nature nature3;

    Mission mission1;
    Mission mission2;
    Mission mission3;

    Utilisateur utilisateur1;
    Utilisateur utilisateur2;
    Utilisateur utilisateur3;

    @Override
    public void initialiser() {
        this.nature1 = new Nature("Conseil", false, false, 150, true, LocalDate.now());
        this.nature2 = new Nature("Expertise technique", true, true, 1000, 4.5f, 150, true, LocalDate.now(), LocalDate.of(2020, Month.APRIL, 1));
        this.nature3 = new Nature("Formation", true, false, 200, false, LocalDate.now());

        this.mission1 = new Mission(LocalDate.now(), LocalDate.of(2018,Month.JULY, 12), nature1, "Nantes", "Lyon", Mission.Transport.COVOITURAGE, Mission.Statut.INITIALE);
        this.mission2 = new Mission(LocalDate.now(), LocalDate.of(2018, Month.SEPTEMBER, 20), nature2, "Paris", "Rennes", Mission.Transport.TRAIN, Mission.Statut.EN_ATTENTE_VALIDATION);
        this.mission3 = new Mission(LocalDate.now(), LocalDate.of(2018, Month.JULY, 30), nature3, "Poitiers", "Marseille", Mission.Transport.VOITURE_DE_SERVICE, Mission.Statut.VALIDEE);

        this.utilisateur1 = new Utilisateur("Mario", this.passwordEncoder.encode("mdpmario"), "mario@kart.wii", Utilisateur.Profil.Utilisateur, null);
        this.utilisateur2 = new Utilisateur("Luigi", this.passwordEncoder.encode("mdpluigi"), "luigi@kart.wii", Utilisateur.Profil.Manager,"../images/luigi.jpeg");
        this.utilisateur3 = new Utilisateur("Yoshi", this.passwordEncoder.encode("mdpluigi"), "yoshi@kart.wii", Utilisateur.Profil.Admin, null);


        nature3.setTJM(750);

        /**
         * On vérifie que la nature n'est pas présente en base avant de l'enregistrer
         */
        if (this.natureRepository.findByNom(nature1.getNom()) == null) {
            natureRepository.save(nature1);
        }
        if (this.natureRepository.findByNom(nature2.getNom()) == null){
            natureRepository.save(nature2);
        }
        if (this.natureRepository.findByNom(nature3.getNom()) == null){
            natureRepository.save(nature3);
        }

        /**
         * On enregistre la mission uniquement si aucune autre mission avec la même nature n'est présente en base.
         * Cela évite d'enregistrer deux fois la même mission.
         * Si une autre mission avec la même nature est déjà présente, notre mission n'est pas enregistrée.
         * Ce n'est cependant pas un problème car il s'agit seuelemnt d'un jeu de données test.
         */
        if (this.missionRepository.findByNatureNom(mission1.getNature().getNom()).isEmpty()){
            missionRepository.save(mission1);
        }
        if (this.missionRepository.findByNatureNom(mission2.getNature().getNom()).isEmpty()){
            missionRepository.save(mission2);
        }
        if (this.missionRepository.findByNatureNom(mission3.getNature().getNom()).isEmpty()){
            missionRepository.save(mission3);
        }

        /**
         * On vérifie que l'utilisateur n'est pas présent en base avant de l'enregistrer
         */
        if (this.utilisateurRepository.findByNom(utilisateur1.getNom()) == null){
            utilisateurRepository.save(utilisateur1);
        }
        if (this.utilisateurRepository.findByNom(utilisateur2.getNom()) == null){
            utilisateurRepository.save(utilisateur2);
        }
        if (this.utilisateurRepository.findByNom(utilisateur3.getNom()) == null){
            utilisateurRepository.save(utilisateur3);
        }

        LOG.debug("Initialisation des donnees");
    }

    @Override
    public void supprimer() {
        this.missionRepository.delete(mission1);
        this.missionRepository.delete(mission2);
        this.missionRepository.delete(mission3);

        this.utilisateurRepository.delete(utilisateur1);
        this.utilisateurRepository.delete(utilisateur2);
        this.utilisateurRepository.delete(utilisateur3);

        LOG.debug("Suppression des donnees");
    }
}
