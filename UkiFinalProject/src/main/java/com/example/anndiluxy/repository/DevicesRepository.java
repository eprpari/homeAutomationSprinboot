package com.example.anndiluxy.repository;


import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.anndiluxy.model.Devices;

@Repository
public interface DevicesRepository extends MongoRepository<Devices ,String> {
	Optional<Devices> findByTitle(String title);

	@Query("{'$or':[ {'title': {$regex : ?0, $options: 'i'}}, {'price': {$regex : ?0, $options: 'i'}}, "
			+ "{'description': {$regex : ?0, $options: 'i'}},{'avatarUrl': {$regex : ?0, $options: 'i'}}, {'imageUrl': {$regex : ?0, $options: 'i'}}]}")
	Page<Devices> searchDevices(Pageable pageable, String searchText);

}
