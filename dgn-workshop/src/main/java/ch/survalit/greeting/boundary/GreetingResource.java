package ch.survalit.greeting.boundary;

import ch.survalit.greeting.control.Greeter;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/greet")
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {

    @Inject
    Greeter greeter;

    @GET
    @Path("{name}")
    public Response howAreYou(@PathParam("name") String name) {
        var mood = this.greeter.getMood(name);
        return Response.ok(mood).build();
    }
}
