package com.asverma.mappers;

import com.asverma.models.Course;
import com.asverma.models.ImmutableCourse;
import com.asverma.models.ImmutableStudent;
import com.asverma.models.Student;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseMapper implements RowMapper<Course> {

    @Override
    public Course map(final ResultSet rs, final StatementContext ctx) throws SQLException {
        return ImmutableCourse.builder().courseName(rs.getString("courseName"))
                              .minProfessor(rs.getInt("minProfessor")).maxProfessor(rs.getInt("maxProfessor"))
                              .maxStudents(rs.getInt("maxStudents")).courseId(rs.getInt("courseId")).build();
    }
}
