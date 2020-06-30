package fr.sg.poc.kata.services;

import org.springframework.transaction.TransactionException;

public interface ConsultationCompte {

    Float consultationCompte(Long bankAccountID) throws TransactionException;
}
