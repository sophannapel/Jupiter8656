package com.jupiter.mumscrum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jupiter.mumscrum.bean.ProductBean;
import com.jupiter.mumscrum.entity.Employee;
import com.jupiter.mumscrum.entity.Product;
import com.jupiter.mumscrum.entity.Role;
import com.jupiter.mumscrum.entity.Status;
import com.jupiter.mumscrum.service.ProductService;

@Controller
@RequestMapping(value = "/product")

public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("productList", productService.listProduct());
		LOGGER.info("Product/productList - Method = GET");
		return "product/productList";
	}

	@RequestMapping(value = "/productForm", method = RequestMethod.GET)
	public String productPage(Model model, HttpServletRequest request) {
		LOGGER.info("Product/productForm - Method = GET");
		Employee emp = (Employee) request.getSession().getAttribute("login_id");
		model.asMap().clear(); // remove mapping from map
		model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
		model.addAttribute("role", emp.getRole().getName());
		return "product/productForm";
	}

	@RequestMapping(value = "/productForm", method = RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("productBean") ProductBean productBeanModel,
			BindingResult result, HttpServletRequest request) {

		LOGGER.info("Product/productForm - Method = POST");
		if (result.hasErrors()) {
			return "product/productForm";
		} else {
			Product newProduct = new Product();
			Employee owner = (Employee) request.getSession().getAttribute("login_id");
			newProduct.setName(productBeanModel.getName());
			newProduct.setDescription(productBeanModel.getDescription());
			newProduct.setStartDate(productBeanModel.getStartDate());
			newProduct.setDueDate(productBeanModel.getDueDate());
			newProduct.setEmployeeId(owner);
			Status status = new Status();
			status.setId(productBeanModel.getStatusId());
			newProduct.setStatus(status);
			productService.createProduct(newProduct);
			return "redirect:/product/productList";
		}
	}

}
