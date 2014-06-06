package me.demo.resource;

import me.demo.exception.DemoServiceException;
import me.jsend.FailureResponse;
import me.jsend.SuccessListResponse;
import me.jsend.SuccessResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import me.demo.dto.DemoCustomer;
import me.demo.service.DemoCustomerService;



/**
 * Created by chrislin on 5/29/2014.
 */



@Path("/customers")
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
@Consumes({MediaType.APPLICATION_JSON})
@Api(value = "/customers", description = "REST api for Customers resources")
public class DemoCustomerResource {

    @Autowired
    private DemoCustomerService customerService;

    @Context
    UriInfo uriInfo;


    @GET
    @ApiOperation(value = "List all Customers", notes = "List all customer using paging", response = DemoCustomer.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Out of luck - something wrong in Server")
    })
    public Response listCustomers(@QueryParam("names") String names, @QueryParam("pageSize") Integer pageSize) {
        //System.out.println("name is:" +  names + ", pageSize is: " + pageSize);
        List<DemoCustomer> list = customerService.listCustomers();
        return Response.ok(new SuccessListResponse(list, 100)).build();
    }

    /**
     *
     * @param id
     * @return
     */
    @Path("/{id}")
    @GET
    @ApiOperation(value = "Retrieve customer using id", notes = "use 111 test for success, 222 for 500 response and others for 404 response", response = DemoCustomer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404 , message = "Not Found"),
            @ApiResponse(code = 500, message = "Out of luck - something wrong in Server")})
    public Response getCustomer(@PathParam("id") Integer id) {
        System.out.println("id is: " + id);

        if (id != 111 && id != 222)
            throw new DemoServiceException("DemoServiceException Throwed message#################");
        if (id == 222)
            return Response.status(Status.NOT_FOUND)
                    .entity(new FailureResponse(Status.NOT_FOUND.getReasonPhrase())).build();

        DemoCustomer c = customerService.getFullCustomer();

        return Response.ok(new SuccessResponse(c)).build();
    }

    @POST
    @ApiOperation(value = "Create new customer", notes = "Create new customer, name bad-name will casue conflict, others are good")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Customer created successfully"),
            @ApiResponse(code = 409, message = "Customer with such name already exists")})
    public Response createCustomer(DemoCustomer c) {
        UriBuilder ub = uriInfo.getAbsolutePathBuilder();
        if ("bad-name".compareTo(c.getName()) == 0) {
            return Response.status(Status.CONFLICT).
                    entity(new FailureResponse(Status.CONFLICT.getReasonPhrase())).build();
        }
        c.setId(1212);
        System.out.println("newly created cutomer: \n"
                + "c.getId(): " + c.getId()
                + ", c.getName(): " + c.getName()
                + ", c.getAccounts().size(): " + c.getAccounts().size()
                + ", c.getAccounts().get(0).getName(): " + c.getAccounts().get(0).getName());

        URI url = ub.segment("999").build();
        return Response.created(url).entity(new SuccessResponse(c)).build();
    }


    @Path("/{id}")
    @PUT
    @ApiOperation(value = "Update Customer partially", notes = "update customer partially - treat json as string, using post request json schema" )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Customer updated successfully")})
    public Response updateCustomer(String aString) {

        ObjectMapper mp = new ObjectMapper();
        DemoCustomer c1 = customerService.getFullCustomer();

        try {
            ObjectReader r = mp.readerForUpdating(c1);
            DemoCustomer c= r.readValue(aString);
            return Response.ok(new SuccessResponse(c)).build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Path("/{id}")
    @DELETE
    @ApiOperation(value = "Delete Customer", notes = "delete Customer use 111 for 204 response, others for 404 not found response")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Customer updated successfully"),
            @ApiResponse(code = 404 , message = "Not Found")})
    public Response deleteCustomer(@PathParam("id") Integer id) {
        System.out.println("id to be deleted: " + id);
        if (id == 111)
            return Response.noContent().build();
        //return Response.status(Status.NO_CONTENT).entity(new SuccessResponse()).build();
        else
            return Response.status(Status.NOT_FOUND).entity(new FailureResponse(Status.NOT_FOUND.getReasonPhrase())).build();
    }

}
