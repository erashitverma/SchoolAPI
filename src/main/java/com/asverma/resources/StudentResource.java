package com.asverma.resources;


import com.asverma.api.ApiResponseWrapper;
import com.asverma.api.ResponseMessage;
import com.asverma.core.services.impl.StudentService;
import com.asverma.models.Student;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "students")
@Path("/api/v1")
public class StudentResource {

    private final StudentService studentService;

    public StudentResource(final StudentService studentService) {
        this.studentService = studentService;
    }

    @POST
    @Path("/students")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Create a student",
                  code = 200,
                  response = Student.class,
                  httpMethod = "POST",
                  produces = "application/json")
    public Response add(@Valid final Student student) {
        return Response.status(Response.Status.OK)
                       .entity(new ApiResponseWrapper<>(this.studentService.createEntity(student)))
                       .build();
    }

    @PUT
    @Path("/students/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Update a student",
                  code = 200,
                  response = Student.class,
                  httpMethod = "PUT",
                  produces = "application/json")
    public Response add(@Valid final Student student, @PathParam("id") final int id) {
        return Response.status(Response.Status.OK)
                       .entity(new ApiResponseWrapper<>(this.studentService.updateEntity(student, id)))
                       .build();
    }

    @GET
    @Path("/students")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get all students",
                  code = 200,
                  response = Student.class,
                  responseContainer = "List",
                  httpMethod = "GET")
    public Response getAll() {
        return Response.status(Response.Status.OK)
                       .entity(new ApiResponseWrapper<>(this.studentService.retrieveAll()))
                       .build();
    }

    @GET
    @Path("/students/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get a student by id",
                  code = 200,
                  response = Student.class,
                  httpMethod = "GET",
                  produces = "application/json")
    public Response getByName(@PathParam("id") final int id) {
        return Response.status(Response.Status.OK)
                       .entity(new ApiResponseWrapper<>(this.studentService.retrieveEntity(id)))
                       .build();
    }

    @DELETE
    @Path("/students/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Delete a student by id",
                  httpMethod = "DELETE")
    @ApiResponses(value = {@ApiResponse(code = 200,
                                        message = "job delete successfully for the given jobId")})
    public Response deleteById(@PathParam("id") final int id) {
        this.studentService.deleteEntity(id);
        return Response.status(Response.Status.OK).entity(new ResponseMessage("Student has been successfully Deleted")).build();
    }

    @PUT
    @Path("/students/{id}/register/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Register a student for course",
                  code = 200,
                  response = Student.class,
                  httpMethod = "PUT",
                  produces = "application/json")
    public Response register(@PathParam("id") final int id, @QueryParam("courseId") final int courseId) {
        this.studentService.registerStudent(id, courseId);
        return Response.status(Response.Status.OK).entity(new ResponseMessage("Student has been successfully Registered")).build();
    }

    @PUT
    @Path("/students/{id}/deregister/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Deregister a student for course",
                  code = 200,
                  response = Student.class,
                  httpMethod = "PUT",
                  produces = "application/json")
    public Response deregister(@PathParam("id") final int id, @QueryParam("courseId") final int courseId) {
        this.studentService.deregisterStudent(id, courseId);
        return Response.status(Response.Status.OK).entity(new ResponseMessage("Student has been successfully Deregister")).build();
    }
}
