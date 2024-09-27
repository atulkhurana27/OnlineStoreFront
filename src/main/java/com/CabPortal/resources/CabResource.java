package com.CabPortal.resources;

import com.CabPortal.Services.CabService;
import com.CabPortal.models.*;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cab")
@Produces(MediaType.APPLICATION_JSON)
public class CabResource {


    private final CabService cabService;

    public CabResource(CabService cabService) {
        this.cabService = cabService;
    }

    @POST
    @Path("/register")
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerCab(CabRegistrationRequest registerCabRequestBody)  throws  Exception{
        CabRegistrationResponse cabRegistrationResponseBody = new CabRegistrationResponse();
        return Response.status(Response.Status.OK).entity(cabRegistrationResponseBody).build();
    }

    @PUT
    @Path("/update")
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCabMetadata(UpdateCabDataRequest updateCabDataRequest)  throws  Exception{
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/cabHistory")
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCabHistory(CabHistoryRequest cabHistoryRequest)  throws  Exception{
        return Response.status(Response.Status.OK).build();
    }
}
