package hud.iys.dao;

import java.util.List;

import hud.iys.model.Mevzuat;

public interface IMevzuatDAO {

	 public void addMevzuat(Mevzuat mevzuat);
	
	 public void updateMevzuat(Mevzuat mevzuat);
	
	 public void deleteMevzuat(Mevzuat mevzuat);
	
	 public Mevzuat getMevzuatById(int id);
	
	 public List<Mevzuat> getMevzuatlar();
	 
	 public List<Mevzuat> getMevzuatlarByMevzuatSetiId(int mevzuatSetiId);
}