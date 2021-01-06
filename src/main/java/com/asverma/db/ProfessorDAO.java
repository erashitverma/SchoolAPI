package com.asverma.db;

import com.asverma.mappers.ProfessorMapper;
import com.asverma.models.Professor;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterRowMapper(ProfessorMapper.class)
public interface ProfessorDAO {

    @SqlUpdate("insert into professors (professorId, firstName, lastName) values (nextval('professor_sequence'), :professor.firstName, :professor.lastName)")
    @GetGeneratedKeys
    Professor insert(@BindBean("professor") Professor professor);

    @SqlUpdate("update professors SET firstName = :professor.firstName, lastName = :professor.lastName where professorId = :professorId")
    @GetGeneratedKeys
    Professor update(@BindBean("professor") Professor professor, @Bind("professorId") int professorId);

    @SqlQuery("select * from professors where professorId = :professorId")
    Professor getById(@Bind("professorId") int professorId);

    @SqlQuery("select * from professors")
    List<Professor> getAll();

    @SqlUpdate("delete from professors where ProfessorId = :professorId")
    int deleteByJobID(@Bind("professorId") int professorId);

    @SqlUpdate("insert into courses_professors (professorId, courseId) values (:professorId, :courseId)")
    int assignProfessor(@Bind("professorId") int professorId, @Bind("courseId") int courseId);

    @SqlUpdate("delete from courses_professors where ProfessorId = :professorId and CourseId = :courseId")
    int deassignProfessor(@Bind("professorId") int professorId, @Bind("courseId") int courseId);

    @SqlQuery("select  s2.professorid, s2.firstname ,s2.lastname from professors s2 join courses_professors cs on s2.professorid = cs.professorid where cs.courseId = :courseId")
    List<Professor> getCourseProfessors(@Bind("courseId") int courseId);
}
