package hud.iys.service;

import java.util.List;

import hud.iys.model.Bent;


public interface IBentService {

	 public void addBent(Bent bent);
	
	 public void updateBent(Bent bent);
	
	 public void deleteBent(Bent bent);
	
	 public Bent getBentById(Long id);
	
	 public List<Bent> getBentler();
	 
	 public List<Bent> getBentlerByFikraId(Long fikraId);
}