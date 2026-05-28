package org.arrow.bemywealth.portfolio.cashOfDeposit.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FinanceUtils {

    /**
     * Calculates FD Maturity Amount
     * Formula: A = P(1 + r/n)^(nt)
     */
    public static BigDecimal calculateMaturity(
        BigDecimal principal, double annualRate, int compoundingFrequency,
        LocalDate depositDate, LocalDate maturityDate)
    {
        double years = (double) ChronoUnit.DAYS.between(depositDate, maturityDate) / 365;
        // (1 + r/n)
        double base = 1 + (annualRate * 0.01 / compoundingFrequency);
        // (nt)
        double exponent = compoundingFrequency * years;
        // Calculate (base^exponent)
        double amount = Math.pow(base, exponent);
        
        // Multiply by Principal and round to 2 decimal places
        return principal.multiply(BigDecimal.valueOf(amount))
                        .setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal currentAmount(BigDecimal principal, double annualRate, int compoundingFrequency, LocalDate depositDate)
    {

        double years = (double) ChronoUnit.DAYS.between(depositDate, LocalDate.now()) / 365;
        double base = 1 + (annualRate * 0.01 / compoundingFrequency);
        // (nt)
        double exponent = compoundingFrequency * years;

        // Calculate (base^exponent)
        double amount = Math.pow(base, exponent);

        // Multiply by Principal and round to 2 decimal places
        return principal.multiply(BigDecimal.valueOf(amount))
                .setScale(2, RoundingMode.HALF_UP);

    }
}