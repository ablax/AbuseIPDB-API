package me.ablax.abuseipdb.models.checkblock;

public class CheckBlockRequest {
    private String network;
    private Integer maxAgeInDays = 30;

    public CheckBlockRequest(final String network, final int maxAgeInDays) {
        this.network = network;
        if (maxAgeInDays >= 1 && maxAgeInDays <= 365) {
            this.maxAgeInDays = maxAgeInDays;
        }
    }

    public CheckBlockRequest(final String network) {
        this.network = network;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(final String network) {
        this.network = network;
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

}
