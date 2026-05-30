package org.arrow.bemywealth.portfolio.cashOfDeposit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.arrow.bemywealth.portfolio.cashOfDeposit.util.CompoundingFrequency;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Table(name = "fixed-deposit")
@Entity
@NoArgsConstructor
public class FixedDepositModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String accountNumber;

    private String institutionName;

    private BigDecimal principalAmount;

    private BigDecimal interestRate;

    private LocalDate openDate;

    private LocalDate closeDate;

    private String nomineeName;

    private String userId;

    private BigDecimal maturityAmount;

    private BigDecimal currentAmount;

    private CompoundingFrequency compoundingFrequency;

    private Double taxPercent;
}
