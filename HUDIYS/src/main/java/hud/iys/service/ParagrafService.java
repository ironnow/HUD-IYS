package hud.iys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hud.iys.model.Paragraf;
import hud.iys.dao.IParagrafDAO;

@Transactional(readOnly = true)
public class ParagrafService implements IParagrafService {
	
	 // MevzuatDAO is injected...
	 IParagrafDAO paragrafDAO;
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void addParagraf(Paragraf paragraf) {
		 getParagrafDAO().addParagraf(paragraf);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void deleteParagraf(Paragraf mevzuat) {
		 getParagrafDAO().deleteParagraf(mevzuat);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void updateParagraf(Paragraf mevzuat) {
		 getParagrafDAO().updateParagraf(mevzuat);
	 }
	
	 @Override
	 public Paragraf getParagrafById(int id) {
		 return getParagrafDAO().getParagrafById(id);
	 }
	
	 
	 @Override
	 public List<Paragraf> getParagraflar() {
		 return getParagrafDAO().getParagraflar();
	 }
	
	 @Override
	 public List<Paragraf> getParagraflarByKanunIcerikId(int kanunIcerikId){
		 return getParagrafDAO().getParagraflarByKanunIcerikId(kanunIcerikId);
	 }
	
	 public IParagrafDAO getParagrafDAO() {
		 return paragrafDAO;
	 }	
	 
	 public void setParagrafDAO(IParagrafDAO paragrafDAO) {
		 this.paragrafDAO = paragrafDAO;
	 }
}