package ch.survalit.math.boundary;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.json.JsonObject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class AddResourceIT {

    @RestClient
    AddResourceClient addResourceClient;

    @Test
    @DisplayName("add 10 and 90")
    void addTenNinety() {
        var response = this.addResourceClient.add(10, 90);
        assertThat(response.getStatus()).isEqualTo(200);
        var entity = response.readEntity(JsonObject.class);

        System.out.println("entity = " + entity);
        assertThat(entity.getInt("result")).isEqualTo(100);
    }
}
