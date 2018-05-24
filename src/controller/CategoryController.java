package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.Category;
import service.CategoryService;
import util.Page;


@Controller
@RequestMapping("")
public class CategoryController {
	
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("listCategory")
	public ModelAndView listCategory(Page page) {
		if(page.getStart()<=0) {
			page.setStart(0);
		}
		ModelAndView mav = new ModelAndView();
		List<Category> cs = categoryService.list(page);
		int total = categoryService.total();
		
		page.caculateLast(total);
		//cs��Ҫ������ͼ�Ĳ�������cs����Ӧjspҳ����Ҫ�õ�EL���ʽcs
		mav.addObject("cs", cs);
		//����Ҫ��Ⱦ��jsp
		mav.setViewName("listCategory");
		return mav;		
	}
	
	@RequestMapping("addCategory")
	public ModelAndView addCategory(Category category) {
		categoryService.add(category);
		ModelAndView mav = new ModelAndView("redirect:/listCategory");
		return mav;
		
	}
	
	@RequestMapping("deleteCategory")
	public ModelAndView deleteCategory(Category category) {
		categoryService.delete(category);
		ModelAndView mav = new ModelAndView("redirect:/listCategory");
		return mav;
	}
		
	@RequestMapping("updateCategory")
	public ModelAndView updateCategory(Category category) {
		categoryService.update(category);
		ModelAndView mav = new ModelAndView("redirect:/listCategory");
		return mav;
	}
	
	@RequestMapping("editCategory")
	public ModelAndView editCategory(Category category) {
		Category c = categoryService.get(category.getId());
		ModelAndView mav = new ModelAndView("editCategory");
		mav.addObject("c", c);
		return mav;
		
	}

}
