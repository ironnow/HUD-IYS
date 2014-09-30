package hud.iys.service;

import java.util.List;

import hud.iys.model.TebligIcerik;


public interface ITebligIcerikService {

	 public void addTebligIcerik(TebligIcerik tebligIcerik);
	
	 public void updateTebligIcerik(TebligIcerik tebligIcerik);
	
	 public void deleteTebligIcerik(TebligIcerik tebligIcerik);
	
	 public TebligIcerik getTebligIcerikById(Long id);
	
	 public List<TebligIcerik> getTebligIcerikleri();
	 
	 public List<TebligIcerik> getTebligIcerikleriByTebligId(Long tebligId);
}