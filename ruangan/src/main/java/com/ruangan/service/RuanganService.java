package com.ruangan.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruangan.repository.RuanganRepository;
import com.ruangan.model.Ruangan;

@Service
@Transactional
public class RuanganService {
	
@Autowired RuanganRepository ruanganRepo;
	
	public List<Ruangan> getAllRuangan(){
		return ruanganRepo.findAll();
	}
	
	public Ruangan getRuanganById(int id) {
		return ruanganRepo.findById(id).get();
	}
	
	public void saveRuangan(Ruangan ruangan) {
		ruanganRepo.save(ruangan);
	}
	
	public void deleteRuangan (int id) {
		ruanganRepo.deleteById(id);
	}
}
