package com.asverma.db;

import com.asverma.mappers.CourseMapper;
import com.asverma.models.Course;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterRowMapper(CourseMapper.class)
public interface CourseDAO extends WrapperInterface {

    @SqlUpdate("insert into courses (courseId, courseName, minProfessor, maxProfessor, maxStudents) values (nextval('course_sequence'),"
                               + " :course.courseName, :course.minProfessor, :course.maxProfessor, :course.maxStudents)")
    @GetGeneratedKeys
    Course insert(@BindBean("course") Course course);

    @SqlUpdate("update courses SET courseName = :course.courseName, minProfessor = :course.minProfessor, "
                               + "maxProfessor = :course.maxProfessor, maxStudents = :course.maxStudents where courseId = :courseId")
    @GetGeneratedKeys
    Course update(@BindBean("course") Course course, @Bind("courseId") int courseId);

    @SqlQuery("select * from courses where courseId = :courseId")
    Course getById(@Bind("courseId") int courseId);

    @SqlQuery("select * from courses")
    List<Course> getAll();

    @SqlUpdate("delete from courses where courseId = :courseId")
    int deleteByJobID(@Bind("courseId") int courseId);
}
