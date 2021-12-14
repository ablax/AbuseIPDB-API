package me.ablax.abuseipdb.models.checkblock;

import java.util.List;

public class CheckBlockResponse {
    private String networkAddress;
    private String netmask;
    private String minAddress;
    private String maxAddress;
    private int numPossibleHosts;
    private String addressSpaceDesc;
    private List<ReportedAddress> reportedAddress;

    public CheckBlockResponse(final String networkAddress, final String netmask, final String minAddress, final String maxAddress, final int numPossibleHosts, final String addressSpaceDesc, final List<ReportedAddress> reportedAddress) {
        this.networkAddress = networkAddress;
        this.netmask = netmask;
        this.minAddress = minAddress;
        this.maxAddress = maxAddress;
        this.numPossibleHosts = numPossibleHosts;
        this.addressSpaceDesc = addressSpaceDesc;
        this.reportedAddress = reportedAddress;
    }

    public CheckBlockResponse() {
    }

    public String getNetworkAddress() {
        return networkAddress;
    }

    public void setNetworkAddress(final String networkAddress) {
        this.networkAddress = networkAddress;
    }

    public String getNetmask() {
        return netmask;
    }

    public void setNetmask(final String netmask) {
        this.netmask = netmask;
    }

    public String getMinAddress() {
        return minAddress;
    }

    public void setMinAddress(final String minAddress) {
        this.minAddress = minAddress;
    }

    public String getMaxAddress() {
        return maxAddress;
    }

    public void setMaxAddress(final String maxAddress) {
        this.maxAddress = maxAddress;
    }

    public int getNumPossibleHosts() {
        return numPossibleHosts;
    }

    public void setNumPossibleHosts(final int numPossibleHosts) {
        this.numPossibleHosts = numPossibleHosts;
    }

    public String getAddressSpaceDesc() {
        return addressSpaceDesc;
    }

    public void setAddressSpaceDesc(final String addressSpaceDesc) {
        this.addressSpaceDesc = addressSpaceDesc;
    }

    public List<ReportedAddress> getReportedAddress() {
        return reportedAddress;
    }

    public void setReportedAddress(final List<ReportedAddress> reportedAddress) {
        this.reportedAddress = reportedAddress;
    }

}