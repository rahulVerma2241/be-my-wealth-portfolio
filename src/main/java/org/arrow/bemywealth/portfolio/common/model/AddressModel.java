package org.arrow.bemywealth.portfolio.common.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "address")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String houseNumber;

    private String street;

    private String village;

    private String postOffice;

    private String tehsil;

    private String landmark;

    private String city;

    private String state;

    private String country;

    private Integer pinCode;
}
