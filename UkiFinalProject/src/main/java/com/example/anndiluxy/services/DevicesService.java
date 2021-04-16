package com.example.anndiluxy.services;
import org.springframework.stereotype.Service;


import com.example.anndiluxy.model.Devices;
import com.example.anndiluxy.repository.DevicesRepository;
//import com.example.anndiluxy.repository.DevicesRepositoryCustom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
//import java.util.Optinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


@Service
public class DevicesService {
	
	@Autowired
	DevicesRepository devicesRepository;
	
//	@Autowired
//	private DevicesRepositoryCustom devicesRepositoryCustom;
//	
	
	public ResponseEntity<Devices> createDevices (Devices devices) {
		try {
			Devices dd =devicesRepository.save(devices);
		return new ResponseEntity<>((dd), HttpStatus.CREATED);
	}catch(Exception e) {
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
}

	
	public ResponseEntity<List<Devices>> getAllDevices() {
		try {
		    List<Devices> devices = new ArrayList<Devices>();
		    devicesRepository.findAll().forEach(devices::add);
		    if (devices.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		    return new ResponseEntity<>(devices, HttpStatus.OK);
		} catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	public ResponseEntity<Devices> getDevicesById(String id) {
		Optional<Devices> dd = devicesRepository.findById(id);
		if (dd.isPresent()) {
			return new ResponseEntity<>(dd.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	public ResponseEntity<Devices> getDevicesByTitle(String title) {
		Optional<Devices> user = devicesRepository.findByTitle(title);
		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

//	public ResponseEntity<Devices> getDevicesById(String id, Devices devices) {
//		Optional<Devices> devicesData =devicesRepository.findById(id);
//
//		if (devicesData.isPresent()) {
//			return new ResponseEntity<>(devicesData.get(), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
	

	
	public ResponseEntity<Devices> updateDevices(String id, Devices devices) {
	Optional<Devices> dd = devicesRepository.findById(id);

	if (dd.isPresent()) {
		Devices _devices = dd.get();
	    _devices.setTitle(devices.getTitle());
	    _devices.setDescription(devices.getDescription());
	    _devices.setPrice(devices.getPrice());
	    _devices.setAvatarUrl(devices.getAvatarUrl());
	    _devices.setImageUrl(devices.getImageUrl());
	    
	    
	    return new ResponseEntity<>(devicesRepository.save(_devices), HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
	
	public ResponseEntity<HttpStatus> deleteDevices(String id) {
	try {
		devicesRepository.deleteById(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
	public ResponseEntity<Map<String, Object>> getAllDevicesInPage(int pageNo, int pageSize, String sortBy) {
		try {
			Map<String, Object> response = new HashMap<>();
		    Sort sort = Sort.by(sortBy);
			Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		    Page<Devices> page = devicesRepository.findAll(pageable);
		    response.put("data", page.getContent());
		    response.put("Total no of pages", page.getTotalPages());
		    response.put("Total no of elements", page.getTotalElements());
		    response.put("Current page no", page.getNumber());

		    return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
}

    
	public ResponseEntity<HttpStatus> deleteAllDevices() {
	try {
		devicesRepository.deleteAll();
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
   
	
	
	public ResponseEntity<Page<Devices>> getDevicesBySearch(String searchText, int pageNo, int pageSize, String sortBy) {
    try {
     

    	Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
    	Page<Devices> devicesPages = devicesRepository.searchDevices(pageable, ".*" + searchText + ".*");
    if (devicesPages.isEmpty()) {
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
        return new ResponseEntity<>(devicesPages, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

}
//String id = devicesRepositoryCustom.getMaxBookId() + 1;
//Devices dd = devices.save(new Devices(id, devices.getTitle(), devices.getPrice(), 
//		devices.getDescription(), devices.getAvatarUrl(), devices.getImageUrl(), devices.getImages()));
//

