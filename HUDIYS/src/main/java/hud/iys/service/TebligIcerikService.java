package hud.iys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hud.iys.model.Teblig;
import hud.iys.model.TebligIcerik;
import hud.iys.dao.ITebligIcerikDAO;

@Transactional(readOnly = true)
public class TebligIcerikService implements ITebligIcerikService {
	
	 // TebligIcerikDAO is injected...
	 ITebligIcerikDAO tebligIcerikDAO;
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void addTebligIcerik(TebligIcerik tebligIcerik) {
		 getTebligIcerikDAO().addTebligIcerik(tebligIcerik);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void deleteTebligIcerik(TebligIcerik tebligIcerik) {
		 getTebligIcerikDAO().deleteTebligIcerik(tebligIcerik);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void updateTebligIcerik(TebligIcerik tebligIcerik) {
		 getTebligIcerikDAO().updateTebligIcerik(tebligIcerik);
	 }
	
	 @Override
	 public TebligIcerik getTebligIcerikById(Long id) {
		 return getTebligIcerikDAO().getTebligIcerikById(id);
	 }
	
	 
	 @Override
	 public List<TebligIcerik> getTebligIcerikleri() {
		 return getTebligIcerikDAO().getTebligIcerikleri();
	 }
	
	 @Override
	 public List<TebligIcerik> getTebligIcerikleriByTebligId(Long tebligId){
		 return getTebligIcerikDAO().getTebligIcerikleriByTebligId(tebligId);
	 }
	 
	 public ITebligIcerikDAO getTebligIcerikDAO() {
		 return tebligIcerikDAO;
	 }
	
	 
	 public void setTebligIcerikDAO(ITebligIcerikDAO tebligIcerikDAO) {
		 this.tebligIcerikDAO = tebligIcerikDAO;
	 }
}