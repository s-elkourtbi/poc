package fr.sg.poc.kata.metierTest;

import fr.sg.poc.kata.KataApplication;
import fr.sg.poc.kata.entities.BankAccount;
import fr.sg.poc.kata.metier.WithdrawalMetier;
import fr.sg.poc.kata.repository.BankAccountRepository;
import fr.sg.poc.kata.repository.MovementRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes= KataApplication.class)
@Transactional
public class WithdrawalMetierImpTest {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @MockBean
    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private WithdrawalMetier withdrawalMetier;

    @Before
    public void setUp() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(1.0f);
        bankAccount.setAccountNumber(1L);
        bankAccount.setIdCompte(1000L);

        Mockito.when(bankAccountRepository.findById(1000L).isPresent())
                .thenReturn(Boolean.valueOf("1"));
        Mockito.when(bankAccountRepository.findById(1000L).get())
                .thenReturn(bankAccount);
    }

    @Test
    public void testRetrait() {
        assertTrue(withdrawalMetier.withdraw(1000L,1));
    }
}
