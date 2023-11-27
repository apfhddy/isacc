package a.firstController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import a.controllerPath.AllPath;
import items.ItemsService;


@Controller
public class FirstController implements AllPath{
	private ItemsService itemsService;
	
	public FirstController(ItemsService itemsService) {
		this.itemsService = itemsService; 
	}
	

	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		String key = request.getParameter("key");
		boolean hiddenPath = key != null && key.equals("admin");
		if(hiddenPath) return hidden;
		else return home; 
	}
	
}
