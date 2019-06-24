package com.app.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//import org.gjt.mm.mysql.Driver;

public class SQLConnectionFactory {

	private static Properties properties = new Properties();

	static {
//		try {
//			FileInputStream fis = new FileInputStream("WEB-INF/db.properties");
//			properties.load(fis);
//			fis.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		// step-1 : register JDBC driver
//		DriverManager.registerDriver(new Driver());
		// or
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}

	// factory-method
	public static Connection getConnection() throws SQLException {

		// step-2 : create new connection
		//String url = properties.getProperty("jdbc:oracle:thin:hr/hr@localhost:1521:orcl");
		//String user = properties.getProperty("hr");
		//String password = properties.getProperty("hr");
		String url = "jdbc:oracle:thin:hr/hr@localhost:1521:orcl";
		String user = "hr";
		String password = "hr";

		return DriverManager.getConnection(url, user, password);

	}

}