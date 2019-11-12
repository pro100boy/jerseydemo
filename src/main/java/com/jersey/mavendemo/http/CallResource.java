package com.jersey.mavendemo.http;

import com.jersey.mavendemo.model.Calls;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Arrays;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/callservice")
@Api("/Call Service")
@SwaggerDefinition(tags = {@Tag(name = "Call Service", description = "REST endpoints for call service")})
@Slf4j
public class CallResource {

    @ApiOperation(value = "get call list", response = Calls.class, responseContainer = "list")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Error 1"),
            @ApiResponse(code = 503, message = "Error 2")
    })
    @GET
    @Path("/calls")
    @Produces(APPLICATION_JSON)
    public List<Calls> getCalls() {
        log.info(">>getCalls");
        return Arrays.asList(
                Calls.builder()
                        .callId("1")
                        .callName("name1")
                        .timestamp("1:" + System.currentTimeMillis())
                        .build(),
                Calls.builder()
                        .callId("2")
                        .callName("name2")
                        .timestamp("2:" + System.currentTimeMillis())
                        .build());
    }
}
