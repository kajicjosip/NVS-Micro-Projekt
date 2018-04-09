package at.htl.kaffeeladen.rest;

import at.htl.kaffeeladen.business.ProductFacade;
import at.htl.kaffeeladen.entities.Product;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by josipkajic on 03.02.2017.
 */
@Path("/product")
public class ProductEnpoint {

    @Inject
    ProductFacade productFacade = new ProductFacade();

    @GET
    @Path("findAll")
    public Response findAll()
    {
        return Response.ok(productFacade.findAll(), MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/findById/{id}")
    public Response findById(@PathParam("id") int id){
        if (id <= 0 ||id > productFacade.findAll().size()){
            return Response.status(400).build();
        }
        return Response.ok(productFacade.findById(id), MediaType.APPLICATION_JSON).build();
    }
    @POST
    @Path("/createProduct")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBill(Product product, @Context UriInfo uriInfo){
        if (product != null){
            productFacade.save(product);
            return Response.ok().build();
        }
        return Response.ok().build();
    }
}
