package org.arrow.bemywealth.portfolio.immovableasset.land.dto;

import org.arrow.bemywealth.portfolio.dto.AddressDto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LandDto (Integer id, String name, BigDecimal purchasePrice, Boolean inheritance,
                       LocalDate purchaseDate, LocalDate sellDate,
                       BigDecimal sellPrice, BigDecimal currentPrice,
                       AddressDto addressDto) {
}
