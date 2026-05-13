package org.arrow.bemywealth.portfolio.cashOfDeposit.dto;

import java.math.BigDecimal;
import java.util.List;

public record FixedDepositSearchDTO(List<FixedDepositDTO> fixedDepositDTO, BigDecimal totalPrincipalAmount, BigDecimal totalCurrentAmount) {
}
