package com.asverma.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link Course}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableCourse.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "Course"})
@Immutable
@CheckReturnValue
public final class ImmutableCourse extends Course {
  private final @Nullable Integer courseId;
  private final String courseName;
  private final Integer minProfessor;
  private final Integer maxProfessor;
  private final Integer maxStudents;
  private final @Nullable ImmutableList<Professor> professors;
  private final @Nullable ImmutableList<Student> students;

  private ImmutableCourse(
      @Nullable Integer courseId,
      String courseName,
      Integer minProfessor,
      Integer maxProfessor,
      Integer maxStudents,
      @Nullable ImmutableList<Professor> professors,
      @Nullable ImmutableList<Student> students) {
    this.courseId = courseId;
    this.courseName = courseName;
    this.minProfessor = minProfessor;
    this.maxProfessor = maxProfessor;
    this.maxStudents = maxStudents;
    this.professors = professors;
    this.students = students;
  }

  /**
   * @return The value of the {@code courseId} attribute
   */
  @JsonProperty("courseId")
  @Override
  public @Nullable Integer getCourseId() {
    return courseId;
  }

  /**
   * @return The value of the {@code courseName} attribute
   */
  @JsonProperty("courseName")
  @Override
  public String getCourseName() {
    return courseName;
  }

  /**
   * @return The value of the {@code minProfessor} attribute
   */
  @JsonProperty("minProfessor")
  @Override
  public Integer getMinProfessor() {
    return minProfessor;
  }

  /**
   * @return The value of the {@code maxProfessor} attribute
   */
  @JsonProperty("maxProfessor")
  @Override
  public Integer getMaxProfessor() {
    return maxProfessor;
  }

  /**
   * @return The value of the {@code maxStudents} attribute
   */
  @JsonProperty("maxStudents")
  @Override
  public Integer getMaxStudents() {
    return maxStudents;
  }

  /**
   * @return The value of the {@code professors} attribute
   */
  @JsonProperty("professors")
  @Override
  public @Nullable ImmutableList<Professor> getProfessors() {
    return professors;
  }

  /**
   * @return The value of the {@code students} attribute
   */
  @JsonProperty("students")
  @Override
  public @Nullable ImmutableList<Student> getStudents() {
    return students;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Course#getCourseId() courseId} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for courseId (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCourse withCourseId(@Nullable Integer value) {
    if (Objects.equals(this.courseId, value)) return this;
    return new ImmutableCourse(
        value,
        this.courseName,
        this.minProfessor,
        this.maxProfessor,
        this.maxStudents,
        this.professors,
        this.students);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Course#getCourseName() courseName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for courseName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCourse withCourseName(String value) {
    if (this.courseName.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "courseName");
    return new ImmutableCourse(
        this.courseId,
        newValue,
        this.minProfessor,
        this.maxProfessor,
        this.maxStudents,
        this.professors,
        this.students);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Course#getMinProfessor() minProfessor} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for minProfessor
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCourse withMinProfessor(Integer value) {
    if (this.minProfessor.equals(value)) return this;
    Integer newValue = Objects.requireNonNull(value, "minProfessor");
    return new ImmutableCourse(
        this.courseId,
        this.courseName,
        newValue,
        this.maxProfessor,
        this.maxStudents,
        this.professors,
        this.students);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Course#getMaxProfessor() maxProfessor} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for maxProfessor
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCourse withMaxProfessor(Integer value) {
    if (this.maxProfessor.equals(value)) return this;
    Integer newValue = Objects.requireNonNull(value, "maxProfessor");
    return new ImmutableCourse(
        this.courseId,
        this.courseName,
        this.minProfessor,
        newValue,
        this.maxStudents,
        this.professors,
        this.students);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Course#getMaxStudents() maxStudents} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for maxStudents
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCourse withMaxStudents(Integer value) {
    if (this.maxStudents.equals(value)) return this;
    Integer newValue = Objects.requireNonNull(value, "maxStudents");
    return new ImmutableCourse(
        this.courseId,
        this.courseName,
        this.minProfessor,
        this.maxProfessor,
        newValue,
        this.professors,
        this.students);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Course#getProfessors() professors}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCourse withProfessors(@Nullable Professor... elements) {
    if (elements == null) {
      return new ImmutableCourse(
          this.courseId,
          this.courseName,
          this.minProfessor,
          this.maxProfessor,
          this.maxStudents,
          null,
          this.students);
    }
    @Nullable ImmutableList<Professor> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableCourse(
        this.courseId,
        this.courseName,
        this.minProfessor,
        this.maxProfessor,
        this.maxStudents,
        newValue,
        this.students);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Course#getProfessors() professors}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of professors elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCourse withProfessors(@Nullable Iterable<? extends Professor> elements) {
    if (this.professors == elements) return this;
    @Nullable ImmutableList<Professor> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableCourse(
        this.courseId,
        this.courseName,
        this.minProfessor,
        this.maxProfessor,
        this.maxStudents,
        newValue,
        this.students);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Course#getStudents() students}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCourse withStudents(@Nullable Student... elements) {
    if (elements == null) {
      return new ImmutableCourse(
          this.courseId,
          this.courseName,
          this.minProfessor,
          this.maxProfessor,
          this.maxStudents,
          this.professors,
          null);
    }
    @Nullable ImmutableList<Student> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableCourse(
        this.courseId,
        this.courseName,
        this.minProfessor,
        this.maxProfessor,
        this.maxStudents,
        this.professors,
        newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Course#getStudents() students}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of students elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCourse withStudents(@Nullable Iterable<? extends Student> elements) {
    if (this.students == elements) return this;
    @Nullable ImmutableList<Student> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableCourse(
        this.courseId,
        this.courseName,
        this.minProfessor,
        this.maxProfessor,
        this.maxStudents,
        this.professors,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableCourse} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableCourse
        && equalTo((ImmutableCourse) another);
  }

  private boolean equalTo(ImmutableCourse another) {
    return Objects.equals(courseId, another.courseId)
        && courseName.equals(another.courseName)
        && minProfessor.equals(another.minProfessor)
        && maxProfessor.equals(another.maxProfessor)
        && maxStudents.equals(another.maxStudents)
        && Objects.equals(professors, another.professors)
        && Objects.equals(students, another.students);
  }

  /**
   * Computes a hash code from attributes: {@code courseId}, {@code courseName}, {@code minProfessor}, {@code maxProfessor}, {@code maxStudents}, {@code professors}, {@code students}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Objects.hashCode(courseId);
    h += (h << 5) + courseName.hashCode();
    h += (h << 5) + minProfessor.hashCode();
    h += (h << 5) + maxProfessor.hashCode();
    h += (h << 5) + maxStudents.hashCode();
    h += (h << 5) + Objects.hashCode(professors);
    h += (h << 5) + Objects.hashCode(students);
    return h;
  }

  /**
   * Prints the immutable value {@code Course} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Course")
        .omitNullValues()
        .add("courseId", courseId)
        .add("courseName", courseName)
        .add("minProfessor", minProfessor)
        .add("maxProfessor", maxProfessor)
        .add("maxStudents", maxStudents)
        .add("professors", professors)
        .add("students", students)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends Course {
    @Nullable Integer courseId;
    @Nullable String courseName;
    @Nullable Integer minProfessor;
    @Nullable Integer maxProfessor;
    @Nullable Integer maxStudents;
    List<Professor> professors = null;
    List<Student> students = null;
    @JsonProperty("courseId")
    public void setCourseId(@Nullable Integer courseId) {
      this.courseId = courseId;
    }
    @JsonProperty("courseName")
    public void setCourseName(String courseName) {
      this.courseName = courseName;
    }
    @JsonProperty("minProfessor")
    public void setMinProfessor(Integer minProfessor) {
      this.minProfessor = minProfessor;
    }
    @JsonProperty("maxProfessor")
    public void setMaxProfessor(Integer maxProfessor) {
      this.maxProfessor = maxProfessor;
    }
    @JsonProperty("maxStudents")
    public void setMaxStudents(Integer maxStudents) {
      this.maxStudents = maxStudents;
    }
    @JsonProperty("professors")
    public void setProfessors(@Nullable List<Professor> professors) {
      this.professors = professors;
    }
    @JsonProperty("students")
    public void setStudents(@Nullable List<Student> students) {
      this.students = students;
    }
    @Override
    public Integer getCourseId() { throw new UnsupportedOperationException(); }
    @Override
    public String getCourseName() { throw new UnsupportedOperationException(); }
    @Override
    public Integer getMinProfessor() { throw new UnsupportedOperationException(); }
    @Override
    public Integer getMaxProfessor() { throw new UnsupportedOperationException(); }
    @Override
    public Integer getMaxStudents() { throw new UnsupportedOperationException(); }
    @Override
    public List<Professor> getProfessors() { throw new UnsupportedOperationException(); }
    @Override
    public List<Student> getStudents() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableCourse fromJson(Json json) {
    ImmutableCourse.Builder builder = ImmutableCourse.builder();
    if (json.courseId != null) {
      builder.courseId(json.courseId);
    }
    if (json.courseName != null) {
      builder.courseName(json.courseName);
    }
    if (json.minProfessor != null) {
      builder.minProfessor(json.minProfessor);
    }
    if (json.maxProfessor != null) {
      builder.maxProfessor(json.maxProfessor);
    }
    if (json.maxStudents != null) {
      builder.maxStudents(json.maxStudents);
    }
    if (json.professors != null) {
      builder.addAllProfessors(json.professors);
    }
    if (json.students != null) {
      builder.addAllStudents(json.students);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Course} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Course instance
   */
  public static ImmutableCourse copyOf(Course instance) {
    if (instance instanceof ImmutableCourse) {
      return (ImmutableCourse) instance;
    }
    return ImmutableCourse.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableCourse ImmutableCourse}.
   * @return A new ImmutableCourse builder
   */
  public static ImmutableCourse.Builder builder() {
    return new ImmutableCourse.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableCourse ImmutableCourse}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_COURSE_NAME = 0x1L;
    private static final long INIT_BIT_MIN_PROFESSOR = 0x2L;
    private static final long INIT_BIT_MAX_PROFESSOR = 0x4L;
    private static final long INIT_BIT_MAX_STUDENTS = 0x8L;
    private long initBits = 0xfL;

    private @Nullable Integer courseId;
    private @Nullable String courseName;
    private @Nullable Integer minProfessor;
    private @Nullable Integer maxProfessor;
    private @Nullable Integer maxStudents;
    private ImmutableList.Builder<Professor> professors = null;
    private ImmutableList.Builder<Student> students = null;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Course} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(Course instance) {
      Objects.requireNonNull(instance, "instance");
      @Nullable Integer courseIdValue = instance.getCourseId();
      if (courseIdValue != null) {
        courseId(courseIdValue);
      }
      courseName(instance.getCourseName());
      minProfessor(instance.getMinProfessor());
      maxProfessor(instance.getMaxProfessor());
      maxStudents(instance.getMaxStudents());
      @Nullable List<Professor> professorsValue = instance.getProfessors();
      if (professorsValue != null) {
        addAllProfessors(professorsValue);
      }
      @Nullable List<Student> studentsValue = instance.getStudents();
      if (studentsValue != null) {
        addAllStudents(studentsValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link Course#getCourseId() courseId} attribute.
     * @param courseId The value for courseId (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("courseId")
    public final Builder courseId(@Nullable Integer courseId) {
      this.courseId = courseId;
      return this;
    }

    /**
     * Initializes the value for the {@link Course#getCourseName() courseName} attribute.
     * @param courseName The value for courseName 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("courseName")
    public final Builder courseName(String courseName) {
      this.courseName = Objects.requireNonNull(courseName, "courseName");
      initBits &= ~INIT_BIT_COURSE_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link Course#getMinProfessor() minProfessor} attribute.
     * @param minProfessor The value for minProfessor 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("minProfessor")
    public final Builder minProfessor(Integer minProfessor) {
      this.minProfessor = Objects.requireNonNull(minProfessor, "minProfessor");
      initBits &= ~INIT_BIT_MIN_PROFESSOR;
      return this;
    }

    /**
     * Initializes the value for the {@link Course#getMaxProfessor() maxProfessor} attribute.
     * @param maxProfessor The value for maxProfessor 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("maxProfessor")
    public final Builder maxProfessor(Integer maxProfessor) {
      this.maxProfessor = Objects.requireNonNull(maxProfessor, "maxProfessor");
      initBits &= ~INIT_BIT_MAX_PROFESSOR;
      return this;
    }

    /**
     * Initializes the value for the {@link Course#getMaxStudents() maxStudents} attribute.
     * @param maxStudents The value for maxStudents 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("maxStudents")
    public final Builder maxStudents(Integer maxStudents) {
      this.maxStudents = Objects.requireNonNull(maxStudents, "maxStudents");
      initBits &= ~INIT_BIT_MAX_STUDENTS;
      return this;
    }

    /**
     * Adds one element to {@link Course#getProfessors() professors} list.
     * @param element A professors element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addProfessors(Professor element) {
      if (this.professors == null) {
        this.professors = ImmutableList.builder();
      }
      this.professors.add(element);
      return this;
    }

    /**
     * Adds elements to {@link Course#getProfessors() professors} list.
     * @param elements An array of professors elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addProfessors(Professor... elements) {
      if (this.professors == null) {
        this.professors = ImmutableList.builder();
      }
      this.professors.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link Course#getProfessors() professors} list.
     * @param elements An iterable of professors elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("professors")
    public final Builder professors(@Nullable Iterable<? extends Professor> elements) {
      if (elements == null) {
        this.professors = null;
        return this;
      }
      this.professors = ImmutableList.builder();
      return addAllProfessors(elements);
    }

    /**
     * Adds elements to {@link Course#getProfessors() professors} list.
     * @param elements An iterable of professors elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllProfessors(Iterable<? extends Professor> elements) {
      Objects.requireNonNull(elements, "professors element");
      if (this.professors == null) {
        this.professors = ImmutableList.builder();
      }
      this.professors.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link Course#getStudents() students} list.
     * @param element A students element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addStudents(Student element) {
      if (this.students == null) {
        this.students = ImmutableList.builder();
      }
      this.students.add(element);
      return this;
    }

    /**
     * Adds elements to {@link Course#getStudents() students} list.
     * @param elements An array of students elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addStudents(Student... elements) {
      if (this.students == null) {
        this.students = ImmutableList.builder();
      }
      this.students.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link Course#getStudents() students} list.
     * @param elements An iterable of students elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("students")
    public final Builder students(@Nullable Iterable<? extends Student> elements) {
      if (elements == null) {
        this.students = null;
        return this;
      }
      this.students = ImmutableList.builder();
      return addAllStudents(elements);
    }

    /**
     * Adds elements to {@link Course#getStudents() students} list.
     * @param elements An iterable of students elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllStudents(Iterable<? extends Student> elements) {
      Objects.requireNonNull(elements, "students element");
      if (this.students == null) {
        this.students = ImmutableList.builder();
      }
      this.students.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableCourse ImmutableCourse}.
     * @return An immutable instance of Course
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableCourse build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableCourse(
          courseId,
          courseName,
          minProfessor,
          maxProfessor,
          maxStudents,
          professors == null ? null : professors.build(),
          students == null ? null : students.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_COURSE_NAME) != 0) attributes.add("courseName");
      if ((initBits & INIT_BIT_MIN_PROFESSOR) != 0) attributes.add("minProfessor");
      if ((initBits & INIT_BIT_MAX_PROFESSOR) != 0) attributes.add("maxProfessor");
      if ((initBits & INIT_BIT_MAX_STUDENTS) != 0) attributes.add("maxStudents");
      return "Cannot build Course, some of required attributes are not set " + attributes;
    }
  }
}
