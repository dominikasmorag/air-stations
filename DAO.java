import java.sql.*;

public class DAO {
    private final Connection connection;
    private final PreparedStatement insertStatementStation;
    private final PreparedStatement insertStatementCity;
    private static final String AIRSTATIONS_INSERT_SQL = "INSERT INTO AIRSTATIONS (" +
            "STATION_ID, " +
            "STATION_NAME, " +
            "GEGR_LAT, " +
            "GEGR_LON, " +
            "ADDRESS_STREET, " +
            "CITY_ID)" +
            "VALUES (?,?,?,?,?,?)";
    private static final String CITIES_INSERT_SQL = "INSERT INTO CITIES (" +
            "CITY_ID, " +
            "CITY_NAME, " +
            "COMMUNE_NAME, " +
            "DISTRICT_NAME, " +
            "PROVINCE_NAME)" +
            "VALUES (?,?,?,?,?)";

    public DAO(Connection connection) throws SQLException{
        this.connection = connection;
        this.insertStatementStation = connection.prepareStatement(AIRSTATIONS_INSERT_SQL);
        this.insertStatementCity = connection.prepareStatement(CITIES_INSERT_SQL);
    }

    public void insertToDB(Station station) throws SQLException {
        insertStatementStation.setInt(1, station.getId());
        insertStatementStation.setString(2, station.getStationName());
        insertStatementStation.setFloat(3, station.getGegrLat());
        insertStatementStation.setFloat(4, station.getGegrLon());
        insertStatementStation.setString(5, station.getAddressStreet());
        insertStatementStation.setInt(6, station.getCityId());
        insertStatementStation.executeUpdate();
    }

    public void insertToDB(City city) throws SQLException {
        insertStatementCity.setInt(1, city.getId());
        insertStatementCity.setString(2, city.getName());
        insertStatementCity.setString(3, city.getCommuneName());
        insertStatementCity.setString(4, city.getDistrictName());
        insertStatementCity.setString(5, city.getProvinceName());
        insertStatementCity.executeUpdate();
    }
}
