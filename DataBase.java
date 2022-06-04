import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    private final Connection connection;
    private static final String AIR_STATIONS_SQL = "CREATE TABLE IF NOT EXISTS AirStations (" +
            "station_id SMALLINT, " +
            "station_name VARCHAR(100), " +
            "gegr_lat DOUBLE(5), " +
            "gegr_lon DOUBLE(5), " +
            "address_street VARCHAR(100), " +
            "city_id SMALLINT" +
            ");";
    private static final String CITIES_SQL = "CREATE TABLE IF NOT EXISTS Cities (" +
            "city_id SMALLINT, " +
            "city_name VARCHAR(100), " +
            "commune_name VARCHAR(100)," +
            "district_name VARCHAR(100), " +
            "province_name VARCHAR(100)" +
            ");";

    DataBase(Connection connection) {
        this.connection = connection;
    }

    public void createSchema() throws SQLException {
        createTables(connection);
    }

    private void createTables(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(AIR_STATIONS_SQL);
        statement.execute(CITIES_SQL);
        statement.close();
    }
}
