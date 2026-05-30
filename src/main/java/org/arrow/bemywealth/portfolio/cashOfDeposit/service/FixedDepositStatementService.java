package org.arrow.bemywealth.portfolio.cashOfDeposit.service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.arrow.bemywealth.portfolio.cashOfDeposit.dto.FixedDepositStatementDTO;
import org.arrow.bemywealth.portfolio.cashOfDeposit.mapper.FixedDepositMapper;
import org.arrow.bemywealth.portfolio.cashOfDeposit.model.FixedDepositStatementModel;
import org.arrow.bemywealth.portfolio.cashOfDeposit.repository.FixedDepositStatementRepository;
import org.arrow.bemywealth.portfolio.exception.NoDataFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FixedDepositStatementService {

    private final FixedDepositStatementRepository statementRepository;

    public List<FixedDepositStatementDTO> getTransactionDetails(@NotBlank @NotNull UUID uuid) {
        final List<FixedDepositStatementModel> statements = statementRepository.findByFixedDepositId(uuid);
        if  (statements.isEmpty()) {
            throw new NoDataFoundException("No fixed-deposit transaction found");
        }
        return statements.stream().map(FixedDepositMapper.INSTANCE::mapFixedDepositStatementDto).toList();
    }
}
