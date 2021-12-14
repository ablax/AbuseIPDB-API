package me.ablax.abuseipdb.models.checkblock;

public class FullCheckBlockResponseData {
    private CheckBlockResponse data;

    public FullCheckBlockResponseData() {
    }

    public FullCheckBlockResponseData(final CheckBlockResponse data) {
        this.data = data;
    }

    public CheckBlockResponse getData() {
        return data;
    }

    public void setData(final CheckBlockResponse data) {
        this.data = data;
    }
}
