package org.arrow.bemywealth.portfolio.cashOfDeposit.repository;

import org.arrow.bemywealth.portfolio.cashOfDeposit.model.FixedDepositModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FixedDepositRepository extends JpaRepository<FixedDepositModel, String> {

    List<FixedDepositModel> findByUserId(String userId);
}
