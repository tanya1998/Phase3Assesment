package com.ShoeShop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoeShop.Model.Item;
import com.ShoeShop.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository repository;
	@Override
	public Item getItemById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Item> getItemByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public List<Item> getItemByCategory(int category_id) {
		return repository.findByCategory_Id(category_id);
	}

	@Override
	public List<Item> getAll() {
		
		return repository.findAll();
	}

	@Override
	public void CreateItem(Item item) {
		
		repository.save(item);
		
	}


}
