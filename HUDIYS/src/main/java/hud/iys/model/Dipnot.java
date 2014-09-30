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

public class Dipnot {

	 private Long dipnotId;
	 private String dipnotNo;
	 private String dipnotMetin;
	
	 public Long getDipnotId() {
		 return dipnotId;
	 }

	
	 public void setDipnotId(Long id) {
		 this.dipnotId = id;
	 }
	
	 public String getDipnotNo() {
		 return dipnotNo;
	 }
	
	
	 public void setDipnotNo(String dipnotNo) {
		 this.dipnotNo = dipnotNo;
	 }
	
	 public String getDipnotMetin() {
		 return dipnotMetin;
	 }
	
	 
	 public void setDipnotMetin(String dipnotMetin) {
		 this.dipnotMetin = dipnotMetin;
	 } 
	 
}