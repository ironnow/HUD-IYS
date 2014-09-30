package hud.iys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hud.iys.model.Kanun;
import hud.iys.model.MaddeIcerik;
import hud.iys.dao.IMaddeIcerikDAO;

@Transactional(readOnly = true)
public class MaddeIcerikService implements IMaddeIcerikService {
	
	 // KanunIcerikDAO is injected...
	 IMaddeIcerikDAO maddeIcerikDAO;
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void addMaddeIcerik(MaddeIcerik maddeIcerik) {
		 getMaddeIcerikDAO().addMaddeIcerik(maddeIcerik);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void deleteMaddeIcerik(MaddeIcerik maddeIcerik) {
		 getMaddeIcerikDAO().deleteMaddeIcerik(maddeIcerik);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void updateMaddeIcerik(MaddeIcerik maddeIcerik) {
		 getMaddeIcerikDAO().updateMaddeIcerik(maddeIcerik);
	 }
	
	 @Override
	 public MaddeIcerik getMaddeIcerikById(Long id) {
		 return getMaddeIcerikDAO().getMaddeIcerikById(id);
	 }
	
	 
	 @Override
	 public List<MaddeIcerik> getMaddeIcerikleri() {
		 return getMaddeIcerikDAO().getMaddeIcerikleri();
	 }
	
	 @Override
	 public List<MaddeIcerik> getMaddeIcerikleriByKanunIcerikId(Long kanunIcerikId){
		 return getMaddeIcerikDAO().getMaddeIcerikleriByKanunIcerikId(kanunIcerikId);
	 }
	 
	 public IMaddeIcerikDAO getMaddeIcerikDAO() {
		 return maddeIcerikDAO;
	 }
	
	 
	 public void setMaddeIcerikDAO(IMaddeIcerikDAO maddeIcerikDAO) {
		 this.maddeIcerikDAO = maddeIcerikDAO;
	 }
}