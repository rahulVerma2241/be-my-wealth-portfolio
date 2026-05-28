package org.arrow.bemywealth.portfolio.cashOfDeposit.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;


public record FixedDepositDTO (String id , @NotNull  BigDecimal amount, @NotNull String accountNumber, @NotNull String institutionName,
                               @NotNull @Min(5_000)  BigDecimal principalAmount, @NotNull @Min(0) BigDecimal interestRate, @NotNull LocalDate openDate,
                               @NotNull LocalDate closeDate, String nomineeName, @NotNull String compoundingFrequency, BigDecimal maturityAmount, BigDecimal currentAmount) { }

