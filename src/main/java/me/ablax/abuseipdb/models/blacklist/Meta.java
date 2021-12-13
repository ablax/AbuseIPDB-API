package me.ablax.abuseipdb.models.blacklist;

import java.util.Date;

public class Meta {
    public Date generatedAt;

    public Meta() {
    }

    public Meta(final Date generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Date getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(final Date generatedAt) {
        this.generatedAt = generatedAt;
    }
}