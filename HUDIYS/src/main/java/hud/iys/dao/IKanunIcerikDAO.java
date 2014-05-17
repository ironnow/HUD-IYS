package hud.iys.dao;

import java.util.List;

import hud.iys.model.KanunIcerik;

public interface IKanunIcerikDAO {

	 public void addKanunIcerik(KanunIcerik kanunIcerik);
	
	 public void updateKanunIcerik(KanunIcerik kanunIcerik);
	
	 public void deleteKanunIcerik(KanunIcerik kanunIcerik);
	
	 public KanunIcerik getKanunIcerikById(int id);
	
	 public List<KanunIcerik> getKanunIcerikleri();
}