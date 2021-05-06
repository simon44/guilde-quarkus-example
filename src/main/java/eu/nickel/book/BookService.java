package eu.nickel.book;

import eu.nickel.book.payload.BookPayload;
import io.netty.handler.codec.http.HttpResponseStatus;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookService {

    public List<Book> getAll() {
        return Book.findAll().list();
    }

    public Book getById(int id) {
        Book book = Book.findById(id);
        return Optional.ofNullable(book)
                .orElseThrow(() -> new WebApplicationException(HttpResponseStatus.NOT_FOUND.code()));
    }

    public Book create(BookPayload bookPayload) {
        Book book = new Book();
        book.title = bookPayload.getTitle();
        book.persist();
        return book;
    }

    public Book update(int id, BookPayload bookPayload) {
        Book book = Book.findById(id);
        return Optional.ofNullable(book)
                .map(b -> {
                    b.title = bookPayload.getTitle();
                    b.persist();
                    return b;
                }).orElseThrow(() -> new WebApplicationException(HttpResponseStatus.NOT_FOUND.code()));
    }

    public void delete(int id) {
        Book book = Book.findById(id);
        if (book == null) {
            throw new WebApplicationException(HttpResponseStatus.NOT_FOUND.code());
        } else {
            book.delete();
        }
    }
}
