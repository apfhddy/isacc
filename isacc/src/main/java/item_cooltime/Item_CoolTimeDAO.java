package item_cooltime;

import org.apache.ibatis.session.SqlSession;

public class Item_CoolTimeDAO {
	private SqlSession sqlSession;
	
	public Item_CoolTimeDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int getItem_CoolTime_NO(Item_CoolTimeDTO dto) {
		Integer no = sqlSession.selectOne("item_cooltime.getItem_CoolTime_NO",dto);
		return no == null ? 0 : no;
	}
	
	public int getNextNo() {
		return sqlSession.selectOne("item_cooltime.getNextNo");
	}
	public int insertCoolTime(Item_CoolTimeDTO dto) {
		return sqlSession.insert("item_cooltime.insertCoolTime",dto);
	}
}
