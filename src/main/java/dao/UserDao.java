package dao;

import java.sql.SQLException;
import java.util.List;

import vo.UserVo;

public interface UserDao {
	//아이디 중복체크
	List<UserVo> checkId(UserVo vo) throws SQLException;
	
	//회원가입 성공
	int joinOk(UserVo vo) throws SQLException;
	
}
