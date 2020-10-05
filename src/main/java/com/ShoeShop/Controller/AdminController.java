package com.ShoeShop.Controller;


import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ShoeShop.Model.Item;
import com.ShoeShop.Model.Purchases;
import com.ShoeShop.Model.User;
import com.ShoeShop.Service.AdminService;
import com.ShoeShop.Service.ItemService;
import com.ShoeShop.Service.PurchasesService;
import com.ShoeShop.Service.UserService;
import com.ShoeShop.utils.WebUtils;

@RestController
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
    private AdminService adminService; 
	@Autowired
	private ItemService itemService;
	@Autowired
	private PurchasesService purchasesService;
	 @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	    public void home(ModelMap map,  javax.servlet.http.HttpServletRequest request) 
	    {
		 	map.addAttribute("pageTitle", "SPORTY SHOES - HOMEPAGE"); 
	    }
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String loginPage(Model model) {
	 
	        return "login";
	    } 
	 @RequestMapping(value = "/admin", method = RequestMethod.GET)
	    public String adminPage(Model model, Principal principal) {
	         
		 return "This is Admin Page ";
	         
	    }
	 
	 @PostMapping(value = "/admin/changepwd")
	 public void changePassword(@RequestBody String pwd)
	 {
		 adminService.changepwd(pwd);
	 }
	 @GetMapping(value = "/admin/user")
	    public List<User> getAllUser() 
	    {
		 	return userService.getAll();
	    }
	 
	 @GetMapping(value = "/admin/user/{id}")
	    public User getUserById(@PathVariable int id) 
	    {
		 	return userService.getUserById(id);
	    }
	 @GetMapping(value = "/admin/user/age/{age}")
	    public List<User> getUserByAge(@PathVariable int age) 
	    {
		 	return userService.getUserByAge(age);
	    }
	 @GetMapping(value = "/admin/user/email/{email}")
	    public List<User> getUserByEmail(@PathVariable String email) 
	    {
		 	return userService.getUserByEmail(email);
	    }
	 @GetMapping(value = "/admin/user/name/{name}")
	    public List<User> getUserByName(@PathVariable String name) 
	    {
		 	return userService.getUserByName(name);
	    }
	 @GetMapping(value = "/admin/item/name/{name}")
	    public List<Item> getItemByName(@PathVariable String name) 
	    {
		 	return itemService.getItemByName(name);
	    }
	 @GetMapping(value = "/admin/item/category/{category}")
	    public List<Item> getItemByName(@PathVariable int category) 
	    {
		 	return itemService.getItemByCategory(category);
	    }
	 @GetMapping(value = "/admin/item/{id}")
	    public Item getItemById(@PathVariable int id) 
	    {
		 	return itemService.getItemById(id);
	    }
	 @GetMapping(value = "/admin/item")
	    public List<Item> getAllItem() 
	    {
		 	return itemService.getAll();
	    }
	 @PostMapping(value="/admin/item")
		 public void createItem(@RequestBody Item item)
		 {
			 itemService.CreateItem(item);
		 }
	 @PutMapping(value = "/admin/item/")
		 public void updateItemCategory(@RequestBody Item item)
		 {
			 itemService.CreateItem(item);;
		 }
	  @GetMapping(value = "/admin/purchases")
	    public List<Purchases> getAllPurchases() 
	    {
		   return purchasesService.getAll();
	    }
	  @GetMapping(value = "/admin/purchases/date/{date}")
	  public List<Purchases> getPurchasesByDate(@PathVariable String date)
	  {
		  DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD"); 
		  Date date_1 = null;
		try {
			date_1 = (Date)formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		  return purchasesService.getPurchasesByDate(date);
		  
	  }
	  @GetMapping(value = "/admin/purchases/category/{category_id}")
	  public List<Purchases> getPurchasesByCategory(@PathVariable int category_id)
	  {
		  return purchasesService.getPurchasesByCategory(category_id);
	  }
	  
	

}
