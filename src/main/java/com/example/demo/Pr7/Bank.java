package com.example.demo.Pr7;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Bank {

    private Map<String, Card> cards;

    @PostConstruct
    public void createInfrastructure(){
        cards = new HashMap<>();
        cards.put("2490120398736251", new Card("2490120398736251", "773", "2025-01-02", 100L));
        cards.put("3000400020001000", new Card("3000400020001000", "392", "2023-02-12", 5000L));
    }

    public Map<String, Card> getCards() {
        return cards;
    }


}
