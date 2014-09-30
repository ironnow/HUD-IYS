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
@Table(name="DipnotMI")
public class DipnotMI {

	 private Long dipnotMIId;
	 private String dipnotMINo;
	 private String dipnotMIMetin;
	 private MaddeIcerik maddeIcerik;
	

	 @Id
	 @GeneratedValue(strategy = IDENTITY)
	 @Column(name = "DipnotMIID", unique = true, nullable = false)
	 public Long getDipnotMIId() {
		 return dipnotMIId;
	 }

	
	 public void setDipnotMIId(Long id) {
		 this.dipnotMIId = id;
	 }
	
	 
	 @Column(name="DipnotMINo")
	 public String getDipnotMINo() {
		 return dipnotMINo;
	 }
	
	
	 public void setDipnotMINo(String dipnotNo) {
		 this.dipnotMINo = dipnotNo;
	 }
	
	
	 @Column(name="DipnotMIMetin")
	 public String getDipnotMIMetin() {
		 return dipnotMIMetin;
	 }
	
	 
	 public void setDipnotMIMetin(String dipnotMetin) {
		 this.dipnotMIMetin = dipnotMetin;
	 } 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "MaddeIcerikID", nullable = false)
	 public MaddeIcerik getMaddeIcerik() {
		 return this.maddeIcerik;
	 }
 
	 public void setMaddeIcerik(MaddeIcerik maddeIcerik) {
		 this.maddeIcerik = maddeIcerik;
	 }
	 
	 @Override
	 public String toString() {
		  StringBuffer strBuff = new StringBuffer();
		  strBuff.append("id : ").append(getDipnotMIId());
		  strBuff.append(", dipnotNo : ").append(getDipnotMINo());
		  strBuff.append(", dipnotMetin : ").append(getDipnotMIMetin());
		  return strBuff.toString();
	 }
}