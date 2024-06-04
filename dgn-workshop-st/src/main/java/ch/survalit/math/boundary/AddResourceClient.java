package ch.survalit.math.boundary;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "base_uri")
@Path("/math/add")
public interface AddResourceClient {

    @GET
    Response add(@QueryParam("a") int a, @QueryParam("b") int b);
}
