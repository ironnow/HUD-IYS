package hud.iys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hud.iys.model.Kanun;
import hud.iys.model.Mevzuat;
import hud.iys.dao.IKanunDAO;

@Transactional(readOnly = true)
public class KanunService implements IKanunService {
	
	 // UserDAO is injected...
	 IKanunDAO kanunDAO;
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void addKanun(Kanun kanun) {
		 getKanunDAO().addKanun(kanun);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void deleteKanun(Kanun kanun) {
		 getKanunDAO().deleteKanun(kanun);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void updateKanun(Kanun kanun) {
		 getKanunDAO().updateKanun(kanun);
	 }
	
	 @Override
	 public Kanun getKanunById(Long id) {
		 return getKanunDAO().getKanunById(id);
	 }
	
	 
	 @Override
	 public List<Kanun> getKanunlar() {
		 return getKanunDAO().getKanunlar();
	 }
	
	 @Override
	 public List<Kanun> getKanunlarByMevzuatId(Long mevzuatId){
		 return getKanunDAO().getKanunlarByMevzuatId(mevzuatId);
	 }
	
	 public IKanunDAO getKanunDAO() {
		 return kanunDAO;
	 }
	
	 
	 public void setKanunDAO(IKanunDAO kanunDAO) {
		 this.kanunDAO = kanunDAO;
	 }
}