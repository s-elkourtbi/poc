package fr.sg.poc.kata.metierTest;

import fr.sg.poc.kata.KataApplication;
import fr.sg.poc.kata.entities.BankAccount;
import fr.sg.poc.kata.metier.NouveauClientMetier;
import fr.sg.poc.kata.repository.BankAccountRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes= KataApplication.class)
public class NouveauClientImpTest {

    @MockBean
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private NouveauClientMetier nouveauClientMetierImp;

    @Before
    public void setUp() {
        BankAccount bankAccount = new BankAccount();
            bankAccount.setBalance(1.0f);
            bankAccount.setAccountNumber(1L);
            bankAccount.setIdCompte(1L);

        Mockito.when(nouveauClientMetierImp.nouvauClient(bankAccount))
                .thenReturn(Boolean.valueOf("1"));
    }

    @Test
    public void testNouveauClient() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(1.0f);
        bankAccount.setAccountNumber(1L);
        bankAccount.setIdCompte(1L);
        assertTrue(nouveauClientMetierImp.nouvauClient(bankAccount));
    }
}
