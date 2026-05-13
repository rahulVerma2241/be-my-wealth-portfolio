package org.arrow.bemywealth.portfolio.cashOfDeposit.data;

import lombok.Data;
import lombok.ToString;
import org.arrow.bemywealth.portfolio.cashOfDeposit.util.CompoundingFrequency;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@ToString
public class FixedDepositData {

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
}
