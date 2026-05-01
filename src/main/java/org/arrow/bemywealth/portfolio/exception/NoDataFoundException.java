package org.arrow.bemywealth.portfolio.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoDataFoundException extends RuntimeException {

    private int errorCode = 5001;
    private String errorMessage;

    public NoDataFoundException(String message) {
        super(message);
    }

    public NoDataFoundException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
