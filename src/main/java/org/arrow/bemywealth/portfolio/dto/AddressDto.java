package org.arrow.bemywealth.portfolio.dto;

import java.util.UUID;

public record AddressDto( UUID id, String houseNumber, String street, String village,
                          String postOffice, String tehsil, String landmark,
                          String city, String state, String country, Integer pinCode) {
}
