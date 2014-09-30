package hud.iys.dao;

import java.util.List;

import hud.iys.model.TebligIcerik;

import org.hibernate.SessionFactory;


public class TebligIcerikDAO implements ITebligIcerikDAO {

	 private SessionFactory sessionFactory;
	
	 
	 public SessionFactory getSessionFactory() {
		 return sessionFactory;
	 }
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	
	 @Override
	 public void addTebligIcerik(TebligIcerik tebligIcerik) {
		 getSessionFactory().getCurrentSession().save(tebligIcerik);
	 }
	
	
	 @Override
	 public void deleteTebligIcerik(TebligIcerik tebligIcerik) {
		 getSessionFactory().getCurrentSession().delete(tebligIcerik);
	 }
	
	 @Override
	 public void updateTebligIcerik(TebligIcerik tebligIcerik) {
		 getSessionFactory().getCurrentSession().update(tebligIcerik);
	 }
	
	 
	 @Override
	 public TebligIcerik getTebligIcerikById(Long id) {
		 List list = getSessionFactory().getCurrentSession()
	           .createQuery("from TebligIcerik where tebligIcerikId=?")
	                 .setParameter(0, id).list();
	  	return (TebligIcerik)list.get(0);
	 }
	
	
	 @Override
	 public List<TebligIcerik> getTebligIcerikleri() {
		 List list = getSessionFactory().getCurrentSession().createQuery("from TebligIcerik").list();
		 return list;
	 }
	 
	 @Override
	 public List<TebligIcerik> getTebligIcerikleriByTebligId(Long tebligId){
		 List list = getSessionFactory().getCurrentSession()
		           .createQuery("from TebligIcerik where TebligId=?")
		                 .setParameter(0, tebligId).list();
		  	 return list;
	 }

}