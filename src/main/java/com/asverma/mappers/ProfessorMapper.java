package com.asverma.mappers;

import com.asverma.models.ImmutableProfessor;
import com.asverma.models.Professor;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorMapper implements RowMapper<Professor> {

    @Override
    public Professor map(final ResultSet rs, final StatementContext ctx) throws SQLException {
        return ImmutableProfessor.builder().firstName(rs.getString("firstName"))
                                 .lastName(rs.getString("lastName")).professorId(rs.getInt("professorId")).build();
    }
}
