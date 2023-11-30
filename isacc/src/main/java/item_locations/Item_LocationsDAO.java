package item_locations;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Item_LocationsDAO {
	private SqlSession sqlSession;
	
	public Item_LocationsDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public  int insertItem_Locations(Item_LocationsDTO dto) {
		return sqlSession.insert("item_locations.insertItem_Locations",dto);
	}
	
	public	List<Map<String,Object>> getOneLocations(int item_no){
		return sqlSession.selectList("item_locations.getOneLocations", item_no);
	}
}
