package me.ablax.abuseipdb.models.report;

public class ReportResponse {

    private String ipAddress;
    private int abuseConfidenceScore;

    public ReportResponse(final String ipAddress, final int abuseConfidenceScore) {
        this.ipAddress = ipAddress;
        this.abuseConfidenceScore = abuseConfidenceScore;
    }

    public ReportResponse() {
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(final String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getAbuseConfidenceScore() {
        return abuseConfidenceScore;
    }

    public void setAbuseConfidenceScore(final int abuseConfidenceScore) {
        this.abuseConfidenceScore = abuseConfidenceScore;
    }

}
