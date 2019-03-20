package com.citi.repository;

import java.util.List;
import java.util.Map;
import org.springframework.data.repository.CrudRepository;
import com.citi.entity.Item;

public interface CatalogRepository extends CrudRepository<Item,Long> {
	
	Item findItemById(long id);
	//Map getCatalogItems();
	
}