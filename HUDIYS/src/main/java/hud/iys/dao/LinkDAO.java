package hud.iys.dao;

import java.util.List;

import hud.iys.model.Link;
import hud.iys.model.Mevzuat;

import org.hibernate.SessionFactory;


public class LinkDAO implements ILinkDAO {

	 private SessionFactory sessionFactory;
	
	 
	 public SessionFactory getSessionFactory() {
		 return sessionFactory;
	 }
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	
	 @Override
	 public void addLink(Link link) {
		 getSessionFactory().getCurrentSession().save(link);
	 }
	
	
	 @Override
	 public void deleteLink(Link link) {
		 getSessionFactory().getCurrentSession().delete(link);
	 }
	
	 @Override
	 public void updateLink(Link link) {
		 getSessionFactory().getCurrentSession().update(link);
	 }
	
	 
	 @Override
	 public Link getLinkById(Long id) {
		 List list = getSessionFactory().getCurrentSession()
	           .createQuery("from Link where linkId=?")
	                 .setParameter(0, id).list();
	  	return (Link)list.get(0);
	 }
	
	
	 @Override
	 public List<Link> getLinkler() {
		 List list = getSessionFactory().getCurrentSession().createQuery("from Link").list();
		 return list;
	 }
	 
	 @Override
	 public List<Link> getLinklerByFromId(Long fromId){
		 List list = getSessionFactory().getCurrentSession()
		           .createQuery("from Link where FromId=?")
		                 .setParameter(0, fromId).list();
		  	 return list;
	 }

}