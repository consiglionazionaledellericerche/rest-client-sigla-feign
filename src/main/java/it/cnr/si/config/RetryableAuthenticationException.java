package it.cnr.si.config;

import feign.Request;
import feign.RetryableException;

import java.util.Date;

public class RetryableAuthenticationException extends RetryableException {

    public RetryableAuthenticationException(int status, String message, Request.HttpMethod httpMethod, Throwable cause, Date retryAfter, Request request) {
        super(status, message, httpMethod, cause, retryAfter, request);
    }

    public RetryableAuthenticationException(int status, String message, Request.HttpMethod httpMethod, Date retryAfter, Request request) {
        super(status, message, httpMethod, retryAfter, request);
    }
}
