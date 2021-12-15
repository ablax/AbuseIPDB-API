package me.ablax.abuseipdb.ednpoints;

import me.ablax.abuseipdb.interfaces.Endpoint;
import me.ablax.abuseipdb.models.clearaddress.ClearAddressRequest;
import me.ablax.abuseipdb.models.clearaddress.ClearAddressResponse;
import me.ablax.abuseipdb.models.clearaddress.FullClearAddressResponseData;

import java.io.IOException;
import java.util.Map;

public class ClearAddress extends Endpoint<ClearAddressRequest, ClearAddressResponse> {
    protected ClearAddress(final String apiKey) {
        super(apiKey);
    }

    @Override
    public ClearAddressResponse sendRequest(final ClearAddressRequest request) throws IOException {
        final Map<Object, Object> fields = propsMapper.writeValueAsProperties(request);
        removeNullValues(fields);

        final String response = httpClient.sendDeleteRequest("clear-address", apiKey, fields);
        return objectMapper.readValue(response, FullClearAddressResponseData.class).getData();
    }
}
