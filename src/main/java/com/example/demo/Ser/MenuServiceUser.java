package com.example.demo.Ser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Menu;
import com.example.demo.Repo.MenuRepo;

@Service
public class MenuServiceUser {
	@Autowired
	private MenuRepo repo;
	
	
	public List<Menu> getallmenu() {
		return  repo.findAll();	}
	
	public List<Menu> getbyCategoryAndType(String category,String type) {
		return  repo.findByCategoryAndType(category, type);
			}
	public List<Menu> getbyPricesRange(Double first,Double Last){
		return repo.findByPriceBetween(first,Last);
	}
	
	public List<Menu> getbyType(String type){
		return repo.findByType(type);
	}
	
	
}
