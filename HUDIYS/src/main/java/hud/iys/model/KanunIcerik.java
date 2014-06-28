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
@Table(name="KANUNICERIK")
public class KanunIcerik {

	 @Id
	 @GeneratedValue(strategy = IDENTITY)
	 @Column(name = "KanunIcerikID", unique = true, nullable = false)	 
	 private Long kanunIcerikId;	
	 
	 @Column(name="KanunIcerikNo")	 
	 private String kanunIcerikNo;
	 
	 @Column(name="KanunIcerikAdi")	 
	 private String kanunIcerikAdi;
	 
	 @Column(name="KanunIcerikMetin")	 
	 private String kanunIcerikMetin;	
	 
	 @ManyToOne(fetch = FetchType.LAZY, optional = true)
	 @JoinColumn(name = "parentID", referencedColumnName = "kanunIcerikID")	 
	 private KanunIcerik parent;
	 
	 @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parent")	 
	 private Collection<KanunIcerik> children;	 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "KanunID", nullable = false)	 
	 private Kanun kanun;
	 
	 @OneToMany(mappedBy = "kanunIcerik")
	 Set<Fikra> fikralar; 
	 
	 @OneToMany(mappedBy = "kanunIcerik")
	 Set<Paragraf> paragraflar;

	 
	 private Long maddeIcerikRoot;
	 
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

	
	 public KanunIcerik getKanunIcerik() {
		 return parent;
	 }
 
	 public void setKanunIcerik(KanunIcerik parent) {
		 this.parent = parent;
	 }
	 
	 
	 public Collection<KanunIcerik> getChildren() {
	 	 return children;
	 }
 
	 public void setKanunIcerikler(Collection<KanunIcerik> children) {
	 	 this.children = children;
	 }
	
	 
	 public Kanun getKanun() {
		return kanun;
	 }

	 public void setKanun(Kanun kanun) {
		this.kanun = kanun;
	 }
	 

	 public Set<Fikra> getFikralar() {
	 	 return fikralar;
	 }

	 public void setFikralar(Set<Fikra> fikralar) {
	 	 this.fikralar = fikralar;
	 }
	 
	 
	 public Set<Paragraf> getParagraflar() {
	 	 return paragraflar;
	 }

	 public void setParagraflar(Set<Paragraf> paragraflar) {
	 	 this.paragraflar = paragraflar;
	 }
	 
	 	 
	 public Long getMaddeIcerikRoot() {
	 	 return maddeIcerikRoot;
	 }

	 public void setMaddeIcerikRoot(Long maddeIcerikRoot) {
		 this.maddeIcerikRoot = maddeIcerikRoot;
 	 }

	@Override
	 public String toString() {
		  StringBuffer strBuff = new StringBuffer();
		  strBuff.append("id : ").append(getKanunIcerikId());
		  strBuff.append(", mevzuatSetiAdi : ").append(getKanunIcerikAdi());
		  return strBuff.toString();
	 }
}