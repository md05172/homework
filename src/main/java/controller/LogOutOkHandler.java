package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import error.Error;

public class LogOutOkHandler implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute(Error.SAVEID);
		response.sendRedirect(request.getContextPath() + "/home.hrd");
	}

}
