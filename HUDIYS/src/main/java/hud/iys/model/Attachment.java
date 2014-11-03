package hud.iys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Entity
@Table(name="Attachment")
public class Attachment {

	 private Long attachmentId;
	 private String attachmentAdi;
	 private byte[] content;
	 private Long fromId;
	 private int fromTypeId;
	 
	 private StreamedContent file;
	 
	 
	 @Id
	 @Column(name="AttachmentId")
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 public Long getAttachmentId() {
		 return attachmentId;
	 }
	 public void setAttachmentId(Long attachmentId) {
		 this.attachmentId = attachmentId;
	 }
	
	 @Column(name="AttachmentAdi")
	 public String getAttachmentAdi() {
		 return attachmentAdi;
	 }
	 public void setAttachmentAdi(String attachmentAdi) {
		 this.attachmentAdi = attachmentAdi;
	 }	 
	 
	 @Column(name="Content")
	 public byte[] getContent() {
		 return content;
	 }
	 public void setContent(byte[] content) {
		 this.content = content;
	 }	
	 
	 @Column(name="fromId")
	 public Long getFromId() {
		 return fromId;
	 }
	 public void setFromId(Long fromId) {
		 this.fromId = fromId;
	 }
	
	 @Column(name="fromTypeId")
	 public int getFromTypeId() {
		 return fromTypeId;
	 }
	 public void setFromTypeId(int fromTypeId) {
		 this.fromTypeId = fromTypeId;
	 }
	 
	 @Transient
	 public StreamedContent getFile() {
		 InputStream inputStream = new ByteArrayInputStream(content);     	
     	 file = new DefaultStreamedContent(inputStream,"image/jpeg",attachmentAdi);
		 return file;
	 }
	 public void setFile(StreamedContent file) {
		 this.file = file;
	 }
	 
	 
	 
}