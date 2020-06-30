package fr.sg.poc.kata.metierTest;

import fr.sg.poc.kata.KataApplication;
import fr.sg.poc.kata.entities.BankAccount;
import fr.sg.poc.kata.metier.ConsultationCompteMetier;
import fr.sg.poc.kata.repository.BankAccountRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes= KataApplication.class)
@Transactional
public class ConsultationCompteMetierImptTest {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private ConsultationCompteMetier consultationCompteMetier;

    @Before
    public void setUp() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setIdCompte(1000L);

        Mockito.when(bankAccountRepository.findById(1000L).isPresent()).thenReturn(true);
        Mockito.when(bankAccountRepository.findById(1000L).get()).thenReturn(bankAccount);

    }

    @Test
    public void testConsultationCompte() {

        assertEquals(5265.0f, consultationCompteMetier.consultationCompte(1000L));
    }
}
