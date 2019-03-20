package com.citi.repository;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public interface CartRepository {

	void add(int itemId, int quantity);

	void remove(int itemId);

	Map<Integer, Integer> getAll();

}