package items;

import org.apache.ibatis.session.SqlSession;

public class ItemsDAO {
	private SqlSession sqlSession;
	
	public ItemsDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insertItems(ItemsDTO dto) {
		return sqlSession.insert("items.insertItems",dto);
	}
}
