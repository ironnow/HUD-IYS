package hud.iys.dao;

import java.util.List;

import hud.iys.model.Attachment;
import hud.iys.model.Mevzuat;

import org.hibernate.SessionFactory;


public class AttachmentDAO implements IAttachmentDAO {

	 private SessionFactory sessionFactory;
	
	 
	 public SessionFactory getSessionFactory() {
		 return sessionFactory;
	 }
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	
	 @Override
	 public void addAttachment(Attachment attachment) {
		 getSessionFactory().getCurrentSession().save(attachment);
	 }
	
	
	 @Override
	 public void deleteAttachment(Attachment attachment) {
		 getSessionFactory().getCurrentSession().delete(attachment);
	 }
	
	 @Override
	 public void updateAttachment(Attachment attachment) {
		 getSessionFactory().getCurrentSession().update(attachment);
	 }
	
	 
	 @Override
	 public Attachment getAttachmentById(Long id) {
		 List list = getSessionFactory().getCurrentSession()
	           .createQuery("from Attachment where attachmentId=?")
	                 .setParameter(0, id).list();
	  	return (Attachment)list.get(0);
	 }
	
	
	 @Override
	 public List<Attachment> getAttachmentlar() {
		 List list = getSessionFactory().getCurrentSession().createQuery("from Attachment").list();
		 return list;
	 }
	 
	 @Override
	 public List<Attachment> getAttachmentlarByTypeAndFromId(int fromTypeId, Long fromId){
		 List list = getSessionFactory().getCurrentSession()
		           .createQuery("from Attachment where fromTypeId=? and fromId=?")
		           .setParameter(0, fromTypeId)      
		           .setParameter(1, fromId).list();
		  	 return list;
	 }

}