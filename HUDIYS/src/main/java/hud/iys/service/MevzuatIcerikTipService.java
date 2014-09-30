package hud.iys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hud.iys.model.MevzuatIcerikTip;
import hud.iys.model.Mevzuat;
import hud.iys.dao.IMevzuatIcerikTipDAO;

@Transactional(readOnly = true)
public class MevzuatIcerikTipService implements IMevzuatIcerikTipService {
	
	 // UserDAO is injected...
	 IMevzuatIcerikTipDAO mevzuatIcerikTipDAO;
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void addMevzuatIcerikTip(MevzuatIcerikTip mevzuatIcerikTip) {
		 getMevzuatIcerikTipDAO().addMevzuatIcerikTip(mevzuatIcerikTip);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void deleteMevzuatIcerikTip(MevzuatIcerikTip mevzuatIcerikTip) {
		 getMevzuatIcerikTipDAO().deleteMevzuatIcerikTip(mevzuatIcerikTip);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void updateMevzuatIcerikTip(MevzuatIcerikTip mevzuatIcerikTip) {
		 getMevzuatIcerikTipDAO().updateMevzuatIcerikTip(mevzuatIcerikTip);
	 }
	
	 @Override
	 public MevzuatIcerikTip getMevzuatIcerikTipById(Long id) {
		 return getMevzuatIcerikTipDAO().getMevzuatIcerikTipById(id);
	 }
	
	 
	 @Override
	 public List<MevzuatIcerikTip> getMevzuatIcerikTipleri() {
		 return getMevzuatIcerikTipDAO().getMevzuatIcerikTipleri();
	 }
	
	
	 public IMevzuatIcerikTipDAO getMevzuatIcerikTipDAO() {
		 return mevzuatIcerikTipDAO;
	 }
	
	 
	 public void setMevzuatIcerikTipDAO(IMevzuatIcerikTipDAO mevzuatIcerikTipDAO) {
		 this.mevzuatIcerikTipDAO = mevzuatIcerikTipDAO;
	 }
}