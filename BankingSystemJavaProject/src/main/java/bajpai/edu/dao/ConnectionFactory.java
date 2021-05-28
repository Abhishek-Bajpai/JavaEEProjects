package bajpai.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private final String connectionURL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String dbUser = "bank";
	private final String dbUserPwdString = "secret";
	
	
	private Connection connection=null;

//	Adding getConnection so it can be closed by the calling program once DB processing is done
	public Connection getConnection() {
	 	if(connection == null) {
	 		try {
				connection = DriverManager.getConnection(connectionURL, dbUser, dbUserPwdString);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	}
		return connection;
	}
}
