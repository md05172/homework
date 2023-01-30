package handler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import controller.Controller;
import dao.WriteDao;
import mapper.Config;
import vo.WriteVo;

public class DetailHandler implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		SqlSession sqlSession = null;
		WriteDao dao = null;
		WriteVo vo = null;
		sqlSession = Config.getSqlSessionFactory().openSession();
		dao = sqlSession.getMapper(WriteDao.class);
		try {
			dao.viewPlus(id);
			vo = dao.showId(id);
			sqlSession.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		request.setAttribute("vo", vo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/detail.jsp");
		dispatcher.forward(request, response);
	}

}
