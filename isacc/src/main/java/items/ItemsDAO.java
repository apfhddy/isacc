package items;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class ItemsDAO {
	private SqlSession sqlSession;
	
	public ItemsDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insertItems(ItemsDTO dto) {
		return sqlSession.insert("items.insertItems",dto);
	}
	
	public int getNextNo() {
		return sqlSession.selectOne("items.getNextNo");
	}
	
	public List<ItemsDTO> getAllItems(){
		return sqlSession.selectList("items.getAllItems");
	}
}
