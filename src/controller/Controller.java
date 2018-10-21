package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Service;
import dal.V3DAO;

@WebServlet(urlPatterns= {"", "/main/*", "/post/*", "/category/*", "/login/*", "/comment/*"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "business.service" + 
					  (req.getServletPath().equals("") ? ".home" : 
					  (req.getServletPath() + (req.getPathInfo() != null ? req.getPathInfo() : ""))
						  .toLowerCase()
						  .replaceAll("/", "."));
		if(path.endsWith("."))
			path = path.substring(0, path.length()-1);
		
		new CookieMonster().cookieControl(req, resp);
		req.setAttribute("visitCntTotal", V3DAO.getinst().selectVisitTotal());
		req.setAttribute("visitCntToday", V3DAO.getinst().selectVisitToday());
		
		try {
			((Service)(Class.forName(path).newInstance())).execute(req, resp);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			if(e instanceof ClassNotFoundException)
				req.getRequestDispatcher("/view/error/404.jsp").forward(req, resp);
			else e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		execute(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		execute(req, resp);
	}
}

