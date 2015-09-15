package com.jupiter.mumscrum.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jupiter.mumscrum.bean.ProductBean;
import com.jupiter.mumscrum.entity.Product;
import com.jupiter.mumscrum.service.ProductService;

@Controller
public class ProductController {

	//private static final Logger LOGGER =
	// LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/product", method = RequestMethod.GET)
	public String productPage(Model model) {
		model.addAttribute("productList", productService.listProduct());
		return "product";
	}
	
	@RequestMapping(value="/viewProduct")
	public String listProducts(Model model) {
		model.addAttribute("productList", productService.listProduct());
		return "viewProduct";
	}

	@RequestMapping(value="/product", method = RequestMethod.POST)
	public String createProduct(@ModelAttribute("productBean") ProductBean productBean, 
			HttpServletRequest request) {
		
		Product product = new Product();
		product.setName(productBean.getName());
		product.setDescription(productBean.getDescription());
		product.setStartDate(productBean.getStartDate());
		product.setDueDate(productBean.getDueDate());
		product.setEmployeeId(productBean.getEmployeeId());
		product.setStatusId(productBean.getStatusId());
		productService.createProduct(product);
		return "redirect:viewProduct";
	}

}
