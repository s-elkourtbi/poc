package fr.sg.poc.kata.services;

import org.springframework.transaction.TransactionException;

public interface Deposit {

    Boolean depot(Long bankAccount, float amount) throws TransactionException;
}
