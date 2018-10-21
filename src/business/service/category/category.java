package business.service.category;

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

public class category implements Service {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> categoryList = CategoryDAO.getinst()
												 .selectCategoryAll();
		List<Post> postList = PostDAO.getinst()
									 .selectPostListByCategoryId(Integer.parseInt(req.getParameter("categoryId")));
		req.setAttribute("categoryList", categoryList);
		req.setAttribute("postList", postList);
		req.setAttribute("categoryId", req.getParameter("categoryId"));
		req.setAttribute("pagePath", "/view/category/category.jsp");
		
		req.getRequestDispatcher("/view/main.jsp").forward(req, resp);
	}
}