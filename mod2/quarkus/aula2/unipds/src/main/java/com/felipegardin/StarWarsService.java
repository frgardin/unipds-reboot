package com.felipegardin;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "https://swapi.info/api/starships")
public interface StarWarsService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getStarships();
}
