package org.arrow.bemywealth.portfolio.immovableasset.land.repository;

import org.arrow.bemywealth.portfolio.immovableasset.land.model.LandModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandAssetRepository extends JpaRepository<LandModel, Integer> {
}
