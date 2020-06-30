package fr.sg.poc.kata.services.impl;

import fr.sg.poc.kata.entities.Movement;
import fr.sg.poc.kata.metier.impl.RelevetMetierImp;
import fr.sg.poc.kata.services.Relevet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;

@Slf4j
@RestController
public class RelevetImp implements Relevet {

    @Autowired
    private RelevetMetierImp relevetMetier;

    @Override
    @RequestMapping(value = "/relevet", method = RequestMethod.GET)
    public boolean generationRelevet(@RequestParam Long  idCompte) {
        boolean succes = false;
        try {
            succes =  relevetMetier.generationRelevet(idCompte);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return succes;
    }

    @Override
    @RequestMapping(value = "/historique", method = RequestMethod.GET)
    public List<Movement> historique(@RequestParam Long idCompte) {

        return relevetMetier.historique(idCompte);
    }

}
