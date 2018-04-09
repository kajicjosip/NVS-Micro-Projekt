package at.htl.kaffeeladen.rest;

import at.htl.kaffeeladen.business.BillFacade;
import at.htl.kaffeeladen.entities.Bill;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by josipkajic on 01.02.2017.
 */
@Path("/bill")
public class BillEndpoint {

    @Inject
    BillFacade billFacade = new BillFacade();

    @GET
    @Path("findAll")
    public Response findAll()
    {
        return Response.ok(billFacade.findAll(), MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/findById/{id}")
    public Response findById(@PathParam("id") int id){
        if (id <= 0 ||id > billFacade.findAll().size()){
            return Response.status(400).build();
        }
        return Response.ok(billFacade.findById(id), MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/createBill")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBill(Bill bill, @Context UriInfo uriInfo){
        if (bill != null){
            billFacade.save(bill);
            return Response.ok().build();
        }
        return Response.ok().build();
    }
}
