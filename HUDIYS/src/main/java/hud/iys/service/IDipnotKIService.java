package hud.iys.service;

import java.util.List;

import hud.iys.model.DipnotKI;


public interface IDipnotKIService {

	 public void addDipnot(DipnotKI dipnot);
	
	 public void updateDipnot(DipnotKI dipnot);
	
	 public void deleteDipnot(DipnotKI dipnot);
	
	 public DipnotKI getDipnotById(Long id);
	
	 public List<DipnotKI> getDipnotlar();
	 
	 public List<DipnotKI> getDipnotlarByKanunIcerikId(Long kanunIcerikId);
}