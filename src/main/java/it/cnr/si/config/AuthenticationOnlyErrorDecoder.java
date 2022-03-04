package it.cnr.si.config;

import feign.Response;
import feign.codec.ErrorDecoder;

public class AuthenticationOnlyErrorDecoder implements ErrorDecoder {

    private ErrorDecoder inner = new ErrorDecoder.Default();

    public Exception decode(String methodKey, Response response) {
        if (response.status() == 401) {
            throw new RuntimeException("Access denied!");
        } else {
            return inner.decode(methodKey, response);
        }
    }
}
