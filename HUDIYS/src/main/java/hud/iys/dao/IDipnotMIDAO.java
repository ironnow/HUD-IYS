package hud.iys.dao;

import java.util.List;

import hud.iys.model.DipnotMI;

public interface IDipnotMIDAO {

	 public void addDipnot(DipnotMI dipnot);
	
	 public void updateDipnot(DipnotMI dipnot);
	
	 public void deleteDipnot(DipnotMI dipnot);
	
	 public DipnotMI getDipnotById(Long id);
	
	 public List<DipnotMI> getDipnotlar();
	 
	 public List<DipnotMI> getDipnotlarByMaddeIcerikId(Long maddeIcerikId);
}