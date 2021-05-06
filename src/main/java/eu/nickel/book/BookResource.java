package eu.nickel.book;

import eu.nickel.book.payload.BookPayload;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GET
    public Response getAll() {
        return Response.ok().entity(bookService.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") int id) {
        return Response.ok().entity(bookService.getById(id)).build();
    }

    @POST
    @Transactional
    public Response create(@Valid BookPayload bookPayload) {
        return Response.ok(bookService.create(bookPayload)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") int id, @Valid BookPayload bookPayload) {
        return Response.ok(bookService.update(id, bookPayload)).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") int id) {
        bookService.delete(id);
        return Response.noContent().build();
    }
}
