package com.jupiter.mumscrum.controller;

import java.util.List;

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
import com.jupiter.mumscrum.entity.Status;
import com.jupiter.mumscrum.exception.CustomException;
import com.jupiter.mumscrum.exception.ErrorCode;
import com.jupiter.mumscrum.service.ProductService;
import com.jupiter.mumscrum.service.StatusService;

@Controller
@RequestMapping(value = "/product")

public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private StatusService statusService;

	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public String listProducts(Model model, HttpServletRequest request) {
		model.addAttribute("productList", productService.listProduct());
		setUserAndRole(model, request);
		LOGGER.info("Product/productList - Method = GET");
		return "product/productList";
	}

	@RequestMapping(value = "/productForm", method = RequestMethod.GET)
	public String productPage(Model model, HttpServletRequest request) {
		LOGGER.info("Product/productForm - Method = GET");
		LOGGER.info("Product ID to update = " + request.getParameter("productId"));
		setUserAndRole(model, request);
		setTitle(model, request);
		if (request.getParameter("productId") != null) { // select of existing
															// product to update
			try {
				model.addAttribute("product",
						productService.getProductById(Integer.valueOf(request.getParameter("productId"))));
				request.getSession().setAttribute("productId", request.getParameter("productId"));
			} catch (Exception e) {
				throw new CustomException(ErrorCode.PRODUCT_NOT_FOUND_CODE, ErrorCode.PRODUCT_NOT_FOUND_MESSAGE);
			}
		} else {
			request.getSession().setAttribute("productId", "-1"); // create new
																	// product
		}
		if (request.getSession().getAttribute("login_id") != null) {
			model.addAttribute("productBean", new ProductBean());
			model.addAttribute("status", getStatusList());
			return "product/productForm";
		} else
			return "product/productForm";
	}

	@RequestMapping(value = "/productForm", method = RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("productBean") ProductBean productBeanModel,
			BindingResult result, HttpServletRequest request, Model model) {
		setUserAndRole(model, request);
		setTitle(model, request);
		LOGGER.info("Product/productForm - Method = POST");
		if (result.hasErrors()) {
			model.addAttribute("status", getStatusList());
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

			if (!request.getSession().getAttribute("productId").equals("-1")) {
				newProduct.setId(Integer.valueOf(request.getSession().getAttribute("productId").toString()));
				productService.updateProduct(newProduct);
				// request.getSession().removeAttribute("productId");
			} else {
				productService.createProduct(newProduct);
			}
			return "redirect:/product/productList";
		}
	}

	@RequestMapping(value = "/productDelete", method = RequestMethod.GET)
	public String deleteProduct(Model model, HttpServletRequest request) {
		int productId = Integer.valueOf(request.getParameter("productId"));
		LOGGER.info("deleteProduct - Method, ID = " + productId);
		productService.deleteProduct(productId);
		return "redirect:/product/productList";
	}

	public List<Status> getStatusList() {
		return statusService.statusList();
	}

	public void setUserAndRole(Model model, HttpServletRequest request) {
		try {
			Employee emp = (Employee) request.getSession().getAttribute("login_id");
			model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
			model.addAttribute("role", emp.getRole().getName());
		} catch (Exception e) {
			throw new CustomException(ErrorCode.USER_NOT_LOGIN_CODE, ErrorCode.USER_NOT_LOGIN_MESSAGE);
		}
	}

	public void setTitle(Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("productId") != null
				&& !request.getSession().getAttribute("productId").equals("-1"))
			model.addAttribute("title", "Edit Product");
		else
			model.addAttribute("title", "Add New Product");
	}
}
