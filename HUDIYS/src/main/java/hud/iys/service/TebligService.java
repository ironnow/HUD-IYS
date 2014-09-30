package hud.iys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hud.iys.model.Teblig;
import hud.iys.model.Mevzuat;
import hud.iys.dao.ITebligDAO;

@Transactional(readOnly = true)
public class TebligService implements ITebligService {
	
	 ITebligDAO tebligDAO;
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void addTeblig(Teblig teblig) {
		 getTebligDAO().addTeblig(teblig);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void deleteTeblig(Teblig teblig) {
		 getTebligDAO().deleteTeblig(teblig);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void updateTeblig(Teblig teblig) {
		 getTebligDAO().updateTeblig(teblig);
	 }
	
	 @Override
	 public Teblig getTebligById(Long id) {
		 return getTebligDAO().getTebligById(id);
	 }
	
	 
	 @Override
	 public List<Teblig> getTebligler() {
		 return getTebligDAO().getTebligler();
	 }
	
	 @Override
	 public List<Teblig> getTebliglerByMevzuatId(Long mevzuatId){
		 return getTebligDAO().getTebliglerByMevzuatId(mevzuatId);
	 }
	
	 public ITebligDAO getTebligDAO() {
		 return tebligDAO;
	 }
	
	 
	 public void setTebligDAO(ITebligDAO tebligDAO) {
		 this.tebligDAO = tebligDAO;
	 }
}