package org.arrow.bemywealth.portfolio.cashOfDeposit.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FinanceUtils {

    /**
     * Calculates FD Maturity Amount
     * Formula: A = P(1 + r/n)^(nt)
     */
    public static BigDecimal calculateMaturity(
        BigDecimal principal, 
        double annualRate, 
        int compoundingFrequency, 
        long days
    ) {
        // Convert rate to decimal (e.g., 7% -> 0.07)
        double r = annualRate / 100;
        double years = (double) days / 365;
        // (1 + r/n)
        double base = 1 + (r / compoundingFrequency);
        
        // (nt)
        double exponent = compoundingFrequency * years;
        
        // Calculate (base^exponent)
        double amount = Math.pow(base, exponent);
        
        // Multiply by Principal and round to 2 decimal places
        return principal.multiply(BigDecimal.valueOf(amount))
                        .setScale(2, RoundingMode.HALF_UP);
    }
}