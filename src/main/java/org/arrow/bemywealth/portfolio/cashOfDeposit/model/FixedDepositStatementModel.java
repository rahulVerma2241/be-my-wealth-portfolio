package org.arrow.bemywealth.portfolio.cashOfDeposit.model;

import jakarta.persistence.*;
import lombok.Data;
import org.arrow.bemywealth.portfolio.cashOfDeposit.util.Expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "fixed-deposit-statement")
public class FixedDepositStatementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID fixedDepositId;

    private Expense expense;

    private BigDecimal amount;

    private LocalDate transactionDate;

    private LocalDate updateDate;

    private String comment;
}
