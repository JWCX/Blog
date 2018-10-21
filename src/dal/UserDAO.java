package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	private static UserDAO inst;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private UserDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "whvlwk");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static UserDAO getinst() {
		if(inst == null)
			inst = new UserDAO();
		return inst;
	}
	public String getPassword(String id) {
		try {
			ps = conn.prepareStatement("SELECT * FROM User WHERE id = ?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next())
				return rs.getString("password");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	public String getHashPw(String pw) {
		try {
			ps = conn.prepareStatement("SELECT sha(?) FROM dual");
			ps.setString(1, pw);
			rs = ps.executeQuery();
			if (rs.next())
				return rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
}
