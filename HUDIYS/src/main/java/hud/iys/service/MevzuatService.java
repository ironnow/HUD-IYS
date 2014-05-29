package hud.iys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hud.iys.model.Mevzuat;
import hud.iys.dao.IMevzuatDAO;

@Transactional(readOnly = true)
public class MevzuatService implements IMevzuatService {
	
	 // MevzuatDAO is injected...
	 IMevzuatDAO mevzuatDAO;
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void addMevzuat(Mevzuat mevzuat) {
		 getMevzuatDAO().addMevzuat(mevzuat);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void deleteMevzuat(Mevzuat mevzuat) {
		 getMevzuatDAO().deleteMevzuat(mevzuat);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void updateMevzuat(Mevzuat mevzuat) {
		 getMevzuatDAO().updateMevzuat(mevzuat);
	 }
	
	 @Override
	 public Mevzuat getMevzuatById(int id) {
		 return getMevzuatDAO().getMevzuatById(id);
	 }
	
	 
	 @Override
	 public List<Mevzuat> getMevzuatlar() {
		 return getMevzuatDAO().getMevzuatlar();
	 }
	
	 @Override
	 public List<Mevzuat> getMevzuatlarByMevzuatSetiId(int mevzuatSetiId){
		 return getMevzuatDAO().getMevzuatlarByMevzuatSetiId(mevzuatSetiId);
	 }
	
	 public IMevzuatDAO getMevzuatDAO() {
		 return mevzuatDAO;
	 }	
	 
	 public void setMevzuatDAO(IMevzuatDAO mevzuatDAO) {
		 this.mevzuatDAO = mevzuatDAO;
	 }
}