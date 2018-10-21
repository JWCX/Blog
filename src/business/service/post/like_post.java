package business.service.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Service;
import dal.PostDAO;

public class like_post implements Service {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean hasCookie=false;
		for(Cookie c : req.getCookies()){
			if(c.getName().equals("like"+req.getParameter("postId"))){
				hasCookie = true;
				Cookie cookie = new Cookie("like"+req.getParameter("postId"),"true");
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
				PostDAO.getinst().updatePostEvaluationCnt_(Integer.parseInt(req.getParameter("postId")));
				break;
			}
		}
		if(!hasCookie) {
			Cookie cookie = new Cookie("like"+req.getParameter("postId"),"true");
			cookie.setMaxAge(2147483647);
			resp.addCookie(cookie);
			PostDAO.getinst().updatePostEvaluationCnt(Integer.parseInt(req.getParameter("postId")));
		}
		resp.sendRedirect(req.getContextPath()+"/post/post?categoryId="+req.getParameter("categoryId")+"&postId="+req.getParameter("postId"));
	}
}
