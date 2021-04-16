//package com.example.anndiluxy.repository;
//
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.stereotype.Repository;
//import com.example.anndiluxy.model.Devices;
//@Repository
//public class DevicesRepositoryCustom {
//	@Autowired
//    MongoTemplate mongoTemplate;
//
//    public String getMaxBookId() {
//		Query query = new Query();
//		query.with(Sort.by(Sort.Direction.DESC, "id"));
//		query.limit(1);
//		Devices maxObject = mongoTemplate.findOne(query, Devices.class);
//		if (maxObject == null) {
//		    return "";
//		}
//		return maxObject.getId();
//    }
//
//}
//
//
