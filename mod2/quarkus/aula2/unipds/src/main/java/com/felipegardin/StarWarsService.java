package com.felipegardin;

import java.time.temporal.ChronoUnit;

import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "https://swapi.info/api/starships")
public interface StarWarsService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("starships")
    @Timeout(
        value = 3,
        unit = ChronoUnit.SECONDS
    )
    public String getStarships();
}
