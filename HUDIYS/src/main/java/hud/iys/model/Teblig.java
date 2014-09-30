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
@Table(name="TEBLIG")
public class Teblig {

	 private Long tebligId;
	 private Long tebligNo;
	 private String tebligAdi;
	 private Long RGNo;
	 private Date RGTarihi;
	 private String tebligAciklama;
	 private Mevzuat mevzuat;
	 
	 private int durumId;

	 private Long tebligIcerikRoot;

	 @Id
	 @Column(name="TebligID")
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 public Long getTebligId() {
		 return tebligId;
	 }
	
	 public void setTebligId(Long id) {
		 this.tebligId = id;
	 }
	
	 @Column(name="TebligNo")
	 public Long getTebligNo() {
		 return tebligNo;
	 }
	
	 public void setTebligNo(Long tebligNo) {
		 this.tebligNo = tebligNo;
	 }	 
	 
		 
	 @Column(name="TebligAdi")
	 public String getTebligAdi() {
		 return tebligAdi;
	 }	
	
	 public void setTebligAdi(String tebligAdi) {
		 this.tebligAdi = tebligAdi;
	 }
	
	 @Column(name="TebligAciklama")
	 public String getTebligAciklama() {
		 return tebligAciklama;
	 }

	 public void setTebligAciklama(String tebligAciklama) {
		 this.tebligAciklama = tebligAciklama;
	 }

	 @Column(name="RGTarihi")
	 public Date getRGTarihi() {
		 return RGTarihi;
	 }

	 public void setRGTarihi(Date rGTarihi) {
		 RGTarihi = rGTarihi;
	 }

	 @Column(name="RGNo")
	 public Long getRGNo() {
		 return RGNo;
	 }
	
	 public void setRGNo(Long RGNo) {
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
	 
	 
	 public Long getTebligIcerikRoot() {
		return tebligIcerikRoot;
	 }


	 public void setTebligIcerikRoot(Long tebligIcerikRoot) {
		this.tebligIcerikRoot = tebligIcerikRoot;
	 }


}