package fr.sg.poc.kata.metier;

import javax.transaction.TransactionalException;

public interface WithdrawalMetier {

    Boolean withdraw(Long bankAccountID, float withdrawAmount) throws TransactionalException;
}
