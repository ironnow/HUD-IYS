package hud.iys.model;

import java.util.Date;

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
@Table(name="KANUN")
public class Kanun {

	 private Long kanunId;
	 private int kanunNo;
	 private String kanunAdi;
	 private int RGNo;
	 private Date RGTarihi;
	 private Date kabulTarihi;
	 private Mevzuat mevzuat;

	 private Long kanunIcerikRoot;
	 
	 private int durumId;

	 @Id
	 @Column(name="KanunID")
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 public Long getKanunId() {
		 return kanunId;
	 }

	
	 public void setKanunId(Long id) {
		 this.kanunId = id;
	 }
	
	 
	 @Column(name="KanunNo")
	 public int getKanunNo() {
		 return kanunNo;
	 }
	
	 public void setKanunNo(int kanunNo) {
		 this.kanunNo = kanunNo;
	 }	 
	
	 
	 @Column(name="KanunAdi")
	 public String getKanunAdi() {
		 return kanunAdi;
	 }	
	
	 public void setKanunAdi(String kanunAdi) {
		 this.kanunAdi = kanunAdi;
	 }
	
	
	 @Column(name="RGTarihi")
	 public Date getRGTarihi() {
		 return RGTarihi;
	 }
	 
	 public void setRGTarihi(Date RGTarihi) {
		 this.RGTarihi = RGTarihi;
	 } 
	 
	 
	 @Column(name="KabulTarihi")
	 public Date getKabulTarihi() {
		 return kabulTarihi;
	 }


	 public void setKabulTarihi(Date kabulTarihi) {
		 this.kabulTarihi = kabulTarihi;
	 }


	 @Column(name="RGNo")
	 public int getRGNo() {
		 return RGNo;
	 }
	
	 public void setRGNo(int RGNo) {
		 this.RGNo = RGNo;
	 }
	
	 @Column(name="DurumId")
	 public int getDurumId() {
		return durumId;
	 }

	 public void setDurumId(int durumId) {
		this.durumId = durumId;
	 }


	@ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "MevzuatID", nullable = false)
	 public Mevzuat getMevzuat() {
		 return this.mevzuat;
	 }
 
	 public void setMevzuat(Mevzuat mevzuat) {
		 this.mevzuat = mevzuat;
	 }	 
	 
	 
	 public Long getKanunIcerikRoot() {
		return kanunIcerikRoot;
	 }


	 public void setKanunIcerikRoot(Long kanunIcerikRoot) {
		this.kanunIcerikRoot = kanunIcerikRoot;
	 }


	 @Override
	 public String toString() {
		  StringBuffer strBuff = new StringBuffer();
		  strBuff.append("id : ").append(getKanunId());
		  strBuff.append(", kanunNo : ").append(getKanunNo());
		  strBuff.append(", kanunAdi : ").append(getKanunAdi());
		  strBuff.append(", RGTarihi : ").append(getRGTarihi());
		  strBuff.append(", RGNo : ").append(getRGNo());
		  return strBuff.toString();
	 }
}