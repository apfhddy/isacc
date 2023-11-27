package item_kinds;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class Item_KindsDAO {
	private SqlSession sqlSession;
	public Item_KindsDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Item_KindsDTO> getAllKind() {
		return sqlSession.selectList("item_kinds.getAllKind");
	}
}
