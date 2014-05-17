package hud.iys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hud.iys.model.KanunIcerik;
import hud.iys.dao.IKanunIcerikDAO;

@Transactional(readOnly = true)
public class KanunIcerikService implements IKanunIcerikService {
	
	 // KanunIcerikDAO is injected...
	 IKanunIcerikDAO kanunIcerikDAO;
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void addKanunIcerik(KanunIcerik kanunIcerik) {
		 getKanunIcerikDAO().addKanunIcerik(kanunIcerik);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void deleteKanunIcerik(KanunIcerik kanunIcerik) {
		 getKanunIcerikDAO().deleteKanunIcerik(kanunIcerik);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void updateKanunIcerik(KanunIcerik kanunIcerik) {
		 getKanunIcerikDAO().updateKanunIcerik(kanunIcerik);
	 }
	
	 @Override
	 public KanunIcerik getKanunIcerikById(int id) {
		 return getKanunIcerikDAO().getKanunIcerikById(id);
	 }
	
	 
	 @Override
	 public List<KanunIcerik> getKanunIcerikleri() {
		 return getKanunIcerikDAO().getKanunIcerikleri();
	 }
	
	
	 public IKanunIcerikDAO getKanunIcerikDAO() {
		 return kanunIcerikDAO;
	 }
	
	 
	 public void setKanunIcerikDAO(IKanunIcerikDAO kanunIcerikDAO) {
		 this.kanunIcerikDAO = kanunIcerikDAO;
	 }
}