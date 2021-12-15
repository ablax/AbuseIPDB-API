package me.ablax.abuseipdb.ednpoints;

import me.ablax.abuseipdb.interfaces.Endpoint;
import me.ablax.abuseipdb.models.bulkreport.BulkReportRequest;
import me.ablax.abuseipdb.models.bulkreport.BulkReportResponse;

public class BulkReport extends Endpoint<BulkReportRequest, BulkReportResponse> {

    protected BulkReport(final String apiKey) {
        super(apiKey);
    }

    @Override
    public BulkReportResponse sendRequest(BulkReportRequest request) {
        return null;
    }

}
