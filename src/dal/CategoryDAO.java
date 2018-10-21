package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dto.Category;

public class CategoryDAO {
	private static CategoryDAO inst;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private CategoryDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "whvlwk");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static CategoryDAO getinst() {
		if(inst == null)
			inst = new CategoryDAO();
		return inst;
	}
	
	public Category selectCategoryById(int categoryId){
		try {
			rs = conn.prepareStatement("SELECT * FROM category WHERE categoryId = "+categoryId+";")
					.executeQuery();
			while(rs.next()) 
				return new Category(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getByte(5),rs.getString(6));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Category> selectCategoryAll(){
		List<Category> categoryList = new ArrayList<>();
		try {
			rs = conn.prepareStatement("SELECT * FROM category ORDER BY groupId, depth, category.order;")
					 .executeQuery();
			while(rs.next()) 
				categoryList.add(new Category(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getByte(5),rs.getString(6)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}
	public void insertCategories(List<Category> categoryList) {
		try {
			for(Category category : categoryList) {
				ps = conn.prepareStatement("INSERT INTO category VALUES(?,?,?,?,?,?);");
				ps.setInt(1, category.getCategoryId());
				ps.setInt(2, category.getGroupId());
				ps.setInt(3, category.getDepth());
				ps.setInt(4, category.getOrder());
				ps.setInt(5, category.getType());
				ps.setString(6, category.getName());
				ps.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCategories(List<Category> categoryList) {
		try {
			for(Category category : categoryList) {
				ps = conn.prepareStatement("UPDATE category SET name = ? WHERE categoryId = ?;");
				ps.setString(1, category.getName());
				ps.setInt(2, category.getCategoryId());
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCategories(List<Integer> categoryList) {
		try {
			for(Integer categoryId : categoryList) {
				ps = conn.prepareStatement("DELETE FROM category WHERE categoryId = ?;");
				ps.setInt(1, categoryId);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
