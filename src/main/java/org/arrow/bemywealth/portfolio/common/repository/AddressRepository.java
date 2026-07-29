package org.arrow.bemywealth.portfolio.common.repository;

import org.arrow.bemywealth.portfolio.common.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<AddressModel, UUID> {
}
