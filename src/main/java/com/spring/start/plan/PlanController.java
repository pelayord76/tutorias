package com.spring.start.plan;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.start.curso.CursoDAO;
import com.spring.start.enmarca.EnmarcaDAO;
import com.spring.start.tutor.Tutor;
import com.spring.start.tutor.TutorDAO;

@Controller
public class PlanController {

	@Autowired
	PlanDAO planDAO;

	@Autowired
	CursoDAO cursoDAO;

	@Autowired
	TutorDAO tutorDao;
	
	@Autowired
	EnmarcaDAO enmarcaDAO;

	@GetMapping("/plan")
	public ModelAndView tutorias() {

		ModelAndView model = new ModelAndView();
		model.setViewName("planes");

		List<Plan> planes = (List<Plan>) planDAO.findAll();

		model.addObject("plan", new Plan());
		model.addObject("cursos", cursoDAO.findAll());
		model.addObject("tutores", tutorDao.getTutoresNoEnlazados());
		model.addObject("planes", planes);

		return model;
	}

	@GetMapping("/plan/{id}")
	public ModelAndView tutoria(@PathVariable long id) {

		Plan plan = planDAO.findById(id).get();

		ModelAndView model = new ModelAndView();
		model.setViewName("plan");
		
		model.addObject("plan", plan);
		model.addObject("enarca", enmarcaDAO.findAll());
		
		return model;
	}

	@GetMapping("/plan/add")
	public ModelAndView addPlan() {

		ModelAndView model = new ModelAndView();

		model.setViewName("formPlan");
		model.addObject("plan", new Plan());
		model.addObject("cursos", cursoDAO.findAll());
		model.addObject("tutores", tutorDao.getTutoresNoEnlazados());

		return model;
	}

	@GetMapping("/plan/edit/{id}")
	public ModelAndView editPlan(@PathVariable long id) {

		ModelAndView model = new ModelAndView();

		Optional<Plan> planazo = planDAO.findById(id);
		if (planazo.isPresent()) {

			model.addObject("plan", planazo.get());
			model.addObject("cursos", cursoDAO.findAll());
			model.addObject("tutores", tutorDao.getTutoresNoEnlazados());

			model.setViewName("formPlan");
		}

		else
			model.setViewName("redirect:/plan");

		return model;
	}

	@GetMapping("/plan/del/{id}")
	public ModelAndView delPlan(@PathVariable long id) {

		planDAO.deleteById(id);

		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/plan");

		return model;
	}

	@GetMapping("/plan/tutor/del/{idPlan}")
	public ModelAndView eliminarTutoriaTutor(@PathVariable long idPlan) {

		Optional<Plan> plan = planDAO.findById(idPlan);
		if (plan.isPresent()) {

			Plan planazo = plan.get();
			Tutor tutor = planazo.getTutor();
			planazo.setTutor(null);
			tutor.setPlan(null);
			planDAO.save(planazo);
		}

		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/plan");

		return model;
	}

	@PostMapping("/plan/save")
	public ModelAndView formTutoria(@ModelAttribute Plan plan) {

		Tutor tutor = plan.getTutor();
		tutor.setPlan(plan);
		planDAO.save(plan);

		ModelAndView model = new ModelAndView();
		model.addObject("planCreado", plan);
		model.setViewName("redirect:/plan/nuevo/" + plan.getId());

		return model;
	}

	@GetMapping("/plan/nuevo/{idPlan}")
	public ModelAndView planCreado(@PathVariable long idPlan) {

		ModelAndView model = new ModelAndView();
		model.setViewName("planes");

		List<Plan> planes = (List<Plan>) planDAO.findAll();
		Plan plan = planDAO.findById(idPlan).get();
		
		model.addObject("plan", new Plan());
		model.addObject("cursos", cursoDAO.findAll());
		model.addObject("tutores", tutorDao.getTutoresNoEnlazados());
		model.addObject("planes", planes);
		model.addObject("planCreado", plan);

		return model;
	}
}