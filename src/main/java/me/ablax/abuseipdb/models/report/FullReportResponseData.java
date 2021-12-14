package me.ablax.abuseipdb.models.report;

public class FullReportResponseData {
    private ReportResponse data;

    public FullReportResponseData() {
    }

    public FullReportResponseData(final ReportResponse data) {
        this.data = data;
    }

    public ReportResponse getData() {
        return data;
    }

    public void setData(final ReportResponse data) {
        this.data = data;
    }
}
