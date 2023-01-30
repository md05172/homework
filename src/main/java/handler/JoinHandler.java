package handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import error.Error;

public class JoinHandler implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		Error.getSessionerror(request);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user/join.jsp");
		dispatcher.forward(request, response);
	}

}
