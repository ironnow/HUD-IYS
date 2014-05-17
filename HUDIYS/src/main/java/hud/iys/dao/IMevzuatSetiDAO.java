package hud.iys.dao;

import java.util.List;

import hud.iys.model.MevzuatSeti;

public interface IMevzuatSetiDAO {

	 public void addMevzuatSeti(MevzuatSeti mevzuatSeti);
	
	 public void updateMevzuatSeti(MevzuatSeti mevzuatSeti);
	
	 public void deleteMevzuatSeti(MevzuatSeti mevzuatSeti);
	
	 public MevzuatSeti getMevzuatSetiById(int id);
	
	 public List<MevzuatSeti> getMevzuatSetleri();
}