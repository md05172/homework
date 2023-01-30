package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("*.hrd")
public class FrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(FrontController.class);
	
	@Override
	public void init() throws ServletException {
		RequestMapping.init();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		String method = request.getMethod();
		System.out.println("url = " + url);
		RequestKeyValue key = new RequestKeyValue(url, method);
		Controller controller = RequestMapping.getController(key);
		if(controller != null) {
			logger.info("=-=-=-=-=-=-=-{}//{}-=-=-=-=-=-=-=", key, controller.getClass());
			controller.handle(request, response);
		} else {
			logger.info("::::::::::::{} 잘못된 요청입니다.::::::::::::", key);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('요청 url, method 와 일치하는 Controller가 없습니다');");
			out.println("location.href='/myself/'");
			out.println("</script>");
		}
	}
}
