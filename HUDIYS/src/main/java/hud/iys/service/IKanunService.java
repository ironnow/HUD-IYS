package hud.iys.service;

import java.util.List;

import hud.iys.model.Kanun;


public interface IKanunService {

	 public void addKanun(Kanun kanun);
	
	 public void updateKanun(Kanun kanun);
	
	 public void deleteKanun(Kanun kanun);
	
	 public Kanun getKanunById(int id);
	
	 public List<Kanun> getKanunlar();
}