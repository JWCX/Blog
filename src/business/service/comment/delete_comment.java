package business.service.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Service;
import dal.CommentDAO;
import dal.PostDAO;

public class delete_comment implements Service {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CommentDAO.getinst()
				  .deleteComment(Integer.parseInt(req.getParameter("commentId")));
		PostDAO.getinst().updatePostCommentCnt_(Integer.parseInt(req.getParameter("postId")));
		resp.sendRedirect(req.getContextPath()+"/post/post?categoryId="+req.getParameter("categoryId")+"&postId="+req.getParameter("postId")+"#textarea");
	}
}
