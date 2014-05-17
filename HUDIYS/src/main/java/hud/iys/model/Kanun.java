package hud.iys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="KANUN")
public class Kanun {

	 private int kanunId;
	 private int kanunNo;
	 private String kanunAdi;
	 private int RGNo;
	 private String RGTarihi;


	 @Id
	 @Column(name="KanunID")
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 public int getKanunId() {
		 return kanunId;
	 }

	
	 public void setKanunId(int id) {
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
	 public String getRGTarihi() {
		 return RGTarihi;
	 }
	
	 
	 public void setRGTarihi(String RGTarihi) {
		 this.RGTarihi = RGTarihi;
	 } 
	 
	 
	 @Column(name="RGNo")
	 public int getRGNo() {
		 return RGNo;
	 }
	
	 public void setRGNo(int RGNo) {
		 this.RGNo = RGNo;
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