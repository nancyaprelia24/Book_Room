package com.ruangan.controller;
	import java.util.List;
	import java.util.NoSuchElementException;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.ruangan.model.Ruangan;
import com.ruangan.service.RuanganService;

@RestController
@RequestMapping("ruangan")
public class RuanganController {
		@Autowired RuanganService ruanganService;
		
		@GetMapping("/get")
		public List<Ruangan> getAllRuangan(){
			return ruanganService.getAllRuangan();
		}
		
		@GetMapping("/get/{id}")
		public ResponseEntity<Ruangan> getRuanganById(@PathVariable("id") int id) {
			try {
				Ruangan ruangan = ruanganService.getRuanganById(id);
				return new ResponseEntity<Ruangan>(ruangan, HttpStatus.OK);
			}
			catch(NoSuchElementException e) {
				return new ResponseEntity<Ruangan>(HttpStatus.NOT_FOUND);
			}
		}
		
		 @PutMapping(value = "/edit/{id}")
		 public ResponseEntity<Ruangan> updateRuangan(@PathVariable("id") int id, @RequestBody Ruangan ruangan){
			 try {
				 Ruangan existruangan = ruanganService.getRuanganById(id);
				 ruangan.setId_ruangan(id);
				 ruanganService.saveRuangan(ruangan);
				 return new ResponseEntity<Ruangan>(ruangan, HttpStatus.OK);
			 }
			 catch(NoSuchElementException e) {
				 return new ResponseEntity<Ruangan>(ruangan, HttpStatus.NOT_FOUND);
			 }
			 
		 }
		 
		 @PostMapping(value="/add")
		 public ResponseEntity<Ruangan> createRuangan(@RequestBody Ruangan ruangan){
			 ruanganService.saveRuangan(ruangan);
			 return new ResponseEntity<Ruangan>(ruangan, HttpStatus.OK);
		 }
		 
		 @DeleteMapping(value="/delete/{id}")
		 public ResponseEntity<String> deleteRuangan(@PathVariable("id") int id){
			 try {
				 Ruangan existRuangan = ruanganService.getRuanganById(id);
				 ruanganService.deleteRuangan(id);
				 return new ResponseEntity<String>(HttpStatus.OK);
			 }
			 catch(NoSuchElementException e) {
				 return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			 }
		 }
	}
