package com.ShoeShop.Service;

import java.util.List;

import com.ShoeShop.Model.Item;

public interface ItemService {
	
	public List<Item> getAll();
	public void CreateItem(Item item);
	public Item getItemById(int id);
	public List<Item> getItemByName(String name);
	public List<Item> getItemByCategory(int category_id);
}
