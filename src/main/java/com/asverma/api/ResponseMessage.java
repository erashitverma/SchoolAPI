package com.asverma.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseMessage {
    @JsonProperty("message")
    private final String message;

    public ResponseMessage(final String message) {
        this.message = message;
    }
}
