package hud.iys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hud.iys.model.DipnotKI;
import hud.iys.dao.IDipnotKIDAO;

@Transactional(readOnly = true)
public class DipnotKIService implements IDipnotKIService {
	
	 IDipnotKIDAO dipnotKIDAO;
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void addDipnot(DipnotKI dipnot) {
		 getDipnotKIDAO().addDipnot(dipnot);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void deleteDipnot(DipnotKI dipnot) {
		 getDipnotKIDAO().deleteDipnot(dipnot);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void updateDipnot(DipnotKI dipnot) {
		 getDipnotKIDAO().updateDipnot(dipnot);
	 }
	
	 @Override
	 public DipnotKI getDipnotById(Long id) {
		 return getDipnotKIDAO().getDipnotById(id);
	 }
	
	 
	 @Override
	 public List<DipnotKI> getDipnotlar() {
		 return getDipnotKIDAO().getDipnotlar();
	 }
	
	 @Override
	 public List<DipnotKI> getDipnotlarByKanunIcerikId(Long kanunIcerikId){
		 return getDipnotKIDAO().getDipnotlarByKanunIcerikId(kanunIcerikId);
	 }
	
	 public IDipnotKIDAO getDipnotKIDAO() {
		 return dipnotKIDAO;
	 }	
	 
	 public void setDipnotKIDAO(IDipnotKIDAO dipnotDAO) {
		 this.dipnotKIDAO = dipnotDAO;
	 }
}