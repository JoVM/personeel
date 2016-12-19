package be.vdab.web;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import be.vdab.services.WerknemerService;
import be.vdab.valueobjects.OpslagWerknemer;

@Controller
@RequestMapping("/werknemer")
public class WerknemerController {
	private static final String WERKNEMERS_VIEW = "werknemers/werknemer";
	private static final String OPSLAG_WERKNEMER_VIEW = "werknemers/opslag";
	private final static String REDIRECT_NA_OPSLAG = "redirect:/";
	private final static String REDIRECT_NA_OPSLAG_EXCEPTION = "redirect:/werknemer/{id}?optimisticlockingexception=true";
	private final WerknemerIdSalaris werknemerIdSalaris;
	private final WerknemerService werknemerService;

	WerknemerController(WerknemerService werknemerService, WerknemerIdSalaris werknemerIdSalaris) {
		this.werknemerService = werknemerService;
		this.werknemerIdSalaris = werknemerIdSalaris;
	}

	@GetMapping
	ModelAndView findByChef() {
		return new ModelAndView(WERKNEMERS_VIEW, "werknemer", werknemerService.findByChef(null));
	}

	@GetMapping("{id}")
	ModelAndView read(@PathVariable long id) {
		ModelAndView modelAndView = new ModelAndView(WERKNEMERS_VIEW);
		werknemerService.findOne(id).ifPresent(werknemer -> modelAndView.addObject(werknemer));
		return modelAndView;
	}

	@GetMapping("opslag/{id}/{salaris}")
	ModelAndView updateWerknemerSalaris(@PathVariable long id, @PathVariable BigDecimal salaris) {
		werknemerIdSalaris.setId(id);
		werknemerIdSalaris.setSalaris(salaris);
		ModelAndView modelAndView = new ModelAndView(OPSLAG_WERKNEMER_VIEW);
		modelAndView.addObject(salaris);
		modelAndView.addObject(new OpslagWerknemer());
		return modelAndView;
	}

	@PostMapping("opslag")
	ModelAndView opslag(@Valid OpslagWerknemer opslagWerknemer, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		long id = werknemerIdSalaris.getId();
		BigDecimal salaris = werknemerIdSalaris.getSalaris();
		ModelAndView modelAndViewFout = new ModelAndView(OPSLAG_WERKNEMER_VIEW);
		modelAndViewFout.addObject("salaris", salaris);
		if (bindingResult.hasErrors()) {
			return modelAndViewFout;
		}
		try {
			werknemerService.geefOpslag(id, opslagWerknemer.getBedrag());
		} catch (ObjectOptimisticLockingFailureException ex) {
			ModelAndView modelAndView = new ModelAndView(REDIRECT_NA_OPSLAG_EXCEPTION);
			redirectAttributes.addAttribute("id", id);
			return modelAndView;
		}
		return new ModelAndView(REDIRECT_NA_OPSLAG);
	}
}
