public class Station {
    private int id;
    private String stationName;
    private Float gegrLat;
    private Float gegrLon;
    private String addressStreet;
    private int cityId;

    public int getCityId() { return cityId; }

    public void setCityId(int cityId) { this.cityId = cityId; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Float getGegrLat() {
        return gegrLat;
    }

    public void setGegrLat(Float gegrLat) {
        this.gegrLat = gegrLat;
    }

    public Float getGegrLon() {
        return gegrLon;
    }

    public void setGegrLon(Float gegrLon) {
        this.gegrLon = gegrLon;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String toString() {
        return "stationId: " + id +
                "\nstationName: " + stationName +
                "\ngegrLat: " + gegrLat +
                "\ngegrLon: " + gegrLon +
                "\naddressStreet: " + addressStreet;
    }
}
