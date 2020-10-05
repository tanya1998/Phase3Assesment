package com.ShoeShop.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoeShop.Model.Purchases;
import com.ShoeShop.repository.PurchasesRepository;

@Service
public class PurchasesServiceImpl implements PurchasesService {

	@Autowired
	private PurchasesRepository repository;
	@Override
	public List<Purchases> getPurchasesByDate(String date) {
		
		return repository.findByDate(date);
	}

	@Override
	public List<Purchases> getPurchasesByCategory(int category_id) {
		
		return repository.findByItem_Category_Id(category_id);
	}

	@Override
	public List<Purchases> getAll() {
		return repository.findAll();
	}

}
