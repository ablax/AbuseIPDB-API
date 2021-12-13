package me.ablax.abuseipdb.models.blacklist;

import java.util.List;

public class BlacklistResponse {


    private Meta meta;
    private List<BlacklistRecord> data;

    public BlacklistResponse(final Meta meta, final List<BlacklistRecord> data) {
        this.meta = meta;
        this.data = data;
    }

    public BlacklistResponse() {
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(final Meta meta) {
        this.meta = meta;
    }

    public List<BlacklistRecord> getData() {
        return data;
    }

    public void setData(final List<BlacklistRecord> data) {
        this.data = data;
    }
}
