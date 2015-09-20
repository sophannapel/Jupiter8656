package com.jupiter.mumscrum.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jupiter.mumscrum.entity.ReleaseBacklog;
import com.jupiter.mumscrum.service.ReleaseBacklogService;

@Controller
public class UtilityController {
	
	@Autowired
	ReleaseBacklogService releaseBacklogService;
	
	@ModelAttribute("releaseListByProductId")
	public List<ReleaseBacklog> getReleaseListByProductId(HttpServletRequest request, Model model) {
		int productId = Integer.valueOf(request.getParameter("productId"));
		return releaseBacklogService.listReleaseByProductId(productId);
	}
}
