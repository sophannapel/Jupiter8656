package com.jupiter.mumscrum.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jupiter.mumscrum.bean.ProductBean;
import com.jupiter.mumscrum.entity.Product;
import com.jupiter.mumscrum.service.ProductService;

@Controller
@RequestMapping(value="product")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	
	@RequestMapping(value="/productForm", method = RequestMethod.GET)
	public String productPage(Model model) {
		LOGGER.info("Product/productForm - Method = GET");
		return "product/productForm";
	}
	
	
	@RequestMapping(value="/productList", method = RequestMethod.GET)
	//@RequestMapping(value="/productList")
	public String listProducts(Model model) {
		model.addAttribute("productList", productService.listProduct());
		LOGGER.info("Product/productList - Method = GET");
		return "product/productList";
	}

	
	
	
	
	
	
	
	
	@RequestMapping(value="/productForm", method = RequestMethod.POST)
	public String createProduct(@ModelAttribute("productBean") ProductBean productBean, 
			HttpServletRequest request) {
		LOGGER.info("Product/productForm - Method = POST");
		Product product = new Product();
		product.setName(productBean.getName());
		product.setDescription(productBean.getDescription());
		product.setStartDate(productBean.getStartDate());
		product.setDueDate(productBean.getDueDate());
		product.setEmployeeId(productBean.getEmployeeId());
		product.setStatusId(productBean.getStatusId());
		productService.createProduct(product);
		//return "redirect:product/productList";
		return "product/productList";
		
	}

}
