package com.asverma.core.services.impl;

import com.asverma.core.services.CRUDService;
import com.asverma.db.CourseDAO;
import com.asverma.db.ProfessorDAO;
import com.asverma.exceptions.SchoolAPIException;
import com.asverma.models.Professor;

import org.jdbi.v3.core.statement.UnableToExecuteStatementException;

import java.util.List;

import javax.ws.rs.core.Response;

public class ProfessorService implements CRUDService<Professor> {

    private final ProfessorDAO professorDAO;
    private final CourseDAO    courseDAO;

    public ProfessorService(final ProfessorDAO professorDAO, final CourseDAO courseDAO) {
        this.professorDAO = professorDAO;
        this.courseDAO = courseDAO;
    }

    @Override
    public Professor retrieveEntity(final int id) {
        return this.professorDAO.getById(id);
    }

    @Override
    public Professor createEntity(final Professor professor) {
        return this.professorDAO.insert(professor);
    }

    @Override
    public Professor updateEntity(final Professor professor, final int id) {
        this.isProfessorExists(id);
        return this.professorDAO.update(professor, id);
    }

    @Override
    public void deleteEntity(final int id) {
        try {
            final int deleteResponse = this.professorDAO.deleteByJobID(id);
            if (deleteResponse == 0) {
                throw new SchoolAPIException("Professor does not exist", Response.Status.NOT_FOUND);
            }
        }
        catch (final UnableToExecuteStatementException ex) {
            // Usually would not send it to end users just leaving it there in case i don't implement logging
            throw new SchoolAPIException("Unable to remove the professor : " + ex.getShortMessage(), Response.Status.NOT_FOUND, ex);
        }
    }

    @Override
    public List<Professor> retrieveAll() {
        return this.professorDAO.getAll();
    }

    public void assignProfessor(final int professorId, final int courseId) {
        try {
            //new CourseService(this.courseDAO).isCourseExists(courseId);
            this.professorDAO.assignProfessor(professorId, courseId);
        }
        catch (final UnableToExecuteStatementException ex) {
            // Log detailed error message for debugging
            throw new SchoolAPIException("Professor already registered for this course", Response.Status.BAD_REQUEST, ex);
        }

    }

    public void deassignProfessor(final int professorId, final int courseId) {
        //new CourseService(this.courseDAO).isCourseExists(courseId);
        this.isProfessorExists(professorId);
        final int deleteResponse = this.professorDAO.deassignProfessor(professorId, courseId);
        if (deleteResponse == 0) {
            throw new SchoolAPIException("professor is not registered for this course", Response.Status.NOT_FOUND);
        }
    }

    private void isProfessorExists(final int professorId) {
        final Professor requestedProfessor = this.professorDAO.getById(professorId);
        if (requestedProfessor == null) {
            throw new SchoolAPIException("Requested professor doesn't exist", Response.Status.BAD_REQUEST);
        }
    }
}
