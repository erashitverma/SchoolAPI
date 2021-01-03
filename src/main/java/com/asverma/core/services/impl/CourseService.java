package com.asverma.core.services.impl;

import com.asverma.core.services.CRUDService;
import com.asverma.db.CourseDAO;
import com.asverma.db.ProfessorDAO;
import com.asverma.db.StudentDAO;
import com.asverma.exceptions.SchoolAPIException;
import com.asverma.models.Course;
import com.asverma.models.ImmutableCourse;

import org.jdbi.v3.core.statement.UnableToExecuteStatementException;

import java.util.List;

import javax.ws.rs.core.Response;

public class CourseService implements CRUDService<Course> {

    private final CourseDAO    courseDAO;
    private final ProfessorDAO professorDAO;
    private final StudentDAO   studentDAO;

    public CourseService(final CourseDAO courseDAO, final ProfessorDAO professorDAO, final StudentDAO studentDAO) {
        this.courseDAO = courseDAO;
        this.professorDAO = professorDAO;
        this.studentDAO = studentDAO;
    }

    @Override
    public Course retrieveEntity(final int id) {
        final Course retrievedCourse = this.courseDAO.getById(id);
        return ImmutableCourse.copyOf(retrievedCourse).withStudents(this.studentDAO.getAll()).withProfessors(this.professorDAO.getAll());

    }

    @Override
    public Course createEntity(final Course course) {
        return this.courseDAO.insert(course);
    }

    @Override
    public Course updateEntity(final Course course, final int id) {
        this.isCourseExists(id);
        return this.courseDAO.update(course, id);
    }

    @Override
    public void deleteEntity(final int id) {
        try {
            final int deleteResponse = this.courseDAO.deleteByJobID(id);
            if (deleteResponse == 0) {
                throw new SchoolAPIException("Requested course doesn't exist", Response.Status.NOT_FOUND);
            }
        }
        catch (final UnableToExecuteStatementException ex) {
            // Usually would not send it to end users just leaving it there in case i don't implement logging
            throw new SchoolAPIException("Unable to remove the course : " + ex.getShortMessage(), Response.Status.NOT_FOUND, ex);
        }
    }

    @Override
    public List<Course> retrieveAll() {
        return this.courseDAO.getAll();
    }

    public void isCourseExists(final int courseId) {
        final Course requestedCourse = this.courseDAO.getById(courseId);
        if (requestedCourse == null) {
            throw new SchoolAPIException("Requested course doesn't exist", Response.Status.BAD_REQUEST);
        }
    }
}
