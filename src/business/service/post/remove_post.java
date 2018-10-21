package business.service.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Service;
import dal.CommentDAO;
import dal.PostDAO;

public class remove_post implements Service{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("admin") == null) {
			req.getRequestDispatcher("/error/404.jsp").forward(req, resp); 
			return;
		}

		CommentDAO.getinst()
				  .deleteCommentsByPostId(Integer.parseInt(req.getParameter("postId")));
		PostDAO dao = PostDAO.getinst();
		
		dao.deletePost(Integer.parseInt(req.getParameter("postId")));
		dao.updatePostNumber(Integer.parseInt(req.getParameter("categoryId")), Integer.parseInt(req.getParameter("postNumber")));
		resp.sendRedirect(req.getContextPath()+"/category/category?categoryId="+req.getParameter("categoryId"));
   }
}
