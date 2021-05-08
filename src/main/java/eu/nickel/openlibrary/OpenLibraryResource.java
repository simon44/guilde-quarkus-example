package eu.nickel.openlibrary;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/openlibrary")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OpenLibraryResource {

    @Inject
    @RestClient
    OpenLibraryClient openLibraryClient;

    @GET
    public SearchResult query(@QueryParam("query") @NotEmpty String query) {
        return openLibraryClient.query(query);
    }
}
