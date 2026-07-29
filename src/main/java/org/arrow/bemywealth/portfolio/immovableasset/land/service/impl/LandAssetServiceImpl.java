package org.arrow.bemywealth.portfolio.immovableasset.land.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.arrow.bemywealth.portfolio.common.mapper.AddressMapper;
import org.arrow.bemywealth.portfolio.common.model.AddressModel;
import org.arrow.bemywealth.portfolio.common.repository.AddressRepository;
import org.arrow.bemywealth.portfolio.exception.NoDataFoundException;
import org.arrow.bemywealth.portfolio.immovableasset.land.dto.LandDto;
import org.arrow.bemywealth.portfolio.immovableasset.land.mapper.LandAssetMapper;
import org.arrow.bemywealth.portfolio.immovableasset.land.model.LandModel;
import org.arrow.bemywealth.portfolio.immovableasset.land.repository.LandAssetRepository;
import org.arrow.bemywealth.portfolio.immovableasset.land.service.LandAssetService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class LandAssetServiceImpl implements LandAssetService {

    private final LandAssetRepository landAssetRepository;

    private final AddressRepository addressRepository;

    private final AddressMapper addressMapper;

    private final LandAssetMapper LAND_MAPPER =  Mappers.getMapper(LandAssetMapper.class);

    @Override
    public List<LandDto> getLands(String userId) {
        return Optional.ofNullable(landAssetRepository.findAll()).orElse(List.of())
                .stream().map(LAND_MAPPER::mapLandDto).toList();
    }

    @Override
    public void createNewAssetLand(LandDto landDto) {
        var addressModel = addressMapper.addressToAddressModel(landDto.addressDto());
        final AddressModel save = addressRepository.save(addressModel);
        log.info("Saved address model: {}", save.getId());
        var landModel = LAND_MAPPER.mapLandModel(landDto);
        landModel.setAddress(save);
        landAssetRepository.save(landModel);

    }

    @Override
    public void updateAssetLand(LandDto landDto) {
        final Optional<LandModel> existingRecord = landAssetRepository.findById(landDto.id());
        if (existingRecord.isPresent()) {
            var addressModel = addressMapper.addressToAddressModel(landDto.addressDto());
            final AddressModel save = addressRepository.save(addressModel);
            var landModel = LAND_MAPPER.mapLandModel(landDto);
            landModel.setAddress(save);
            landAssetRepository.save(landModel);
        }
        throw new NoDataFoundException(101, "No data found for Land");
    }
}
