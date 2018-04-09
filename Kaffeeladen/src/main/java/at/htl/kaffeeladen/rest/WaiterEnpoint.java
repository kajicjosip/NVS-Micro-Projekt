package at.htl.kaffeeladen.rest;

import at.htl.kaffeeladen.business.WaiterFacade;
import at.htl.kaffeeladen.entities.Waiter;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by josipkajic on 03.02.2017.
 */
@Path("/waiter")
public class WaiterEnpoint {

    @Inject
    WaiterFacade waiterFacade = new WaiterFacade();

    @GET
    @Path("findAll")
    public Response findAll()
    {
        return Response.ok(waiterFacade.findAll(), MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/findById/{id}")
    public Response findById(@PathParam("id") int id){
        if (id <= 0 ||id > waiterFacade.findAll().size()){
            return Response.status(400).build();
        }
        return Response.ok(waiterFacade.findById(id), MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/createWaiter")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBill(Waiter waiter, @Context UriInfo uriInfo){
        if (waiter != null){
            waiterFacade.save(waiter);
            return Response.ok().build();
        }
        return Response.ok().build();
    }
}
