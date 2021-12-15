package me.ablax.abuseipdb.ednpoints;

import me.ablax.abuseipdb.interfaces.Endpoint;
import me.ablax.abuseipdb.models.check.CheckRequest;
import me.ablax.abuseipdb.models.check.CheckResponse;
import me.ablax.abuseipdb.models.check.FullCheckResponseData;

import java.io.IOException;
import java.util.Map;

public class Check extends Endpoint<CheckRequest, CheckResponse> {

    protected Check(final String apiKey) {
        super(apiKey);
    }

    @Override
    public CheckResponse sendRequest(final CheckRequest request) throws IOException {
        final Map<Object, Object> fields = propsMapper.writeValueAsProperties(request);
        removeNullValues(fields);

        final String response = httpClient.sendGetRequest("check", apiKey, fields);

        return objectMapper.readValue(response, FullCheckResponseData.class).getData();
    }
}
