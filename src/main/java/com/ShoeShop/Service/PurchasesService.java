package com.ShoeShop.Service;

import java.util.Date;
import java.util.List;

import com.ShoeShop.Model.Purchases;

public interface PurchasesService {

	public List<Purchases> getAll();
	public List<Purchases> getPurchasesByDate(String date);
	public List<Purchases> getPurchasesByCategory(int category_id);
}
