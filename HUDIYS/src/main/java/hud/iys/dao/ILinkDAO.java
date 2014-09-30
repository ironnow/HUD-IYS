package hud.iys.dao;

import java.util.List;

import hud.iys.model.Link;


public interface ILinkDAO {

	 public void addLink(Link link);
	
	 public void updateLink(Link link);
	
	 public void deleteLink(Link link);
	
	 public Link getLinkById(Long id);
	
	 public List<Link> getLinkler();
	 
	 public List<Link> getLinklerByFromId(Long fromId);
}