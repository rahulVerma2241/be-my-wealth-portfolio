package org.arrow.bemywealth.portfolio.immovableasset.land.mapper;

import org.arrow.bemywealth.portfolio.common.model.AddressModel;
import org.arrow.bemywealth.portfolio.immovableasset.land.dto.LandDto;
import org.arrow.bemywealth.portfolio.immovableasset.land.model.LandModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper
public interface LandAssetMapper {

    LandAssetMapper INSTANCE = Mappers.getMapper(LandAssetMapper.class);

    @Mapping(target = "addressDto", source = "landModel.address")
    LandDto mapLandDto(LandModel landModel);


    LandModel mapLandModel(LandDto landDto);
}
