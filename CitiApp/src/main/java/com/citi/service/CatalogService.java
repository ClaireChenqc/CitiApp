package com.citi.service;

import java.util.*;

import com.citi.entity.Item;

public interface CatalogService {

	Map getCatalogItems();
	Item getItem(long id);
	void insertItem(String desc, double price);
	void updateItem(int id, String desc, double price);
}