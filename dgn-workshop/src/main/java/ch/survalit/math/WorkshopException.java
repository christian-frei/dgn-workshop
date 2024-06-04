package ch.survalit.math;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class WorkshopException extends WebApplicationException {

    public WorkshopException(Response.Status status) {
        super(status);
    }

    public WorkshopException(Response.Status status, String message) {
        super(message, Response.status(status)
                .header("reason", message)
                .build());
    }

    public WorkshopException(Response.Status status, String errorCode, String error) {
        super(Response.status(status)
                .entity(createErrorObject(errorCode, error))
                .build());
    }

    private static JsonObject createErrorObject(String errorCode, String error) {
        return Json.createObjectBuilder()
                .add("error_code", errorCode)
                .add("error", error)
                .build();
    }
}
