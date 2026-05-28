package org.arrow.bemywealth.portfolio.cashOfDeposit.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CompoundingFrequency {

    MONTHLY("Monthly", 12),

    QUARTERLY("Quarterly", 4),

    HALF_YEARLY("Half Yearly", 2),

    YEARLY("Yearly", 1);

    private final String name;

    private final int frequency;

    public static CompoundingFrequency findByName(String name) {
        for (CompoundingFrequency frequency : values()) {
            if (frequency.name.equalsIgnoreCase(name)) {
                return frequency;
            }
        }
        return null;
    }
}
