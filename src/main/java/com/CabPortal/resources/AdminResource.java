package com.CabPortal.resources;

import com.CabPortal.Services.AdminService;
import com.CabPortal.models.*;
import io.dropwizard.hibernate.UnitOfWork;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Admin")
@Produces(MediaType.APPLICATION_JSON)
public class AdminResource {


    private final AdminService adminService;

    public AdminResource(AdminService adminService) {
        this.adminService = adminService;
    }

    @POST
    @Path("/onboardCity")
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    public Response onboardCity(OnboardCityRequest onboardCityRequest)  throws  Exception{
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/cabIdlePeriod")
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    public Response checkIsCableIdle(CheckCABIdleRequest checkCABIdleRequest)  throws  Exception{
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/highDemandCities")
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getHighDemandCities(CheckHighDemandRequest checkHighDemandRequest)  throws  Exception{
        return Response.status(Response.Status.OK).build();
    }

}
