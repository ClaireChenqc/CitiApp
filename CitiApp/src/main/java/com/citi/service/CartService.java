package com.citi.service;

import java.util.Map;

public interface CartService {

	/* (non-Javadoc)
	 * @see solution.onlineretailer.CartService#addItemToCart(int, int)
	 */
	void addItemToCart(int id, int quantity);

	/* (non-Javadoc)
	 * @see solution.onlineretailer.CartService#removeItemFromCart(int)
	 */
	void removeItemFromCart(int id);

	/* (non-Javadoc)
	 * @see solution.onlineretailer.CartService#getAllItemsInCart()
	 */
	Map<Integer, Integer> getAllItemsInCart();

	/* (non-Javadoc)
	 * @see solution.onlineretailer.CartService#calculateCartCost()
	 */
	double calculateCartNetCost();

	double calculateCartTotalCost();

}