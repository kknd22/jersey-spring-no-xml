package me.demo.exceptionmapper;

import me.demo.exception.DemoServiceException;
import me.jsend.FailureResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by chrislin on 5/29/2014.
 */

@Provider
public class DemoRSExceptionMapper implements ExceptionMapper<DemoServiceException> {

    public Response toResponse(DemoServiceException ex) {
        FailureResponse f = new FailureResponse("encountered server error", "unkown", "try again in later time");
        return Response.serverError().entity(f).build();
    }
}

