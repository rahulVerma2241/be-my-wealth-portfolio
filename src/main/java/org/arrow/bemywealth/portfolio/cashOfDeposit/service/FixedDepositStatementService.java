package org.arrow.bemywealth.portfolio.cashOfDeposit.service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.arrow.bemywealth.portfolio.cashOfDeposit.dto.FixedDepositStatementDTO;
import org.arrow.bemywealth.portfolio.cashOfDeposit.mapper.FixedDepositMapper;
import org.arrow.bemywealth.portfolio.cashOfDeposit.model.FixedDepositStatementModel;
import org.arrow.bemywealth.portfolio.cashOfDeposit.repository.FixedDepositRepository;
import org.arrow.bemywealth.portfolio.cashOfDeposit.repository.FixedDepositStatementRepository;
import org.arrow.bemywealth.portfolio.exception.NoDataFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class FixedDepositStatementService {

    private final FixedDepositStatementRepository statementRepository;

    private final FixedDepositRepository fixedDepositRepository;

    public List<FixedDepositStatementDTO> getTransactionDetails(@NotBlank @NotNull UUID uuid) {
        log.info("getTransactionDetails called");
        final List<FixedDepositStatementModel> statements = statementRepository.findByFixedDepositId(uuid);
        if  (statements.isEmpty()) {
            throw new NoDataFoundException("No fixed-deposit transaction found");
        }
        return statements.stream().map(FixedDepositMapper.INSTANCE::mapFixedDepositStatementDto).toList();
    }

    public FixedDepositStatementDTO updateTransaction(FixedDepositStatementDTO fixedDepositStatementDTO) {
        log.info("updateTransaction called");
        final boolean exists = statementRepository.existsById(fixedDepositStatementDTO.id());
        if (!exists) {
            throw new NoDataFoundException("No fixed-deposit transaction found "+ fixedDepositStatementDTO.id());
        }
        log.debug("transaction available for update {}", fixedDepositStatementDTO);
        final FixedDepositStatementModel model = statementRepository.save(FixedDepositMapper.INSTANCE.mapFixedDepositStatementModel(fixedDepositStatementDTO));
        log.debug("statement model updated {}", model);
        return FixedDepositMapper.INSTANCE.mapFixedDepositStatementDto(model);
    }

    public FixedDepositStatementDTO createTransaction(FixedDepositStatementDTO fixedDepositStatementDTO) {
        log.info("createTransaction called");
        final boolean exists = fixedDepositRepository.existsById(fixedDepositStatementDTO.fixedDepositId());
        if (!exists) {
            throw new NoDataFoundException("No fixed-deposit found");
        }
        log.debug("transaction available for create {}", fixedDepositStatementDTO);
        statementRepository.save(FixedDepositMapper.INSTANCE.mapFixedDepositStatementModel(fixedDepositStatementDTO));
        return fixedDepositStatementDTO;
    }

    public void deleteTransaction(Long id) {
        log.info("deleteTransaction called {}" , id);
        statementRepository.deleteById(id);
    }
}
