package dao;

import java.sql.SQLException;
import java.util.List;

import vo.WriteVo;

public interface WriteDao {
	int write(WriteVo vo) throws SQLException;
	
	WriteVo showId(int id) throws SQLException;
	
	int viewPlus(int id) throws SQLException;
	
	List<WriteVo> showAll() throws SQLException;
	
}
