package fr.sg.poc.kata.services.impl;

import fr.sg.poc.kata.entities.BankAccount;
import fr.sg.poc.kata.metier.impl.NouveauClientMetierImp;
import fr.sg.poc.kata.services.NouveauClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NouveauClientImp implements NouveauClient {

    @Autowired
    private NouveauClientMetierImp nouveauClientMetier;

    @Override
    @RequestMapping(value = "/nouveauClient", method = RequestMethod.POST)
    public Boolean nouvauClient(@RequestBody BankAccount bankAccount) {
        Boolean succes = Boolean.FALSE;
        try {
           succes = nouveauClientMetier.nouvauClient(bankAccount);
        } catch (Exception e) {
            e.getMessage();
        }
        return succes;
    }
}
