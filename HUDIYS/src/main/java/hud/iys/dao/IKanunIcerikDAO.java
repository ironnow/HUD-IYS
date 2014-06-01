package hud.iys.dao;

import java.util.List;

import hud.iys.model.Kanun;
import hud.iys.model.KanunIcerik;

public interface IKanunIcerikDAO {

	 public void addKanunIcerik(KanunIcerik kanunIcerik);
	
	 public void updateKanunIcerik(KanunIcerik kanunIcerik);
	
	 public void deleteKanunIcerik(KanunIcerik kanunIcerik);
	
	 public KanunIcerik getKanunIcerikById(Long id);
	
	 public List<KanunIcerik> getKanunIcerikleri();
	 
	 public List<KanunIcerik> getKanunIcerikleriByKanunId(Long kanunId);
}