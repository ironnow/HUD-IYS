package hud.iys.dao;

import java.util.List;

import hud.iys.model.Bent;

public interface IBentDAO {

	 public void addBent(Bent bent);
	
	 public void updateBent(Bent bent);
	
	 public void deleteBent(Bent bent);
	
	 public Bent getBentById(int id);
	
	 public List<Bent> getBentler();
	 
	 public List<Bent> getBentlerByParagrafId(int paragrafId);
}