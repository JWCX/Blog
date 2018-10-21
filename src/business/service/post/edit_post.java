package business.service.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Service;
import dal.CategoryDAO;
import dal.PostDAO;
import dto.Post;

public class edit_post implements Service {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("admin") == null) {
			req.getRequestDispatcher("/error/404.jsp").forward(req, resp); 
			return;
		}
		Post post = PostDAO.getinst()
						   .selectPostById(Integer.parseInt(req.getParameter("postId")));
		req.setAttribute("post", post);
		req.setAttribute("categoryName", CategoryDAO.getinst()
													.selectCategoryById(post.getCategoryId()).getName());
		req.getRequestDispatcher("/view/post/write_post.jsp").forward(req, resp);
	}
}
