package business.service.category;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Service;
import dal.CategoryDAO;
import dto.Category;

public class modify implements Service{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("admin") == null) {
			req.getRequestDispatcher("/error/404.jsp").forward(req, resp); 
			return;
		}
		List<Category> categoryList = CategoryDAO.getinst()
				 						 .selectCategoryAll();
		req.setAttribute("categoryList", categoryList);
		req.getRequestDispatcher("/view/category/modify.jsp").forward(req, resp);
	}
}
