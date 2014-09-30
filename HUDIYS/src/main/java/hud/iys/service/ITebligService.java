package hud.iys.service;

import java.util.List;

import hud.iys.model.Teblig;


public interface ITebligService {

	 public void addTeblig(Teblig teblig);
	
	 public void updateTeblig(Teblig teblig);
	
	 public void deleteTeblig(Teblig teblig);
	
	 public Teblig getTebligById(Long id);
	
	 public List<Teblig> getTebligler();
	 
	 public List<Teblig> getTebliglerByMevzuatId(Long mevzuatId);
}