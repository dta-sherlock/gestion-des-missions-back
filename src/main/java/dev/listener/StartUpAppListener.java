package dev.listener;


import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartUpAppListener {

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent(){
    }
}
