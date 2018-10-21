package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class V3DAO {
	private static V3DAO inst;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private V3DAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "whvlwk");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static V3DAO getinst() {
		if(inst == null)
			inst = new V3DAO();
		return inst;
	}
	
	public void insertVisit() {
		try {
			conn.prepareStatement("INSERT INTO visit VALUES(default, now());")
				.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int selectVisitTotal() {
		try {
			rs = conn.prepareStatement("SELECT COUNT(visitId) FROM visit;")
					 .executeQuery();
			while(rs.next()) 
				return rs.getInt(1); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;	
	}
	public int selectVisitToday() {
		try {
			rs = conn.prepareStatement("SELECT COUNT(visitId) FROM visit WHERE now()-date < 86400;")
					.executeQuery();
			while(rs.next()) 
				return rs.getInt(1); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;	
	}
}
