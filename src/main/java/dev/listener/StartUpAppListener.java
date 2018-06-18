package dev.listener;

import dev.service.InitialiserDonneesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartUpAppListener {
    @Autowired
    private InitialiserDonneesService initialiserDonneesService;

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent(){
        initialiserDonneesService.Initialiser();
    }
}
