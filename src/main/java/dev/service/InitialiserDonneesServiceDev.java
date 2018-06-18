package dev.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class InitialiserDonneesServiceDev implements InitialiserDonneesService{

    private static final Logger LOG = LoggerFactory.getLogger(InitialiserDonneesService.class);

    //@Autowired
    //MissionRepository missionrepository;

    @Override
    public void Initialiser() {
        //Mission mission1 = new Mission();

        //missionrepository.save(mission1);

        LOG.debug("Initialisation des donnees");
    }
}
