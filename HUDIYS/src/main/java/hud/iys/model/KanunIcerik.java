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
@Table(name="KANUNICERIK")
public class KanunIcerik {

	 @Id
	 @GeneratedValue(strategy = IDENTITY)
	 @Column(name = "KanunIcerikID", unique = true, nullable = false)	 
	 private Long icerikId;	
	 
	 @Column(name="KanunIcerikNo")	 
	 private String icerikNo;
	 
	 @Column(name="KanunIcerikAdi")	 
	 private String icerikAdi;
	 
	 @Column(name="KanunIcerikMetin")	 
	 private String icerikMetin;	
	 
	 @ManyToOne(fetch = FetchType.LAZY, optional = true)
	 @JoinColumn(name = "parentID", referencedColumnName = "kanunIcerikID")	 
	 private KanunIcerik parent;
	 
	 @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parent")	
	 @OrderBy(clause = "ChildPosition ASC")
	 private Collection<KanunIcerik> children;	 
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "KanunID", nullable = false)	 
	 private Kanun kanun;
	 
	 private Long maddeIcerikRoot;
	 
	 private Long leftId;
	 
	 private Long rightId;
	 
	 @Column(name="ChildPosition")	
	 private Long childPosition;
	 
	 @OneToMany(fetch = FetchType.EAGER, mappedBy = "kanunIcerik")
	 Set<DipnotKI> dipnotlar; 
	 
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
	
	 
	 public String getIcerikMetin() {
		return icerikMetin;
	 }

	 public void setIcerikMetin(String icerikMetin) {
		this.icerikMetin = icerikMetin;
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
	 

	
	 
	 	 
	 public Long getMaddeIcerikRoot() {
	 	 return maddeIcerikRoot;
	 }

	 public void setMaddeIcerikRoot(Long maddeIcerikRoot) {
		 this.maddeIcerikRoot = maddeIcerikRoot;
 	 }	 

	public Set<DipnotKI> getDipnotlar() {
		return dipnotlar;
	}

	public void setDipnotlar(Set<DipnotKI> dipnotlar) {
		this.dipnotlar = dipnotlar;
	}
	
	

	public Long getLeftId() {
		return leftId;
	}

	public void setLeftId(Long leftId) {
		this.leftId = leftId;
	}

	public Long getRightId() {
		return rightId;
	}

	public void setRightId(Long rightId) {
		this.rightId = rightId;
	}
	
	

	public Long getChildPosition() {
		return childPosition;
	}

	public void setChildPosition(Long childPosition) {
		this.childPosition = childPosition;
	}

	@Override
	 public String toString() {
		  StringBuffer strBuff = new StringBuffer();
		  strBuff.append("id : ").append(getIcerikId());
		  strBuff.append(", mevzuatSetiAdi : ").append(getIcerikAdi());
		  return strBuff.toString();
	 }
}