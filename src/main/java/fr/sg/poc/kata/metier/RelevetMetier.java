package fr.sg.poc.kata.metier;

import fr.sg.poc.kata.entities.Movement;

import java.io.IOException;
import java.util.List;

public interface RelevetMetier {

    boolean generationRelevet(Long idCompte) throws IOException;

    List<Movement> historique(Long idCompte);
}
