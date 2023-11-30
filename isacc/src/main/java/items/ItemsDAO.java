package items;

import java.util.List;
import java.util.Map;

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
	
	public List<Map<String,Object>> getAllItems(){
		return sqlSession.selectList("items.getAllItems");
	}
	
	public Map<String,Object> getOneItem(int no){
		return sqlSession.selectOne("items.getOneItem",no);
	}
	
	public int updateData(ItemsDTO dto) {
		return sqlSession.update("items.updateData",dto);
	}
}
