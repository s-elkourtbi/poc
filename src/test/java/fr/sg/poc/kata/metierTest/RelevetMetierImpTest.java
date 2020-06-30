package fr.sg.poc.kata.metierTest;

import fr.sg.poc.kata.KataApplication;
import fr.sg.poc.kata.entities.BankAccount;
import fr.sg.poc.kata.entities.Movement;
import fr.sg.poc.kata.metier.RelevetMetier;
import fr.sg.poc.kata.repository.BankAccountRepository;
import fr.sg.poc.kata.repository.MovementRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes= KataApplication.class)
@Transactional
public class RelevetMetierImpTest {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private RelevetMetier relevetMetier;

    @Before
    public void setUp() {
        BankAccount bankAccount = new BankAccount();
        Movement movement = new Movement();
        movement.setIdMovement(1000L);
        bankAccount.setIdCompte(1000L);

        Mockito.when(bankAccountRepository.findById(1000L).isPresent()).thenReturn(true);
        Mockito.when(bankAccountRepository.findById(1000L).get()).thenReturn(bankAccount);

        Mockito.when(movementRepository.findById(1000L).isPresent()).thenReturn(true);
        Mockito.when(movementRepository.findById(1000L).get()).thenReturn(movement);
    }

    @Test
    public void generationRelevetTest() throws IOException {

        assertTrue(relevetMetier.generationRelevet(1000L));
    }

    @Test
    public void historiqueTest() throws IOException {

        List<Movement> movements = relevetMetier.historique(1000L);
        assertNotNull(movements);
    }
}
