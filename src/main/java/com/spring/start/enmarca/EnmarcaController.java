package com.spring.start.enmarca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.start.actividad.ActividadDAO;
import com.spring.start.plan.Plan;
import com.spring.start.plan.PlanDAO;
import com.spring.start.tutor.Tutor;

@Controller
public class EnmarcaController {

	@Autowired
	EnmarcaDAO enmarcaDAO;
	
	@Autowired
	PlanDAO planDAO;
	
	@Autowired
	ActividadDAO actividadDAO;
	
	@GetMapping("/enmarca")
	public ModelAndView enmarcas() {
		
		ModelAndView model = new ModelAndView();
		model.addObject("enmarcaciones", enmarcaDAO.findAll());
		model.setViewName("enmarca");
		
		return model;
	}
	
	@GetMapping("/enmarca/add")
	public ModelAndView enmarcaAd() {
		
		ModelAndView respuesta = new ModelAndView();
		respuesta.addObject("enmarca", new Enmarca());
		respuesta.addObject("planes", planDAO.findAll());
		respuesta.addObject("actividades", actividadDAO.findAll());
		
		respuesta.setViewName("FormEnmarca");
		
		return respuesta;
	}
	
	@PostMapping("/enmarca/save")
	public ModelAndView formTutoria(@ModelAttribute Enmarca enmarca) {

//		Tutor tutor = plan.getTutor();
//		tutor.setPlan(plan);
//		planDAO.save(plan);
		
		ModelAndView model = new ModelAndView();
		System.out.println(enmarca);
		model.setViewName("redirect:/enmarca");

		return model;
	}
}
