package hud.iys.service;

import java.util.List;

import hud.iys.model.TebligMaddeIcerik;

public interface ITebligMaddeIcerikService {

	 public void addTebligMaddeIcerik(TebligMaddeIcerik maddeIcerik);
	
	 public void updateTebligMaddeIcerik(TebligMaddeIcerik maddeIcerik);
	
	 public void deleteTebligMaddeIcerik(TebligMaddeIcerik maddeIcerik);
	
	 public TebligMaddeIcerik getTebligMaddeIcerikById(Long id);
	
	 public List<TebligMaddeIcerik> getTebligMaddeIcerikleri();
	 
	 public List<TebligMaddeIcerik> getTebligMaddeIcerikleriByTebligIcerikId(Long tebligIcerikId);
}