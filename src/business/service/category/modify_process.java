package business.service.category;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Service;
import dal.CategoryDAO;
import dal.PostDAO;
import dto.Category;

public class modify_process implements Service {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("admin") == null) {
			req.getRequestDispatcher("/error/404.jsp").forward(req, resp); 
			return;
		}
		
		CategoryDAO dao = CategoryDAO.getinst();
		List<Category> updateCategoryList = new ArrayList<>();
		List<Integer> deleteCategoryList = new ArrayList<>();
		List<Category> insertCategoryList = new ArrayList<>();
		
		for(Entry<String,String[]> paramName : req.getParameterMap().entrySet()) {
			String key = paramName.getKey();
			String[] value = paramName.getValue();
			if(key.equals("delete")) {
				for(String categoryId : value)
					deleteCategoryList.add(Integer.parseInt(categoryId));
			} else {
				if(value[0].equals("new")) {
					insertCategoryList.add(new Category(Integer.parseInt(key), Integer.parseInt(value[1]),
														Integer.parseInt(value[2]), Integer.parseInt(value[3]),
														Integer.parseInt(value[4]), value[5]));		
				} else {
					updateCategoryList.add(new Category(Integer.parseInt(key), Integer.parseInt(value[0]),
												  Integer.parseInt(value[1]),Integer.parseInt(value[2]),
												  Integer.parseInt(value[3]),value[4]));
				}
			}
		}
		
		for(int categoryId : deleteCategoryList) 
			PostDAO.getinst().deletePostsByCateogryId(categoryId);
		
		dao.updateCategories(updateCategoryList);	// must follow this order
		dao.deleteCategories(deleteCategoryList);
		dao.insertCategories(insertCategoryList);
		resp.sendRedirect(req.getContextPath()+"/category/modify_complete");
	}
}
