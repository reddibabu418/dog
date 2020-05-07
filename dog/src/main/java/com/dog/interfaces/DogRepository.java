package com.dog.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dog.model.Dog;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long>{
	
	//List<Dog> findByName(String name);
	Dog findById(long id);

}
