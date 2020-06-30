package fr.sg.poc.kata.services.impl;

import fr.sg.poc.kata.metier.impl.ConsultationCompteMetierImp;
import fr.sg.poc.kata.services.ConsultationCompte;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ConsultationCompteImp implements ConsultationCompte {

    @Autowired
    private ConsultationCompteMetierImp consultationCompteMetierImp;

    @Override
    @RequestMapping(value = "/consultationCompte", method = RequestMethod.GET)
    public Float consultationCompte(@RequestParam Long bankAccountID) throws TransactionException {
        Float balance = 0f;
        try {
            balance = consultationCompteMetierImp.consultationCompte(bankAccountID);
        } catch (TransactionException e) {
        }
        return balance;
    }

}
