package hud.iys.dao;

import java.util.List;

import hud.iys.model.Paragraf;

public interface IParagrafDAO {

	 public void addParagraf(Paragraf paragraf);
	
	 public void updateParagraf(Paragraf paragraf);
	
	 public void deleteParagraf(Paragraf paragraf);
	
	 public Paragraf getParagrafById(int id);
	
	 public List<Paragraf> getParagraflar();
	 
	 public List<Paragraf> getParagraflarByKanunIcerikId(int kanunIcerikId);
}