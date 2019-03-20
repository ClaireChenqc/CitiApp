package com.citi.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citi.entity.Item;
import com.citi.repository.CatalogRepository;

@Component
public class CatalogServiceImpl implements CatalogService {
	@Autowired
	private CatalogRepository repository;
	

	/* (non-Javadoc)
	 * @see demo.webmvcjsp.CatelogService#getAllItems()
	 */
	@Override
	public Map getCatalogItems() {
		// TODO Auto-generated method stub
		Map<Integer, Item> map = new HashMap<>();
		repository.findAll().forEach(i -> {map.put( (int)i.getId(), i);} );
		return  map;
	}


	@Override
	public Item getItem(long id) {
		// TODO Auto-generated method stub
		return (Item) repository.findItemById(id);
		//return (Item) repository.getCatalogItems().get(id);
	}


	@Override
	public void insertItem(String desc, double price) {
		// TODO Auto-generated method stub
		repository.save(new Item(desc, price));
	}


	@Override
	public void updateItem(int id, String desc, double price) {
		// TODO Auto-generated method stub
		
	}
	
	/*@Override
	public Collection<Item> getItems() {
		return repository.getItems().values();
	}
	
	@Override
	public Item getItem(int id) {
		System.out.println((Item) repository.getItems().get(id));
		return (Item) repository.getItems().get(id);
	}*/
}
