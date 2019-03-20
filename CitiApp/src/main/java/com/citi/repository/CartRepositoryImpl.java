package com.citi.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CartRepositoryImpl implements CartRepository {

	// Map of item IDs and quantities.
	private Map<Integer, Integer> cart = new HashMap<>();
	
	/* (non-Javadoc)
	 * @see com.citi.repository.CartRepository#add(int, int)
	 */
	@Override
	public void add(int itemId, int quantity) {
		Integer existingQuantity = cart.get(itemId);
		if (existingQuantity != null) {
			quantity += existingQuantity;			
		}
		cart.put(itemId,  quantity);
	}
	
	/* (non-Javadoc)
	 * @see com.citi.repository.CartRepository#remove(int)
	 */
	@Override
	public void remove(int itemId) {
		cart.remove(itemId);
	}
	
	/* (non-Javadoc)
	 * @see com.citi.repository.CartRepository#getAll()
	 */
	@Override
	public Map<Integer, Integer> getAll() {
		return cart;
	}
}
