import org.h2.jdbcx.JdbcDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class AirStations {

    public static void main(String[] args) throws SQLException {
        try {
            Client client = new Client();
            client.jsonToObjects();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JdbcDataSource ds = new JdbcDataSource();
        ds.setUrl(args[0]);
        ds.setUser(args[1]);
        ds.setPassword(args[2]);
        Connection conn = ds.getConnection();

        try {
            DataBase db = new DataBase(conn);
            db.createSchema();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        DAO dao = new DAO(conn);

        for(Station st : Client.stationsList) {
            dao.insertToDB(st);
        }

        for(Station st : Client.stationsList) {
            System.out.println(st);
        }
        for(City ct : Client.citiesList) {
            dao.insertToDB(ct);
        }
    }
}
