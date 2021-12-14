package me.ablax.abuseipdb.models.check;

public class FullCheckResponseData {
    private CheckResponse data;

    public FullCheckResponseData() {
    }

    public FullCheckResponseData(final CheckResponse data) {
        this.data = data;
    }

    public CheckResponse getData() {
        return data;
    }

    public void setData(final CheckResponse data) {
        this.data = data;
    }
}
