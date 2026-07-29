package org.arrow.bemywealth.portfolio.immovableasset.land.model;

import jakarta.persistence.*;
import lombok.Data;
import org.arrow.bemywealth.portfolio.common.model.AddressModel;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "land")
@Data
public class LandModel {

    @Id
    private Integer id;

    private String name;

    private BigDecimal purchasePrice;

    private Boolean inheritance;

    private LocalDate purchaseDate;

    private LocalDate sellDate;

    private BigDecimal sellPrice;

    private BigDecimal currentPrice;


    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressModel address;
}
