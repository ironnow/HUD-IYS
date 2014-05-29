package hud.iys.dao;

import java.util.List;

import hud.iys.model.Kanun;
import hud.iys.model.KanunIcerik;

import org.hibernate.SessionFactory;


public class KanunIcerikDAO implements IKanunIcerikDAO {

	 private SessionFactory sessionFactory;
	
	 
	 public SessionFactory getSessionFactory() {
		 return sessionFactory;
	 }
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	
	 @Override
	 public void addKanunIcerik(KanunIcerik kanunIcerik) {
		 getSessionFactory().getCurrentSession().save(kanunIcerik);
	 }
	
	
	 @Override
	 public void deleteKanunIcerik(KanunIcerik kanunIcerik) {
		 getSessionFactory().getCurrentSession().delete(kanunIcerik);
	 }
	
	 @Override
	 public void updateKanunIcerik(KanunIcerik kanunIcerik) {
		 getSessionFactory().getCurrentSession().update(kanunIcerik);
	 }
	
	 
	 @Override
	 public KanunIcerik getKanunIcerikById(int id) {
		 List list = getSessionFactory().getCurrentSession()
	           .createQuery("from KanunIcerik where kanunIcerikId=?")
	                 .setParameter(0, id).list();
	  	return (KanunIcerik)list.get(0);
	 }
	
	
	 @Override
	 public List<KanunIcerik> getKanunIcerikleri() {
		 List list = getSessionFactory().getCurrentSession().createQuery("from KanunIcerik").list();
		 return list;
	 }
	 
	 @Override
	 public List<KanunIcerik> getKanunIcerikleriByKanunId(int kanunId){
		 List list = getSessionFactory().getCurrentSession()
		           .createQuery("from KanunIcerik where KanunId=?")
		                 .setParameter(0, kanunId).list();
		  	 return list;
	 }

}