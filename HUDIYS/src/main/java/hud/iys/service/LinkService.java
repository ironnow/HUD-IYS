package hud.iys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hud.iys.model.Link;
import hud.iys.model.Mevzuat;
import hud.iys.dao.ILinkDAO;

@Transactional(readOnly = true)
public class LinkService implements ILinkService {
	
	 ILinkDAO linkDAO;
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void addLink(Link link) {
		 getLinkDAO().addLink(link);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void deleteLink(Link link) {
		 getLinkDAO().deleteLink(link);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void updateLink(Link link) {
		 getLinkDAO().updateLink(link);
	 }
	
	 @Override
	 public Link getLinkById(Long id) {
		 return getLinkDAO().getLinkById(id);
	 }
	
	 
	 @Override
	 public List<Link> getLinkler() {
		 return getLinkDAO().getLinkler();
	 }
	
	 @Override
	 public List<Link> getLinklerByFromId(Long fromId){
		 return getLinkDAO().getLinklerByFromId(fromId);
	 }
	
	 public ILinkDAO getLinkDAO() {
		 return linkDAO;
	 }
	
	 
	 public void setLinkDAO(ILinkDAO linkDAO) {
		 this.linkDAO = linkDAO;
	 }
}