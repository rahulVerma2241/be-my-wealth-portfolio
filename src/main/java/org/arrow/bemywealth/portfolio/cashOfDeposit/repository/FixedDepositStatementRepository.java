package org.arrow.bemywealth.portfolio.cashOfDeposit.repository;

import org.arrow.bemywealth.portfolio.cashOfDeposit.model.FixedDepositStatementModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FixedDepositStatementRepository extends JpaRepository<FixedDepositStatementModel, Long> {

    List<FixedDepositStatementModel> findByFixedDepositId(UUID uuid);
}
