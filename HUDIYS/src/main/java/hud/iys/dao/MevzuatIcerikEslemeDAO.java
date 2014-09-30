package hud.iys.dao;

import java.util.List;

import hud.iys.model.MevzuatIcerikEsleme;
import hud.iys.model.Mevzuat;

import org.hibernate.SessionFactory;


public class MevzuatIcerikEslemeDAO implements IMevzuatIcerikEslemeDAO {

	 private SessionFactory sessionFactory;
	
	 
	 public SessionFactory getSessionFactory() {
		 return sessionFactory;
	 }
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	
	 @Override
	 public void addMevzuatIcerikEsleme(MevzuatIcerikEsleme mevzuatIcerikEsleme) {
		 getSessionFactory().getCurrentSession().save(mevzuatIcerikEsleme);
	 }
	
	
	 @Override
	 public void deleteMevzuatIcerikEsleme(MevzuatIcerikEsleme mevzuatIcerikEsleme) {
		 getSessionFactory().getCurrentSession().delete(mevzuatIcerikEsleme);
	 }
	
	 @Override
	 public void updateMevzuatIcerikEsleme(MevzuatIcerikEsleme mevzuatIcerikEsleme) {
		 getSessionFactory().getCurrentSession().update(mevzuatIcerikEsleme);
	 }
	
	 
	 @Override
	 public MevzuatIcerikEsleme getMevzuatIcerikEslemeById(Long id) {
		 List list = getSessionFactory().getCurrentSession()
	           .createQuery("from MevzuatIcerikEsleme where id=?")
	                 .setParameter(0, id).list();
	  	return (MevzuatIcerikEsleme)list.get(0);
	 }
	
	
	 @Override
	 public List<MevzuatIcerikEsleme> getMevzuatIcerikEslemeleri() {
		 List list = getSessionFactory().getCurrentSession().createQuery("from MevzuatIcerikEsleme").list();
		 return list;
	 }
	 
	 @Override
	 public List<MevzuatIcerikEsleme> getMevzuatIcerikEslemeleriByMevzuatId(Long mevzuatId){
		 List list = getSessionFactory().getCurrentSession()
		           .createQuery("from MevzuatIcerikEsleme where MevzuatId=?")
		                 .setParameter(0, mevzuatId).list();
		  	 return list;
	 }

}