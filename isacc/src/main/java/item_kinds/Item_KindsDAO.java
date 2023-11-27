package item_kinds;

import org.apache.ibatis.session.SqlSession;

public class Item_KindsDAO {
	private SqlSession sqlSession;
	public Item_KindsDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
