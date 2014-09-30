package hud.iys.dao;

import java.util.List;

import hud.iys.model.MaddeIcerik;
import hud.iys.model.KanunIcerik;

public interface IMaddeIcerikDAO {

	 public void addMaddeIcerik(MaddeIcerik maddeIcerik);
	
	 public void updateMaddeIcerik(MaddeIcerik maddeIcerik);
	
	 public void deleteMaddeIcerik(MaddeIcerik maddeIcerik);
	
	 public MaddeIcerik getMaddeIcerikById(Long id);
	
	 public List<MaddeIcerik> getMaddeIcerikleri();
	 
	 public List<MaddeIcerik> getMaddeIcerikleriByKanunIcerikId(Long kanunIcerikId);
}