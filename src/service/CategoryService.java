package service;

import java.util.List;



import pojo.Category;
import util.Page;


public interface CategoryService {
	
	List<Category> list();
	
	void add(Category category);
	
	void delete(Category category);
	
	void update(Category category);
	
	int total();
	
	Category get(int i);
	
	List<Category> list (Page page);
	

	

}
