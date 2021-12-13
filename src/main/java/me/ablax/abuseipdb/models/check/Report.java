package me.ablax.abuseipdb.models.check;

import java.util.Date;
import java.util.List;

public class Report {
    private Date reportedAt;
    private String comment;
    private List<Integer> categories;
    private Integer reporterId;
    private String reporterCountryCode;
    private String reporterCountryName;

    public Report(final Date reportedAt, final String comment, final List<Integer> categories, final int reporterId, final String reporterCountryCode, final String reporterCountryName) {
        this.reportedAt = reportedAt;
        this.comment = comment;
        this.categories = categories;
        this.reporterId = reporterId;
        this.reporterCountryCode = reporterCountryCode;
        this.reporterCountryName = reporterCountryName;
    }

    public Report() {
    }

    public Date getReportedAt() {
        return reportedAt;
    }

    public void setReportedAt(final Date reportedAt) {
        this.reportedAt = reportedAt;
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

    public Integer getReporterId() {
        return reporterId;
    }

    public void setReporterId(final Integer reporterId) {
        this.reporterId = reporterId;
    }

    public String getReporterCountryCode() {
        return reporterCountryCode;
    }

    public void setReporterCountryCode(final String reporterCountryCode) {
        this.reporterCountryCode = reporterCountryCode;
    }

    public String getReporterCountryName() {
        return reporterCountryName;
    }

    public void setReporterCountryName(final String reporterCountryName) {
        this.reporterCountryName = reporterCountryName;
    }
}
