package me.ablax.abuseipdb.models.clearaddress;

public class FullClearAddressResponseData {
    private ClearAddressResponse data;

    public FullClearAddressResponseData(final ClearAddressResponse data) {
        this.data = data;
    }

    public FullClearAddressResponseData() {
    }

    public ClearAddressResponse getData() {
        return data;
    }

    public void setData(final ClearAddressResponse data) {
        this.data = data;
    }
}
