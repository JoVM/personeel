package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.JobtitelService;

@Controller
@RequestMapping("/jobtitels")
public class JobtitelController {
	private static final String JOBTITELS_VIEW = "jobtitels/jobtitels";
	private final JobtitelService jobtitelService;

	public JobtitelController(JobtitelService jobtitelService) {
		this.jobtitelService = jobtitelService;
	}

	@GetMapping
	ModelAndView findAll() {
		return new ModelAndView(JOBTITELS_VIEW, "jobtitels", jobtitelService.findAll());
	}

	@GetMapping("{id}")
	ModelAndView read(@PathVariable long id) {
		ModelAndView modelAndView = new ModelAndView(JOBTITELS_VIEW);
		modelAndView.addObject("jobtitels", jobtitelService.findAll());
		jobtitelService.findOne(id).ifPresent(jobtitel -> modelAndView.addObject(jobtitel));
		return modelAndView;
	}
}
