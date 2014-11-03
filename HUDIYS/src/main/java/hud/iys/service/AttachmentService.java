package hud.iys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hud.iys.model.Attachment;
import hud.iys.model.Mevzuat;
import hud.iys.dao.IAttachmentDAO;

@Transactional(readOnly = true)
public class AttachmentService implements IAttachmentService {
	
	 IAttachmentDAO attachmentDAO;
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void addAttachment(Attachment attachment) {
		 getAttachmentDAO().addAttachment(attachment);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void deleteAttachment(Attachment attachment) {
		 getAttachmentDAO().deleteAttachment(attachment);
	 }
	
	 
	 @Transactional(readOnly = false)
	 @Override
	 public void updateAttachment(Attachment attachment) {
		 getAttachmentDAO().updateAttachment(attachment);
	 }
	
	 @Override
	 public Attachment getAttachmentById(Long id) {
		 return getAttachmentDAO().getAttachmentById(id);
	 }
	
	 
	 @Override
	 public List<Attachment> getAttachmentlar() {
		 return getAttachmentDAO().getAttachmentlar();
	 }
	
	 @Override
	 public List<Attachment> getAttachmentlarByTypeAndFromId(int fromTypeId, Long fromId){
		 return getAttachmentDAO().getAttachmentlarByTypeAndFromId(fromTypeId,fromId);
	 }
	
	 public IAttachmentDAO getAttachmentDAO() {
		 return attachmentDAO;
	 }
	
	 
	 public void setAttachmentDAO(IAttachmentDAO attachmentDAO) {
		 this.attachmentDAO = attachmentDAO;
	 }
}