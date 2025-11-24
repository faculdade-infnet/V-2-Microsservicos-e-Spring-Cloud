package com.infnet.kubernetes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class Controller {
    final private Random random = new Random();

    final private List<String> frases = Arrays.asList(
            "O gato pulou o muro antes da chuva.",
            "Por que os pinguins não voam?",
            "Esqueci de comprar pão hoje de manhã.",
            "A lua parece maior perto do horizonte.",
            "O silêncio às vezes é a resposta mais alta.",
            "Uma bicicleta roxa passou apressada.",
            "O café está quase pronto.",
            "Existem mais estrelas no universo do que grãos de areia na Terra."
    );

    @GetMapping("/")
    public String indexRoute() {
        int index = random.nextInt(frases.size());
        String result = frases.get(index);

        return result;
    }
}
