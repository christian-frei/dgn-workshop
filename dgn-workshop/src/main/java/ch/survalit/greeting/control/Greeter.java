package ch.survalit.greeting.control;

import ch.survalit.greeting.entity.Mood;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class Greeter {


    public Mood getMood(String name) {
        return switch (name) {
            case "pinky" -> new Mood("GREAT!", "i have cheese cake! yay! yippee!");
            case "brain" -> new Mood("UNFORTUNATE!", "tomorrow, we will conquer THE WORLD!! muuaaahahaha");
            default -> throw new WebApplicationException(Response.Status.BAD_REQUEST);
        };
    }
}
