package hud.iys.dao;

import java.util.List;

import hud.iys.model.MevzuatIcerikTip;


public interface IMevzuatIcerikTipDAO {

	 public void addMevzuatIcerikTip(MevzuatIcerikTip mevzuatIcerikTip);
	
	 public void updateMevzuatIcerikTip(MevzuatIcerikTip mevzuatIcerikTip);
	
	 public void deleteMevzuatIcerikTip(MevzuatIcerikTip mevzuatIcerikTip);
	
	 public MevzuatIcerikTip getMevzuatIcerikTipById(Long id);
	 
	 public MevzuatIcerikTip getMevzuatIcerikTipIdByName(String mevzuatIcerikTipName);
	
	 public List<MevzuatIcerikTip> getMevzuatIcerikTipleri();
	 
	
}