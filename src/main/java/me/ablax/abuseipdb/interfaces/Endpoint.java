package me.ablax.abuseipdb.interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;
import me.ablax.abuseipdb.client.HttpClient;

import java.io.IOException;
import java.util.Map;

public abstract class Endpoint<REQ, RES> {

    protected final String apiKey;
    protected final JavaPropsMapper propsMapper = new JavaPropsMapper();
    protected final ObjectMapper objectMapper = new ObjectMapper();
    protected final HttpClient httpClient = new HttpClient();

    protected Endpoint(final String apiKey) {
        this.apiKey = apiKey;
    }

    protected void removeNullValues(final Map<Object, Object> fields) {
        while (true) {
            if (!fields.values().remove(null)) break;
        }
    }

    public abstract RES sendRequest(REQ request) throws IOException;
}
