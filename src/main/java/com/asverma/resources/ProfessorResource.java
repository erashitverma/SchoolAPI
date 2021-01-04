package com.asverma.resources;


import com.asverma.api.ApiResponseWrapper;
import com.asverma.api.ResponseMessage;
import com.asverma.core.services.impl.ProfessorService;
import com.asverma.models.Professor;

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

@Api(value = "professors")
@Path("/api/v1")
public class ProfessorResource {

    private final ProfessorService professorService;

    public ProfessorResource(final ProfessorService professorService) {
        this.professorService = professorService;
    }

    @POST
    @Path("/professors")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Create a professor",
                  code = 200,
                  response = Professor.class,
                  httpMethod = "POST",
                  produces = "application/json")
    public Response add(@Valid final Professor professor) {
        return Response.status(Response.Status.OK)
                       .entity(new ApiResponseWrapper<>(this.professorService.createEntity(professor)))
                       .build();
    }

    @PUT
    @Path("/professors/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Update a professor",
                  code = 200,
                  response = Professor.class,
                  httpMethod = "POST",
                  produces = "application/json")
    public Response add(@Valid final Professor professor, @PathParam("id") final int id) {
        return Response.status(Response.Status.OK)
                       .entity(new ApiResponseWrapper<>(this.professorService.updateEntity(professor, id)))
                       .build();
    }

    @GET
    @Path("/professors")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get all professors",
                  code = 200,
                  response = Professor.class,
                  responseContainer = "List",
                  httpMethod = "GET")
    public Response getAll() {
        return Response.status(Response.Status.OK)
                       .entity(new ApiResponseWrapper<>(this.professorService.retrieveAll()))
                       .build();
    }

    @GET
    @Path("/professors/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get a professor by id",
                  code = 200,
                  response = Professor.class,
                  httpMethod = "GET",
                  produces = "application/json")
    public Response getByName(@PathParam("id") final int id) {
        return Response.status(Response.Status.OK)
                       .entity(new ApiResponseWrapper<>(this.professorService.retrieveEntity(id)))
                       .build();
    }

    @DELETE
    @Path("/professors/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Delete a professor by id",
                  httpMethod = "DELETE")
    @ApiResponses(value = {@ApiResponse(code = 200,
                                        message = "job delete successfully for the given jobId")})
    public Response deleteById(@PathParam("id") final int id) {
        this.professorService.deleteEntity(id);
        return Response.status(Response.Status.OK).entity(new ResponseMessage("Professor has been successfully Deleted")).build();
    }

    @PUT
    @Path("/professors/{id}/assign/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Register a professor for course",
                  code = 200,
                  response = Professor.class,
                  httpMethod = "POST",
                  produces = "application/json")
    public Response register(@PathParam("id") final int id, @QueryParam("courseId") final int courseId) {
        this.professorService.assignProfessor(id, courseId);
        return Response.status(Response.Status.OK).entity(new ResponseMessage("Professor has been successfully Registered")).build();
    }

    @PUT
    @Path("/professors/{id}/deassign/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Deregister a professor for course",
                  code = 200,
                  response = Professor.class,
                  httpMethod = "POST",
                  produces = "application/json")
    public Response deregister(@PathParam("id") final int id, @QueryParam("courseId") final int courseId) {
        this.professorService.deassignProfessor(id, courseId);
        return Response.status(Response.Status.OK).entity(new ResponseMessage("Professor has been successfully Deregister")).build();
    }

}
