package hud.iys.dao;

import java.util.List;

import hud.iys.model.MaddeIcerik;
import hud.iys.model.KanunIcerik;

import org.hibernate.SessionFactory;


public class MaddeIcerikDAO implements IMaddeIcerikDAO {

	 private SessionFactory sessionFactory;
	
	 
	 public SessionFactory getSessionFactory() {
		 return sessionFactory;
	 }
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	
	 @Override
	 public void addMaddeIcerik(MaddeIcerik maddeIcerik) {
		 getSessionFactory().getCurrentSession().save(maddeIcerik);
	 }
	
	
	 @Override
	 public void deleteMaddeIcerik(MaddeIcerik maddeIcerik) {
		 getSessionFactory().getCurrentSession().delete(maddeIcerik);
	 }
	
	 @Override
	 public void updateMaddeIcerik(MaddeIcerik maddeIcerik) {
		 getSessionFactory().getCurrentSession().update(maddeIcerik);
	 }
	
	 
	 @Override
	 public MaddeIcerik getMaddeIcerikById(Long id) {
		 List list = getSessionFactory().getCurrentSession()
	           .createQuery("from MaddeIcerik where maddeIcerikId=?")
	                 .setParameter(0, id).list();
		if (list!=null && list.size()>0){
			return (MaddeIcerik)list.get(0);
		}
		else {
			return null;
		}
		
	 }
	
	
	 @Override
	 public List<MaddeIcerik> getMaddeIcerikleri() {
		 List list = getSessionFactory().getCurrentSession().createQuery("from MaddeIcerik").list();
		 return list;
	 }
	 
	 @Override
	 public List<MaddeIcerik> getMaddeIcerikleriByKanunIcerikId(Long kanunIcerikId){
		 List list = getSessionFactory().getCurrentSession()
		           .createQuery("from MaddeIcerik where KanunIcerikId=?")
		                 .setParameter(0, kanunIcerikId).list();
		  	 return list;
	 }

}