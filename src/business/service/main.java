package business.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Service;
import dal.CategoryDAO;
import dal.PostDAO;
import dto.Category;
import dto.Post;

public class main implements Service {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> categoryList = CategoryDAO.getinst()
				 								 .selectCategoryAll();
		List<Post> recentList = PostDAO.getinst()
									   .selectRecentPostList();
		List<Post> popularList = PostDAO.getinst()
										.selectMostPopularPostList();
		List<Post> likedList = PostDAO.getinst()
									  .selectMostLikedPostList();
		
		req.setAttribute("categoryList", categoryList);
		req.setAttribute("recentList", recentList);
		req.setAttribute("popularList", popularList);
		req.setAttribute("likedList", likedList);
		req.getRequestDispatcher("/view/main.jsp").forward(req, resp);
	}
}
