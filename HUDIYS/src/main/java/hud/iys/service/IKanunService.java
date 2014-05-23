package hud.iys.service;

import java.util.List;

import hud.iys.model.Kanun;
import hud.iys.model.Mevzuat;


public interface IKanunService {

	 public void addKanun(Kanun kanun);
	
	 public void updateKanun(Kanun kanun);
	
	 public void deleteKanun(Kanun kanun);
	
	 public Kanun getKanunById(int id);
	
	 public List<Kanun> getKanunlar();
	 
	 public List<Kanun> getKanunlarByMevzuatId(int mevzuatId);
}