package a.firstController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.controllerPath.AllPath;
import items.ItemsService;


@Controller
public class FirstController implements AllPath{
	private ItemsService itemsService;
	
	public FirstController(ItemsService itemsService) {
		this.itemsService = itemsService;
	}
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return home; 
	}
	
}
