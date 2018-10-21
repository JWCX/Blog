package business.service.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Service;
import dal.PostDAO;
import dto.Post;

public class new_post_process implements Service{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("admin") == null) {
			req.getRequestDispatcher("/error/404.jsp").forward(req, resp); 
			return;
		}
		boolean secret = false;
		if(req.getParameter("secret") != null)
			secret = true;
		PostDAO.getinst()
			   .insertPost(new Post(Integer.parseInt(req.getParameter("categoryId")), req.getParameter("title"), req.getParameter("content"), secret));
		resp.sendRedirect(req.getContextPath()+"/post/new_post_complete");
	}
}
