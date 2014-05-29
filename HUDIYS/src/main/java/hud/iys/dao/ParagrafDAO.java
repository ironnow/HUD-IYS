package hud.iys.dao;

import java.util.List;

import hud.iys.model.Paragraf;

import org.hibernate.SessionFactory;


public class ParagrafDAO implements IParagrafDAO {

	 private SessionFactory sessionFactory;
	
	 
	 public SessionFactory getSessionFactory() {
		 return sessionFactory;
	 }
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	
	 @Override
	 public void addParagraf(Paragraf paragraf) {
		 getSessionFactory().getCurrentSession().save(paragraf);
	 }
	
	
	 @Override
	 public void deleteParagraf(Paragraf paragraf) {
		 getSessionFactory().getCurrentSession().delete(paragraf);
	 }
	
	 @Override
	 public void updateParagraf(Paragraf paragraf) {
		 getSessionFactory().getCurrentSession().update(paragraf);
	 }
	
	 
	 @Override
	 public Paragraf getParagrafById(int id) {
		 List list = getSessionFactory().getCurrentSession()
	           .createQuery("from Paragraf where id=?")
	                 .setParameter(0, id).list();
	  	 return (Paragraf)list.get(0);
	 }
	
	 @Override
	 public List<Paragraf> getParagraflar() {
		 List list = getSessionFactory().getCurrentSession().createQuery("from Paragraf").list();
		 return list;
	 }
	 
	 @Override
	 public List<Paragraf> getParagraflarByKanunIcerikId(int kanunIcerikId){
		 List list = getSessionFactory().getCurrentSession()
		           .createQuery("from Paragraf where KanunIcerikId=?")
		                 .setParameter(0, kanunIcerikId).list();
		  	 return list;
	 }
	 

}