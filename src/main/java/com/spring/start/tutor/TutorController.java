package com.spring.start.tutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.start.plan.PlanDAO;

@Controller
public class TutorController {

	@Autowired
	TutorDAO tutorDAO;

	@Autowired
	PlanDAO tutoriaDAO;
}
