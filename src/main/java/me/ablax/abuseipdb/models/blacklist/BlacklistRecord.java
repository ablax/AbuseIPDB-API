package me.ablax.abuseipdb.models.blacklist;

import java.util.Date;

public class BlacklistRecord {
    private String ipAddress;
    private String countryCode;
    private int abuseConfidenceScore;
    private Date lastReportedAt;

    public BlacklistRecord(final String ipAddress, final String countryCode, final int abuseConfidenceScore, final Date lastReportedAt) {
        this.ipAddress = ipAddress;
        this.countryCode = countryCode;
        this.abuseConfidenceScore = abuseConfidenceScore;
        this.lastReportedAt = lastReportedAt;
    }

    public BlacklistRecord() {
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
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

    public Date getLastReportedAt() {
        return lastReportedAt;
    }

    public void setLastReportedAt(final Date lastReportedAt) {
        this.lastReportedAt = lastReportedAt;
    }
}