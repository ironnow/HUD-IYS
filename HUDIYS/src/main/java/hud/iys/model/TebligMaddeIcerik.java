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
@Table(name="TEBLIGMADDEICERIK")
public class TebligMaddeIcerik {

	 @Id
	 @GeneratedValue(strategy = IDENTITY)
	 @Column(name = "TebligMaddeIcerikID", unique = true, nullable = false)	 
	 private Long tebligMaddeIcerikId;	
	 
	 @Column(name="TebligMaddeIcerikAdi")	 
	 private String tebligMaddeIcerikAdi;
	 
	 @Column(name="TebligMaddeIcerikMetin")	 
	 private String tebligMaddeIcerikMetin;	
	 
	 @ManyToOne(fetch = FetchType.LAZY, optional = true)
	 @JoinColumn(name = "parentID", referencedColumnName = "tebligMaddeIcerikID")	 
	 private TebligMaddeIcerik parent;
	 
	 @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parent")	 
	 private Collection<TebligMaddeIcerik> children;	 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "TebligIcerikID", nullable = false)	 
	 private TebligIcerik tebligIcerik;
	 
	
	 public Long getTebligMaddeIcerikId() {
		 return tebligMaddeIcerikId;
	 }
	
	 public void setTebligMaddeIcerikId(Long id) {
		 this.tebligMaddeIcerikId = id;
	 }
	
	 
	 public String getTebligMaddeIcerikAdi() {
		 return tebligMaddeIcerikAdi;
	 }
		
	 public void setTebligMaddeIcerikAdi(String tebligMaddeIcerikAdi) {
		 this.tebligMaddeIcerikAdi = tebligMaddeIcerikAdi;
	 }
	
	 
	 public String getTebligMaddeIcerikMetin() {
		return tebligMaddeIcerikMetin;
	 }

	 public void setTebligMaddeIcerikMetin(String tebligMaddeIcerikMetin) {
		this.tebligMaddeIcerikMetin = tebligMaddeIcerikMetin;
	 }

	
	 public TebligMaddeIcerik getTebligMaddeIcerik() {
		 return parent;
	 }
 
	 public void setTebligMaddeIcerik(TebligMaddeIcerik parent) {
		 this.parent = parent;
	 }
	 
	 
	 public Collection<TebligMaddeIcerik> getChildren() {
	 	 return children;
	 }
 
	 public void setTebligMaddeIcerikler(Collection<TebligMaddeIcerik> children) {
	 	 this.children = children;
	 }
	
	 
	 public TebligIcerik getTebligIcerik() {
		return tebligIcerik;
	 }

	 public void setTebligIcerik(TebligIcerik tebligIcerik) {
		this.tebligIcerik = tebligIcerik;
	 }	 
	
}