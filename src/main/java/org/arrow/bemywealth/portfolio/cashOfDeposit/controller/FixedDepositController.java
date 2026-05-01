package org.arrow.bemywealth.portfolio.cashOfDeposit.controller;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.arrow.bemywealth.portfolio.cashOfDeposit.dto.FixedDepositDTO;
import org.arrow.bemywealth.portfolio.cashOfDeposit.service.FixedDepositService;
import org.arrow.bemywealth.portfolio.exception.NoDataFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/fixed-deposit")
@AllArgsConstructor
@CrossOrigin("http://localhost:5173")
public class FixedDepositController {

    private FixedDepositService fixedDepositService;

    @GetMapping("/all")
    public ResponseEntity<List<FixedDepositDTO>> getAllFixedDeposits(@RequestHeader() String token) {
        final List<FixedDepositDTO> allDeposits = fixedDepositService.getAllDeposits("");
        if (allDeposits.isEmpty()) {
            throw new NoDataFoundException("No fixed-deposit found");
        }
        return ResponseEntity.ok(allDeposits);
    }

    @PostMapping("/save")
    public ResponseEntity.BodyBuilder saveFixedDeposit(@NotNull @RequestBody FixedDepositDTO fixedDepositDTO) {
        if (fixedDepositDTO.closeDate().isBefore(fixedDepositDTO.openDate())) {
            throw new NoDataFoundException("No fixed-deposit found");
        }
        fixedDepositService.saveFixedDeposit(fixedDepositDTO);
        return ResponseEntity.accepted();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFixedDeposit(@PathVariable("id") String id, @RequestHeader String token) {
        fixedDepositService.deleteFixedDeposit(id);
        return ResponseEntity.accepted().build();
    }
}
