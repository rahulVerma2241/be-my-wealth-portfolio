package org.arrow.bemywealth.portfolio.cashOfDeposit.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.arrow.bemywealth.portfolio.cashOfDeposit.data.FixedDepositData;
import org.arrow.bemywealth.portfolio.cashOfDeposit.dto.FixedDepositDTO;
import org.arrow.bemywealth.portfolio.cashOfDeposit.mapper.FixedDepositMapper;
import org.arrow.bemywealth.portfolio.cashOfDeposit.model.FixedDepositModel;
import org.arrow.bemywealth.portfolio.cashOfDeposit.repository.FixedDepositRepository;
import org.arrow.bemywealth.portfolio.cashOfDeposit.util.CompoundingFrequency;
import org.arrow.bemywealth.portfolio.cashOfDeposit.util.FinanceUtils;
import org.arrow.bemywealth.portfolio.exception.NoDataFoundException;
import org.springframework.stereotype.Service;


import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class FixedDepositService {

    private FixedDepositRepository fixedDepositRepository;

    public List<FixedDepositDTO> getAllDeposits(String userId) {
        final List<FixedDepositModel> fixedDepositDetails = fixedDepositRepository.findAll();
        return Optional.ofNullable(fixedDepositDetails).orElse(List.of())
                .stream().map(FixedDepositMapper.INSTANCE::mapFixedDepositModel).toList();
    }

    public void saveFixedDeposit(FixedDepositDTO fixedDepositDTO) {
        log.info("Saving fixed deposit: {}", fixedDepositDTO);
        FixedDepositData fixedDepositData = FixedDepositMapper.INSTANCE.mapFixedDepositDto(fixedDepositDTO);
        long between = ChronoUnit.DAYS.between(fixedDepositDTO.openDate(), fixedDepositDTO.closeDate());
        fixedDepositData.setMaturityAmount(FinanceUtils.calculateMaturity(fixedDepositDTO.principalAmount(), fixedDepositDTO.interestRate().doubleValue(),
                fixedDepositData.getCompoundingFrequency().getFrequency(), between));
        fixedDepositData.setPrincipalAmount(fixedDepositDTO.principalAmount());
        log.info("Saving fixed deposit data: {}", fixedDepositData);
        final FixedDepositModel depositModel = fixedDepositRepository.save(FixedDepositMapper.INSTANCE.mapFixedDepositModel(fixedDepositData));
        log.info("Saved FixedDeposit with id:{} ", depositModel.getId());
    }

    public void deleteFixedDeposit(String fixedDepositId) throws NoDataFoundException {
        log.info("Deleting fixed deposit with id:{}", fixedDepositId);
        final Optional<FixedDepositModel> depositModel = fixedDepositRepository.findById(fixedDepositId);
        if (depositModel.isPresent()) {
            fixedDepositRepository.delete(depositModel.get());
        }
        else {
            throw new NoDataFoundException("FixedDeposit with id:" + fixedDepositId + " not found");
        }

    }

}
