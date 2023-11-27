package location;

import org.apache.ibatis.session.SqlSession;

public class LocationDAO {
	private SqlSession sqlSession;
	public LocationDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
