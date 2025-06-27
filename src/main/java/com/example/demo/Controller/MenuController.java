package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Menu;
import com.example.demo.Repo.MenuRepo;
import com.example.demo.Ser.MenuServiceUser;
@RequestMapping("/restaurant1")
@RestController
public class MenuController {
	@Autowired
	private MenuServiceUser service;
	
	@GetMapping("/getallmenu")
	public List<Menu> getallmenu(){
		return service.getallmenu();
	}
	
	@GetMapping("/getbycategoryandtype/{category}/{type}")
	public List<Menu> findbycategory(@PathVariable String category,@PathVariable String type ) {
		return service.getbyCategoryAndType(category, type);
	}
	
	@GetMapping("/getbyprice/{min}/{max}")
	public List<Menu> findbyprice(@PathVariable Double min,@PathVariable Double max){
		return service.getbyPricesRange(min, max);
	}
	
	@GetMapping("/getbytype/{type}")
	public List<Menu> findbytype(@PathVariable String type){
		return service.getbyType(type);
	}
	


	
	

}
