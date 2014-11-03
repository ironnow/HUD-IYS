package hud.iys.view;

public class TebligMetin {
	
	private String icerikAdi;
	
	private String icerikMetin;
	
	private String type;
	
	private Long icerikId;

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

	public TebligMetin(String icerikAdi, String icerikMetni) {
		super();
		this.icerikAdi = icerikAdi;
		this.icerikMetin = icerikMetni;
	}
	public TebligMetin() {		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getIcerikId() {
		return icerikId;
	}

	public void setIcerikId(Long icerikId) {
		this.icerikId = icerikId;
	}
	
	

}