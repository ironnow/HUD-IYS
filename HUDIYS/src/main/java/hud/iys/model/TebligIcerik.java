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

import org.hibernate.annotations.OrderBy;

@Entity
@Table(name="TEBLIGICERIK")
public class TebligIcerik {

	 @Id
	 @GeneratedValue(strategy = IDENTITY)
	 @Column(name = "TebligIcerikID", unique = true, nullable = false)	 
	 private Long icerikId;	
	 
	 @Column(name="TebligIcerikNo")	 
	 private String icerikNo;
	 
	 @Column(name="TebligIcerikAdi")	 
	 private String icerikAdi;
	 
	 @Column(name="TebligIcerikAyraci")	 
	 private String icerikAyraci;
	 
	 @Column(name="TebligIcerikMetin")	 
	 private String icerikMetin;	
	 
	 @ManyToOne(fetch = FetchType.LAZY, optional = true)
	 @JoinColumn(name = "parentID", referencedColumnName = "tebligIcerikID")	 
	 private TebligIcerik parent;
	 
	 @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parent")	 
	 @OrderBy(clause = "ChildPosition ASC")
	 private Collection<TebligIcerik> children;	 
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "TebligID", nullable = false)	 
	 private Teblig teblig;
	 
	 @Column(name="TebligMaddeIcerikRoot")	 	 
	 private Long maddeIcerikRoot;
	 
	 @Column(name="ChildPosition")	
	 private Long childPosition;
	
	 public Long getIcerikId() {
		 return icerikId;
	 }
	
	 public void setIcerikId(Long id) {
		 this.icerikId = id;
	 }
	
	 
	 public String getIcerikNo() {
		 return icerikNo;
	 }

	 public void setIcerikNo(String icerikNo) {
		 this.icerikNo = icerikNo;
   	 }

	 public String getIcerikAdi() {
		 return icerikAdi;
	 }
		
	 public void setIcerikAdi(String icerikAdi) {
		 this.icerikAdi = icerikAdi;
	 }
	
	 
	 public String getIcerikAyraci() {
		return icerikAyraci;
	}

	public void setIcerikAyraci(String icerikAyraci) {
		this.icerikAyraci = icerikAyraci;
	}

	public String getIcerikMetin() {
		return icerikMetin;
	 }

	 public void setIcerikMetin(String icerikMetin) {
		this.icerikMetin = icerikMetin;
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
	 
	 	 
	 public Long getMaddeIcerikRoot() {
	 	 return maddeIcerikRoot;
	 }

	 public void setMaddeIcerikRoot(Long maddeIcerikRoot) {
		 this.maddeIcerikRoot = maddeIcerikRoot;
 	 }

	 public Long getChildPosition() {
		 return childPosition;
	 }

	 public void setChildPosition(Long childPosition) {
		 this.childPosition = childPosition;
	 }
}