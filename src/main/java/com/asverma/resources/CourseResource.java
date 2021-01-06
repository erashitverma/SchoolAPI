package com.asverma.resources;

import com.asverma.api.ApiResponseWrapper;
import com.asverma.api.ResponseMessage;
import com.asverma.core.services.impl.CourseService;
import com.asverma.models.Course;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "courses")
@Path("/api/v1")
public class CourseResource {

    private final CourseService courseService;

    public CourseResource(final CourseService courseService) {
        this.courseService = courseService;
    }

    @POST
    @Path("/courses")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Create a course",
                  code = 200,
                  response = Course.class,
                  httpMethod = "POST",
                  produces = "application/json")
    public Response add(@Valid final Course course) {
        return Response.status(Response.Status.OK)
                       .entity(new ApiResponseWrapper<>(this.courseService.createEntity(course)))
                       .build();
    }

    @PUT
    @Path("/courses/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Update a course",
                  code = 200,
                  response = Course.class,
                  httpMethod = "PUT",
                  produces = "application/json")
    public Response add(@Valid final Course course, @PathParam("id") final int id) {
        return Response.status(Response.Status.OK)
                       .entity(new ApiResponseWrapper<>(this.courseService.updateEntity(course, id)))
                       .build();
    }

    @GET
    @Path("/courses")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get all courses",
                  code = 200,
                  response = Course.class,
                  responseContainer = "List",
                  httpMethod = "GET")
    public Response getAll() {
        return Response.status(Response.Status.OK)
                       .entity(new ApiResponseWrapper<>(this.courseService.retrieveAll()))
                       .build();
    }

    @GET
    @Path("/courses/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get a course by id",
                  code = 200,
                  response = Course.class,
                  httpMethod = "GET",
                  produces = "application/json")
    public Response getByName(@PathParam("id") final int id) {
        return Response.status(Response.Status.OK)
                       .entity(new ApiResponseWrapper<>(this.courseService.retrieveEntity(id)))
                       .build();
    }

    @DELETE
    @Path("/courses/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Delete a course by id",
                  httpMethod = "DELETE")
    @ApiResponses(value = {@ApiResponse(code = 200,
                                        message = "job delete successfully for the given jobId")})
    public Response deleteById(@PathParam("id") final int id) {
        this.courseService.deleteEntity(id);
        return Response.status(Response.Status.OK).entity(new ResponseMessage("Course has been successfully Deleted")).build();
    }
}
