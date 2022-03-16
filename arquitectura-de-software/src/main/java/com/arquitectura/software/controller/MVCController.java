package com.arquitectura.software.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller	
@RequestMapping("/test")
public class MVCController {
	@RequestMapping(path = "hola/mvc", method = RequestMethod.GET)
	
	public String holaMundo(Model moodelo) {
		return "hola.html";
	}
}
