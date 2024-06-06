package ch.survalit.greeting.control;

import ch.survalit.exception.control.WorkshopException;
import ch.survalit.greeting.entity.Mood;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class Greeter {

    public Mood getMood(String name) {
        return switch (name) {
            case "pinky" -> new Mood("GREAT!", "i have cheese cake! yay! yippee!");
            case "brain" -> new Mood("UNFORTUNATE!", "tomorrow, we will conquer THE WORLD!! muuaaahahaha");
//            default -> throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
//                    .header("reason", "%s does not exist".formatted(name))
//                    .entity(Json.createObjectBuilder()
//                            .add("why", "%s does not exist".formatted(name))
//                            .build())
//                    .build());
            default -> throw new WorkshopException(Response.Status.BAD_REQUEST, "001", "not found");
        };
    }
}
