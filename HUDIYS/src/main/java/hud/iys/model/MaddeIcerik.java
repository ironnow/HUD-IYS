package hud.iys.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OrderBy;

@Entity
@Table(name="MADDEICERIK")
public class MaddeIcerik {

	 @Id
	 @GeneratedValue(strategy = IDENTITY)
	 @Column(name = "MaddeIcerikID", unique = true, nullable = false)	 
	 private Long maddeIcerikId;	
	 
	 @Column(name="MaddeIcerikAdi")	 
	 private String maddeIcerikAdi;
	 
	 @Column(name="MaddeIcerikMetin")	 
	 private String maddeIcerikMetin;	
	 
	 @Column(name="Attachment")	 
	 private byte[] attachment;	
	 
	 @ManyToOne(fetch = FetchType.LAZY, optional = true)
	 @JoinColumn(name = "parentID", referencedColumnName = "maddeIcerikID")	 
	 private MaddeIcerik parent;
	 
	 @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parent")
	 @OrderBy(clause = "ChildPosition ASC")	 
	 private Collection<MaddeIcerik> children;	 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "KanunIcerikID", nullable = false)	 
	 private KanunIcerik kanunIcerik;
	 
	 @OneToMany(fetch = FetchType.EAGER, mappedBy = "maddeIcerik")
	 Set<DipnotMI> dipnotlar; 
	
	 @Column(name="ChildPosition")	
	 private Long childPosition;
	
	 public Long getMaddeIcerikId() {
		 return maddeIcerikId;
	 }
	
	 public void setMaddeIcerikId(Long id) {
		 this.maddeIcerikId = id;
	 }
	
	 
	 public String getMaddeIcerikAdi() {
		 return maddeIcerikAdi;
	 }
		
	 public void setMaddeIcerikAdi(String maddeIcerikAdi) {
		 this.maddeIcerikAdi = maddeIcerikAdi;
	 }
	
	 
	 public String getMaddeIcerikMetin() {
		return maddeIcerikMetin;
	 }

	 public void setMaddeIcerikMetin(String maddeIcerikMetin) {
		this.maddeIcerikMetin = maddeIcerikMetin;
	 }

	
	 public MaddeIcerik getMaddeIcerik() {
		 return parent;
	 }
 
	 public void setMaddeIcerik(MaddeIcerik parent) {
		 this.parent = parent;
	 }
	 
	 
	 public Collection<MaddeIcerik> getChildren() {
	 	 return children;
	 }
 
	 public void setMaddeIcerikler(Collection<MaddeIcerik> children) {
	 	 this.children = children;
	 }
	
	 
	 public KanunIcerik getKanunIcerik() {
		return kanunIcerik;
	 }

	 public void setKanunIcerik(KanunIcerik kanunIcerik) {
		this.kanunIcerik = kanunIcerik;
	 }	 
	 
	 
	 public Set<DipnotMI> getDipnotlar() {
		return dipnotlar;
	}

	public void setDipnotlar(Set<DipnotMI> dipnotlar) {
		this.dipnotlar = dipnotlar;
	}

	
	public Long getChildPosition() {
		return childPosition;
	}

	public void setChildPosition(Long childPosition) {
		this.childPosition = childPosition;
	}
	
	

	
	public byte[] getAttachment() {
		return attachment;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}

	@Override
	 public String toString() {
		  StringBuffer strBuff = new StringBuffer();
		  strBuff.append("id : ").append(getMaddeIcerikId());
		  strBuff.append(", maddeIcerikAdi : ").append(getMaddeIcerikAdi());
		  return strBuff.toString();
	 }
}