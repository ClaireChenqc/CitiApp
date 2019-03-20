package com.citi.controller;

import java.sql.Array;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.citi.entity.Item;
import com.citi.service.CartService;
import com.citi.service.CatalogService;

@Controller
public class CatalogController {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	CatalogService catalogService;
	
    @RequestMapping("/")
    public String handler1(Model model) {
    	/*Map catalog = catalogService.getCatalogItems();
    	model.addAttribute("catalogItems", catalog);*/
    	showPage(model);
    	
        return "catalog"; 
    }
    
    @RequestMapping("/addItemToCart")
    public String handler2(Model model, @RequestParam("id") Integer id, @RequestParam("quantity") Integer quantity) {
    	cartService.addItemToCart(id, quantity);
    	showPage(model);

        return "catalog";
    }
    
    @RequestMapping("/deleteItemToCart")
    public String handler3(Model model, @RequestParam("id") Integer id) {
    	cartService.removeItemFromCart(id);
    	showPage(model);
    	
    	return "catalog";
    }
    
    @RequestMapping("/addItemToCatalog")
    public String handler4(Model model, @RequestParam("description") String description, @RequestParam("price") double price) {
    	catalogService.insertItem(description, price);
    	showPage(model);
    	
    	return "catalog";
    }
    
    public void showPage(Model model) {
    	Map catalog = catalogService.getCatalogItems();
    	model.addAttribute("catalogItems", catalog);
    	
    	Map<Integer, Integer> cart = cartService.getAllItemsInCart();
    	Map<Integer, ArrayList> shoppingCart = getShoppingCart(cart, catalog);
    	double calculateCartNetCost = cartService.calculateCartNetCost();
    	double calculateCartTotalCost = cartService.calculateCartTotalCost();
    	model.addAttribute("cart", cart);
    	model.addAttribute("cartDetails", shoppingCart);
    	model.addAttribute("netCost", calculateCartNetCost);
    	model.addAttribute("totalCost", calculateCartTotalCost);
    }
    
    public Map<Integer, ArrayList> getShoppingCart(Map<Integer, Integer> cart, Map<Integer, Item> catalog) {
    	Map<Integer, ArrayList> shoppingCart = new HashMap<>();
    	cart.keySet().stream().forEach(m -> {
    		Item item = (Item) catalog.get(m);
    		System.out.println("ASDASDAS " +  catalog.keySet());
    		
    		ArrayList<String> values = new ArrayList<>();
    		values.add(item.getDescription());
    		values.add(""+item.getPrice());
    		values.add(""+cart.get(m));
    		values.add(""+  (double) Math.round( item.getPrice() * cart.get(m) * 100) / 100 );
    		shoppingCart.put((int)m, values);
    	});
    	return shoppingCart;
    }

}