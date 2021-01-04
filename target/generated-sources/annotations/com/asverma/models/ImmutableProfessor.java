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
 * Immutable implementation of {@link Professor}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableProfessor.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "Professor"})
@Immutable
@CheckReturnValue
public final class ImmutableProfessor extends Professor {
  private final @Nullable Integer professorId;
  private final String firstName;
  private final String lastName;

  private ImmutableProfessor(
      @Nullable Integer professorId,
      String firstName,
      String lastName) {
    this.professorId = professorId;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * @return The value of the {@code professorId} attribute
   */
  @JsonProperty("professorId")
  @Override
  public @Nullable Integer getProfessorId() {
    return professorId;
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
   * Copy the current immutable object by setting a value for the {@link Professor#getProfessorId() professorId} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for professorId (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableProfessor withProfessorId(@Nullable Integer value) {
    if (Objects.equals(this.professorId, value)) return this;
    return new ImmutableProfessor(value, this.firstName, this.lastName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Professor#getFirstName() firstName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for firstName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableProfessor withFirstName(String value) {
    if (this.firstName.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "firstName");
    return new ImmutableProfessor(this.professorId, newValue, this.lastName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Professor#getLastName() lastName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for lastName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableProfessor withLastName(String value) {
    if (this.lastName.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "lastName");
    return new ImmutableProfessor(this.professorId, this.firstName, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableProfessor} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableProfessor
        && equalTo((ImmutableProfessor) another);
  }

  private boolean equalTo(ImmutableProfessor another) {
    return Objects.equals(professorId, another.professorId)
        && firstName.equals(another.firstName)
        && lastName.equals(another.lastName);
  }

  /**
   * Computes a hash code from attributes: {@code professorId}, {@code firstName}, {@code lastName}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Objects.hashCode(professorId);
    h += (h << 5) + firstName.hashCode();
    h += (h << 5) + lastName.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Professor} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Professor")
        .omitNullValues()
        .add("professorId", professorId)
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
  static final class Json extends Professor {
    @Nullable Integer professorId;
    @Nullable String firstName;
    @Nullable String lastName;
    @JsonProperty("professorId")
    public void setProfessorId(@Nullable Integer professorId) {
      this.professorId = professorId;
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
    public Integer getProfessorId() { throw new UnsupportedOperationException(); }
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
  static ImmutableProfessor fromJson(Json json) {
    ImmutableProfessor.Builder builder = ImmutableProfessor.builder();
    if (json.professorId != null) {
      builder.professorId(json.professorId);
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
   * Creates an immutable copy of a {@link Professor} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Professor instance
   */
  public static ImmutableProfessor copyOf(Professor instance) {
    if (instance instanceof ImmutableProfessor) {
      return (ImmutableProfessor) instance;
    }
    return ImmutableProfessor.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableProfessor ImmutableProfessor}.
   * @return A new ImmutableProfessor builder
   */
  public static ImmutableProfessor.Builder builder() {
    return new ImmutableProfessor.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableProfessor ImmutableProfessor}.
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

    private @Nullable Integer professorId;
    private @Nullable String firstName;
    private @Nullable String lastName;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Professor} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(Professor instance) {
      Objects.requireNonNull(instance, "instance");
      @Nullable Integer professorIdValue = instance.getProfessorId();
      if (professorIdValue != null) {
        professorId(professorIdValue);
      }
      firstName(instance.getFirstName());
      lastName(instance.getLastName());
      return this;
    }

    /**
     * Initializes the value for the {@link Professor#getProfessorId() professorId} attribute.
     * @param professorId The value for professorId (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("professorId")
    public final Builder professorId(@Nullable Integer professorId) {
      this.professorId = professorId;
      return this;
    }

    /**
     * Initializes the value for the {@link Professor#getFirstName() firstName} attribute.
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
     * Initializes the value for the {@link Professor#getLastName() lastName} attribute.
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
     * Builds a new {@link ImmutableProfessor ImmutableProfessor}.
     * @return An immutable instance of Professor
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableProfessor build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableProfessor(professorId, firstName, lastName);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_FIRST_NAME) != 0) attributes.add("firstName");
      if ((initBits & INIT_BIT_LAST_NAME) != 0) attributes.add("lastName");
      return "Cannot build Professor, some of required attributes are not set " + attributes;
    }
  }
}
