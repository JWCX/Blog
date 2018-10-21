package business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException ;
}
