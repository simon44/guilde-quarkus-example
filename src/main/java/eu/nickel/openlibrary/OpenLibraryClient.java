package eu.nickel.openlibrary;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@RegisterRestClient(configKey="open-library-api")
public interface OpenLibraryClient {

    @GET
    @Path("/search.json")
    SearchResult query(@QueryParam("q") String query);
}
