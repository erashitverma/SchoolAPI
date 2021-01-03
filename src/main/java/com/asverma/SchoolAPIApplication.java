package com.asverma;

import com.asverma.api.mappers.SchoolAPIExceptionMapper;
import com.asverma.core.services.impl.CourseService;
import com.asverma.core.services.impl.ProfessorService;
import com.asverma.core.services.impl.StudentService;
import com.asverma.db.CourseDAO;
import com.asverma.db.ProfessorDAO;
import com.asverma.db.StudentDAO;
import com.asverma.resources.CourseResource;
import com.asverma.resources.ProfessorResource;
import com.asverma.resources.StudentResource;

import org.jdbi.v3.core.Jdbi;

import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class SchoolAPIApplication extends Application<SchoolAPIConfiguration> {

    public static void main(final String[] args) throws Exception {
        new SchoolAPIApplication().run(args);
    }

    @Override
    public String getName() {
        return "SchoolAPI";
    }

    @Override
    public void initialize(final Bootstrap<SchoolAPIConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final SchoolAPIConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        final StudentDAO studentDAO = jdbi.onDemand(StudentDAO.class);
        final CourseDAO courseDAO = jdbi.onDemand(CourseDAO.class);
        final ProfessorDAO professorDAO = jdbi.onDemand(ProfessorDAO.class);
        environment.jersey().register(new StudentResource(new StudentService(studentDAO, courseDAO)));
        environment.jersey().register(new CourseResource(new CourseService(courseDAO, professorDAO, studentDAO)));
        environment.jersey().register(new ProfessorResource(new ProfessorService(professorDAO, courseDAO)));
        environment.jersey().register(new SchoolAPIExceptionMapper());
    }
}
