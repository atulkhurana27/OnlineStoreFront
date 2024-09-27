package com.CabPortal.resources;

import com.CabPortal.Services.UserService;
import com.CabPortal.models.RegisterUserRequest;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {


    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @POST
    @Path("/register")
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerUser(RegisterUserRequest registerUserRequest)  throws  Exception{
        return Response.status(Response.Status.OK).build();
    }

}
