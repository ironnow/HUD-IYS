package hud.iys.view;

import hud.iys.model.Mevzuat;

import java.util.Date;

public class Icerik {
	
	 private Long icerikId;
	 private Long icerikNo;
	 private String icerikAdi;
	 private int RGNo;
	 private Date RGTarihi;
	 private Mevzuat mevzuat;
	 private Long icerikRoot;	 
	 private int durumId;
	 
	 
	public Long getIcerikId() {
		return icerikId;
	}
	public void setIcerikId(Long icerikId) {
		this.icerikId = icerikId;
	}
	public Long getIcerikNo() {
		return icerikNo;
	}
	public void setIcerikNo(Long icerikNo) {
		this.icerikNo = icerikNo;
	}
	public String getIcerikAdi() {
		return icerikAdi;
	}
	public void setIcerikAdi(String icerikAdi) {
		this.icerikAdi = icerikAdi;
	}
	public int getRGNo() {
		return RGNo;
	}
	public void setRGNo(int rGNo) {
		RGNo = rGNo;
	}
	public Date getRGTarihi() {
		return RGTarihi;
	}
	public void setRGTarihi(Date rGTarihi) {
		RGTarihi = rGTarihi;
	}
	public Mevzuat getMevzuat() {
		return mevzuat;
	}
	public void setMevzuat(Mevzuat mevzuat) {
		this.mevzuat = mevzuat;
	}
	public Long getIcerikRoot() {
		return icerikRoot;
	}
	public void setIcerikRoot(Long icerikRoot) {
		this.icerikRoot = icerikRoot;
	}
	public int getDurumId() {
		return durumId;
	}
	public void setDurumId(int durumId) {
		this.durumId = durumId;
	}
	
}
