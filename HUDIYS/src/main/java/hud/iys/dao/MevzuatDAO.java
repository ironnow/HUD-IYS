package hud.iys.dao;

import java.util.List;

import hud.iys.model.Mevzuat;

import org.hibernate.SessionFactory;


public class MevzuatDAO implements IMevzuatDAO {

	 private SessionFactory sessionFactory;
	
	 
	 public SessionFactory getSessionFactory() {
		 return sessionFactory;
	 }
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	
	 @Override
	 public void addMevzuat(Mevzuat mevzuat) {
		 getSessionFactory().getCurrentSession().save(mevzuat);
	 }
	
	
	 @Override
	 public void deleteMevzuat(Mevzuat mevzuat) {
		 getSessionFactory().getCurrentSession().delete(mevzuat);
	 }
	
	 @Override
	 public void updateMevzuat(Mevzuat mevzuat) {
		 getSessionFactory().getCurrentSession().update(mevzuat);
	 }
	
	 
	 @Override
	 public Mevzuat getMevzuatById(int id) {
		 List list = getSessionFactory().getCurrentSession()
	           .createQuery("from Mevzuat where id=?")
	                 .setParameter(0, id).list();
	  	 return (Mevzuat)list.get(0);
	 }
	
	
	 @Override
	 public List<Mevzuat> getMevzuatlar() {
		 List list = getSessionFactory().getCurrentSession().createQuery("from Mevzuat").list();
		 return list;
	 }
	 
	 @Override
	 public List<Mevzuat> getMevzuatlarByMevzuatSetiId(int mevzuatSetiId){
		 List list = getSessionFactory().getCurrentSession()
		           .createQuery("from Mevzuat where MevzuatSetiId=?")
		                 .setParameter(0, mevzuatSetiId).list();
		  	 return list;
	 }
	 

}