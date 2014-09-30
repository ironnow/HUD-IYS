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
@Table(name="DipnotTI")
public class DipnotTI {

	 private Long dipnotTIId;
	 private String dipnotTINo;
	 private String dipnotTIMetin;
	 private TebligIcerik tebligIcerik;
	

	 @Id
	 @GeneratedValue(strategy = IDENTITY)
	 @Column(name = "DipnotTIID", unique = true, nullable = false)
	 public Long getDipnotTIId() {
		 return dipnotTIId;
	 }

	
	 public void setDipnotTIId(Long id) {
		 this.dipnotTIId = id;
	 }
	
	 
	 @Column(name="DipnotTINo")
	 public String getDipnotTINo() {
		 return dipnotTINo;
	 }
	
	
	 public void setDipnotTINo(String dipnotNo) {
		 this.dipnotTINo = dipnotNo;
	 }
	
	
	 @Column(name="DipnotTIMetin")
	 public String getDipnotTIMetin() {
		 return dipnotTIMetin;
	 }
	
	 
	 public void setDipnotTIMetin(String dipnotMetin) {
		 this.dipnotTIMetin = dipnotMetin;
	 } 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "TebligIcerikID", nullable = false)
	 public TebligIcerik getTebligIcerik() {
		 return tebligIcerik;
	 }
 
	 public void setTebligIcerik(TebligIcerik tebligIcerik) {
		 this.tebligIcerik = tebligIcerik;
	 }
	 
	 @Override
	 public String toString() {
		  StringBuffer strBuff = new StringBuffer();
		  strBuff.append("id : ").append(getDipnotTIId());
		  strBuff.append(", dipnotNo : ").append(getDipnotTINo());
		  strBuff.append(", dipnotMetin : ").append(getDipnotTIMetin());
		  return strBuff.toString();
	 }
}