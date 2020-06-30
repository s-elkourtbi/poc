package fr.sg.poc.kata.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Entité representative d'un mouvement sur le compte bancaire
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MOVEMENT")
@Entity(name = "Movement")
@SequenceGenerator(name = "SEQ_MOVEMENT", sequenceName = "SEQ_MOVEMENT", allocationSize = 1)
public class Movement {

    /**
     * L'id du mouvement (PK).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_MOVEMENT")
    @Column(name = "ID_MOVEMENT", nullable = false, unique = true)
    private Long idMovement;

    /**
     * Le montant retirait du compte.
     */
     @Column(name = "AMOUNT")
    private float amount;

    /**
     * Date de l'opération.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_MOVEMENT")
    private Date date;

    /**
     * (FK) sur le compte bancaire
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_COMPTE")
    @JsonIgnore
    private BankAccount bankAccount;

    /**
     * La date du mouvement.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_DE_MOUVEMENT")
    private MovementEnum movementEnum;

}

