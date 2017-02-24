package org.xiaoxz.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author
 * 2017Äê2ÔÂ23ÈÕ  
 * TODO
 *
 */
public class DBManager {
	
	public static Connection getConnection(){
		Connection conn = null;
		String name = PropsUtils.getUsername();
		String password = PropsUtils.getPassword();
		String url = PropsUtils.getUrl();
		try {
			conn = DriverManager.getConnection(url, name, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection(Connection connection,PreparedStatement statement,ResultSet rs){
		try{
			if(connection != null)
				connection.close();
			if(statement != null)
				statement.close();
			if(rs != null)
				rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
}
