package org.arrow.bemywealth.portfolio.cashOfDeposit.dto;
import org.arrow.bemywealth.portfolio.cashOfDeposit.util.Expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record FixedDepositStatementDTO ( Long id,
         UUID fixedDepositId,
         Expense expense,
         BigDecimal amount,
         BigDecimal taxAmount,
         LocalDate transactionDate,
         LocalDate updateDate) { }
