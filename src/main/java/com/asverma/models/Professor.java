package com.asverma.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value;

import javax.annotation.Nullable;

@Value.Immutable
@JsonSerialize(as = ImmutableProfessor.class)
@JsonDeserialize(as = ImmutableProfessor.class)
public abstract class Professor {

    @Nullable
    public abstract Integer getProfessorId();

    public abstract String getFirstName();

    public abstract String getLastName();
}
