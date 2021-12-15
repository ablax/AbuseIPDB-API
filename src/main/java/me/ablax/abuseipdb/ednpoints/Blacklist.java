package me.ablax.abuseipdb.ednpoints;

import me.ablax.abuseipdb.interfaces.Endpoint;
import me.ablax.abuseipdb.models.blacklist.BlacklistRequest;
import me.ablax.abuseipdb.models.blacklist.BlacklistResponse;

import java.io.IOException;
import java.util.Map;

public class Blacklist extends Endpoint<BlacklistRequest, BlacklistResponse> {
    protected Blacklist(final String apiKey) {
        super(apiKey);
    }

    @Override
    protected BlacklistResponse sendRequest(final BlacklistRequest request) throws IOException {
        final Map<Object, Object> fields = propsMapper.writeValueAsProperties(request);
        removeNullValues(fields);

        final String response = httpClient.sendGetRequest("blacklist", apiKey, fields);

        return objectMapper.readValue(response, BlacklistResponse.class);
    }

}
