package com.ShoeShop.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShoeShop.Model.Purchases;

@Repository
public interface PurchasesRepository extends JpaRepository<Purchases,Integer> {
	public List<Purchases> findByDate(String date);
	public List<Purchases> findByItem_Category_Id(int category_id);

}
