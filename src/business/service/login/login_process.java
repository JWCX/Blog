package business.service.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Service;
import dal.UserDAO;

public class login_process implements Service {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO dao = UserDAO.getinst();
		if (dao.getPassword(req.getParameter("id")).equals(dao.getHashPw(req.getParameter("password")))) {
			req.getSession().setAttribute("admin", "true");
			req.getSession().setMaxInactiveInterval(0);
			resp.sendRedirect(req.getContextPath());
		} else {
			req.getRequestDispatcher("/view/login/login_failed.jsp").forward(req, resp);
		}
	}
}