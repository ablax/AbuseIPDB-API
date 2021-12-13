package me.ablax.abuseipdb.models.check;

public class CheckRequest {
    private String ipAddress;
    private Integer maxAgeInDays;
    private Boolean verbose;

    public CheckRequest(final String ipAddress, final int maxAgeInDays, final boolean verbose) {
        this.ipAddress = ipAddress;
        if (maxAgeInDays < 1 || maxAgeInDays > 365) {
            this.maxAgeInDays = 30;
        } else {
            this.maxAgeInDays = maxAgeInDays;
        }
        this.verbose = verbose;
    }

    public CheckRequest(final String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(final String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getMaxAgeInDays() {
        return maxAgeInDays;
    }

    public void setMaxAgeInDays(final Integer maxAgeInDays) {
        if (maxAgeInDays < 1 || maxAgeInDays > 365) {
            this.maxAgeInDays = 30;
        } else {
            this.maxAgeInDays = maxAgeInDays;
        }
    }

    public Boolean isVerbose() {
        return verbose;
    }

    public void setVerbose(final Boolean verbose) {
        this.verbose = verbose;
    }
}
