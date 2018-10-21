package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Post;

public class PostDAO {
	private static PostDAO inst;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private PostDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "whvlwk");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static PostDAO getinst() {
		if(inst == null)
			inst = new PostDAO();
		return inst;
	}
	
	public void insertPost(Post post) {
		try {
				int latestPostNumber=0; 
				rs = conn.prepareStatement("SELECT MAX(number) FROM post WHERE categoryId = '"+post.getCategoryId()+"';")
						 .executeQuery();
				while(rs.next())
					latestPostNumber = rs.getInt(1);
				ps = conn.prepareStatement("INSERT INTO post VALUES(default, ?, now(), null, ?, ?, ?, ?, 0, 0, 0);");
				ps.setInt(1, post.getCategoryId());
				ps.setInt(2, ++latestPostNumber);
				ps.setString(3, post.getTitle());
				ps.setString(4, post.getContent());
				ps.setBoolean(5, post.isSecret());
				ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updatePost(Post post) {
		try {
			ps = conn.prepareStatement("UPDATE post SET title = ?, content = ?, secret = ? WHERE postId = ?;");
			ps.setString(1, post.getTitle());
			ps.setString(2, post.getContent());
			ps.setBoolean(3, post.isSecret());
			ps.setInt(4, post.getPostId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Post> selectPostListByCategoryId(int categoryId) {
		List<Post> postList = new ArrayList<>();
		try {
			rs = conn.prepareStatement("SELECT postId, categoryId, date, modifiedDate, number, title, secret, "
										+ "viewCnt, commentCnt, evaluationCnt FROM post WHERE categoryId = '" + categoryId + "' ORDER BY date desc;")
					 .executeQuery();
			while(rs.next()) 
				postList.add(new Post(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getInt(5), 
						  rs.getString(6), rs.getBoolean(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return postList;	
	}
	public List<Post> selectRecentPostList() {
		List<Post> postList = new ArrayList<>();
		try {
			rs = conn.prepareStatement("SELECT postId, categoryId, date, modifiedDate, number, title, secret, "
					+ "viewCnt, commentCnt, evaluationCnt FROM post ORDER BY date DESC, viewCnt DESC LIMIT 10;")
					.executeQuery();
			while(rs.next()) 
				postList.add(new Post(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getInt(5), 
						rs.getString(6), rs.getBoolean(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return postList;	
	}
	public List<Post> selectMostPopularPostList() {
		List<Post> postList = new ArrayList<>();
		try {
			rs = conn.prepareStatement("SELECT postId, categoryId, date, modifiedDate, number, title, secret, "
										+ "viewCnt, commentCnt, evaluationCnt FROM post ORDER BY viewCnt DESC, commentCnt DESC LIMIT 10;")
					 .executeQuery();
			while(rs.next()) 
				postList.add(new Post(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getInt(5), 
						  rs.getString(6), rs.getBoolean(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return postList;	
	}
	public List<Post> selectMostLikedPostList() {
		List<Post> postList = new ArrayList<>();
		try {
			rs = conn.prepareStatement("SELECT postId, categoryId, date, modifiedDate, number, title, secret, "
					+ "viewCnt, commentCnt, evaluationCnt FROM post ORDER BY evaluationCnt DESC, viewCnt DESC LIMIT 10;")
					.executeQuery();
			while(rs.next()) 
				postList.add(new Post(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getInt(5), 
						rs.getString(6), rs.getBoolean(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return postList;	
	}
	public Post selectPostById(int postId) {
		try {
			rs = conn.prepareStatement("SELECT * FROM post WHERE postId = " + postId + ";")
					 .executeQuery();
			while(rs.next()) 
				return new Post(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getInt(5), 
									  rs.getString(6), rs.getString(7), rs.getBoolean(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	public void deletePost(int postId) {
		try {
			ps = conn.prepareStatement("DELETE FROM post WHERE postId = ?");
			ps.setInt(1, postId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deletePostsByCateogryId(int categoryId) {
		try {
			ps = conn.prepareStatement("DELETE FROM post WHERE categoryId = ?");
			ps.setInt(1, categoryId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updatePostNumber(int categoryId, int postNumber) {
		try {
			ps = conn.prepareStatement("UPDATE post SET number = number-1 WHERE categoryId = ? AND number > ?;");
			ps.setInt(1, categoryId);
			ps.setInt(2, postNumber);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updatePostViewCnt(int postId) {
		try {
			conn.prepareStatement("UPDATE post SET viewCnt = viewCnt+1 WHERE postId = " + postId + ";")
				.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updatePostCommentCnt(int postId) {
		try {
			conn.prepareStatement("UPDATE post SET commentCnt = commentCnt+1 WHERE postId = " + postId + ";")
			.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updatePostCommentCnt_(int postId) {
		try {
			conn.prepareStatement("UPDATE post SET commentCnt = commentCnt-1 WHERE postId = " + postId + ";")
			.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updatePostEvaluationCnt(int postId) {
		try {
			conn.prepareStatement("UPDATE post SET evaluationCnt = evaluationCnt+1 WHERE postId = " + postId + ";")
			.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updatePostEvaluationCnt_(int postId) {
		try {
			conn.prepareStatement("UPDATE post SET evaluationCnt = evaluationCnt-1 WHERE postId = " + postId + ";")
			.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}