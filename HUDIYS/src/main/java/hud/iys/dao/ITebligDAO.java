package hud.iys.dao;

import java.util.List;

import hud.iys.model.Teblig;


public interface ITebligDAO {

	 public void addTeblig(Teblig teblig);
	
	 public void updateTeblig(Teblig teblig);
	
	 public void deleteTeblig(Teblig teblig);
	
	 public Teblig getTebligById(Long id);
	
	 public List<Teblig> getTebligler();
	 
	 public List<Teblig> getTebliglerByMevzuatId(Long mevzuatId);
}