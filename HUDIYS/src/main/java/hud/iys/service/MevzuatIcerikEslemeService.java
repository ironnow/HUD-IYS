package hud.iys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hud.iys.model.MevzuatIcerikEsleme;
import hud.iys.model.Mevzuat;
import hud.iys.dao.IMevzuatIcerikEslemeDAO;

@Transactional(readOnly = true)
public class MevzuatIcerikEslemeService implements IMevzuatIcerikEslemeService {
	
	 // UserDAO is injected...
	 IMevzuatIcerikEslemeDAO mevzuatIcerikEslemeDAO;
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void addMevzuatIcerikEsleme(MevzuatIcerikEsleme mevzuatIcerikEsleme) {
		 getMevzuatIcerikEslemeDAO().addMevzuatIcerikEsleme(mevzuatIcerikEsleme);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void deleteMevzuatIcerikEsleme(MevzuatIcerikEsleme mevzuatIcerikEsleme) {
		 getMevzuatIcerikEslemeDAO().deleteMevzuatIcerikEsleme(mevzuatIcerikEsleme);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void updateMevzuatIcerikEsleme(MevzuatIcerikEsleme mevzuatIcerikEsleme) {
		 getMevzuatIcerikEslemeDAO().updateMevzuatIcerikEsleme(mevzuatIcerikEsleme);
	 }
	
	 @Override
	 public MevzuatIcerikEsleme getMevzuatIcerikEslemeById(Long id) {
		 return getMevzuatIcerikEslemeDAO().getMevzuatIcerikEslemeById(id);
	 }
	
	 
	 @Override
	 public List<MevzuatIcerikEsleme> getMevzuatIcerikEslemeleri() {
		 return getMevzuatIcerikEslemeDAO().getMevzuatIcerikEslemeleri();
	 }
	
	 @Override
	 public List<MevzuatIcerikEsleme> getMevzuatIcerikEslemeleriByMevzuatId(Long mevzuatId){
		 return getMevzuatIcerikEslemeDAO().getMevzuatIcerikEslemeleriByMevzuatId(mevzuatId);
	 }
	
	 public IMevzuatIcerikEslemeDAO getMevzuatIcerikEslemeDAO() {
		 return mevzuatIcerikEslemeDAO;
	 }
	
	 
	 public void setMevzuatIcerikEslemeDAO(IMevzuatIcerikEslemeDAO mevzuatIcerikEslemeDAO) {
		 this.mevzuatIcerikEslemeDAO = mevzuatIcerikEslemeDAO;
	 }
}