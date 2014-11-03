package hud.iys.service;

import java.util.List;

import hud.iys.model.MevzuatIcerikTip;
import hud.iys.model.Mevzuat;


public interface IMevzuatIcerikTipService {

	 public void addMevzuatIcerikTip(MevzuatIcerikTip mevzuatIcerikTip);
	
	 public void updateMevzuatIcerikTip(MevzuatIcerikTip mevzuatIcerikTip);
	
	 public void deleteMevzuatIcerikTip(MevzuatIcerikTip mevzuatIcerikTip);
	
	 public MevzuatIcerikTip getMevzuatIcerikTipById(Long id);
	 
	 public MevzuatIcerikTip getMevzuatIcerikTipIdByName(String mevzuatIcerikTipName);
	
	 public List<MevzuatIcerikTip> getMevzuatIcerikTipleri();
	 
	
}