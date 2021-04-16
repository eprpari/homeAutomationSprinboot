package com.example.anndiluxy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "devices")
public class Devices {
@Id
	private String id;
private String title;
private String price;
private String description;
private String avatarUrl;
private String imageUrl;
public Devices(String id, String title, String price, String description, String avatarUrl, String imageUrl) {
	super();
	this.id = id;
	this.title = title;
	this.price = price;
	this.description = description;
	this.avatarUrl = avatarUrl;
	this.imageUrl = imageUrl;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getAvatarUrl() {
	return avatarUrl;
}
public void setAvatarUrl(String avatarUrl) {
	this.avatarUrl = avatarUrl;
}
public String getImageUrl() {
	return imageUrl;
}
public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}


	
	
		
	
	}
