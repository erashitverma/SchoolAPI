package com.asverma.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value;

import javax.annotation.Nullable;

@Value.Immutable
@Value.Modifiable
@JsonSerialize(as = ImmutableStudent.class)
@JsonDeserialize(as = ImmutableStudent.class)
public abstract class Student {

    public static ImmutableStudent.Builder builder() {
        return ImmutableStudent.builder();
    }

    @Nullable
    public abstract Integer getStudentId();

    public abstract String getFirstName();

    public abstract String getLastName();
}
