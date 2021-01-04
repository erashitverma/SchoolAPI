package com.asverma.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class SchoolAPIException extends RuntimeException {

    private static final long   serialVersionUID = 8116723091362382657L;
    private final        Status httpStatus;

    public SchoolAPIException(final String message) {
        this(message, Status.INTERNAL_SERVER_ERROR);
    }

    public SchoolAPIException(final String message,
                              final Response.Status httpStatus) {
        this(message, httpStatus, null);
    }

    public SchoolAPIException(final String message,
                              final Response.Status httpStatus,
                              final Throwable cause) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public final int getHttpStatus() {
        return this.httpStatus.getStatusCode();
    }
}
