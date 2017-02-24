package org.xiaoxz.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * @Author
 * 2017Äê2ÔÂ24ÈÕ  
 * TODO
 *
 */
public class PropsUtils {
	private static Properties props = null;
	private static InputStream in = null;
	private static String  username;
	private static String password;
	private static String url;
	private static String prjId;
	private static String time;
	private static String sql;
	static{
		try {
			in = PropsUtils.class.getResourceAsStream("/database.properties");
			props = new Properties();
		    props.load(in);
			String drivers = props.getProperty("jdbc.drivers");
			url = props.getProperty("jdbc.url");
			username = props.getProperty("jdbc.username");
			password = props.getProperty("jdbc.password");
			time = props.getProperty("time");
			prjId = props.getProperty("prjId");
			sql = props.getProperty("sql");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static Properties getProps() {
		return props;
	}

	public static void setProps(Properties props) {
		PropsUtils.props = props;
	}


	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		PropsUtils.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		PropsUtils.password = password;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		PropsUtils.url = url;
	}

	public static String getPrjId() {
		return prjId;
	}

	public static void setPrjId(String prjId) {
		PropsUtils.prjId = prjId;
	}

	public static String getTime() {
		return time;
	}

	public static void setTime(String time) {
		PropsUtils.time = time;
	}

	public static String getSql() {
		return sql;
	}

	public static void setSql(String sql) {
		PropsUtils.sql = sql;
	}
	
	
	

}
