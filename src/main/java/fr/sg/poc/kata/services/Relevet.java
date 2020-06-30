package fr.sg.poc.kata.services;

import fr.sg.poc.kata.entities.Movement;

import java.io.IOException;
import java.util.List;

public interface Relevet {

    boolean generationRelevet(Long idCompte) throws IOException;

    List<Movement> historique(Long idCompte);
}
