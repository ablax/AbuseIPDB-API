package me.ablax.abuseipdb.models.checkblock;

import java.util.Date;

public class ReportedAddress {
    private String ipAddress;
    private int numReports;
    private Date mostRecentReport;
    private int abuseConfidenceScore;
    private Object countryCode;

    public ReportedAddress(final String ipAddress, final int numReports, final Date mostRecentReport, final int abuseConfidenceScore, final Object countryCode) {
        this.ipAddress = ipAddress;
        this.numReports = numReports;
        this.mostRecentReport = mostRecentReport;
        this.abuseConfidenceScore = abuseConfidenceScore;
        this.countryCode = countryCode;
    }

    public ReportedAddress() {
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(final String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getNumReports() {
        return numReports;
    }

    public void setNumReports(final int numReports) {
        this.numReports = numReports;
    }

    public Date getMostRecentReport() {
        return mostRecentReport;
    }

    public void setMostRecentReport(final Date mostRecentReport) {
        this.mostRecentReport = mostRecentReport;
    }

    public int getAbuseConfidenceScore() {
        return abuseConfidenceScore;
    }

    public void setAbuseConfidenceScore(final int abuseConfidenceScore) {
        this.abuseConfidenceScore = abuseConfidenceScore;
    }

    public Object getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(final Object countryCode) {
        this.countryCode = countryCode;
    }

}