package com.ecommerce.commonlib.exception.globalException;

import java.util.List;

import com.ecommerce.commonlib.exception.AccessDeniedException;
import com.ecommerce.commonlib.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.ecommerce.commonlib.viewModel.ErrorVm;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler {
    private static final String ERROR_LOG_FORMAT = "Error: URI: {}, ErrorCode: {}, Message: {}";
    private static final String INVALID_REQUEST_INFORMATION_MESSAGE = "Request information is not valid";

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorVm> handleNotFoundException(NotFoundException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = ex.getMessage();
        System.out.println(buildErrorResponse(status, message, null, ex, request, 404));
        return buildErrorResponse(status, message, null, ex, request, 404);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorVm> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        String message = ex.getMessage();

        return buildErrorResponse(status, message, null, ex, request, 403);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorVm> handleOtherException(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String message = ex.getMessage();

        return buildErrorResponse(status, message, null, ex, request, 500);
    }

    private ResponseEntity<ErrorVm> buildErrorResponse(
            HttpStatus status, String message, List<String> errors,
            Exception ex, WebRequest request, int statusCode) {
        ErrorVm errorVm = new ErrorVm(status.toString(), status.getReasonPhrase(), message, errors);

        if (request != null) {
            log.error(ERROR_LOG_FORMAT, this.getServletPath(request), statusCode, message);
        }
        log.error(message, ex);
        return ResponseEntity.status(status).body(errorVm);
    }

    private String getServletPath(WebRequest webRequest) {
        ServletWebRequest servletRequest = (ServletWebRequest) webRequest;
        return servletRequest.getRequest().getServletPath();
    }
}