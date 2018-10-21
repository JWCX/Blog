package business.service.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Service;

public class new_post_complete implements Service {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("admin") == null) {
			req.getRequestDispatcher("/error/404.jsp").forward(req, resp); 
			return;
		}
		req.setAttribute("message", "포스트를 등록했습니다.");
		req.getRequestDispatcher("/view/redirect_to_main.jsp").forward(req, resp);
	}
}
