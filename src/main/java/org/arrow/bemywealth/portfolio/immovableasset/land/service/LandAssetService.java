package org.arrow.bemywealth.portfolio.immovableasset.land.service;

import org.arrow.bemywealth.portfolio.immovableasset.land.dto.LandDto;
import java.util.List;


public interface LandAssetService {

    List<LandDto> getLands(String userId);

    void createNewAssetLand(LandDto landDto);

    void updateAssetLand(LandDto landDto);
}
