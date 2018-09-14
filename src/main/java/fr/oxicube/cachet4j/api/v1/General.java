package fr.oxicube.cachet4j.api.v1;

import javax.ws.rs.core.MediaType;

public class General {

    private CachetClient cachetClient;

    public General(CachetClient cachetClient) {
        this.cachetClient = cachetClient;
    }

    public boolean ping() {
        PingResponse response = cachetClient.apiUrl.path("/ping").request(MediaType.APPLICATION_JSON)
                .get(PingResponse.class);
        if (response.data.equals("Pong!")) {
            return true;
        } else {
            return false;
        }
    }

    public String version() {
        VersionResponse response = cachetClient.apiUrl.path("/version").request(MediaType.APPLICATION_JSON)
                .get(VersionResponse.class);
        return response.data;
    }
}

class PingResponse {
    public String data;
}

class VersionResponse {
    public String data;
    public VersionMeta meta;
}

class VersionMeta {
    public String on_latest;
    public MetaLatest latest;
}

class MetaLatest {
    public String tag_name;
    public Boolean prelease;
    public Boolean draft;
}