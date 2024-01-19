package org.br.mineradora.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "proposal")
@Data
@NoArgsConstructor
public class ProposalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customer;

    @Column(name = "price_tonne")
    private BigDecimal priceTonne;

    private Integer tonnes;

    private String country;

    @Column(name = "proposal_validity_days" )
    private Integer proposalValidityDays;

    private LocalDateTime created;

}
