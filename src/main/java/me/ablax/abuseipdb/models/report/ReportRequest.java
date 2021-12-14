package me.ablax.abuseipdb.models.report;

import java.util.List;

public class ReportRequest {

    private String ip;
    private String comment;
    private List<Integer> categories;

    public ReportRequest(final String ip, final String comment, final List<Integer> categories) {
        this.ip = ip;
        this.comment = comment;
        this.categories = categories;
    }

    public ReportRequest() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(final String ip) {
        this.ip = ip;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(final List<Integer> categories) {
        this.categories = categories;
    }
}
