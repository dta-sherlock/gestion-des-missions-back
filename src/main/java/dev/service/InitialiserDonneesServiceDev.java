package dev.service;

import dev.model.Mission;
import dev.model.Nature;
import dev.repository.MissionRepository;
import dev.repository.NatureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;

@Service
@Transactional
public class InitialiserDonneesServiceDev implements InitialiserDonneesService{

    private static final Logger LOG = LoggerFactory.getLogger(InitialiserDonneesService.class);

    @Autowired
    MissionRepository missionRepository;

    @Autowired
    NatureRepository natureRepository;

    @Override
    public void Initialiser() {

        Nature nature1 = new Nature("Conseil", false, false, 150, true, LocalDate.now());
        Nature nature2 = new Nature("Expertise technique", true, true, 1000, 4.5f, 150, true, LocalDate.now(), LocalDate.of(2020, Month.APRIL, 1));
        Nature nature3 = new Nature("Formation", true, false, 200, false, LocalDate.now());
        nature3.setTJM(750);

        /**
         * On vérifie que la nature n'est pas présente en base avant de l'enregistrer
         */
        if (this.natureRepository.findByName("Conseil") == null) {
            natureRepository.save(nature1);
        }

        if (this.natureRepository.findByName("Expertise technique") == null){
            natureRepository.save(nature2);
        }

        if (this.natureRepository.findByName("Formation") == null){
            natureRepository.save(nature3);
        }

        Mission mission1 = new Mission(LocalDate.now(), LocalDate.of(2018,Month.JULY, 12), nature1, "Nantes", "Lyon", Mission.Transport.Covoiturage, Mission.Statue.INITIALE);
        Mission mission2 = new Mission(LocalDate.now(), LocalDate.of(2018, Month.SEPTEMBER, 20), nature2, "Paris", "Rennes", Mission.Transport.Train, Mission.Statue.EN_ATTENTE_VALIDATION);
        Mission mission3 = new Mission(LocalDate.now(), LocalDate.of(2018, Month.JULY, 30), nature3, "Poitiers", "Marseille", Mission.Transport.Voiture_de_service, Mission.Statue.VALIDEE);

        /**
         * On enregistre la mission uniquement si aucune autre mission avec la même nature n'est présente en base.
         * Cela évite d'enregistrer deux fois la même mission.
         * Si une autre mission avec la même nature est déjà présente, notre mission n'est pas enregistrée.
         * Ce n'est cependant pas un problème car il s'agit seuelemnt d'un jeu de données test.
         */
        if (this.missionRepository.findByNatureName("Conseil").isEmpty()){
            missionRepository.save(mission1);
        }

        if (this.missionRepository.findByNatureName("Expertise technique").isEmpty()){
            missionRepository.save(mission2);
        }

        if (this.missionRepository.findByNatureName("Formation").isEmpty()){
            missionRepository.save(mission3);
        }

        LOG.debug("Initialisation des donnees");
    }
}
