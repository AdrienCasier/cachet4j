package fr.oxicube.cachet4j.api.v1;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class CachetClient {

    private final Client client = ClientBuilder.newClient();

    public final String host;
    public final String apiToken;
    public final WebTarget apiUrl;

    public CachetClient(String host, String apiToken) {
        this.host = host;
        this.apiToken = apiToken;
        this.apiUrl = this.client.target(this.host + "/api/v1/");
    }
}