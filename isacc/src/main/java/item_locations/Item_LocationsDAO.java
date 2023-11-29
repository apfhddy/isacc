package item_locations;

import org.apache.ibatis.session.SqlSession;

public class Item_LocationsDAO {
	private SqlSession sqlSession;
	
	public Item_LocationsDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insertItem_Locations(Item_LocationsDTO dto) {
		return sqlSession.insert("",dto);
	}
}
