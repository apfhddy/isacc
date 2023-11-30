package a.firstController;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import a.controllerPath.AllPath;
import item_kinds.Item_KindsDTO;
import item_kinds.Item_KindsService;
import items.ItemsService;
import locations.LocationsDTO;
import locations.LocationsService;


@Controller
public class FirstController implements AllPath{
	private ItemsService itemsService;
	private Item_KindsService item_KindsService;
	private LocationsService locationService;
	
	public FirstController(ItemsService itemsService,Item_KindsService item_KindsService,LocationsService locationService) {
		this.itemsService = itemsService; 
		this.item_KindsService = item_KindsService;
		this.locationService = locationService;
	}
	

	@RequestMapping("/")
	public String home(HttpServletRequest req) {
		String key = req.getParameter("key");
		boolean hiddenPath = key != null && key.equals("admin");
		if(hiddenPath) {
			List<Item_KindsDTO> kindList = item_KindsService.getAllKind();
			List<LocationsDTO> locationsList = locationService.getAllLocations(); 
			req.setAttribute("kindList", kindList);
			req.setAttribute("locationsList", locationsList);
			return hidden;
		}
		else {
			List<Map<String,Object>> itemList = itemsService.getAllItems();
			String json = JSONArray.toJSONString(itemList);
			req.setAttribute("itemList", json);
			return home; 
		}
	}
	
}
