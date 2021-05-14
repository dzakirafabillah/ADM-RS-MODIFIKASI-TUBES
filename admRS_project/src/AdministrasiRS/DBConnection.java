
package AdministrasiRS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String DB_DRIVER_CLASS = "oracle.jdbc.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USERNAME = "HR";
	private static final String DB_PASSWORD = "kurogane";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			// load the Driver Class
			Class.forName(DB_DRIVER_CLASS);

			// create the connection now
			con = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
