package fr.sg.poc.kata.services;

import fr.sg.poc.kata.entities.BankAccount;

public interface NouveauClient {

    Boolean nouvauClient(BankAccount bankAccount) throws Exception;
}
