package hud.iys.dao;

import java.util.List;

import hud.iys.model.MevzuatIcerikEsleme;


public interface IMevzuatIcerikEslemeDAO {

	 public void addMevzuatIcerikEsleme(MevzuatIcerikEsleme mevzuatIcerikEsleme);
	
	 public void updateMevzuatIcerikEsleme(MevzuatIcerikEsleme mevzuatIcerikEsleme);
	
	 public void deleteMevzuatIcerikEsleme(MevzuatIcerikEsleme mevzuatIcerikEsleme);
	
	 public MevzuatIcerikEsleme getMevzuatIcerikEslemeById(Long id);
	
	 public List<MevzuatIcerikEsleme> getMevzuatIcerikEslemeleri();
	 
	 public List<MevzuatIcerikEsleme> getMevzuatIcerikEslemeleriByMevzuatId(Long mevzuatId);
	
}