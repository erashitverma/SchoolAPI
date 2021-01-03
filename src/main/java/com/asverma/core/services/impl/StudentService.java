package com.asverma.core.services.impl;

import com.asverma.core.services.CRUDService;
import com.asverma.db.CourseDAO;
import com.asverma.db.StudentDAO;
import com.asverma.exceptions.SchoolAPIException;
import com.asverma.models.Student;

import org.jdbi.v3.core.statement.UnableToExecuteStatementException;

import java.util.List;

import javax.ws.rs.core.Response;

public class StudentService implements CRUDService<Student> {

    private final StudentDAO studentDAO;
    private final CourseDAO  courseDAO;

    public StudentService(final StudentDAO studentDAO, final CourseDAO courseDAO) {
        this.studentDAO = studentDAO;
        this.courseDAO = courseDAO;
    }

    @Override
    public Student retrieveEntity(final int id) {
        return this.studentDAO.getById(id);
    }

    @Override
    public Student createEntity(final Student student) {
        return this.studentDAO.insert(student);
    }

    @Override
    public Student updateEntity(final Student student, final int id) {
        this.isStudentExists(id);
        return this.studentDAO.update(student, id);
    }

    @Override
    public void deleteEntity(final int id) {
        try {
            final int deleteResponse = this.studentDAO.deleteByJobID(id);
            if (deleteResponse == 0) {
                throw new SchoolAPIException("Student does not exist", Response.Status.NOT_FOUND);
            }
        }
        catch (final UnableToExecuteStatementException ex) {
            // Usually would not send it to end users just leaving it there in case i don't implement logging
            throw new SchoolAPIException("Unable to remove the student : " + ex.getShortMessage(), Response.Status.NOT_FOUND, ex);
        }
    }

    @Override
    public List<Student> retrieveAll() {
        return this.studentDAO.getAll();
    }

    public void registerStudent(final int studentId, final int courseId) {
        try {
            //new CourseService(this.courseDAO).isCourseExists(courseId);
            this.studentDAO.registerStudent(studentId, courseId);
        }
        catch (final UnableToExecuteStatementException ex) {
            // Log detailed error message for debugging
            throw new SchoolAPIException("Student already registered for this course", Response.Status.BAD_REQUEST, ex);
        }

    }

    public void deregisterStudent(final int studentId, final int courseId) {
        //new CourseService(this.courseDAO).isCourseExists(courseId);
        this.isStudentExists(studentId);
        final int deleteResponse = this.studentDAO.deregisterStudent(studentId, courseId);
        if (deleteResponse == 0) {
            throw new SchoolAPIException("Student is not registered for this course", Response.Status.NOT_FOUND);
        }
    }

    private void isStudentExists(final int studentId) {
        final Student requestedStudent = this.studentDAO.getById(studentId);
        if (requestedStudent == null) {
            throw new SchoolAPIException("Requested student doesn't exist", Response.Status.BAD_REQUEST);
        }
    }
}
