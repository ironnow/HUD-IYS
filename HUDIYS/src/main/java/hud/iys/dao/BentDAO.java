package hud.iys.dao;

import java.util.List;

import hud.iys.model.Bent;

import org.hibernate.SessionFactory;


public class BentDAO implements IBentDAO {

	 private SessionFactory sessionFactory;
	
	 
	 public SessionFactory getSessionFactory() {
		 return sessionFactory;
	 }
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	
	 @Override
	 public void addBent(Bent bent) {
		 getSessionFactory().getCurrentSession().save(bent);
	 }
	
	
	 @Override
	 public void deleteBent(Bent bent) {
		 getSessionFactory().getCurrentSession().delete(bent);
	 }
	
	 @Override
	 public void updateBent(Bent bent) {
		 getSessionFactory().getCurrentSession().update(bent);
	 }
	
	 
	 @Override
	 public Bent getBentById(Long id) {
		 List list = getSessionFactory().getCurrentSession()
	           .createQuery("from Bent where id=?")
	                 .setParameter(0, id).list();
	  	 return (Bent)list.get(0);
	 }
	
	
	 @Override
	 public List<Bent> getBentler() {
		 List list = getSessionFactory().getCurrentSession().createQuery("from Bent").list();
		 return list;
	 }
	 
	 @Override
	 public List<Bent> getBentlerByFikraId(Long fikraId){
		 List list = getSessionFactory().getCurrentSession()
		           .createQuery("from Bent where ParagrafId=?")
		                 .setParameter(0, fikraId).list();
		  	 return list;
	 }
	 

}