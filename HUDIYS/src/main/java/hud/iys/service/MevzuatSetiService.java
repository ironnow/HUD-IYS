package hud.iys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hud.iys.model.MevzuatSeti;
import hud.iys.dao.IMevzuatSetiDAO;

@Transactional(readOnly = true)
public class MevzuatSetiService implements IMevzuatSetiService {
	
	 // MevzuatSetiDAO is injected...
	 IMevzuatSetiDAO mevzuatSetiDAO;
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void addMevzuatSeti(MevzuatSeti mevzuatSeti) {
		 getMevzuatSetiDAO().addMevzuatSeti(mevzuatSeti);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void deleteMevzuatSeti(MevzuatSeti mevzuatSeti) {
		 getMevzuatSetiDAO().deleteMevzuatSeti(mevzuatSeti);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void updateMevzuatSeti(MevzuatSeti mevzuatSeti) {
		 getMevzuatSetiDAO().updateMevzuatSeti(mevzuatSeti);
	 }
	
	 @Override
	 public MevzuatSeti getMevzuatSetiById(Long id) {
		 return getMevzuatSetiDAO().getMevzuatSetiById(id);
	 }
	
	 
	 @Override
	 public List<MevzuatSeti> getMevzuatSetleri() {
		 return getMevzuatSetiDAO().getMevzuatSetleri();
	 }
	
	
	 public IMevzuatSetiDAO getMevzuatSetiDAO() {
		 return mevzuatSetiDAO;
	 }
	
	 
	 public void setMevzuatSetiDAO(IMevzuatSetiDAO mevzuatSetiDAO) {
		 this.mevzuatSetiDAO = mevzuatSetiDAO;
	 }
}