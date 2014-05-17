package hud.iys.dao;

import java.util.List;

import hud.iys.model.MevzuatSeti;

import org.hibernate.SessionFactory;


public class MevzuatSetiDAO implements IMevzuatSetiDAO {

	 private SessionFactory sessionFactory;
	
	 
	 public SessionFactory getSessionFactory() {
		 return sessionFactory;
	 }
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	
	 @Override
	 public void addMevzuatSeti(MevzuatSeti mevzuatSeti) {
		 getSessionFactory().getCurrentSession().save(mevzuatSeti);
	 }
	
	
	 @Override
	 public void deleteMevzuatSeti(MevzuatSeti mevzuatSeti) {
		 getSessionFactory().getCurrentSession().delete(mevzuatSeti);
	 }
	
	 @Override
	 public void updateMevzuatSeti(MevzuatSeti mevzuatSeti) {
		 getSessionFactory().getCurrentSession().update(mevzuatSeti);
	 }
	
	 
	 @Override
	 public MevzuatSeti getMevzuatSetiById(int id) {
		 List list = getSessionFactory().getCurrentSession()
	           .createQuery("from MevzuatSeti where mevzuatSetiId=?")
	                 .setParameter(0, id).list();
	  	return (MevzuatSeti)list.get(0);
	 }
	
	
	 @Override
	 public List<MevzuatSeti> getMevzuatSetleri() {
		 List list = getSessionFactory().getCurrentSession().createQuery("from MevzuatSeti").list();
		 return list;
	 }

}