package com.ruangan.client.controller;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.ui.ModelMap;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.bind.support.SessionStatus;
	import org.springframework.web.client.HttpStatusCodeException;
	import org.springframework.web.servlet.ModelAndView;
	import org.springframework.web.servlet.view.RedirectView;

import com.ruangan.client.api.RuanganApi;
import com.ruangan.client.model.Ruangan;

	
	@RestController
	@RequestMapping("ruangan")
	public class RuanganController {
		
		@Autowired RuanganApi ruanganapi;
			
		@GetMapping("")
		public ModelAndView index() {
			ModelAndView mv = new ModelAndView("home");
			mv.addObject("listRuangan", ruanganapi.getAllRuangan());
			System.out.println("get in");
			return mv;
		}

		    
	    @GetMapping("/hapus/{id}")
	    public RedirectView hapusRuangan(@PathVariable("id") int id) {
	    	System.out.println("into the delete");
	    	ruanganapi.deleteRuangan(id);
	        return new RedirectView("/ruangan/");
	    }
	    
	    @GetMapping("/form/{id}")
	    public ModelAndView tampilFormedit(@PathVariable(name = "id") int id, ModelMap modelMap) {
	        System.out.println(ruanganapi.getRuanganById(id).getId_ruangan());
	        
	        ModelAndView mv = new ModelAndView("form");
	       
	        mv.addObject("ruangan", ruanganapi.getRuanganById(id));
	    
	        return mv;
	    }
	    
	    @GetMapping("/form")
	    public void tampilFormTambah(ModelMap modelMap) {
	    	Ruangan ruangan =  new Ruangan();
	        modelMap.addAttribute("ruangan", ruangan);
	        
	        ruanganapi.updateRuangan(ruangan);
	    }
	    
	    @PostMapping("/form")
	    public RedirectView editMahasiswa(@ModelAttribute Ruangan ruangan, BindingResult errors, SessionStatus status) {
	        try {
	        	ruanganapi.updateRuangan(ruangan);
	            status.setComplete();
	            return new RedirectView("/ruangan/");
	        } catch (HttpStatusCodeException e) {
	            ResponseEntity<String> response = ResponseEntity.status(e.getStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
	            errors.reject("error.object", response.getBody());
	        }
	        return new RedirectView("/ruangan/form");
	    }
	    
	    @GetMapping("/formAdd")
	    public ModelAndView tampilFormTambah(){

	    	Ruangan ruangan= new Ruangan();
	          ModelAndView modelAndView = new ModelAndView("formAdd");
	          modelAndView.addObject("ruangan", ruangan);
	          modelAndView.setViewName("formAdd");
	        return modelAndView;
	    }
	    
	    @PostMapping("/formAdd")
	    public RedirectView addRuangan(@ModelAttribute("formAdd") Ruangan ruangan){

	    	ruanganapi.addRuangan(ruangan);
	        
	        return new RedirectView("/ruangan/");
	    }


	}
