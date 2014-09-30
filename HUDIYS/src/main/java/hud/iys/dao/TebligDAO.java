package hud.iys.dao;

import java.util.List;

import hud.iys.model.Teblig;
import hud.iys.model.Mevzuat;

import org.hibernate.SessionFactory;


public class TebligDAO implements ITebligDAO {

	 private SessionFactory sessionFactory;
	
	 
	 public SessionFactory getSessionFactory() {
		 return sessionFactory;
	 }
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	
	 @Override
	 public void addTeblig(Teblig teblig) {
		 getSessionFactory().getCurrentSession().save(teblig);
	 }
	
	
	 @Override
	 public void deleteTeblig(Teblig teblig) {
		 getSessionFactory().getCurrentSession().delete(teblig);
	 }
	
	 @Override
	 public void updateTeblig(Teblig teblig) {
		 getSessionFactory().getCurrentSession().update(teblig);
	 }
	
	 
	 @Override
	 public Teblig getTebligById(Long id) {
		 List list = getSessionFactory().getCurrentSession()
	           .createQuery("from Teblig where id=?")
	                 .setParameter(0, id).list();
	  	return (Teblig)list.get(0);
	 }
	
	
	 @Override
	 public List<Teblig> getTebligler() {
		 List list = getSessionFactory().getCurrentSession().createQuery("from Teblig").list();
		 return list;
	 }
	 
	 @Override
	 public List<Teblig> getTebliglerByMevzuatId(Long mevzuatId){
		 List list = getSessionFactory().getCurrentSession()
		           .createQuery("from Teblig where MevzuatId=?")
		                 .setParameter(0, mevzuatId).list();
		  	 return list;
	 }

}