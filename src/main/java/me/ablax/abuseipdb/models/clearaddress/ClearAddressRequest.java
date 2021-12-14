package me.ablax.abuseipdb.models.clearaddress;

public class ClearAddressRequest {
    private String ipAddress;

    public ClearAddressRequest() {
    }

    public ClearAddressRequest(final String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(final String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
