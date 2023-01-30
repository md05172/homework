package handler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import controller.Controller;
import dao.UserDao;
import error.Error;
import mapper.Config;
import vo.UserVo;

public class JoinOkHandler implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String re_password = request.getParameter("re_password");
		String name = request.getParameter("name");
		
		String conpath = request.getContextPath();
		
		if(!password.equals(re_password)) {
			Error.addSessionerror(request, "error", "비밀번호 같은거같냐???");
			Error.addSessionerror(request, "username", username);
			Error.addSessionerror(request, "name", name);
			response.sendRedirect(conpath + "/join.hrd");
			return;
		}
		
		SqlSession sqlSession = null;
		UserDao dao = null;
		UserVo vo = UserVo.builder().username(username).password(password).name(name).build();
		List<UserVo> list = null;
		int cnt = 0;
		try {
			sqlSession = Config.getSqlSessionFactory().openSession();
			dao = sqlSession.getMapper(UserDao.class);
			list = dao.checkId(vo);
			
			if(list.size() != 0) {
				Error.addSessionerror(request, "error", "아이디 있자나 ㅅㅂ");
				Error.addSessionerror(request, "username", username);
				Error.addSessionerror(request, "name", name);
				response.sendRedirect(conpath + "/join.hrd");
				return;
			}
			cnt = dao.joinOk(vo);
			sqlSession.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		request.setAttribute("result", cnt);
		request.setAttribute("vo", vo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user/joinOk.jsp");
		dispatcher.forward(request, response);
	}

}
