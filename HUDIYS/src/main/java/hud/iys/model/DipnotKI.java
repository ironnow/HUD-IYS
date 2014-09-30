package hud.iys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="DipnotKI")
public class DipnotKI {

	 private Long dipnotKIId;
	 private String dipnotKINo;
	 private String dipnotKIMetin;
	 private KanunIcerik kanunIcerik;
	

	 @Id
	 @GeneratedValue(strategy = IDENTITY)
	 @Column(name = "DipnotKIID", unique = true, nullable = false)
	 public Long getDipnotKIId() {
		 return dipnotKIId;
	 }

	
	 public void setDipnotKIId(Long id) {
		 this.dipnotKIId = id;
	 }
	
	 
	 @Column(name="DipnotKINo")
	 public String getDipnotKINo() {
		 return dipnotKINo;
	 }
	
	
	 public void setDipnotKINo(String dipnotNo) {
		 this.dipnotKINo = dipnotNo;
	 }
	
	
	 @Column(name="DipnotKIMetin")
	 public String getDipnotKIMetin() {
		 return dipnotKIMetin;
	 }
	
	 
	 public void setDipnotKIMetin(String dipnotMetin) {
		 this.dipnotKIMetin = dipnotMetin;
	 } 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "KanunIcerikID", nullable = false)
	 public KanunIcerik getKanunIcerik() {
		 return this.kanunIcerik;
	 }
 
	 public void setKanunIcerik(KanunIcerik kanunIcerik) {
		 this.kanunIcerik = kanunIcerik;
	 }
	 
	 @Override
	 public String toString() {
		  StringBuffer strBuff = new StringBuffer();
		  strBuff.append("id : ").append(getDipnotKIId());
		  strBuff.append(", dipnotNo : ").append(getDipnotKINo());
		  strBuff.append(", dipnotMetin : ").append(getDipnotKIMetin());
		  return strBuff.toString();
	 }
}