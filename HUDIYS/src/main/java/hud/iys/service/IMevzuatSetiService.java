package hud.iys.service;

import java.util.List;

import hud.iys.model.MevzuatSeti;


public interface IMevzuatSetiService {

	 public void addMevzuatSeti(MevzuatSeti mevzuatSeti);
	
	 public void updateMevzuatSeti(MevzuatSeti mevzuatSeti);
	
	 public void deleteMevzuatSeti(MevzuatSeti mevzuatSeti);
	
	 public MevzuatSeti getMevzuatSetiById(Long id);
	
	 public List<MevzuatSeti> getMevzuatSetleri();
}