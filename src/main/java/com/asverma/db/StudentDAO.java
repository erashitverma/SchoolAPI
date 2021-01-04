package com.asverma.db;

import com.asverma.mappers.StudentMapper;
import com.asverma.models.Student;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterRowMapper(StudentMapper.class)
public interface StudentDAO extends WrapperInterface {

    @SqlUpdate("insert into student (studentId, firstName, lastName) values (nextval('student_sequence'), :student.firstName, :student.lastName)")
    @GetGeneratedKeys
    Student insert(@BindBean("student") Student student);

    @SqlUpdate("update student SET firstName = :student.firstName, lastName = :student.lastName where studentId = :studentId")
    @GetGeneratedKeys
    Student update(@BindBean("student") Student student, @Bind("studentId") int studentId);

    @SqlQuery("select * from student where studentId = :studentId")
    Student getById(@Bind("studentId") int studentId);

    @SqlQuery("select * from student")
    List<Student> getAll();

    @SqlUpdate("delete from student where StudentId = :studentId")
    int deleteByJobID(@Bind("studentId") int studentId);

    @SqlUpdate("insert into courses_students (studentId, courseId) values (:studentId, :courseId)")
    int registerStudent(@Bind("studentId") int studentId, @Bind("courseId") int courseId);

    @SqlUpdate("delete from courses_students where StudentId = :studentId and CourseId = :courseId")
    int deregisterStudent(@Bind("studentId") int studentId, @Bind("courseId") int courseId);

    @SqlQuery("select  s2.studentid, s2.firstname ,s2.lastname from student s2 join courses_students cs on s2.studentid = cs.studentid where cs.courseId = :courseId")
    List<Student> getCourseStudent(@Bind("courseId") int courseId);
}
