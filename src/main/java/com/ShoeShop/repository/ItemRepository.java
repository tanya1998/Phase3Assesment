package com.ShoeShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ShoeShop.Model.Item;

public interface ItemRepository extends JpaRepository<Item,Integer> {
	
	public List<Item> findByName(String name);
	public List<Item> findByCategory_Id(int category_id);
	@Modifying
	@Query(value = "INSERT INTO ITEM_CATEGORY (ITEM_ID,CATEGORY_ID) VALUES(:item_id, :category_id)",nativeQuery = true)
	public void addCategory(@Param("category_id")Integer category_id, @Param("item_id")Integer item_id);
	

	
}
