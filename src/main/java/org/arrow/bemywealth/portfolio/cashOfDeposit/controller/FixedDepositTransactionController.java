package org.arrow.bemywealth.portfolio.cashOfDeposit.controller;

import lombok.AllArgsConstructor;
import org.arrow.bemywealth.portfolio.cashOfDeposit.dto.FixedDepositStatementDTO;
import org.arrow.bemywealth.portfolio.cashOfDeposit.service.FixedDepositStatementService;
import org.arrow.bemywealth.portfolio.exception.NoDataFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("fixed-deposit")
@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:5173")
public class FixedDepositTransactionController {

    private final FixedDepositStatementService fixedDepositStatementService;


    @GetMapping("/{uuid}/transactions")
    public ResponseEntity<List<FixedDepositStatementDTO>> getAllTransactionDetails(@PathVariable("uuid") UUID uuid) {
        final List<FixedDepositStatementDTO> transactionDetails = fixedDepositStatementService.getTransactionDetails(uuid);
        if (transactionDetails.isEmpty()) {
            throw new NoDataFoundException("No fixed-deposit transaction found");
        }
        return ResponseEntity.ok(transactionDetails);
    }

    @PutMapping("transaction")
    public ResponseEntity<FixedDepositStatementDTO> updateTransaction(@RequestBody FixedDepositStatementDTO statementDTO) {
        final FixedDepositStatementDTO fixedDepositStatementDTO = fixedDepositStatementService.updateTransaction(statementDTO);
        return ResponseEntity.ok(fixedDepositStatementDTO);
    }

    @PostMapping("transaction")
    public ResponseEntity<FixedDepositStatementDTO> saveTransaction(@RequestBody FixedDepositStatementDTO statementDTO) {
        final FixedDepositStatementDTO transaction = fixedDepositStatementService.createTransaction(statementDTO);
        return ResponseEntity.accepted().body(transaction);
    }

    @DeleteMapping("transaction/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable("id") Long id) {
        fixedDepositStatementService.deleteTransaction(id);
        return ResponseEntity.accepted().build();
    }

}
