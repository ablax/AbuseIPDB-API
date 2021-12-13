package me.ablax.abuseipdb;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;
import me.ablax.abuseipdb.client.HttpClient;
import me.ablax.abuseipdb.models.check.CheckRequest;
import me.ablax.abuseipdb.models.check.CheckResponse;
import me.ablax.abuseipdb.models.check.FullCheckResponseData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AbuseIPDBApi {

    private static final Map<String, AbuseIPDBApi> instances = new HashMap<>();
    private final JavaPropsMapper propsMapper = new JavaPropsMapper();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final HttpClient httpClient = new HttpClient();
    private final String apiKey;

    private AbuseIPDBApi(final String apiKey) {
        this.apiKey = apiKey;
    }

    public static AbuseIPDBApi getAPI(final String apiKey) {
        if (instances.containsKey(apiKey)) {
            return instances.get(apiKey);
        }

        final AbuseIPDBApi api = new AbuseIPDBApi(apiKey);
        instances.put(apiKey, api);
        return api;
    }

    public static void main(String[] args) {
        final AbuseIPDBApi api = AbuseIPDBApi.getAPI("3916da6486bef48c3521e5a6a50e64f0b412af57522898be424dfd5151d306ccc2d6486ce1368be4");
        try {
            final CheckResponse checkResponse = api.checkIp(new CheckRequest("87.121.54.170"));
            System.out.println(checkResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CheckResponse checkIp(final CheckRequest request) throws IOException {
        final Map<Object, Object> fields = propsMapper.writeValueAsProperties(request);
        while (fields.values().remove(null)) ;

        final String response = httpClient.sendRequest("check", apiKey, fields);

        return objectMapper.readValue(response, FullCheckResponseData.class).data;
    }
}
