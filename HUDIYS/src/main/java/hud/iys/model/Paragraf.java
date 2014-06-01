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
@Table(name="PARAGRAF")
public class Paragraf {

	 private Long paragrafId;
	 private Long paragrafNo;
	 private String paragrafMetin;
	 private Long prevParagrafId;
	 private Long nextParagrafId;
	 private KanunIcerik kanunIcerik;
	
	 @Id
	 @GeneratedValue(strategy = IDENTITY)
	 @Column(name = "ParagrafID", unique = true, nullable = false)
	 public Long getParagrafId() {
		 return paragrafId;
	 }

	
	 public void setParagrafId(Long id) {
		 this.paragrafId = id;
	 }
	
	 
	 @Column(name="ParagrafNo")
	 public Long getParagrafNo() {
		 return paragrafNo;
	 }
	
	
	 public void setParagrafNo(Long paragrafNo) {
		 this.paragrafNo = paragrafNo;
	 }
	
	
	 @Column(name="ParagrafMetin")
	 public String getParagrafMetin() {
		 return paragrafMetin;
	 }
	
	 
	 public void setParagrafMetin(String paragrafMetin) {
		 this.paragrafMetin = paragrafMetin;
	 } 
	 
	 @Column(name="PrevParagrafID")
	 public Long getPrevParagrafId() {
		 return prevParagrafId;
	 }
	
	
	 public void setPrevParagrafId(Long prevParagrafId) {
		 this.prevParagrafId = prevParagrafId;
	 }
	 
	 @Column(name="NextParagrafID")
	 public Long getNextParagrafId() {
		 return nextParagrafId;
	 }
	
	
	 public void setNextParagrafId(Long nextParagrafId) {
		 this.nextParagrafId = nextParagrafId;
	 }
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "KanunIcerikID", nullable = false)
	 public KanunIcerik getKanunIcerik() {
		 return kanunIcerik;
	 }
 
	 public void setKanunIcerik(KanunIcerik kanunIcerik) {
		 this.kanunIcerik = kanunIcerik;
	 }
	 
	
	 @Override
	 public String toString() {
		  StringBuffer strBuff = new StringBuffer();
		  strBuff.append("id : ").append(getParagrafId());
		  strBuff.append(", paragrafNo : ").append(getParagrafNo());
		  strBuff.append(", paragrafMetin : ").append(getParagrafMetin());
		  return strBuff.toString();
	 }
}