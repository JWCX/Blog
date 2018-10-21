package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Comment;
import dto.Post;

public class CommentDAO {
	private static CommentDAO inst;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private CommentDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "whvlwk");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static CommentDAO getinst() {
		if(inst == null)
			inst = new CommentDAO();
		return inst;
	}
	
	public void insertComment(Comment comment) {
		try {
				ps = conn.prepareStatement("INSERT INTO comment VALUES(default, ?, ?, ?, NOW(), ?, ?);");
				ps.setInt(1, comment.getPostId());
				ps.setString(2, comment.getWriter());
				ps.setString(3, comment.getPassword());
				ps.setString(4, comment.getContent());
				ps.setInt(5, comment.getVisible());
				ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Comment> SelectCommentByPostId(int postId) {
		List<Comment> commentList = new ArrayList<>();
		try {
			rs = conn.prepareStatement("SELECT * FROM comment WHERE postId = '" + postId + "' ORDER BY date asc;")
					 .executeQuery();
			while(rs.next()) 
				commentList.add(new Comment(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), 
											rs.getTimestamp(5), rs.getString(6), rs.getInt(7)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commentList;	
	}
	public void deleteComment(int commentId) {
		try {
			ps = conn.prepareStatement("DELETE FROM comment WHERE commentId = ?");
			ps.setInt(1, commentId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteCommentsByPostId(int postId) {
		try {
			ps = conn.prepareStatement("DELETE FROM comment WHERE postId = ?");
			ps.setInt(1, postId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
