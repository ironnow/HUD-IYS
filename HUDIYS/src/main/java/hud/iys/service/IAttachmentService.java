package hud.iys.service;

import java.util.List;

import hud.iys.model.Attachment;


public interface IAttachmentService {

	 public void addAttachment(Attachment attachment);
	
	 public void updateAttachment(Attachment attachment);
	
	 public void deleteAttachment(Attachment attachment);
	
	 public Attachment getAttachmentById(Long id);
	
	 public List<Attachment> getAttachmentlar();
	 
	 public List<Attachment> getAttachmentlarByTypeAndFromId(int fromTypeId, Long fromId);
}