package eu.nickel.book.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class BookPayload {

    private final String title;

    @JsonCreator
    public BookPayload(@JsonProperty("title") @NotEmpty String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
