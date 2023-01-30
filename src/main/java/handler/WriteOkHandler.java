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
import error.Error;
import mapper.Config;
import vo.UserVo;
import vo.WriteVo;

public class WriteOkHandler implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		SqlSession session = null;
		WriteDao dao = null;
		//현재 로그인한 사람 정보
		UserVo vo = (UserVo)request.getSession().getAttribute(Error.SAVEID);
		WriteVo wvo = new WriteVo();
		wvo.setUser(vo);
		wvo.setSubject(subject);
		wvo.setContent(content);	
		
		int cnt = 0;
		
		session = Config.getSqlSessionFactory().openSession();
		dao = session.getMapper(WriteDao.class);
		try {
			cnt = dao.write(wvo);
			session.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		request.setAttribute("result", cnt);
		request.setAttribute("wvo", wvo);
		System.out.println("wvo.getId = " + wvo.getId());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/writeOk.jsp");
		dispatcher.forward(request, response);
		
	}

}
