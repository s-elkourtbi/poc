package fr.sg.poc.kata.metier;

import org.springframework.transaction.TransactionException;

public interface DepositMetier {

    Boolean depot(Long bankAccountID, float amount) throws TransactionException;
}
