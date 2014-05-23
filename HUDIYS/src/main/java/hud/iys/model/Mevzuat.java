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
@Table(name="MEVZUAT")
public class Mevzuat {

	 private int mevzuatId;
	 private String mevzuatAdi;
	 private String mevzuatAciklama;
	 private MevzuatSeti mevzuatSeti;
	 Set<Kanun> kanunlar; 


	 @Id
	 @GeneratedValue(strategy = IDENTITY)
	 @Column(name = "MevzuatID", unique = true, nullable = false)
	 public int getMevzuatId() {
		 return mevzuatId;
	 }

	
	 public void setMevzuatId(int id) {
		 this.mevzuatId = id;
	 }
	
	 
	 @Column(name="MevzuatAdi")
	 public String getMevzuatAdi() {
		 return mevzuatAdi;
	 }
	
	
	 public void setMevzuatAdi(String mevzuatAdi) {
		 this.mevzuatAdi = mevzuatAdi;
	 }
	
	
	 @Column(name="MevzuatAciklama")
	 public String getMevzuatAciklama() {
		 return mevzuatAciklama;
	 }
	
	 
	 public void setMevzuatAciklama(String mevzuatAciklama) {
		 this.mevzuatAciklama = mevzuatAciklama;
	 } 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "MevzuatSetiID", nullable = false)
	 public MevzuatSeti getMevzuatSeti() {
		 return this.mevzuatSeti;
	 }
 
	 public void setMevzuatSeti(MevzuatSeti mevzuatSeti) {
		 this.mevzuatSeti = mevzuatSeti;
	 }
	 
	 @OneToMany(mappedBy = "mevzuat")
	 public Set<Kanun> getKanunlar() {
	 	 return this.kanunlar;
	 }
 
	 public void setKanunlar(Set<Kanun> kanunlar) {
	 	 this.kanunlar = kanunlar;
	 }
	
	 @Override
	 public String toString() {
		  StringBuffer strBuff = new StringBuffer();
		  strBuff.append("id : ").append(getMevzuatId());
		  strBuff.append(", mevzuatAdi : ").append(getMevzuatAdi());
		  strBuff.append(", mevzuatAciklama : ").append(getMevzuatAciklama());
		  return strBuff.toString();
	 }
}