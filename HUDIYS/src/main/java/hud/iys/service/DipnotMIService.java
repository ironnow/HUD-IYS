package hud.iys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hud.iys.model.DipnotMI;
import hud.iys.dao.IDipnotMIDAO;

@Transactional(readOnly = true)
public class DipnotMIService implements IDipnotMIService {
	
	 IDipnotMIDAO dipnotMIDAO;
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void addDipnot(DipnotMI dipnot) {
		 getDipnotMIDAO().addDipnot(dipnot);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void deleteDipnot(DipnotMI dipnot) {
		 getDipnotMIDAO().deleteDipnot(dipnot);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void updateDipnot(DipnotMI dipnot) {
		 getDipnotMIDAO().updateDipnot(dipnot);
	 }
	
	 @Override
	 public DipnotMI getDipnotById(Long id) {
		 return getDipnotMIDAO().getDipnotById(id);
	 }
	
	 
	 @Override
	 public List<DipnotMI> getDipnotlar() {
		 return getDipnotMIDAO().getDipnotlar();
	 }
	
	 @Override
	 public List<DipnotMI> getDipnotlarByMaddeIcerikId(Long maddeIcerikId){
		 return getDipnotMIDAO().getDipnotlarByMaddeIcerikId(maddeIcerikId);
	 }
	
	 public IDipnotMIDAO getDipnotMIDAO() {
		 return dipnotMIDAO;
	 }	
	 
	 public void setDipnotMIDAO(IDipnotMIDAO dipnotDAO) {
		 this.dipnotMIDAO = dipnotDAO;
	 }
}