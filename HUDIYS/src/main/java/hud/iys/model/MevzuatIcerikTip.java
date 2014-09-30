package hud.iys.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MevzuatIcerikTip")
public class MevzuatIcerikTip {

	 private Long mevzuatIcerikTipId;
	 private String mevzuatIcerikTipAdi;
	 
	 @Id
	 @Column(name="MevzuatIcerikTipID")
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 public Long getMevzuatIcerikTipId() {
		 return mevzuatIcerikTipId;
	 }
	
	 public void setMevzuatIcerikTipId(Long id) {
		 this.mevzuatIcerikTipId = id;
	 }
		
	 
	 @Column(name="MevzuatIcerikTipAdi")
	 public String getMevzuatIcerikTipAdi() {
		 return mevzuatIcerikTipAdi;
	 }	
	
	 public void setMevzuatIcerikTipAdi(String mevzuatIcerikTipAdi) {
		 this.mevzuatIcerikTipAdi = mevzuatIcerikTipAdi;
	 }
	
}