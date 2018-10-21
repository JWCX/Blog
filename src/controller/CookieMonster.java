package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.PostDAO;
import dal.V3DAO;

public class CookieMonster {
	public CookieMonster() {}
	public void cookieControl(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("admin") == null) {
			Cookie[] cookies = req.getCookies();
			Map<String, Cookie> cookieMap = new HashMap<>();
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					cookieMap.put(cookie.getName(), cookie);
				}
			}
			if(cookieMap.get("jwcxvisitor")==null) {
				Cookie cookie = new Cookie("jwcxvisitor", "0");
				cookie.setPath("/");
				cookie.setMaxAge(21600);
				resp.addCookie(cookie);

				V3DAO.getinst().insertVisit();	// TODO: 방문자 쿠키가없으므로 블로그 방문자수 + 1 처리구문
			}
			if(req.getParameter("postId")!=null && cookieMap.get("jwcxpid"+req.getParameter("postId"))==null) {
				Cookie cookie = new Cookie("jwcxpid"+req.getParameter("postId"),"0");
				cookie.setMaxAge(21600);
				resp.addCookie(cookie);
				
				PostDAO.getinst().updatePostViewCnt(Integer.parseInt(req.getParameter("postId"))); // TODO: 해당포스트 쿠키가 없으므로 해당 포스트 조회 + 1 처리구문.
			}
		}
	}
}
