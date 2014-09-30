package hud.iys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hud.iys.model.DipnotTI;
import hud.iys.dao.IDipnotTIDAO;

@Transactional(readOnly = true)
public class DipnotTIService implements IDipnotTIService {
	
	 IDipnotTIDAO dipnotTIDAO;
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void addDipnot(DipnotTI dipnot) {
		 getDipnotTIDAO().addDipnot(dipnot);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void deleteDipnot(DipnotTI dipnot) {
		 getDipnotTIDAO().deleteDipnot(dipnot);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void updateDipnot(DipnotTI dipnot) {
		 getDipnotTIDAO().updateDipnot(dipnot);
	 }
	
	 @Override
	 public DipnotTI getDipnotById(Long id) {
		 return getDipnotTIDAO().getDipnotById(id);
	 }
	
	 
	 @Override
	 public List<DipnotTI> getDipnotlar() {
		 return getDipnotTIDAO().getDipnotlar();
	 }
	
	 @Override
	 public List<DipnotTI> getDipnotlarByTebligIcerikId(Long tebligIcerikId){
		 return getDipnotTIDAO().getDipnotlarByTebligIcerikId(tebligIcerikId);
	 }
	
	 public IDipnotTIDAO getDipnotTIDAO() {
		 return dipnotTIDAO;
	 }	
	 
	 public void setDipnotTIDAO(IDipnotTIDAO dipnotDAO) {
		 this.dipnotTIDAO = dipnotDAO;
	 }
}