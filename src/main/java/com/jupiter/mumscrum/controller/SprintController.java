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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jupiter.mumscrum.bean.SprintBean;
import com.jupiter.mumscrum.entity.Coordinates;
import com.jupiter.mumscrum.entity.Employee;
import com.jupiter.mumscrum.entity.ReleaseBacklog;
import com.jupiter.mumscrum.entity.Sprint;
import com.jupiter.mumscrum.entity.UserStory;
import com.jupiter.mumscrum.service.ProductService;
import com.jupiter.mumscrum.service.ReleaseBacklogService;
import com.jupiter.mumscrum.service.SprintService;
import com.jupiter.mumscrum.service.UserStoryService;
import com.jupiter.mumscrum.util.Utility;

@Controller
public class SprintController {

	@Autowired
	private SprintService sprintService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ReleaseBacklogService releaseBacklogService;

	@Autowired
	private UserStoryService userStoryService;

	private static final Logger LOGGER = LoggerFactory.getLogger(SprintController.class);

	@RequestMapping(value = "sprint/sprintForm", method = RequestMethod.GET)
	public String sprintPage(Model model, HttpServletRequest request) {

		LOGGER.info("Get Method for createSprint");
		model.addAttribute("sprintBean", new SprintBean());
		Employee emp = (Employee) request.getSession().getAttribute("login_id");
		model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
		model.addAttribute("role", emp.getRole().getName());
		model.addAttribute("productList", productService.listProduct());
		return "sprint/sprintForm";
	}

	@RequestMapping(value = "sprint/createSprint", method = RequestMethod.POST)
	public String insertSprint(@Valid @ModelAttribute("sprintBean") SprintBean sprintBean, BindingResult bindingResult,
			Model model) {

		LOGGER.info("Scrum Master saves new Sprint information");
		if (bindingResult.hasErrors()) {
			model.addAttribute("productList", productService.listProduct());
			return "sprint/sprintForm";
		}
		Sprint sprint = new Sprint();
		sprint.setName(sprintBean.getName());
		sprint.setStartDate(sprintBean.getStartDate());
		sprint.setDueDate(sprintBean.getDueDate());
		ReleaseBacklog release = new ReleaseBacklog();
		release.setId(sprintBean.getReleaseId());
		sprint.setReleaseBacklog(release);

		int sprintId = sprintService.insertSprint(sprint);

		LOGGER.info("New Sprint created with Sprint id::" + sprintId);

		List<Integer> userStoriesList = sprintBean.getUserStoryList();
		for (Integer id : userStoriesList) {
			UserStory userStory = userStoryService.getUserStoryById(id);
			userStoryService.updateSprintForUserStory(userStory, sprintId);
		}

		return "redirect:/sprint/sprintList";
	}

	@RequestMapping(method = RequestMethod.GET, value = "sprint/getProductReleases")
	@ResponseBody
	public String handleRequest(@RequestParam("productId") int id) {
		List<ReleaseBacklog> releases = releaseBacklogService.listRelease();
		List<ReleaseBacklog> productRelease = new ArrayList<ReleaseBacklog>();

		for (ReleaseBacklog release : releases) {
			if (release.getProduct().getId() == id) {
				productRelease.add(release);
			}
		}

		String json = Utility.generateJSON(productRelease);
		return json;
	}

	@RequestMapping(value = "sprint/sprintList", method = RequestMethod.GET)
	public String sprintList(Model model, HttpServletRequest request) {

		LOGGER.info("Get Method for sprintList");
		Employee emp = (Employee) request.getSession().getAttribute("login_id");
		model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
		model.addAttribute("role", emp.getRole().getName());
		model.addAttribute("sprintList", sprintService.listSprint());
		return "sprint/sprintList";
	}

	@RequestMapping(value = "sprint/editSprint", method = RequestMethod.GET)
	public String editSprint(@RequestParam("id") int id, Model model, HttpServletRequest request) {

		LOGGER.info("Edit method for Sprint id:: " + id);
		model.addAttribute("sprintBean", new SprintBean());
		Employee emp = (Employee) request.getSession().getAttribute("login_id");
		model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
		model.addAttribute("role", emp.getRole().getName());
		model.addAttribute("sprint", sprintService.getSprintById(id));
		model.addAttribute("productList", productService.listProduct());
		return "sprint/sprintUpdate";
	}

	@RequestMapping(value = "sprint/updateSprint", method = RequestMethod.POST)
	public String updateSprint(@Valid @ModelAttribute("sprintBean") SprintBean sprintBean, BindingResult bindingResult,
			Model model) {

		LOGGER.info("Updates data for Sprint ::" + sprintBean.getId());
		if (bindingResult.hasErrors()) {
			model.addAttribute("productList", productService.listProduct());
			return "sprint/sprintUpdate";
		}

		Sprint sprint = new Sprint();
		sprint.setId(sprintBean.getId());
		sprint.setName(sprintBean.getName());
		sprint.setStartDate(sprintBean.getStartDate());
		sprint.setDueDate(sprintBean.getDueDate());
		ReleaseBacklog release = new ReleaseBacklog();
		release.setId(sprintBean.getReleaseId());
		sprint.setReleaseBacklog(release);

		sprintService.updateSprint(sprint);

		return "redirect:/sprint/sprintList";
	}

	@RequestMapping(value = "sprint/deleteSprint", method = RequestMethod.GET)
	public String deleteSprint(@RequestParam("id") int id) {

		LOGGER.info("Delete method for Sprint id:: " + id);
		sprintService.deleteSprint(id);
		return "redirect:/sprint/sprintList";
	}

	@RequestMapping(value = "sprint/burndownChart", method = RequestMethod.GET)
	public String viewChart(Model model, HttpServletRequest request) {

		LOGGER.info("Get Method ViewChart");
		Employee emp = (Employee) request.getSession().getAttribute("login_id");
		model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
		model.addAttribute("role", emp.getRole().getName());
		model.addAttribute("sprintList", sprintService.listSprint());

		return "/sprint/burndownChart";
	}

	@RequestMapping(method = RequestMethod.GET, value = "sprint/getCoordinates")
	@ResponseBody
	public String getCoordinates(@RequestParam("sprintId") int id) {
		LOGGER.info("Get Method for Sprint Json Data");
		List<Coordinates> results = sprintService.getWorklogDataSet(id);
		List<Coordinates> dataset = new ArrayList<Coordinates>();
		Double remaining = (double) sprintService.getTotalEstimate(id);

		for (Object result : results) {
			Object[] obj = (Object[]) result;

			remaining -= (Double) obj[0];
			dataset.add(new Coordinates(remaining.intValue(), String.valueOf(obj[1])));
		}

		String json = Utility.generateDataSetJSON(dataset);
		LOGGER.info("Get Method for Sprint Json Data:: " + json);
		return json;

	}

	@RequestMapping(method = RequestMethod.GET, value = "sprint/getUserStories")
	@ResponseBody
	public String getUserStories(@RequestParam("releaseId") int id) {

		LOGGER.info("Get UserStory for releaseId::" + id);
		List<UserStory> userStories = userStoryService.getUserStoryForRelease(id);

		String json = Utility.generateJSONInGeneric(userStories);
		return json;
	}
}