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

@Entity
@Table(name="KANUNICERIK_TEMP")
public class KanunIcerik_TEMP {

	 @Id
	 @Column(name = "KanunIcerikID")	 
	 private Long kanunIcerikId;	
	 
	 @Column(name="KanunIcerikNo")	 
	 private String kanunIcerikNo;
	 
	 @Column(name="KanunIcerikAdi")	 
	 private String kanunIcerikAdi;
	 
	 @Column(name="KanunIcerikMetin")	 
	 private String kanunIcerikMetin;	
	 
	 @Column(name="kanunIcerikID")	 
	 private Long parent;
	
	 @Column(name="KanunID")	 
	 private Long kanun;
	 
	 private Long maddeIcerikRoot;
	 
	 private Long leftId;
	 
	 private Long rightId;
	
	 
	 public Long getKanunIcerikId() {
		 return kanunIcerikId;
	 }
	
	 public void setKanunIcerikId(Long id) {
		 this.kanunIcerikId = id;
	 }
	
	 
	 
	 public String getKanunIcerikNo() {
		 return kanunIcerikNo;
	 }

	 public void setKanunIcerikNo(String kanunIcerikNo) {
		 this.kanunIcerikNo = kanunIcerikNo;
   	 }

	 public String getKanunIcerikAdi() {
		 return kanunIcerikAdi;
	 }
		
	 public void setKanunIcerikAdi(String kanunIcerikAdi) {
		 this.kanunIcerikAdi = kanunIcerikAdi;
	 }
	
	 
	 public String getKanunIcerikMetin() {
		return kanunIcerikMetin;
	 }

	 public void setKanunIcerikMetin(String kanunIcerikMetin) {
		this.kanunIcerikMetin = kanunIcerikMetin;
	 }

	
	 public Long getKanunIcerik() {
		 return parent;
	 }
 
	 public void setKanunIcerik(Long parent) {
		 this.parent = parent;
	 }
	 
	
	 public Long getKanun() {
		return kanun;
	 }

	 public void setKanun(Long kanun) {
		this.kanun = kanun;
	 }
	 

	
	 
	 	 
	 public Long getMaddeIcerikRoot() {
	 	 return maddeIcerikRoot;
	 }

	 public void setMaddeIcerikRoot(Long maddeIcerikRoot) {
		 this.maddeIcerikRoot = maddeIcerikRoot;
 	 }	 

	
	

	public Long getLeftId() {
		return leftId;
	}

	public void setLeftId(Long leftId) {
		this.leftId = leftId;
	}

	public Long getRightId() {
		return rightId;
	}

	public void setRightId(Long rightId) {
		this.rightId = rightId;
	}

	@Override
	 public String toString() {
		  StringBuffer strBuff = new StringBuffer();
		  strBuff.append("id : ").append(getKanunIcerikId());
		  strBuff.append(", mevzuatSetiAdi : ").append(getKanunIcerikAdi());
		  return strBuff.toString();
	 }
}