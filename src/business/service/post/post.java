package business.service.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Service;
import dal.CategoryDAO;
import dal.CommentDAO;
import dal.PostDAO;
import dto.Category;
import dto.Comment;
import dto.Post;

public class post implements Service {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Post post = PostDAO.getinst()
						   .selectPostById(Integer.parseInt(req.getParameter("postId"))); 
		List<Category> categoryList = CategoryDAO.getinst()
												 .selectCategoryAll();
		List<Post> postList = PostDAO.getinst().selectPostListByCategoryId(Integer.parseInt(req.getParameter("categoryId")));
		List<Comment> commentList = CommentDAO.getinst().SelectCommentByPostId(Integer.parseInt(req.getParameter("postId")));
		req.setAttribute("categoryList", categoryList);
		req.setAttribute("postList", postList);
		req.setAttribute("commentList", commentList);
		req.setAttribute("post", post);
		req.setAttribute("categoryId", req.getParameter("categoryId"));
		req.setAttribute("pagePath", "/view/post/post.jsp");
		
		for(Cookie c : req.getCookies())
			if(c.getName().equals("like"+req.getParameter("postId")))
				req.setAttribute("like", "true");
		
		req.getRequestDispatcher("/view/main.jsp").forward(req, resp);
	}
}
