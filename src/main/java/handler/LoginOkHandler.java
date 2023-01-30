package handler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import controller.Controller;
import dao.UserDao;
import error.Error;
import mapper.Config;
import vo.UserVo;

public class LoginOkHandler implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String conpath = request.getContextPath();
		
		UserVo vo = UserVo.builder().username(username).build();
		SqlSession sqlSession = Config.getSqlSessionFactory().openSession();
		UserDao dao = sqlSession.getMapper(UserDao.class);
		
		try {
			List<UserVo> list = dao.checkId(vo);
			if(list.size() != 1) {
				Error.addSessionerror(request, "error", "아이디가 같지 않습니다.");
				Error.addSessionerror(request, "username", "username");
				response.sendRedirect(conpath + "/login.hrd");
				return;
			}
			
			System.out.println("vo = " + list.get(0).toString());
			
			if(!list.get(0).getPassword().equals(password)) {
				Error.addSessionerror(request, "error", "비밀번호가 같지 않습니다.");
				Error.addSessionerror(request, "username", username);
				response.sendRedirect(conpath + "/login.hrd");
				return;
			}
			vo = list.get(0);
			HttpSession session = request.getSession();
			session.setAttribute(Error.SAVEID, vo);
			
			sqlSession.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("./home.jsp");
		dispatcher.forward(request, response);
	}

}
