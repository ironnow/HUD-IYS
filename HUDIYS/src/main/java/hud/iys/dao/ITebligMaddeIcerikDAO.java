package hud.iys.dao;

import java.util.List;

import hud.iys.model.TebligMaddeIcerik;
import hud.iys.model.KanunIcerik;

public interface ITebligMaddeIcerikDAO {

	 public void addTebligMaddeIcerik(TebligMaddeIcerik tebligMaddeIcerik);
	
	 public void updateTebligMaddeIcerik(TebligMaddeIcerik tebligMaddeIcerik);
	
	 public void deleteTebligMaddeIcerik(TebligMaddeIcerik tebligMaddeIcerik);
	
	 public TebligMaddeIcerik getTebligMaddeIcerikById(Long id);
	
	 public List<TebligMaddeIcerik> getTebligMaddeIcerikleri();
	 
	 public List<TebligMaddeIcerik> getTebligMaddeIcerikleriByTebligIcerikId(Long tebligIcerikId);
}