package com.asverma.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value;

import java.util.List;

import javax.annotation.Nullable;

@Value.Immutable
@JsonSerialize(as = ImmutableCourse.class)
@JsonDeserialize(as = ImmutableCourse.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Course {


    @Nullable
    public abstract Integer getCourseId();

    public abstract String getCourseName();

    public abstract Integer getMinProfessor();

    public abstract Integer getMaxProfessor();

    public abstract Integer getMaxStudents();

    @Nullable
    public abstract List<Professor> getProfessors();

    @Nullable
    public abstract List<Student> getStudents();
}

