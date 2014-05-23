package hud.iys.dao;

import java.util.List;

import hud.iys.model.Kanun;
import hud.iys.model.Mevzuat;


public interface IKanunDAO {

	 public void addKanun(Kanun kanun);
	
	 public void updateKanun(Kanun kanun);
	
	 public void deleteKanun(Kanun kanun);
	
	 public Kanun getKanunById(int id);
	
	 public List<Kanun> getKanunlar();
	 
	 public List<Kanun> getKanunlarByMevzuatId(int mevzuatId);
}