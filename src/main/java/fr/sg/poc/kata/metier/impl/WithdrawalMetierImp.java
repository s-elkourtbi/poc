package fr.sg.poc.kata.metier.impl;

import fr.sg.poc.kata.entities.BankAccount;
import fr.sg.poc.kata.entities.Movement;
import fr.sg.poc.kata.entities.MovementEnum;
import fr.sg.poc.kata.metier.WithdrawalMetier;
import fr.sg.poc.kata.repository.BankAccountRepository;
import fr.sg.poc.kata.repository.MovementRepository;
import fr.sg.poc.kata.utils.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.TransactionalException;

/**
 * Classe métier pour le retait.
 */
@Slf4j
@Service
public class WithdrawalMetierImp implements WithdrawalMetier {


    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private MovementRepository movementRepository;

    /**
     * Méthode pour éffectuer un retrait d'un compte client.
     * @param bankAccountID
     * @param withdrawAmount
     * @return
     * @throws TransactionalException
     */
    @Override
    public Boolean withdraw(Long bankAccountID, float withdrawAmount) throws TransactionalException {
        Boolean succes = Boolean.FALSE;
        try {
            if (bankAccountID != null && withdrawAmount != 0) {
                if (bankAccountRepository.findById(bankAccountID).isPresent()) {
                    BankAccount bankAccount = bankAccountRepository.findById(bankAccountID).get();
                    Movement movement = new Movement();
                    float newBalance;

                    newBalance = bankAccount.getBalance() - withdrawAmount;
                    bankAccount.setBalance(newBalance);
                    bankAccountRepository.saveAndFlush(bankAccount);
                    movement.setDate(Utilities.getCurrentDate());
                    movement.setAmount(withdrawAmount);
                    movement.setBankAccount(bankAccount);
                    movement.setMovementEnum(MovementEnum.RETRAIT);
                    movementRepository.saveAndFlush(movement);
                    log.info("retrait effectué");
                    succes = Boolean.TRUE;
                }
            }
        } catch (TransactionalException e) {
            log.error(e.getMessage());
        }
        return succes;
    }
}
