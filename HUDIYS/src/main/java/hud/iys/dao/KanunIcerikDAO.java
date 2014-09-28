package hud.iys.dao;

import java.util.List;

import hud.iys.model.Kanun;
import hud.iys.model.KanunIcerik;
import hud.iys.model.KanunIcerik_TEMP;

import org.hibernate.Query;
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
	 public KanunIcerik getKanunIcerikById(Long id) {
		 List list = getSessionFactory().getCurrentSession()
	           .createQuery("from KanunIcerik where kanunIcerikId=?")
	                 .setParameter(0, id).list();
	  	return (KanunIcerik)list.get(0);
	 }
	 
	 @Override
	 public KanunIcerik getKanunIcerikByParentId(Long parentId) {
		 List list = getSessionFactory().getCurrentSession()
	           .createQuery("from KanunIcerik where parentId=?")
	                 .setParameter(0, parentId).list();
	  	return (KanunIcerik)list.get(0);
	 }
	 
	 @Override
	 public KanunIcerik getKanunIcerikByParentLeftId(Long parentId) {
		 Query query = getSessionFactory().getCurrentSession().createQuery("from KanunIcerik where parentId=? and leftId=null");
		 query.setParameter(0, parentId);
		 List list = query.list();
		 if (list != null && list.size() != 0) {
			 return (KanunIcerik)list.get(0);
		 }
		 else return null;
	 }
	 
	 @Override
	 public KanunIcerik getKanunIcerikByParentRightId(Long parentId) {
		 Query query = getSessionFactory().getCurrentSession().createQuery("from KanunIcerik where parentId=? and rightId=null");
		 query.setParameter(0, parentId);
		 List list = query.list();
		 if (list != null && list.size() != 0) {
			 return (KanunIcerik)list.get(0);
		 }
		 else return null;
	 }
	
	
	 @Override
	 public List<KanunIcerik> getKanunIcerikleri() {
		 List list = getSessionFactory().getCurrentSession().createQuery("from KanunIcerik").list();
		 return list;
	 }
	 
	 @Override
	 public List<KanunIcerik> getKanunIcerikleriByKanunId(Long kanunId){
		 List list = getSessionFactory().getCurrentSession()
		           .createQuery("from KanunIcerik where KanunId=?")
		                 .setParameter(0, kanunId).list();
		  	 return list;
	 }

	 @Override
	 public List<KanunIcerik_TEMP> getKanunIcerikTree(Long rootId){
		 Query query = getSessionFactory().getCurrentSession().createSQLQuery("CALL GetTree(:GivenID, :initial)");
		 query.setParameter("GivenID", rootId);
		 query.setParameter("initial", 1);
		 List list = getSessionFactory().getCurrentSession().createQuery("from KanunIcerik_TEMP").list();
		 return list;
	 }
}