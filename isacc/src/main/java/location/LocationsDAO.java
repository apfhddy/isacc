package location;

import org.apache.ibatis.session.SqlSession;

public class LocationsDAO {
	private SqlSession sqlSession;
	public LocationsDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
