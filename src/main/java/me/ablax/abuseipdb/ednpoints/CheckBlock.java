package me.ablax.abuseipdb.ednpoints;

import me.ablax.abuseipdb.interfaces.Endpoint;
import me.ablax.abuseipdb.models.checkblock.CheckBlockRequest;
import me.ablax.abuseipdb.models.checkblock.CheckBlockResponse;
import me.ablax.abuseipdb.models.checkblock.FullCheckBlockResponseData;

import java.io.IOException;
import java.util.Map;

public class CheckBlock extends Endpoint<CheckBlockRequest, CheckBlockResponse> {

    protected CheckBlock(final String apiKey) {
        super(apiKey);
    }

    @Override
    protected CheckBlockResponse sendRequest(final CheckBlockRequest request) throws IOException {
        final Map<Object, Object> fields = propsMapper.writeValueAsProperties(request);
        removeNullValues(fields);

        final String response = httpClient.sendGetRequest("check-block", apiKey, fields);

        return objectMapper.readValue(response, FullCheckBlockResponseData.class).getData();
    }
}
