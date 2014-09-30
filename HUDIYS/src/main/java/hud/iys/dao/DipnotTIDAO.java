package hud.iys.dao;

import java.util.List;

import hud.iys.model.DipnotTI;

import org.hibernate.SessionFactory;


public class DipnotTIDAO implements IDipnotTIDAO {

	 private SessionFactory sessionFactory;
	
	 
	 public SessionFactory getSessionFactory() {
		 return sessionFactory;
	 }
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	
	 @Override
	 public void addDipnot(DipnotTI dipnot) {
		 getSessionFactory().getCurrentSession().save(dipnot);
	 }
	
	
	 @Override
	 public void deleteDipnot(DipnotTI dipnot) {
		 getSessionFactory().getCurrentSession().delete(dipnot);
	 }
	
	 @Override
	 public void updateDipnot(DipnotTI dipnot) {
		 getSessionFactory().getCurrentSession().update(dipnot);
	 }
	
	 
	 @Override
	 public DipnotTI getDipnotById(Long id) {
		 List list = getSessionFactory().getCurrentSession()
	           .createQuery("from Dipnot where dipnotId=?")
	                 .setParameter(0, id).list();
	  	 return (DipnotTI)list.get(0);
	 }
	
	
	 @Override
	 public List<DipnotTI> getDipnotlar() {
		 List list = getSessionFactory().getCurrentSession().createQuery("from Dipnot").list();
		 return list;
	 }
	 
	 @Override
	 public List<DipnotTI> getDipnotlarByTebligIcerikId(Long tebligIcerikId){
		 List list = getSessionFactory().getCurrentSession()
		           .createQuery("from Dipnot where TebligIcerikId=?")
		                 .setParameter(0, tebligIcerikId).list();
		  	 return list;
	 }
	 

}