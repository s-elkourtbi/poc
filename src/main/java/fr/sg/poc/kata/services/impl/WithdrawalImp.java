package fr.sg.poc.kata.services.impl;

import fr.sg.poc.kata.metier.impl.WithdrawalMetierImp;
import fr.sg.poc.kata.services.Withdrawal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WithdrawalImp implements Withdrawal {

    @Autowired
    private WithdrawalMetierImp withdrawalMetier;

    @Override
    @RequestMapping(value = "/retrait", method = RequestMethod.POST)
    public Boolean withdraw(@RequestParam Long bankAccountID,@RequestParam float withdrawAmount) throws Exception {

        return withdrawalMetier.withdraw(bankAccountID, withdrawAmount);
    }
}
