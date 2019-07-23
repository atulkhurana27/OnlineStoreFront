package com.OnlineStore.resources;

import com.OnlineStore.CartService.DiscountHandler;
import com.OnlineStore.db.DepartmentDAO;
import com.OnlineStore.db.ProductDAO;
import com.OnlineStore.models.CartRequestBody;
import com.OnlineStore.models.CartResponseBody;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/carts")
@Produces(MediaType.APPLICATION_JSON)
public class CartResource {


    private final ProductDAO productDAO;
    private final DepartmentDAO departmentDAO;
    private final DiscountHandler discountHandler;

    public CartResource(ProductDAO productDAO, DepartmentDAO departmentDAO, DiscountHandler discountHandler) {
        this.productDAO = productDAO;
        this.departmentDAO = departmentDAO;
        this.discountHandler = discountHandler;
    }

    @POST
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    public Response applyDiscounts(CartRequestBody cartRequestBody)  throws  Exception{
        CartResponseBody cartResponseBody = discountHandler.applyDiscounts(cartRequestBody);
        return Response.status(Response.Status.OK).entity(cartResponseBody).build();
    }
}
