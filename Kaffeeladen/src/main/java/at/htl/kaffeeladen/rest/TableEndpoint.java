package at.htl.kaffeeladen.rest;

import at.htl.kaffeeladen.business.TableFacade;
import at.htl.kaffeeladen.entities.CoffeeTable;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by josipkajic on 03.02.2017.
 */
@Path("/table")
public class TableEndpoint {

    @Inject
    TableFacade tableFacade = new TableFacade();

    @GET
    @Path("findAll")
    public Response findAll()
    {
        return Response.ok(tableFacade.findAll(), MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/findById/{id}")
    public Response findById(@PathParam("id") int id){
        if (id <= 0 ||id > tableFacade.findAll().size()){
            return Response.status(400).build();
        }
        return Response.ok(tableFacade.findById(id), MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/createTable")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBill(CoffeeTable coffeeTable, @Context UriInfo uriInfo){
        if (coffeeTable != null){
            tableFacade.save(coffeeTable);
            return Response.ok().build();
        }
        return Response.ok().build();
    }
}
