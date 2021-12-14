package me.ablax.abuseipdb;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;
import me.ablax.abuseipdb.client.HttpClient;
import me.ablax.abuseipdb.models.blacklist.BlacklistRequest;
import me.ablax.abuseipdb.models.blacklist.BlacklistResponse;
import me.ablax.abuseipdb.models.check.CheckRequest;
import me.ablax.abuseipdb.models.check.CheckResponse;
import me.ablax.abuseipdb.models.check.FullCheckResponseData;
import me.ablax.abuseipdb.models.checkblock.CheckBlockRequest;
import me.ablax.abuseipdb.models.checkblock.CheckBlockResponse;
import me.ablax.abuseipdb.models.checkblock.FullCheckBlockResponseData;
import me.ablax.abuseipdb.models.clearaddress.ClearAddressRequest;
import me.ablax.abuseipdb.models.clearaddress.ClearAddressResponse;
import me.ablax.abuseipdb.models.clearaddress.FullClearAddressResponseData;
import me.ablax.abuseipdb.models.report.FullReportResponseData;
import me.ablax.abuseipdb.models.report.ReportRequest;
import me.ablax.abuseipdb.models.report.ReportResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
        removeNullValues(fields);

        final String response = httpClient.sendGetRequest("check", apiKey, fields);

        return objectMapper.readValue(response, FullCheckResponseData.class).getData();
    }

    public CheckBlockResponse checkNetwork(final CheckBlockRequest request) throws IOException {
        final Map<Object, Object> fields = propsMapper.writeValueAsProperties(request);
        removeNullValues(fields);

        final String response = httpClient.sendGetRequest("check-block", apiKey, fields);

        return objectMapper.readValue(response, FullCheckBlockResponseData.class).getData();
    }

    public ClearAddressResponse clearIp(final ClearAddressRequest request) throws IOException {
        final Map<Object, Object> fields = propsMapper.writeValueAsProperties(request);
        removeNullValues(fields);

        final String response = httpClient.sendDeleteRequest("clear-address", apiKey, fields);
        return objectMapper.readValue(response, FullClearAddressResponseData.class).getData();
    }

    public BlacklistResponse getBlacklist(final BlacklistRequest request) throws IOException {
        final Map<Object, Object> fields = propsMapper.writeValueAsProperties(request);
        removeNullValues(fields);

        final String response = httpClient.sendGetRequest("blacklist", apiKey, fields);

        return objectMapper.readValue(response, BlacklistResponse.class);
    }

    public ReportResponse reportIp(final ReportRequest reportRequest) throws IOException {
        final Map<Object, Object> fields = propsMapper.writeValueAsProperties(reportRequest);
        fields.keySet().forEach(key -> {
            if (key.toString().startsWith("category")) fields.remove(key);
        });
        final Optional<String> categories = reportRequest.getCategories().stream().map(String::valueOf).reduce((a, b) -> a + "," + b);
        if (categories.isPresent()) {
            fields.put("categories", categories.get());
        } else {
            throw new RuntimeException("No categories specified");
        }

        fields.put("category", categories.get());
        removeNullValues(fields);

        final String response = httpClient.sendPostRequest("report", apiKey, fields);

        return objectMapper.readValue(response, FullReportResponseData.class).getData();
    }


    private void removeNullValues(final Map<Object, Object> fields) {
        while (true) {
            if (!fields.values().remove(null)) break;
        }
    }
}
