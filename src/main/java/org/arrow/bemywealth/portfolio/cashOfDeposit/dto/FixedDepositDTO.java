package org.arrow.bemywealth.portfolio.cashOfDeposit.dto;


import java.math.BigDecimal;
import java.time.LocalDate;


public record FixedDepositDTO (String id ,String institutionName, BigDecimal principalAmount,
                               BigDecimal interestRate,
                                LocalDate openDate, LocalDate closeDate, String nomineeName,
                               String compoundingFrequency, BigDecimal maturityAmount) { }

