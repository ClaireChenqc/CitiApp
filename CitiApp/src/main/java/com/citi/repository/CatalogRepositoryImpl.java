package com.citi.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.citi.entity.Item;


public class CatalogRepositoryImpl {
	private Map<Integer, Integer> cart = new HashMap<>();
	
	/* (non-Javadoc)
	 * @see demo.webmvcjsp.CatalogRepository#getItems()
	 */
	
	public Map getCatalogItems() {
		// TODO Auto-generated method stub
		/*Map<Integer, Item> items = new HashMap<>();
		items.put(0, new Item(0, "Apple Mac Book Pro", 2499.99));
		items.put(1, new Item(1, "32GB San Disk", 15.99));
		items.put(2, new Item(2, "OLED 64in TV", 1800.99));
		items.put(3, new Item(3, "Wireless Mouse", 10.59));
		items.put(4, new Item(4, "Virtual Reality HeadSet", 200.59));
		items.put(5, new Item(5, "Sat Nav", 159.99));
		return items;*/
		return null;
	}
}
