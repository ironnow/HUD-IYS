package hud.iys.dao;

import java.util.List;

import hud.iys.model.Kanun;


public interface IKanunDAO {

	 public void addKanun(Kanun kanun);
	
	 public void updateKanun(Kanun kanun);
	
	 public void deleteKanun(Kanun kanun);
	
	 public Kanun getKanunById(int id);
	
	 public List<Kanun> getKanunlar();
}