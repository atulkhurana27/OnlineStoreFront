package com.OnlineStore.resources;

import com.OnlineStore.Utils.Utils;
import com.OnlineStore.models.Product;
import com.OnlineStore.db.DepartmentDAO;
import com.OnlineStore.db.ProductDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;


@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    private final ProductDAO productDAO;
    private final DepartmentDAO departmentDAO;

    public ProductResource(ProductDAO productDAO, DepartmentDAO departmentDAO) {
        this.productDAO = productDAO;
        this.departmentDAO = departmentDAO;
    }

    @POST
    @UnitOfWork
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(Product product)  throws  Exception{
        product = productDAO.create(product);
        return Response.status(Response.Status.OK).entity(product).build();
    }

    @GET
    @UnitOfWork
    @Path("/fetch/{id}")
    public Response findById(@PathParam("id") Long id) {
        Optional<Product> optional = productDAO.findById(id);
        if(optional.isPresent()) {
            Product product = productDAO.findById(id).get();
            return Response.status(Response.Status.OK).entity(product).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }


    }

    @PUT
    @UnitOfWork
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(@HeaderParam("authentification_header") String authenHeader,Product product) throws  Exception {
        if(authenHeader.equalsIgnoreCase(Utils.AUTH_HEADER)) {
            product =  productDAO.update(product);
            return Response.status(Response.Status.OK).entity(product).build();
        }else {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

    }

    @DELETE
    @UnitOfWork
    @Path("/delete/{id}")
    public Response deleteProduct(@HeaderParam("authentification_header") String authenHeader,@PathParam("id") Long id) {
        if(authenHeader.equalsIgnoreCase(Utils.AUTH_HEADER)) {
            productDAO.delete(id);
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }


    @GET
    @UnitOfWork
    @Path("/search/{searchParam}/{value}")
    public Response searchProducts(@PathParam("searchParam") String searchParam,@PathParam("value") String value)
    { try{
        List<Product> list = productDAO.searchByField(searchParam,value);
        return Response.status(Response.Status.OK).entity(list).build();
    }
    catch (Exception e){
        e.printStackTrace();
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    }
}
