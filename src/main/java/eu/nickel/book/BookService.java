package eu.nickel.book;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class BookService {

    public List<Book> getAll() {
        return Book.findAll().list();
    }
}
