package com.jupiter.mumscrum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jupiter.mumscrum.bean.ProductBean;
import com.jupiter.mumscrum.service.ProductService;

@Controller
public class ProductController {

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("productList", productService.listProduct());
		return "product";
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	//public String executeLogin(@ModelAttribute("productBean") ProductBean productBean) {
	public String executeLogin(@ModelAttribute("productBean") ProductBean productBean) {
			
		System.out.println("You are here");
		System.out.println(productBean.getId());
		System.out.println(productBean.getName());
		System.out.println(productBean.getDescription());
		System.out.println(productBean.getEmployeeId());
		System.out.println(productBean.getStatus());
		System.out.println(productBean.getDueDate());
		System.out.println(productBean.getStartDate());
		return "product";
	}

}
