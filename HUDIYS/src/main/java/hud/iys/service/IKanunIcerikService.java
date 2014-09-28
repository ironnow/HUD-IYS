package hud.iys.service;

import java.util.List;

import hud.iys.model.Kanun;
import hud.iys.model.KanunIcerik;
import hud.iys.model.KanunIcerik_TEMP;


public interface IKanunIcerikService {

	 public void addKanunIcerik(KanunIcerik kanunIcerik);
	
	 public void updateKanunIcerik(KanunIcerik kanunIcerik);
	
	 public void deleteKanunIcerik(KanunIcerik kanunIcerik);
	
	 public KanunIcerik getKanunIcerikById(Long id);
	 
     public KanunIcerik getKanunIcerikByParentId(Long parentId);
	 
     public KanunIcerik getKanunIcerikByParentLeftId(Long parentId);
	 
	 public KanunIcerik getKanunIcerikByParentRightId(Long parentId);
	
	 public List<KanunIcerik> getKanunIcerikleri();
	 
	 public List<KanunIcerik> getKanunIcerikleriByKanunId(Long kanunId);
	 
	 public List<KanunIcerik_TEMP> getKanunIcerikTree(Long rootId);
}