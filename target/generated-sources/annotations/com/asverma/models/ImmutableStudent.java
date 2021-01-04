package com.asverma.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
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
 * Immutable implementation of {@link Student}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableStudent.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "Student"})
@Immutable
@CheckReturnValue
public final class ImmutableStudent extends Student {
  private final @Nullable Integer studentId;
  private final String firstName;
  private final String lastName;

  private ImmutableStudent(
      @Nullable Integer studentId,
      String firstName,
      String lastName) {
    this.studentId = studentId;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * @return The value of the {@code studentId} attribute
   */
  @JsonProperty("studentId")
  @Override
  public @Nullable Integer getStudentId() {
    return studentId;
  }

  /**
   * @return The value of the {@code firstName} attribute
   */
  @JsonProperty("firstName")
  @Override
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return The value of the {@code lastName} attribute
   */
  @JsonProperty("lastName")
  @Override
  public String getLastName() {
    return lastName;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Student#getStudentId() studentId} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for studentId (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableStudent withStudentId(@Nullable Integer value) {
    if (Objects.equals(this.studentId, value)) return this;
    return new ImmutableStudent(value, this.firstName, this.lastName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Student#getFirstName() firstName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for firstName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableStudent withFirstName(String value) {
    if (this.firstName.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "firstName");
    return new ImmutableStudent(this.studentId, newValue, this.lastName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Student#getLastName() lastName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for lastName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableStudent withLastName(String value) {
    if (this.lastName.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "lastName");
    return new ImmutableStudent(this.studentId, this.firstName, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableStudent} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableStudent
        && equalTo((ImmutableStudent) another);
  }

  private boolean equalTo(ImmutableStudent another) {
    return Objects.equals(studentId, another.studentId)
        && firstName.equals(another.firstName)
        && lastName.equals(another.lastName);
  }

  /**
   * Computes a hash code from attributes: {@code studentId}, {@code firstName}, {@code lastName}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Objects.hashCode(studentId);
    h += (h << 5) + firstName.hashCode();
    h += (h << 5) + lastName.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Student} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Student")
        .omitNullValues()
        .add("studentId", studentId)
        .add("firstName", firstName)
        .add("lastName", lastName)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends Student {
    @Nullable Integer studentId;
    @Nullable String firstName;
    @Nullable String lastName;
    @JsonProperty("studentId")
    public void setStudentId(@Nullable Integer studentId) {
      this.studentId = studentId;
    }
    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }
    @JsonProperty("lastName")
    public void setLastName(String lastName) {
      this.lastName = lastName;
    }
    @Override
    public Integer getStudentId() { throw new UnsupportedOperationException(); }
    @Override
    public String getFirstName() { throw new UnsupportedOperationException(); }
    @Override
    public String getLastName() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableStudent fromJson(Json json) {
    ImmutableStudent.Builder builder = ImmutableStudent.builder();
    if (json.studentId != null) {
      builder.studentId(json.studentId);
    }
    if (json.firstName != null) {
      builder.firstName(json.firstName);
    }
    if (json.lastName != null) {
      builder.lastName(json.lastName);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Student} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Student instance
   */
  public static ImmutableStudent copyOf(Student instance) {
    if (instance instanceof ImmutableStudent) {
      return (ImmutableStudent) instance;
    }
    return ImmutableStudent.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableStudent ImmutableStudent}.
   * @return A new ImmutableStudent builder
   */
  public static ImmutableStudent.Builder builder() {
    return new ImmutableStudent.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableStudent ImmutableStudent}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_FIRST_NAME = 0x1L;
    private static final long INIT_BIT_LAST_NAME = 0x2L;
    private long initBits = 0x3L;

    private @Nullable Integer studentId;
    private @Nullable String firstName;
    private @Nullable String lastName;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Student} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(Student instance) {
      Objects.requireNonNull(instance, "instance");
      @Nullable Integer studentIdValue = instance.getStudentId();
      if (studentIdValue != null) {
        studentId(studentIdValue);
      }
      firstName(instance.getFirstName());
      lastName(instance.getLastName());
      return this;
    }

    /**
     * Initializes the value for the {@link Student#getStudentId() studentId} attribute.
     * @param studentId The value for studentId (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("studentId")
    public final Builder studentId(@Nullable Integer studentId) {
      this.studentId = studentId;
      return this;
    }

    /**
     * Initializes the value for the {@link Student#getFirstName() firstName} attribute.
     * @param firstName The value for firstName 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("firstName")
    public final Builder firstName(String firstName) {
      this.firstName = Objects.requireNonNull(firstName, "firstName");
      initBits &= ~INIT_BIT_FIRST_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link Student#getLastName() lastName} attribute.
     * @param lastName The value for lastName 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("lastName")
    public final Builder lastName(String lastName) {
      this.lastName = Objects.requireNonNull(lastName, "lastName");
      initBits &= ~INIT_BIT_LAST_NAME;
      return this;
    }

    /**
     * Builds a new {@link ImmutableStudent ImmutableStudent}.
     * @return An immutable instance of Student
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableStudent build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableStudent(studentId, firstName, lastName);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_FIRST_NAME) != 0) attributes.add("firstName");
      if ((initBits & INIT_BIT_LAST_NAME) != 0) attributes.add("lastName");
      return "Cannot build Student, some of required attributes are not set " + attributes;
    }
  }
}
