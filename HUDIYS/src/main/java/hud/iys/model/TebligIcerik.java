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
@Table(name="TEBLIGICERIK")
public class TebligIcerik {

	 @Id
	 @GeneratedValue(strategy = IDENTITY)
	 @Column(name = "TebligIcerikID", unique = true, nullable = false)	 
	 private Long tebligIcerikId;	
	 
	 @Column(name="TebligIcerikNo")	 
	 private String tebligIcerikNo;
	 
	 @Column(name="TebligIcerikAdi")	 
	 private String tebligIcerikAdi;
	 
	 @Column(name="TebligIcerikAyraci")	 
	 private String tebligIcerikAyraci;
	 
	 @Column(name="TebligIcerikMetin")	 
	 private String tebligIcerikMetin;	
	 
	 @ManyToOne(fetch = FetchType.LAZY, optional = true)
	 @JoinColumn(name = "parentID", referencedColumnName = "tebligIcerikID")	 
	 private TebligIcerik parent;
	 
	 @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parent")	 
	 private Collection<TebligIcerik> children;	 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "TebligID", nullable = false)	 
	 private Teblig teblig;
	 
		 
	 private Long tebligMaddeIcerikRoot;
	 
	 public Long getTebligIcerikId() {
		 return tebligIcerikId;
	 }
	
	 public void setTebligIcerikId(Long id) {
		 this.tebligIcerikId = id;
	 }
	
	 
	 public String getTebligIcerikNo() {
		 return tebligIcerikNo;
	 }

	 public void setTebligIcerikNo(String tebligIcerikNo) {
		 this.tebligIcerikNo = tebligIcerikNo;
   	 }

	 public String getTebligIcerikAdi() {
		 return tebligIcerikAdi;
	 }
		
	 public void setTebligIcerikAdi(String tebligIcerikAdi) {
		 this.tebligIcerikAdi = tebligIcerikAdi;
	 }
	
	 
	 public String getTebligIcerikAyraci() {
		return tebligIcerikAyraci;
	}

	public void setTebligIcerikAyraci(String tebligIcerikAyraci) {
		this.tebligIcerikAyraci = tebligIcerikAyraci;
	}

	public String getTebligIcerikMetin() {
		return tebligIcerikMetin;
	 }

	 public void setTebligIcerikMetin(String tebligIcerikMetin) {
		this.tebligIcerikMetin = tebligIcerikMetin;
	 }

	
	 public TebligIcerik getTebligIcerik() {
		 return parent;
	 }
 
	 public void setTebligIcerik(TebligIcerik parent) {
		 this.parent = parent;
	 }
	 
	 
	 public Collection<TebligIcerik> getChildren() {
	 	 return children;
	 }
 
	 public void setTebligIcerikler(Collection<TebligIcerik> children) {
	 	 this.children = children;
	 }
	
	 
	 public Teblig getTeblig() {
		return teblig;
	 }

	 public void setTeblig(Teblig teblig) {
		this.teblig = teblig;
	 }
	 
	 	 
	 public Long getTebligMaddeIcerikRoot() {
	 	 return tebligMaddeIcerikRoot;
	 }

	 public void setTebligMaddeIcerikRoot(Long tebligMaddeIcerikRoot) {
		 this.tebligMaddeIcerikRoot = tebligMaddeIcerikRoot;
 	 }

}