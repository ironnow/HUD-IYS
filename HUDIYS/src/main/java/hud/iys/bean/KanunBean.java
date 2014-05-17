package hud.iys.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.dao.DataAccessException;

import hud.iys.model.Kanun;
import hud.iys.service.IKanunService;


@ManagedBean(name="kanunMB")
@ViewScoped
public class KanunBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 //Spring Kanun Service is injected...
	 @ManagedProperty(value="#{KanunService}")
	 IKanunService kanunService;
	
	 List<Kanun> kanunList;
	
	 private int kanunNo;
	 private String kanunAdi;
	 private int RGNo;
	 private String RGTarihi;

	 public String addKanun() {
		  try {
			   Kanun kanun = new Kanun();
			   kanun.setKanunNo(getKanunNo());
			   kanun.setKanunAdi(getKanunAdi());
			   kanun.setRGNo(getRGNo());
			   kanun.setRGTarihi(getRGTarihi());
			  
			   getKanunService().addKanun(kanun);
			   return SUCCESS;
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		  return ERROR;
	 }

	 public void reset() {
		 this.setKanunNo(0);
		 this.setKanunAdi("");
		 this.setRGNo(0);
		 this.setRGTarihi("");
	 }

	 public List<Kanun> getKanunList() {
		  kanunList = new ArrayList<Kanun>();
		  kanunList.addAll(getKanunService().getKanunlar());
		  return kanunList;
	 }

	public IKanunService getKanunService() {
		return kanunService;
	}

	public void setKanunService(IKanunService kanunService) {
		this.kanunService = kanunService;
	}

	public int getKanunNo() {
		return kanunNo;
	}

	public void setKanunNo(int kanunNo) {
		this.kanunNo = kanunNo;
	}

	public String getKanunAdi() {
		return kanunAdi;
	}

	public void setKanunAdi(String kanunAdi) {
		this.kanunAdi = kanunAdi;
	}

	public int getRGNo() {
		return RGNo;
	}

	public void setRGNo(int rGNo) {
		RGNo = rGNo;
	}

	public String getRGTarihi() {
		return RGTarihi;
	}

	public void setRGTarihi(String rGTarihi) {
		RGTarihi = rGTarihi;
	}

	public void setKanunList(List<Kanun> kanunList) {
		this.kanunList = kanunList;
	}

 
	 

}