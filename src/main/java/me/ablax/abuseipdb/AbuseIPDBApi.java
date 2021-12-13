package me.ablax.abuseipdb;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;
import me.ablax.abuseipdb.client.HttpClient;
import me.ablax.abuseipdb.models.blacklist.BlacklistRequest;
import me.ablax.abuseipdb.models.blacklist.BlacklistResponse;
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

    public CheckResponse checkIp(final CheckRequest request) throws IOException {
        final Map<Object, Object> fields = propsMapper.writeValueAsProperties(request);
        while (fields.values().remove(null)) ;

        final String response = httpClient.sendRequest("check", apiKey, fields);

        return objectMapper.readValue(response, FullCheckResponseData.class).data;
    }

    public BlacklistResponse getBlacklist(final BlacklistRequest request) throws IOException {
        final Map<Object, Object> fields = propsMapper.writeValueAsProperties(request);
        while (fields.values().remove(null)) ;

        final String response = httpClient.sendRequest("blacklist", apiKey, fields);

        return objectMapper.readValue(response, BlacklistResponse.class);
    }
}
