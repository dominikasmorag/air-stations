public class City {
    int id;
    String name;
    String communeName;
    String districtName;
    String provinceName;

    public String getCommuneName() {
        return communeName;
    }

    public void setCommuneName(String communeName) {
        this.communeName = communeName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "cityId: " + id +
                "\ncityName: " + name +
                "\ncommuneName: " + communeName +
                "\ndistrictName: " + districtName +
                "\nprovinceName: " + provinceName;
    }

}
