package hud.iys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hud.iys.model.Kanun;
import hud.iys.model.TebligMaddeIcerik;
import hud.iys.dao.ITebligMaddeIcerikDAO;

@Transactional(readOnly = true)
public class TebligMaddeIcerikService implements ITebligMaddeIcerikService {
	
	 ITebligMaddeIcerikDAO tebligMaddeIcerikDAO;
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void addTebligMaddeIcerik(TebligMaddeIcerik tebligMaddeIcerik) {
		 getTebligMaddeIcerikDAO().addTebligMaddeIcerik(tebligMaddeIcerik);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void deleteTebligMaddeIcerik(TebligMaddeIcerik tebligMaddeIcerik) {
		 getTebligMaddeIcerikDAO().deleteTebligMaddeIcerik(tebligMaddeIcerik);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void updateTebligMaddeIcerik(TebligMaddeIcerik tebligMaddeIcerik) {
		 getTebligMaddeIcerikDAO().updateTebligMaddeIcerik(tebligMaddeIcerik);
	 }
	
	 @Override
	 public TebligMaddeIcerik getTebligMaddeIcerikById(Long id) {
		 return getTebligMaddeIcerikDAO().getTebligMaddeIcerikById(id);
	 }
	
	 
	 @Override
	 public List<TebligMaddeIcerik> getTebligMaddeIcerikleri() {
		 return getTebligMaddeIcerikDAO().getTebligMaddeIcerikleri();
	 }
	
	 @Override
	 public List<TebligMaddeIcerik> getTebligMaddeIcerikleriByTebligIcerikId(Long tebligIcerikId){
		 return getTebligMaddeIcerikDAO().getTebligMaddeIcerikleriByTebligIcerikId(tebligIcerikId);
	 }
	 
	 public ITebligMaddeIcerikDAO getTebligMaddeIcerikDAO() {
		 return tebligMaddeIcerikDAO;
	 }
	
	 
	 public void setTebligMaddeIcerikDAO(ITebligMaddeIcerikDAO tebligMaddeIcerikDAO) {
		 this.tebligMaddeIcerikDAO = tebligMaddeIcerikDAO;
	 }
}