package hud.iys.dao;

import java.util.List;

import hud.iys.model.Kanun;
import hud.iys.model.Mevzuat;

import org.hibernate.SessionFactory;


public class KanunDAO implements IKanunDAO {

	 private SessionFactory sessionFactory;
	
	 
	 public SessionFactory getSessionFactory() {
		 return sessionFactory;
	 }
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	
	 @Override
	 public void addKanun(Kanun kanun) {
		 getSessionFactory().getCurrentSession().save(kanun);
	 }
	
	
	 @Override
	 public void deleteKanun(Kanun kanun) {
		 getSessionFactory().getCurrentSession().delete(kanun);
	 }
	
	 @Override
	 public void updateKanun(Kanun kanun) {
		 getSessionFactory().getCurrentSession().update(kanun);
	 }
	
	 
	 @Override
	 public Kanun getKanunById(int id) {
		 List list = getSessionFactory().getCurrentSession()
	           .createQuery("from Kanun where id=?")
	                 .setParameter(0, id).list();
	  	return (Kanun)list.get(0);
	 }
	
	
	 @Override
	 public List<Kanun> getKanunlar() {
		 List list = getSessionFactory().getCurrentSession().createQuery("from Kanun").list();
		 return list;
	 }
	 
	 @Override
	 public List<Kanun> getKanunlarByMevzuatId(int mevzuatId){
		 List list = getSessionFactory().getCurrentSession()
		           .createQuery("from Kanun where MevzuatId=?")
		                 .setParameter(0, mevzuatId).list();
		  	 return list;
	 }

}