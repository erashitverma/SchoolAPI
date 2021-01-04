package com.asverma.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * A modifiable implementation of the {@link Student Student} type.
 * <p>Use the {@link #create()} static factory methods to create new instances.
 * Use the {@link #toImmutable()} method to convert to canonical immutable instances.
 * <p><em>ModifiableStudent is not thread-safe</em>
 * @see ImmutableStudent
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Modifiables.generator", "Student"})
@NotThreadSafe
public final class ModifiableStudent extends Student {
  private static final long INIT_BIT_FIRST_NAME = 0x1L;
  private static final long INIT_BIT_LAST_NAME = 0x2L;
  private long initBits = 0x3L;

  private @Nullable Integer studentId;
  private String firstName;
  private String lastName;

  private ModifiableStudent() {}

  /**
   * Construct a modifiable instance of {@code Student}.
   * @return A new modifiable instance
   */
  public static ModifiableStudent create() {
    return new ModifiableStudent();
  }

  /**
   * @return value of {@code studentId} attribute, may be {@code null}
   */
  @JsonProperty("studentId")
  @Override
  public final @Nullable Integer getStudentId() {
    return studentId;
  }

  /**
   * @return value of {@code firstName} attribute
   */
  @JsonProperty("firstName")
  @Override
  public final String getFirstName() {
    if (!firstNameIsSet()) {
      checkRequiredAttributes();
    }
    return firstName;
  }

  /**
   * @return value of {@code lastName} attribute
   */
  @JsonProperty("lastName")
  @Override
  public final String getLastName() {
    if (!lastNameIsSet()) {
      checkRequiredAttributes();
    }
    return lastName;
  }

  /**
   * Clears the object by setting all attributes to their initial values.
   * @return {@code this} for use in a chained invocation
   */
  public ModifiableStudent clear() {
    initBits = 0x3L;
    studentId = null;
    firstName = null;
    lastName = null;
    return this;
  }

  /**
   * Fill this modifiable instance with attribute values from the provided {@link Student} instance.
   * Regular attribute values will be overridden, i.e. replaced with ones of an instance.
   * Any of the instance's absent optional values will not be copied (will not override current values).
   * @param instance The instance from which to copy values
   * @return {@code this} for use in a chained invocation
   */
  public ModifiableStudent from(Student instance) {
    Objects.requireNonNull(instance, "instance");
    @Nullable Integer studentIdValue = instance.getStudentId();
    if (studentIdValue != null) {
      setStudentId(studentIdValue);
    }
    setFirstName(instance.getFirstName());
    setLastName(instance.getLastName());
    return this;
  }

  /**
   * Assigns a value to the {@link Student#getStudentId() studentId} attribute.
   * @param studentId The value for studentId, can be {@code null}
   * @return {@code this} for use in a chained invocation
   */
  public ModifiableStudent setStudentId(@Nullable Integer studentId) {
    this.studentId = studentId;
    return this;
  }

  /**
   * Assigns a value to the {@link Student#getFirstName() firstName} attribute.
   * @param firstName The value for firstName
   * @return {@code this} for use in a chained invocation
   */
  public ModifiableStudent setFirstName(String firstName) {
    this.firstName = Objects.requireNonNull(firstName, "firstName");
    initBits &= ~INIT_BIT_FIRST_NAME;
    return this;
  }

  /**
   * Assigns a value to the {@link Student#getLastName() lastName} attribute.
   * @param lastName The value for lastName
   * @return {@code this} for use in a chained invocation
   */
  public ModifiableStudent setLastName(String lastName) {
    this.lastName = Objects.requireNonNull(lastName, "lastName");
    initBits &= ~INIT_BIT_LAST_NAME;
    return this;
  }

  /**
   * Returns {@code true} if the required attribute {@link Student#getFirstName() firstName} is set.
   * @return {@code true} if set
   */
  public final boolean firstNameIsSet() {
    return (initBits & INIT_BIT_FIRST_NAME) == 0;
  }

  /**
   * Returns {@code true} if the required attribute {@link Student#getLastName() lastName} is set.
   * @return {@code true} if set
   */
  public final boolean lastNameIsSet() {
    return (initBits & INIT_BIT_LAST_NAME) == 0;
  }


  /**
   * Reset an attribute to its initial value.
   * @return {@code this} for use in a chained invocation
   */
  public final ModifiableStudent unsetFirstName() {
    initBits |= INIT_BIT_FIRST_NAME;
    firstName = null;
    return this;
  }

  /**
   * Reset an attribute to its initial value.
   * @return {@code this} for use in a chained invocation
   */
  public final ModifiableStudent unsetLastName() {
    initBits |= INIT_BIT_LAST_NAME;
    lastName = null;
    return this;
  }

  /**
   * Returns {@code true} if all required attributes are set, indicating that the object is initialized.
   * @return {@code true} if set
   */
  public final boolean isInitialized() {
    return initBits == 0;
  }

  private void checkRequiredAttributes() {
    if (!isInitialized()) {
      throw new IllegalStateException(formatRequiredAttributesMessage());
    }
  }

  private String formatRequiredAttributesMessage() {
    List<String> attributes = Lists.newArrayList();
    if (!firstNameIsSet()) attributes.add("firstName");
    if (!lastNameIsSet()) attributes.add("lastName");
    return "Student in not initialized, some of the required attributes are not set " + attributes;
  }

  /**
   * Converts to {@link ImmutableStudent ImmutableStudent}.
   * @return An immutable instance of Student
   */
  public final ImmutableStudent toImmutable() {
    checkRequiredAttributes();
    return ImmutableStudent.copyOf(this);
  }

  /**
   * This instance is equal to all instances of {@code ModifiableStudent} that have equal attribute values.
   * An uninitialized instance is equal only to itself.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    if (!(another instanceof ModifiableStudent)) return false;
    ModifiableStudent other = (ModifiableStudent) another;
    if (!isInitialized() || !other.isInitialized()) {
      return false;
    }
    return equalTo(other);
  }

  private boolean equalTo(ModifiableStudent another) {
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
   * Generates a string representation of this {@code Student}.
   * If uninitialized, some attribute values may appear as question marks.
   * @return A string representation
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ModifiableStudent")
        .add("studentId", getStudentId())
        .add("firstName", firstNameIsSet() ? getFirstName() : "?")
        .add("lastName", lastNameIsSet() ? getLastName() : "?")
        .toString();
  }
}
