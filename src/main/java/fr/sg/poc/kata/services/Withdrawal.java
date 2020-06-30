package fr.sg.poc.kata.services;

public interface Withdrawal {

    Boolean withdraw(Long bankAccount, float withdrawAmount) throws Exception;
}
