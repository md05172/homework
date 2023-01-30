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
import dao.WriteDao;
import mapper.Config;
import vo.WriteVo;

public class ListHandler implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = null;
		WriteDao dao = null;
		List<WriteVo> list = null;
		
		sqlSession = Config.getSqlSessionFactory().openSession();
		dao = sqlSession.getMapper(WriteDao.class);
		try {
			list = dao.showAll();
			
			sqlSession.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/list.jsp");
		dispatcher.forward(request, response);
	}

}
