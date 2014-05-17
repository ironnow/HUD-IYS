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
	 private int kanunIcerikId;
	 
	 @Column(name="KanunIcerikAdi")
	 private String kanunIcerikAdi;
	 
	 @Column(name="KanunIcerikMetin")
	 private String kanunIcerikMetin;
	 
	 @ManyToOne(fetch = FetchType.LAZY, optional = true)
	 @JoinColumn(name = "parentID", referencedColumnName = "kanunIcerikID")
	 private KanunIcerik parent;

	 @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parent")
	 private Collection<KanunIcerik> children;
	 
	 
	// @ManyToOne
	// @JoinColumn(name="parentID")	    
	// private KanunIcerik parent;

	 //@OneToMany(mappedBy = "parent")	 
	 //private Set<KanunIcerik> kanunIcerikler = new HashSet<KanunIcerik>();; 
	 
	public int getKanunIcerikId() {
		 return kanunIcerikId;
	 }

	
	 public void setKanunIcerikId(int id) {
		 this.kanunIcerikId = id;
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
	
	 @Override
	 public String toString() {
		  StringBuffer strBuff = new StringBuffer();
		  strBuff.append("id : ").append(getKanunIcerikId());
		  strBuff.append(", mevzuatSetiAdi : ").append(getKanunIcerikAdi());
		  return strBuff.toString();
	 }
}