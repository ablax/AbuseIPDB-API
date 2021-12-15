package me.ablax.abuseipdb.ednpoints;

import me.ablax.abuseipdb.interfaces.Endpoint;
import me.ablax.abuseipdb.models.report.FullReportResponseData;
import me.ablax.abuseipdb.models.report.ReportRequest;
import me.ablax.abuseipdb.models.report.ReportResponse;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public class Report extends Endpoint<ReportRequest, ReportResponse> {

    protected Report(final String apiKey) {
        super(apiKey);
    }

    @Override
    protected ReportResponse sendRequest(final ReportRequest request) throws IOException {
        final Map<Object, Object> fields = propsMapper.writeValueAsProperties(request);
        fields.keySet().forEach(key -> {
            if (key.toString().startsWith("category")) fields.remove(key);
        });
        final Optional<String> categories = request.getCategories().stream().map(String::valueOf).reduce((a, b) -> a + "," + b);
        fields.put("categories", categories.orElse(""));

        removeNullValues(fields);

        final String response = httpClient.sendPostRequest("report", apiKey, fields);

        return objectMapper.readValue(response, FullReportResponseData.class).getData();
    }
}
