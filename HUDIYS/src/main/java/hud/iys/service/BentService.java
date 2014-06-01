package hud.iys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hud.iys.model.Bent;
import hud.iys.dao.IBentDAO;

@Transactional(readOnly = true)
public class BentService implements IBentService {
	
	 // BentDAO is injected...
	 IBentDAO bentDAO;
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void addBent(Bent bent) {
		 getBentDAO().addBent(bent);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void deleteBent(Bent bent) {
		 getBentDAO().deleteBent(bent);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void updateBent(Bent bent) {
		 getBentDAO().updateBent(bent);
	 }
	
	 @Override
	 public Bent getBentById(Long id) {
		 return getBentDAO().getBentById(id);
	 }
	
	 
	 @Override
	 public List<Bent> getBentler() {
		 return getBentDAO().getBentler();
	 }
	
	 @Override
	 public List<Bent> getBentlerByFikraId(Long fikraId){
		 return getBentDAO().getBentlerByFikraId(fikraId);
	 }
	
	 public IBentDAO getBentDAO() {
		 return bentDAO;
	 }
	
	 
	 public void setBentDAO(IBentDAO bentDAO) {
		 this.bentDAO = bentDAO;
	 }
}