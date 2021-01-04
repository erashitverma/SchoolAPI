package com.asverma.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public class ApiResponseWrapper<T> {

    private final T data;

    public ApiResponseWrapper(final T data) {
        this.data = data;
    }

    /**
     * @return The value of the {@code data} attribute
     */
    @JsonProperty("data")
    public Optional<T> getData() {
        return Optional.ofNullable(this.data);
    }
}
