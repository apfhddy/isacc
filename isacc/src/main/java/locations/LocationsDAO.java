package locations;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class LocationsDAO {
	private SqlSession sqlSession;
	public LocationsDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<LocationsDTO> getAllLocations(){
		return sqlSession.selectList("");
	}
}
