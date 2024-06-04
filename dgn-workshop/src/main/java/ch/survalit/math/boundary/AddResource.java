package ch.survalit.math.boundary;

import ch.survalit.exception.control.WorkshopException;
import ch.survalit.math.control.Adder;
import jakarta.json.Json;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/math/add")
@Produces(MediaType.APPLICATION_JSON)
public class AddResource {

    @GET
    public Response add(@QueryParam("a") int a, @QueryParam("b") int b) {

        if (a < 0 || b < 0) {
            throw new WorkshopException(Response.Status.BAD_REQUEST, "001", "stay positive");
        }

        var result = Adder.add(a, b);
        var entity = Json.createObjectBuilder()
                .add("result", result)
                .build();

        return Response.ok(entity)
                .build();
    }
}
