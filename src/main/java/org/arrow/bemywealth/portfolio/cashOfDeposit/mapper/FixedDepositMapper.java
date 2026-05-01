package org.arrow.bemywealth.portfolio.cashOfDeposit.mapper;

import org.arrow.bemywealth.portfolio.cashOfDeposit.data.FixedDepositData;
import org.arrow.bemywealth.portfolio.cashOfDeposit.dto.FixedDepositDTO;
import org.arrow.bemywealth.portfolio.cashOfDeposit.model.FixedDepositModel;
import org.arrow.bemywealth.portfolio.cashOfDeposit.util.CompoundingFrequency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(imports = CompoundingFrequency.class)
public interface FixedDepositMapper {

    FixedDepositMapper INSTANCE = Mappers.getMapper(FixedDepositMapper.class);

    @Mapping(target = "compoundingFrequency", expression = "java(fixedDepositModel.getCompoundingFrequency().getName())")
    FixedDepositDTO mapFixedDepositModel(FixedDepositModel fixedDepositModel) ;

    @Mapping(target="compoundingFrequency", expression = "java(CompoundingFrequency.findByName(fixedDepositDto.compoundingFrequency()))")
    FixedDepositData mapFixedDepositDto(FixedDepositDTO  fixedDepositDto) ;

    FixedDepositModel mapFixedDepositModel(FixedDepositData fixedDepositData) ;
}
