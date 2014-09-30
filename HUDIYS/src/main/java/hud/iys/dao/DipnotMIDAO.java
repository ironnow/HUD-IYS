package hud.iys.dao;

import java.util.List;

import hud.iys.model.DipnotMI;

import org.hibernate.SessionFactory;


public class DipnotMIDAO implements IDipnotMIDAO {

	 private SessionFactory sessionFactory;
	
	 
	 public SessionFactory getSessionFactory() {
		 return sessionFactory;
	 }
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	
	 @Override
	 public void addDipnot(DipnotMI dipnot) {
		 getSessionFactory().getCurrentSession().save(dipnot);
	 }
	
	
	 @Override
	 public void deleteDipnot(DipnotMI dipnot) {
		 getSessionFactory().getCurrentSession().delete(dipnot);
	 }
	
	 @Override
	 public void updateDipnot(DipnotMI dipnot) {
		 getSessionFactory().getCurrentSession().update(dipnot);
	 }
	
	 
	 @Override
	 public DipnotMI getDipnotById(Long id) {
		 List list = getSessionFactory().getCurrentSession()
	           .createQuery("from Dipnot where dipnotId=?")
	                 .setParameter(0, id).list();
	  	 return (DipnotMI)list.get(0);
	 }
	
	
	 @Override
	 public List<DipnotMI> getDipnotlar() {
		 List list = getSessionFactory().getCurrentSession().createQuery("from Dipnot").list();
		 return list;
	 }
	 
	 @Override
	 public List<DipnotMI> getDipnotlarByMaddeIcerikId(Long maddeIcerikId){
		 List list = getSessionFactory().getCurrentSession()
		           .createQuery("from Dipnot where MaddeIcerikId=?")
		                 .setParameter(0, maddeIcerikId).list();
		  	 return list;
	 }
	 

}