package hud.iys.dao;

import java.util.List;

import hud.iys.model.MevzuatIcerikTip;
import hud.iys.model.Mevzuat;

import org.hibernate.SessionFactory;


public class MevzuatIcerikTipDAO implements IMevzuatIcerikTipDAO {

	 private SessionFactory sessionFactory;
	
	 
	 public SessionFactory getSessionFactory() {
		 return sessionFactory;
	 }
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	
	 @Override
	 public void addMevzuatIcerikTip(MevzuatIcerikTip mevzuatIcerikTip) {
		 getSessionFactory().getCurrentSession().save(mevzuatIcerikTip);
	 }
	
	
	 @Override
	 public void deleteMevzuatIcerikTip(MevzuatIcerikTip mevzuatIcerikTip) {
		 getSessionFactory().getCurrentSession().delete(mevzuatIcerikTip);
	 }
	
	 @Override
	 public void updateMevzuatIcerikTip(MevzuatIcerikTip mevzuatIcerikTip) {
		 getSessionFactory().getCurrentSession().update(mevzuatIcerikTip);
	 }
	
	 
	 @Override
	 public MevzuatIcerikTip getMevzuatIcerikTipById(Long id) {
		 List list = getSessionFactory().getCurrentSession()
	           .createQuery("from MevzuatIcerikTip where id=?")
	                 .setParameter(0, id).list();
	  	return (MevzuatIcerikTip)list.get(0);
	 }
	
	
	 @Override
	 public List<MevzuatIcerikTip> getMevzuatIcerikTipleri() {
		 List list = getSessionFactory().getCurrentSession().createQuery("from MevzuatIcerikTip").list();
		 return list;
	 }
	 
	 @Override
	 public MevzuatIcerikTip getMevzuatIcerikTipIdByName(String mevzuatIcerikTipName){
		 List list = getSessionFactory().getCurrentSession()
		           .createQuery("from MevzuatIcerikTip where mevzuatIcerikTipAdi=?")
		                 .setParameter(0, mevzuatIcerikTipName).list();
		  	return (MevzuatIcerikTip)list.get(0);
	 }

}