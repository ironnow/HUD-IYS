package hud.iys.service;

import java.util.List;

import hud.iys.model.Mevzuat;


public interface IMevzuatService {

	 public void addMevzuat(Mevzuat mevzuat);
	
	 public void updateMevzuat(Mevzuat mevzuat);
	
	 public void deleteMevzuat(Mevzuat mevzuat);
	
	 public Mevzuat getMevzuatById(Long id);
	
	 public List<Mevzuat> getMevzuatlar();
	 
	 public List<Mevzuat> getMevzuatlarByMevzuatSetiId(Long mevzuatSetiId);
}