package hud.iys.dao;

import java.util.List;

import hud.iys.model.TebligMaddeIcerik;
import hud.iys.model.KanunIcerik;

import org.hibernate.SessionFactory;


public class TebligMaddeIcerikDAO implements ITebligMaddeIcerikDAO {

	 private SessionFactory sessionFactory;
	
	 
	 public SessionFactory getSessionFactory() {
		 return sessionFactory;
	 }
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	
	 @Override
	 public void addTebligMaddeIcerik(TebligMaddeIcerik tebligMaddeIcerik) {
		 getSessionFactory().getCurrentSession().save(tebligMaddeIcerik);
	 }
	
	
	 @Override
	 public void deleteTebligMaddeIcerik(TebligMaddeIcerik tebligMaddeIcerik) {
		 getSessionFactory().getCurrentSession().delete(tebligMaddeIcerik);
	 }
	
	 @Override
	 public void updateTebligMaddeIcerik(TebligMaddeIcerik tebligMaddeIcerik) {
		 getSessionFactory().getCurrentSession().update(tebligMaddeIcerik);
	 }
	
	 
	 @Override
	 public TebligMaddeIcerik getTebligMaddeIcerikById(Long id) {
		 List list = getSessionFactory().getCurrentSession()
	           .createQuery("from TebligMaddeIcerik where tebligMaddeIcerikId=?")
	                 .setParameter(0, id).list();
		if (list!=null && list.size()>0){
			return (TebligMaddeIcerik)list.get(0);
		}
		else {
			return null;
		}
		
	 }
	
	
	 @Override
	 public List<TebligMaddeIcerik> getTebligMaddeIcerikleri() {
		 List list = getSessionFactory().getCurrentSession().createQuery("from TebligMaddeIcerik").list();
		 return list;
	 }
	 
	 @Override
	 public List<TebligMaddeIcerik> getTebligMaddeIcerikleriByTebligIcerikId(Long tebligIcerikId){
		 List list = getSessionFactory().getCurrentSession()
		           .createQuery("from TebligMaddeIcerik where TebligIcerikId=?")
		                 .setParameter(0, tebligIcerikId).list();
		  	 return list;
	 }

}