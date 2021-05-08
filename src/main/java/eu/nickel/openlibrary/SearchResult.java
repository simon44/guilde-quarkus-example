package eu.nickel.openlibrary;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchResult {

    private final int numFound;

    private final List<BookResult> docs;

    @JsonCreator
    public SearchResult(@JsonProperty("numFound") int numFound,
                        @JsonProperty("docs") List<BookResult> docs) {
        this.numFound = numFound;
        this.docs = docs;
    }

    public int getNumFound() {
        return numFound;
    }

    public List<BookResult> getDocs() {
        return docs;
    }
}
