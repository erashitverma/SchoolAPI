package com.asverma.mappers;

import com.asverma.models.ImmutableStudent;
import com.asverma.models.Student;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student map(final ResultSet rs, final StatementContext ctx) throws SQLException {
        return ImmutableStudent.builder().firstName(rs.getString("firstName"))
                               .lastName(rs.getString("lastName")).studentId(rs.getInt("studentId")).build();
    }
}
