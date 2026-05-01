package org.arrow.bemywealth.portfolio.config;

import org.apache.coyote.BadRequestException;
import org.arrow.bemywealth.portfolio.exception.NoDataFoundException;
import org.arrow.bemywealth.portfolio.model.ErrorModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PortfolioExceptionHandler {

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ErrorModel> handleNoDataFoundException(NoDataFoundException e) {
        ErrorModel errorModel = new ErrorModel(e.getErrorCode(), e.getMessage());
        return ResponseEntity.ok(errorModel);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorModel> handleBadRequestException(BadRequestException e) {
        ErrorModel errorModel = new ErrorModel(5002, e.getMessage());
        return ResponseEntity.ok(errorModel);
    }
}
