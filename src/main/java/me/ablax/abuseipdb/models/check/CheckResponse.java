package me.ablax.abuseipdb.models.check;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class CheckResponse {
    private String ipAddress;
    @JsonProperty(value="isPublic")
    private Boolean isPublic;
    private Integer ipVersion;
    @JsonProperty(value="isWhitelisted")
    private Boolean isWhitelisted;
    private Integer abuseConfidenceScore;
    private String countryCode;
    private String countryName;
    private String usageType;
    private String isp;
    private String domain;
    private List<String> hostnames;
    private Integer totalReports;
    private Integer numDistinctUsers;
    private Date lastReportedAt;
    private List<Report> reports;

    public CheckResponse() {
    }

    public CheckResponse(final String ipAddress, final Boolean isPublic, final Integer ipVersion, final Boolean isWhitelisted, final Integer abuseConfidenceScore, final String countryCode, final String countryName, final String usageType, final String isp, final String domain, final List<String> hostnames, final Integer totalReports, final Integer numDistinctUsers, final Date lastReportedAt, final List<Report> reports) {
        this.ipAddress = ipAddress;
        this.isPublic = isPublic;
        this.ipVersion = ipVersion;
        this.isWhitelisted = isWhitelisted;
        this.abuseConfidenceScore = abuseConfidenceScore;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.usageType = usageType;
        this.isp = isp;
        this.domain = domain;
        this.hostnames = hostnames;
        this.totalReports = totalReports;
        this.numDistinctUsers = numDistinctUsers;
        this.lastReportedAt = lastReportedAt;
        this.reports = reports;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(final String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(final Boolean aPublic) {
        isPublic = aPublic;
    }

    public Integer getIpVersion() {
        return ipVersion;
    }

    public void setIpVersion(final Integer ipVersion) {
        this.ipVersion = ipVersion;
    }

    public Boolean getWhitelisted() {
        return isWhitelisted;
    }

    public void setWhitelisted(final Boolean whitelisted) {
        isWhitelisted = whitelisted;
    }

    public Integer getAbuseConfidenceScore() {
        return abuseConfidenceScore;
    }

    public void setAbuseConfidenceScore(final Integer abuseConfidenceScore) {
        this.abuseConfidenceScore = abuseConfidenceScore;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(final String countryName) {
        this.countryName = countryName;
    }

    public String getUsageType() {
        return usageType;
    }

    public void setUsageType(final String usageType) {
        this.usageType = usageType;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(final String isp) {
        this.isp = isp;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(final String domain) {
        this.domain = domain;
    }

    public List<String> getHostnames() {
        return hostnames;
    }

    public void setHostnames(final List<String> hostnames) {
        this.hostnames = hostnames;
    }

    public Integer getTotalReports() {
        return totalReports;
    }

    public void setTotalReports(final Integer totalReports) {
        this.totalReports = totalReports;
    }

    public Integer getNumDistinctUsers() {
        return numDistinctUsers;
    }

    public void setNumDistinctUsers(final Integer numDistinctUsers) {
        this.numDistinctUsers = numDistinctUsers;
    }

    public Date getLastReportedAt() {
        return lastReportedAt;
    }

    public void setLastReportedAt(final Date lastReportedAt) {
        this.lastReportedAt = lastReportedAt;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(final List<Report> reports) {
        this.reports = reports;
    }

    @Override
    public String toString() {
        return "CheckResponse{" +
                "ipAddress='" + ipAddress + '\'' +
                ", isPublic=" + isPublic +
                ", ipVersion=" + ipVersion +
                ", isWhitelisted=" + isWhitelisted +
                ", abuseConfidenceScore=" + abuseConfidenceScore +
                ", countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", usageType='" + usageType + '\'' +
                ", isp='" + isp + '\'' +
                ", domain='" + domain + '\'' +
                ", hostnames=" + hostnames +
                ", totalReports=" + totalReports +
                ", numDistinctUsers=" + numDistinctUsers +
                ", lastReportedAt=" + lastReportedAt +
                ", reports=" + reports +
                '}';
    }
}
