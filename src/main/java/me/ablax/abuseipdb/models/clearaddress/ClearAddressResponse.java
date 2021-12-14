package me.ablax.abuseipdb.models.clearaddress;

public class ClearAddressResponse {
    private int numReportsDeleted;

    public ClearAddressResponse() {
    }

    public ClearAddressResponse(final int numReportsDeleted) {
        this.numReportsDeleted = numReportsDeleted;
    }

    public int getNumReportsDeleted() {
        return numReportsDeleted;
    }

    public void setNumReportsDeleted(final int numReportsDeleted) {
        this.numReportsDeleted = numReportsDeleted;
    }

}
