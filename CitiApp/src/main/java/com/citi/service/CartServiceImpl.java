package com.citi.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.citi.repository.CartRepository;

@Component
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository repository;

	/*@Value("#{catalog}")	
	private Map<Integer, Item> catalog;*/
	
	@Value("${saleTaxRate}")	
	private double saleTaxRate;
	
	@Autowired
	private CatalogService catalogService;
	
	/* (non-Javadoc)
	 * @see solution.onlineretailer.CartService#addItemToCart(int, int)
	 */
	/* (non-Javadoc)
	 * @see demo.webmvcjsp.CartService#addItemToCart(int, int)
	 */
	@Override
	public void addItemToCart(int id, int quantity) {
		if (catalogService.getItem(id) != null) {
			repository.add(id, quantity);
		}
	}
	
	/* (non-Javadoc)
	 * @see solution.onlineretailer.CartService#removeItemFromCart(int)
	 */
	/* (non-Javadoc)
	 * @see demo.webmvcjsp.CartService#removeItemFromCart(int)
	 */
	@Override
	public void removeItemFromCart(int id) {
		repository.remove(id);
	}
	
	/* (non-Javadoc)
	 * @see solution.onlineretailer.CartService#getAllItemsInCart()
	 */
	/* (non-Javadoc)
	 * @see demo.webmvcjsp.CartService#getAllItemsInCart()
	 */
	@Override
	public Map<Integer, Integer> getAllItemsInCart() {
		return repository.getAll();
	}
	
	/* (non-Javadoc)
	 * @see solution.onlineretailer.CartService#calculateCartCost()
	 */
	/* (non-Javadoc)
	 * @see demo.webmvcjsp.CartService#calculateCartNetCost()
	 */
	@Override
	public double calculateCartNetCost() {
		Map<Integer, Integer> items = repository.getAll();
		
		double nettCost = 0;
		for (Map.Entry<Integer, Integer> item: items.entrySet()) {
			int id = item.getKey();
			int quantity = item.getValue();
			double itemCost = catalogService.getItem(id).getPrice() * quantity;
			nettCost +=  Math.round(itemCost * 100) / 100;
		}
		return nettCost;
	}

	/* (non-Javadoc)
	 * @see demo.webmvcjsp.CartService#calculateCartTotalCost()
	 */
	@Override
	public double calculateCartTotalCost() {
		// TODO Auto-generated method stub
		return Math.round(calculateCartNetCost() * saleTaxRate  * 100) / 100;
	}


}
