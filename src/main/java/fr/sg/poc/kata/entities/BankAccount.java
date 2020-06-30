package fr.sg.poc.kata.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Entité representative d'un compte bancaire.
 */
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@SequenceGenerator(name = "SEQ_BANKACCOUNT", sequenceName = "SEQ_BANKACCOUNT", allocationSize = 1)
@Table(name = "BANK_ACCOUNT")
@Entity(name = "BankAccount")
public class BankAccount {

    /**
     * l'id du compte.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_BANKACCOUNT")
    @Column(name = "ID_COMPTE", nullable = false, unique = true)
    private Long idCompte;

    /**
     * Le numéro de compte.
     */
    @Column(name = "ACCOUNT_NUMBER", length = 9, nullable = false)
    protected Long accountNumber;

    /**
     * Somme sur le compte.
     */
    @Column(name = "balance")
    private Float balance;

    /**
     * Histroriqye des mouvements sur le compte.
     */
    @OneToMany(mappedBy = "bankAccount", fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
    private List<Movement> movements;

}
