package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Menu {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ItemName;
	private String description;
	private String url;
	private String category;
	private String type;
	private Double price;
	private String AvailabilityTime;
	private String TasteInfo;
	private String NutritionalInfo;
	private boolean available = true;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAvailabilityTime() {
		return AvailabilityTime;
	}
	public void setAvailabilityTime(String availabilityTime) {
		AvailabilityTime = availabilityTime;
	}
	public String getTasteInfo() {
		return TasteInfo;
	}
	public void setTasteInfo(String tasteInfo) {
		TasteInfo = tasteInfo;
	}
	public String getNutritionalInfo() {
		return NutritionalInfo;
	}
	public void setNutritionalInfo(String nutritionalInfo) {
		NutritionalInfo = nutritionalInfo;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	@ManyToOne
	private Restaurant restaurant;
	

}
