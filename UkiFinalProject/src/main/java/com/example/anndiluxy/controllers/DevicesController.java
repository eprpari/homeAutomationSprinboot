package com.example.anndiluxy.controllers;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.anndiluxy.model.Devices;
import com.example.anndiluxy.services.DevicesService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/device")

public class DevicesController {
	 @Autowired
	  DevicesService devicesService;
	
	@PostMapping
	  public ResponseEntity<Devices> createDevices(@RequestBody Devices devices) {
		return devicesService.createDevices(devices);
}
	
	@GetMapping
	  public ResponseEntity<List<Devices>> getAllDevices() {
		  return devicesService.getAllDevices();
	  }

//	@GetMapping("/{id}")
//	public ResponseEntity<Devices> getDevicesById(@PathVariable("id")String id ,@RequestBody Devices devices){
//		return devicesService.getDevicesById(id );
//	}
	
	 @GetMapping("/page")
	    public ResponseEntity<Map<String, Object>> getAllBooksInPage(
	    		@RequestParam(name = "pageNo", defaultValue = "0") int pageNo, 
	    		@RequestParam(name = "pageSize", defaultValue = "2") int pageSize, 
	    		@RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
			return devicesService.getAllDevicesInPage(pageNo, pageSize, sortBy);
	 }
	 
	
	
	 @GetMapping(params="id")
	  public ResponseEntity<Devices> getDevicesById(@RequestParam String id) {
		  return devicesService.getDevicesById(id);
	  }
	 @GetMapping(params="title")
	  public ResponseEntity<Devices> getDevicesByTitle(@RequestParam String title) {
		  return devicesService.getDevicesByTitle(title);
	  }
	 
	 
	@PutMapping("/{id}")
	  public ResponseEntity<Devices> updateDevices(@PathVariable("id") String id, @RequestBody Devices devices) {
		return devicesService.updateDevices(id, devices);
	  }	 
	
	 
	 @DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deleteDevices(@PathVariable("id") String id) {
		  return devicesService.deleteDevices(id);
	  }
	 
	 @DeleteMapping
	  public ResponseEntity<HttpStatus> deleteAllDevices() {
		  return devicesService.deleteAllDevices();
	  }
	 @GetMapping("/search/{search}")
		public ResponseEntity<?> getDevices(@PathVariable String search, @RequestParam(value="pageNo",defaultValue="0") int pageNo,
				@RequestParam(value="pageSize",defaultValue="0") int pageSize,@RequestParam(name = "sortBy", defaultValue = "id") String sortBy){
			return devicesService.getDevicesBySearch(search,pageNo,pageSize,sortBy);
		}
}