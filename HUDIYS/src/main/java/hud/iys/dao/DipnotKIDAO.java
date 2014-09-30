package hud.iys.dao;

import java.util.List;

import hud.iys.model.DipnotKI;

import org.hibernate.SessionFactory;


public class DipnotKIDAO implements IDipnotKIDAO {

	 private SessionFactory sessionFactory;
	
	 
	 public SessionFactory getSessionFactory() {
		 return sessionFactory;
	 }
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	
	 @Override
	 public void addDipnot(DipnotKI dipnot) {
		 getSessionFactory().getCurrentSession().save(dipnot);
	 }
	
	
	 @Override
	 public void deleteDipnot(DipnotKI dipnot) {
		 getSessionFactory().getCurrentSession().delete(dipnot);
	 }
	
	 @Override
	 public void updateDipnot(DipnotKI dipnot) {
		 getSessionFactory().getCurrentSession().update(dipnot);
	 }
	
	 
	 @Override
	 public DipnotKI getDipnotById(Long id) {
		 List list = getSessionFactory().getCurrentSession()
	           .createQuery("from Dipnot where dipnotId=?")
	                 .setParameter(0, id).list();
	  	 return (DipnotKI)list.get(0);
	 }
	
	
	 @Override
	 public List<DipnotKI> getDipnotlar() {
		 List list = getSessionFactory().getCurrentSession().createQuery("from Dipnot").list();
		 return list;
	 }
	 
	 @Override
	 public List<DipnotKI> getDipnotlarByKanunIcerikId(Long kanunIcerikId){
		 List list = getSessionFactory().getCurrentSession()
		           .createQuery("from Dipnot where KanunIcerikId=?")
		                 .setParameter(0, kanunIcerikId).list();
		  	 return list;
	 }
	 

}