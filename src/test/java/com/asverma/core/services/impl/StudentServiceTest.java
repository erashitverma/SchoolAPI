package com.asverma.core.services.impl;

import com.asverma.db.CourseDAO;
import com.asverma.db.StudentDAO;
import com.asverma.exceptions.SchoolAPIException;
import com.asverma.models.ImmutableStudent;
import com.asverma.models.Student;

import org.assertj.core.api.Assertions;
import org.jdbi.v3.core.statement.UnableToExecuteStatementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class StudentServiceTest {
    final   StudentDAO     mockStudentDAO = mock(StudentDAO.class);
    final   CourseDAO      mockCourseDAO  = mock(CourseDAO.class);
    final   StudentService studentService = new StudentService(this.mockStudentDAO, this.mockCourseDAO);
    private Student        student;

    @BeforeEach
    public void setUp() {
        this.student = ImmutableStudent.builder().studentId(1000).firstName("Ashit").lastName("Verma").build();
    }

    @Test
    public void retrieveEntity_shouldReturnStudent() {
        // GIVEN
        when(this.mockStudentDAO.getById(1000)).thenReturn(this.student);

        // WHEN
        final Student returnedStudent = this.studentService.retrieveEntity(1000);

        // THEN
        Assertions.assertThat(returnedStudent.getStudentId()).isEqualTo(this.student.getStudentId());
        Assertions.assertThat(returnedStudent.getFirstName()).isEqualTo(this.student.getFirstName());
        Assertions.assertThat(returnedStudent.getLastName()).isEqualTo(this.student.getLastName());
    }

    @Test
    public void retrieveEntity_shouldReturnNull_whenStudentDoesNotExist() {
        // GIVEN
        when(this.mockStudentDAO.getById(1001)).thenReturn(null);

        // WHEN
        final Student returnedStudent = this.studentService.retrieveEntity(1000);

        // THEN
        Assertions.assertThat(returnedStudent).isEqualTo(null);
    }

    @Test
    public void deleteEntity_shouldReturnVoid_whenOperationIsSuccessful() {
        // GIVEN
        when(this.mockStudentDAO.deleteByJobID(1000)).thenReturn(1);

        // WHEN & THEN
        Assertions.assertThatCode(() -> this.studentService.deleteEntity(1000))
                  .doesNotThrowAnyException();
    }

    @Test
    public void deleteEntity_shouldThrowException_whenStudentDoesNotExist() {
        // GIVEN
        when(this.mockStudentDAO.deleteByJobID(1000)).thenReturn(0);

        // WHEN & THEN
        Assertions.assertThatExceptionOfType(SchoolAPIException.class)
                  .isThrownBy(() -> this.studentService.deleteEntity(1000))
                  .withMessageContaining("Student does not exist");
    }

    @Test
    public void deleteEntity_shouldThrowException_whenDAOThrowsAnException() {
        // GIVEN
        when(this.mockStudentDAO.deleteByJobID(1000)).thenThrow(new UnableToExecuteStatementException("Sample Message"));

        // WHEN & THEN
        Assertions.assertThatExceptionOfType(SchoolAPIException.class)
                  .isThrownBy(() -> this.studentService.deleteEntity(1000))
                  .withMessageContaining("Unable to remove the student");
    }



}
