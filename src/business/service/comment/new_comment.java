package business.service.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Service;
import dal.CommentDAO;
import dal.PostDAO;
import dto.Comment;

public class new_comment implements Service {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int secret = 0;
		if(req.getParameter("visible") != null)
			secret = 1;
		CommentDAO.getinst()
				  .insertComment(new Comment(0,Integer.parseInt(req.getParameter("postId")), req.getParameter("writer"), 
						  					 req.getParameter("password"), null, req.getParameter("content"),secret));
		PostDAO.getinst().updatePostCommentCnt(Integer.parseInt(req.getParameter("postId")));
		resp.sendRedirect(req.getContextPath()+"/post/post?categoryId="+req.getParameter("categoryId")+"&postId="+req.getParameter("postId"));
	}
}
