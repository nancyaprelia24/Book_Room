package com.ruangan.client.api;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ruangan.client.model.Ruangan;

@Service
public class RuanganApi {
	
	String url = "http://localhost:8080/";
	
	@Autowired RestTemplate restTemplate;
	
	public List<Ruangan> getAllRuangan(){
		List<Ruangan> listRuangan= Arrays.stream(restTemplate.getForObject(url + "ruangan/get", Ruangan[].class)).collect(Collectors.toList());
		return listRuangan;
	}
	
	public Ruangan getRuanganById(int id) {
		Ruangan ruangan = restTemplate.getForObject(url + "/ruangan/get/{id}", Ruangan.class, id);
		return ruangan;
	}
	
	public void deleteRuangan(Integer id) {
		Map<String, Integer> parameter = new HashMap<String, Integer>();
		parameter.put("id", id);
		restTemplate.delete(url + "/ruangan/delete/{id}", parameter);
	}
	
	public void updateRuangan(Ruangan ruangan) {
		Map<String, Integer> parameter = new HashMap<String, Integer>();
		parameter.put("id", ruangan.getId_ruangan());
		restTemplate.put(url + "ruangan/edit/{id}", ruangan, parameter);
	}
	
	public void addRuangan(Ruangan ruangan) {
		restTemplate.postForObject(url + "/ruangan/add", ruangan, Ruangan.class);
	}


}
