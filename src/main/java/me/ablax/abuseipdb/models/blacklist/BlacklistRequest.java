package me.ablax.abuseipdb.models.blacklist;

public class BlacklistRequest {

    private Integer confidenceMinimum;

    public BlacklistRequest(final Integer confidenceMinimum) {
        this.confidenceMinimum = confidenceMinimum;
    }

    public BlacklistRequest() {
        this.confidenceMinimum = 90;
    }

    public Integer getConfidenceMinimum() {
        return confidenceMinimum;
    }

    public void setConfidenceMinimum(final Integer confidenceMinimum) {
        this.confidenceMinimum = confidenceMinimum;
    }
}
