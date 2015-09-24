package com.jupiter.mumscrum.controller;

import java.util.ArrayList;
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

import com.jupiter.mumscrum.bean.ReleaseBacklogBean;
import com.jupiter.mumscrum.entity.Employee;
import com.jupiter.mumscrum.entity.Product;
import com.jupiter.mumscrum.entity.ReleaseBacklog;
import com.jupiter.mumscrum.exception.CustomException;
import com.jupiter.mumscrum.exception.ErrorCode;
import com.jupiter.mumscrum.service.EmployeeService;
import com.jupiter.mumscrum.service.ProductService;
import com.jupiter.mumscrum.service.ReleaseBacklogService;
import com.jupiter.mumscrum.util.Role;

@Controller
@RequestMapping(value = "/releaseBacklog")
public class ReleaseBacklogController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ReleaseBacklogService releaseBacklogService;

	@Autowired
	private ProductService productService;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/releaseBacklogForm", method = RequestMethod.GET)
	public String createReleaseBacklogForm(HttpServletRequest request, Model model) {
		model.addAttribute("releaseBacklogBean", new ReleaseBacklogBean());
		setTitle(model, request);
		setUserAndRole(model, request);
		model.addAttribute("productList", getProductList());
		model.addAttribute("releaseType", releaseType());
		model.addAttribute("scrumMaster", getScrumMasterList());
		// select of existing release backlog to update
		if (request.getParameter("releaseId") != null) {
			try {
				int releaseId = Integer.valueOf(request.getParameter("releaseId"));
				request.getSession().setAttribute("releaseId", releaseId);
				model.addAttribute("releaseBacklog", releaseBacklogService.getReleaseBacklogById(releaseId));
			} catch (Exception e) {
				throw new CustomException(ErrorCode.RELEASE_NOT_FOUND_CODE, ErrorCode.RELEASE_NOT_FOUND_MESSAGE);
			}
		} else {
			// create new releaseBacklog
			request.getSession().setAttribute("releaseId", "-1");
		}
		return "releaseBacklog/releaseBacklogForm";
	}

	@RequestMapping(value = "/releaseBacklogForm", method = RequestMethod.POST)
	public String createReleaseBacklog(@Valid @ModelAttribute("releaseBacklogBean") ReleaseBacklogBean releaseBeanModel,
			BindingResult result, HttpServletRequest request, Model model) {

		LOGGER.info("ReleaseBacklog/ReleaseBacklogForm - Method = POST");
		setTitle(model, request);
		setUserAndRole(model, request);
		if (result.hasErrors()) {
			model.addAttribute("productList", getProductList());
			model.addAttribute("releaseType", releaseType());
			model.addAttribute("scrumMaster", getScrumMasterList());
			return "releaseBacklog/releaseBacklogForm";
		} else {
			ReleaseBacklog newRelease = new ReleaseBacklog();
			Product product = new Product();
			product.setId(releaseBeanModel.getProductId());
			Employee scrumMaster = new Employee();
			scrumMaster.setId(releaseBeanModel.getScrumMasterId());
			newRelease.setDescriptioon(releaseBeanModel.getDescription());
			newRelease.setDueDate(releaseBeanModel.getDueDate());
			newRelease.setName(releaseBeanModel.getName());
			newRelease.setProduct(product);
			newRelease.setStartDate(releaseBeanModel.getStartDate());
			newRelease.setType(releaseBeanModel.getType());
			newRelease.setEmployee(scrumMaster);

			if (!request.getSession().getAttribute("releaseId").equals("-1")) {
				newRelease.setId(Integer.valueOf(request.getSession().getAttribute("releaseId").toString()));
				releaseBacklogService.updateReleaseBacklog(newRelease);
				// request.getSession().removeAttribute("userStoryId");
			} else {
				releaseBacklogService.createRelease(newRelease);
			}
			return "redirect:/releaseBacklog/releaseBacklogList";
		}
	}

	@RequestMapping(value = "/releaseBacklogList", method = RequestMethod.GET)
	public String listReleases(Model model, HttpServletRequest request) {
		model.addAttribute("releaseList", releaseBacklogService.listRelease());
		LOGGER.info("ReleaseBacklog/listReleases - Method = GET");
		setUserAndRole(model, request);
		return "releaseBacklog/releaseBacklogList";
	}

	@RequestMapping(value = "/releaseBacklogDelete", method = RequestMethod.GET)
	public String deleteReleaseBacklog(Model model, HttpServletRequest request) {
		LOGGER.info("deleteReleaseBacklog - Method");
		int releaseId = Integer.valueOf(request.getParameter("releaseId"));
		releaseBacklogService.deleteReleaseBacklog(releaseId);
		return "redirect:/releaseBacklog/releaseBacklogList";
	}

	public List<Product> getProductList() {
		return productService.listProduct();
	}

	public List<String> releaseType() {
		List<String> list = new ArrayList<String>();
		list.add("Beta");
		list.add("Production");
		return list;
	}

	public List<Employee> getScrumMasterList() {
		return employeeService.getUserListByRole(Role.SCRUM_MASTER.getRoleId());
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
		if (request.getSession().getAttribute("releaseId") != null
				&& !request.getSession().getAttribute("releaseId").equals("-1"))
			model.addAttribute("title", "Edit Release Backlog");
		else
			model.addAttribute("title", "Add New Release Backlog");
	}
}
