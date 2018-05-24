package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import mapper.CategoryMapper;
import pojo.Category;
import service.CategoryService;
import util.Page;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryMapper categoryMapper;
	 public List<Category> list(){
		 return categoryMapper.list();
	 }
	 
	 public void add(Category category) {
		 categoryMapper.add(category);
	 }
	 @Override
	 public int total() {
		 return categoryMapper.total();
	 }
	 @Override
	 public List<Category> list(Page page) {
		 return categoryMapper.list(page);
	 }
	 
	 @Override
	 public void delete(Category category) {
		 categoryMapper.delete(category);
	 }
	 
	 @Override
	 public void update(Category category) {
		 categoryMapper.update(category);
	 }
	 
	 @Override
	 public Category get(int id) {
		 return categoryMapper.get(id);
	 }
	 

	 
}
