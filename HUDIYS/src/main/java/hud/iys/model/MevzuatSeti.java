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

@Entity
@Table(name="MEVZUATSETI")
public class MevzuatSeti {

	 private Long mevzuatSetiId;
	 private String mevzuatSetiAdi;
	 private String mevzuatSetiAciklama;
	 Set<Mevzuat> mevzuatlar; 

	 @Id
	 @GeneratedValue(strategy = IDENTITY)
	 @Column(name = "MevzuatSetiID", unique = true, nullable = false)
	 public Long getMevzuatSetiId() {
		 return mevzuatSetiId;
	 }

	
	 public void setMevzuatSetiId(Long id) {
		 this.mevzuatSetiId = id;
	 }
	
	 
	 @Column(name="MevzuatSetiAdi")
	 public String getMevzuatSetiAdi() {
		 return mevzuatSetiAdi;
	 }
	
	
	 public void setMevzuatSetiAdi(String mevzuatSetiAdi) {
		 this.mevzuatSetiAdi = mevzuatSetiAdi;
	 }
	
	
	 @Column(name="MevzuatSetiAciklama")
	 public String getMevzuatSetiAciklama() {
		 return mevzuatSetiAciklama;
	 }
	
	 
	 public void setMevzuatSetiAciklama(String mevzuatSetiAciklama) {
		 this.mevzuatSetiAciklama = mevzuatSetiAciklama;
	 } 
	 
	 @OneToMany(mappedBy = "mevzuatSeti")
	 public Set<Mevzuat> getMevzuatlar() {
	 	 return this.mevzuatlar;
	 }
 
	 public void setMevzuatlar(Set<Mevzuat> mevzuatlar) {
	 	 this.mevzuatlar = mevzuatlar;
	 }
	 
	
	 @Override
	 public String toString() {
		  StringBuffer strBuff = new StringBuffer();
		  strBuff.append("id : ").append(getMevzuatSetiId());
		  strBuff.append(", mevzuatSetiAdi : ").append(getMevzuatSetiAdi());
		  strBuff.append(", mevzuatSetiAciklama : ").append(getMevzuatSetiAciklama());
		  return strBuff.toString();
	 }
}