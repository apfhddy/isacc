package items;

import javax.servlet.http.HttpServletRequest;

import a.controllerPath.StaticMethod;
import item_cooltime.Item_CoolTimeDAO;
import item_cooltime.Item_CoolTimeDTO;
import item_locations.Item_LocationsDAO;

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
		String unlock = req.getParameter("unlock");
		String effect = req.getParameter("effect");
		int quality = Integer.parseInt(req.getParameter("quality"));
		int i_c_no = 0;
		String goldaccessories = req.getParameter("goldaccessories");
		
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
				for(String locatoin : locations) {
					Item_LocationsDAO.insertItem_Locations(new );
				}
			}
		}
		
		return answer;
	}
}
