package eu.nickel.openlibrary;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BookResult {

    private final String title;

    private final List<String> authorNames;

    private final int firstPublishYear;

    @JsonCreator
    public BookResult(@JsonProperty("title") String title,
                      @JsonProperty("author_name") List<String> authorNames,
                      @JsonProperty("first_publish_year") int firstPublishYear) {
        this.title = title;
        this.authorNames = authorNames;
        this.firstPublishYear = firstPublishYear;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthorNames() {
        return authorNames;
    }

    public int getFirstPublishYear() {
        return firstPublishYear;
    }
}
