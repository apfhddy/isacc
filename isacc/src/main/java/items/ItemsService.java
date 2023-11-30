package items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import a.controllerPath.StaticMethod;
import item_cooltime.Item_CoolTimeDAO;
import item_cooltime.Item_CoolTimeDTO;
import item_locations.Item_LocationsDAO;
import item_locations.Item_LocationsDTO;
import locations.LocationsDTO;

public class ItemsService {
	private ItemsDAO itemsDAO;
	private Item_CoolTimeDAO item_CoolTimeDAO;
	private Item_LocationsDAO item_LocationsDAO;
	
	public ItemsService(ItemsDAO itemsDAO, Item_CoolTimeDAO item_CoolTimeDAO, Item_LocationsDAO item_LocationsDAO) {
		this.itemsDAO = itemsDAO;
		this.item_CoolTimeDAO = item_CoolTimeDAO;
		this.item_LocationsDAO = item_LocationsDAO;
	}
	
	public int insertItem(HttpServletRequest req,String fileName) {
		int item_no = itemsDAO.getNextNo();
		int kind_no = Integer.parseInt(req.getParameter("kind"));
		String image = fileName;
		int id = Integer.parseInt(req.getParameter("id"));
		String kr_name = req.getParameter("kr_name");
		String en_name = req.getParameter("en_name");
		String kr_line = req.getParameter("kr_line");
		String en_line = req.getParameter("en_line");
		String unlock = StaticMethod.textLineChange(req.getParameter("unlock"));
		String effect = StaticMethod.textLineChange(req.getParameter("effect"));
		int quality = Integer.parseInt(req.getParameter("quality"));
		int i_c_no = 0;
		String goldaccessories = StaticMethod.textLineChange(req.getParameter("goldaccessories"));
		
		//액티브 쿨타임 처리
		if(kind_no == 2) {
			int num = StaticMethod.parameterNullCheckToInt0(req.getParameter("num"));
			int secondOrspaces = StaticMethod.parameterNullCheckToInt0(req.getParameter("scdOspc"));
			int infinityOroneoff = StaticMethod.parameterNullCheckToInt0(req.getParameter("iftOoo"));
			if(num == 0) {
				secondOrspaces = 0;
			}
			Item_CoolTimeDTO item_CoolTimeDTO = new Item_CoolTimeDTO(num, secondOrspaces, infinityOroneoff);
			i_c_no = item_CoolTimeDAO.getItem_CoolTime_NO(item_CoolTimeDTO);
			
			if(i_c_no == 0) {
				i_c_no = item_CoolTimeDAO.getNextNo();
				item_CoolTimeDTO.setI_c_no(i_c_no);
				item_CoolTimeDAO.insertCoolTime(item_CoolTimeDTO);
			}
		}
		
		ItemsDTO item = new ItemsDTO(item_no,kind_no, image, id, kr_name, en_name, kr_line, en_line, unlock, effect, quality, i_c_no, goldaccessories);
		int answer = itemsDAO.insertItems(item);
		
		//패시브 액티브 등장장소 설정 처리
		if(kind_no != 3) {
			String[] locations = req.getParameterValues("locations");
			if(locations != null) {
				for(String location : locations) {
					item_LocationsDAO.insertItem_Locations(new Item_LocationsDTO(item_no, Integer.parseInt(location)));
				}
			}
		}
		return answer;
	}
	
	public List<Map<String,Object>> getAllItems(){
		List<ItemsDTO> list = itemsDAO.getAllItems();
		
		List<Map<String,Object>> returnMap = new ArrayList<Map<String,Object>>();
		for(ItemsDTO item : list) {
			Map<String,Object> sideMap = new HashMap<String, Object>();
			int kind = item.getKind_no();
			int item_no = item.getItem_no();
			sideMap.put("item_no", item_no);
			sideMap.put("kind_no", kind);
			sideMap.put("image", item.getImage());	
			sideMap.put("id", item.getId());
			sideMap.put("kr_name", item.getKr_name());
			sideMap.put("en_name", item.getEn_name());
			sideMap.put("kr_line", item.getKr_line());
			sideMap.put("en_line", item.getEn_line());
			sideMap.put("unlock", item.getUnlock());
			sideMap.put("effect", item.getEffect());
			sideMap.put("quality", item.getQuality());
			if(kind != 3) {//3이 아니라면 
				List<Map<String,Object>> locations = item_LocationsDAO.getOneLocations(item_no);
				sideMap.put("locations", locations);
			}
			if(kind == 2) {
				sideMap.put("i_c_no", item.getI_c_no());
			}
			if(kind == 3) {
				sideMap.put("goldaccessories", item.getGoldaccessories());
			}
			returnMap.add(sideMap);
		}
		
		
		
		
		return returnMap;
	}
	
	
}
