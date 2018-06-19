package dev.service;

import dev.model.Nature;
import dev.repository.MissionRepository;
import dev.repository.NatureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

        if (this.natureRepository.findByName("Conseil") == null) {
            Nature nature1 = new Nature(true, true, 20, 5);
            nature1.setName("Conseil");
            natureRepository.save(nature1);
        }

        LOG.debug("Initialisation des donnees");
    }
}
