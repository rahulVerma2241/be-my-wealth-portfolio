package org.arrow.bemywealth.portfolio.cashOfDeposit.repository;

import org.arrow.bemywealth.portfolio.cashOfDeposit.model.FixedDepositModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FixedDepositRepository extends JpaRepository<FixedDepositModel, UUID> {

    List<FixedDepositModel> findByUserId(String userId);
}
