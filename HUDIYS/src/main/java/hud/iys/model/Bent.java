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
@Table(name="BENT")
public class Bent {

	 private Long bentId;
	 private String bentSira;
	 private String bentMetin;
	 private Long prevBentId;
	 private Long nextBentId;
	 private Fikra fikra;
	 Set<AltBent> altBentler; 

	 @Id
	 @GeneratedValue(strategy = IDENTITY)
	 @Column(name = "BentID", unique = true, nullable = false)
	 public Long getBentId() {
		 return bentId;
	 }

	
	 public void setBentId(Long id) {
		 this.bentId = id;
	 }
	
	 
	 @Column(name="BentSira")
	 public String getBentSira() {
		 return bentSira;
	 }
	
	
	 public void setBentSira(String bentSira) {
		 this.bentSira = bentSira;
	 }
	
	
	 @Column(name="BentMetin")
	 public String getBentMetin() {
		 return bentMetin;
	 }
	
	 
	 public void setBentMetin(String bentMetin) {
		 this.bentMetin = bentMetin;
	 } 
	 
	 @Column(name="PrevBentID")
	 public Long getPrevBentId() {
		 return prevBentId;
	 }
	
	
	 public void setPrevBentId(Long prevBentId) {
		 this.prevBentId = prevBentId;
	 }
	 
	 @Column(name="NextBentID")
	 public Long getNextBentId() {
		 return nextBentId;
	 }	
	
	 public void setNextBentId(Long nextBentId) {
		 this.nextBentId = nextBentId;
	 }
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "FikraID", nullable = false)
	 public Fikra getFikra() {
		 return fikra;
	 }
 
	 public void setFikra(Fikra fikra) {
		 this.fikra = fikra;
	 }
	 
	 @OneToMany(mappedBy = "bent")
	 public Set<AltBent> getAltBentler() {
	 	 return altBentler;
	 }
 
	 public void setAltBentler(Set<AltBent> altBentler) {
	 	 this.altBentler = altBentler;
	 }
	
	
	 @Override
	 public String toString() {
		  StringBuffer strBuff = new StringBuffer();
		  strBuff.append("id : ").append(getBentId());
		  strBuff.append(", bentSira : ").append(getBentSira());
		  strBuff.append(", bentMetin : ").append(getBentMetin());
		  return strBuff.toString();
	 }
}