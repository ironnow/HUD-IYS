package hud.iys.dao;

import java.util.List;

import hud.iys.model.DipnotTI;

public interface IDipnotTIDAO {

	 public void addDipnot(DipnotTI dipnot);
	
	 public void updateDipnot(DipnotTI dipnot);
	
	 public void deleteDipnot(DipnotTI dipnot);
	
	 public DipnotTI getDipnotById(Long id);
	
	 public List<DipnotTI> getDipnotlar();
	 
	 public List<DipnotTI> getDipnotlarByTebligIcerikId(Long tebligIcerikId);
}