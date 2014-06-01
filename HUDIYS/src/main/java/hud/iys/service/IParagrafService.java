package hud.iys.service;

import java.util.List;

import hud.iys.model.Paragraf;


public interface IParagrafService {

	 public void addParagraf(Paragraf paragraf);
	
	 public void updateParagraf(Paragraf paragraf);
	
	 public void deleteParagraf(Paragraf paragraf);
	
	 public Paragraf getParagrafById(Long id);
	
	 public List<Paragraf> getParagraflar();
	 
	 public List<Paragraf> getParagraflarByKanunIcerikId(Long kanunIcerikId);
}