package com.asverma.api.mappers;

import com.asverma.exceptions.SchoolAPIException;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class SchoolAPIExceptionMapper implements ExceptionMapper<SchoolAPIException> {

    @Override
    public Response toResponse(final SchoolAPIException e) {
        return Response.status(e.getHttpStatus())
                       .entity(new SchoolApiErrorResponse(e.getMessage()))
                       .build();
    }

    public static class SchoolApiErrorResponse {

        @JsonProperty("Error Message")
        private final String errorMessage;

        public SchoolApiErrorResponse(final String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }
}
