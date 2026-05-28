package org.arrow.bemywealth.portfolio.cashOfDeposit.mapper;

import org.arrow.bemywealth.portfolio.cashOfDeposit.data.FixedDepositData;
import org.arrow.bemywealth.portfolio.cashOfDeposit.dto.FixedDepositDTO;
import org.arrow.bemywealth.portfolio.cashOfDeposit.model.FixedDepositModel;
import org.arrow.bemywealth.portfolio.cashOfDeposit.util.CompoundingFrequency;
import org.arrow.bemywealth.portfolio.cashOfDeposit.util.FinanceUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import java.math.BigDecimal;
import java.util.Objects;

@Mapper(imports = CompoundingFrequency.class)
public interface FixedDepositMapper {

    FixedDepositMapper INSTANCE = Mappers.getMapper(FixedDepositMapper.class);

    @Mapping(target = "compoundingFrequency", expression = "java(fixedDepositModel.getCompoundingFrequency().getName())")
    FixedDepositDTO mapFixedDepositModel(FixedDepositModel fixedDepositModel) ;

    @Mapping(target="compoundingFrequency", expression = "java(CompoundingFrequency.findByName(fixedDepositDto.compoundingFrequency()))")
    @Mapping(target = "currentAmount", source = "fixedDepositDto" , qualifiedByName = "calculateCurrentAmount")
    @Mapping(target = "principalAmount", source = "fixedDepositDto.principalAmount")
    @Mapping(target = "maturityAmount", source = "fixedDepositDto" , qualifiedByName = "calculateMaturityAmount")
    FixedDepositData mapFixedDepositDto(FixedDepositDTO  fixedDepositDto) ;

    FixedDepositModel mapFixedDepositModel(FixedDepositData fixedDepositData) ;

    @Named("calculateCurrentAmount")
    default BigDecimal calculateCurrentAmount(FixedDepositDTO  fixedDepositDto) {
        return FinanceUtils.currentAmount(fixedDepositDto.principalAmount(), fixedDepositDto.interestRate().doubleValue(),
                Objects.requireNonNull(CompoundingFrequency.findByName(fixedDepositDto.compoundingFrequency())).getFrequency(),
                fixedDepositDto.openDate());
    }


    @Named("calculateMaturityAmount")
    default BigDecimal calculateMaturityAmount(FixedDepositDTO  fixedDepositDTO) {
        return FinanceUtils.calculateMaturity(fixedDepositDTO.principalAmount(), fixedDepositDTO.interestRate().doubleValue(),
                Objects.requireNonNull(CompoundingFrequency.findByName(fixedDepositDTO.compoundingFrequency())).getFrequency(), fixedDepositDTO.openDate(), fixedDepositDTO.closeDate());
    }
}

