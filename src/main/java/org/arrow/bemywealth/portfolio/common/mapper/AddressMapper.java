package org.arrow.bemywealth.portfolio.common.mapper;

import org.arrow.bemywealth.portfolio.common.model.AddressModel;
import org.arrow.bemywealth.portfolio.dto.AddressDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressModel addressToAddressModel(AddressDto addressDto) ;
}
