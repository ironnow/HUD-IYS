package hud.iys.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.dao.DataAccessException;

import hud.iys.model.Kanun;
import hud.iys.model.KanunIcerik;
import hud.iys.model.MaddeIcerik;
import hud.iys.model.Mevzuat;
import hud.iys.model.Yonetmelik;
import hud.iys.service.IKanunIcerikService;
import hud.iys.service.IKanunService;
import hud.iys.service.IMaddeIcerikService;
import hud.iys.service.IYonetmelikService;
import hud.iys.view.KanunDataModel;
import hud.iys.view.YonetmelikDataModel;


@ManagedBean(name="yonetmelikMB")
@SessionScoped
public class YonetmelikBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 //Spring Kanun Service is injected...
	 @ManagedProperty(value="#{YonetmelikService}")
	 IYonetmelikService yonetmelikService;
	 
	
	 @ManagedProperty(value="#{mevzuatMB}")
	 private MevzuatBean mevzuatBean;
	 
	 private List<Yonetmelik> mevzuatYonetmelikList;
	 private YonetmelikDataModel yonetmeliklerModel;
	
	
	
	 private String yonetmelikAdi;
	 private String yonetmelikTuru;
	 private int RGNo;
	 private Date RGTarihi; 
	 private Long ilgiliKanunNo;
	 private String ilgiliKanunAdi;
	 private String kurum;
	 private String aciklama;
	 private String metin;
	 
	 private Yonetmelik selectedYonetmelik;
	 
	 private boolean editModeOpen;
	 
	 
	 @PostConstruct
     public void init() {
		 editModeOpen = false;
		 
	 }

	 public String addYonetmelik() {
		  try {
			   Yonetmelik yonetmelik = new Yonetmelik();
			   yonetmelik.setYonetmelikAdi(getYonetmelikAdi());
			   yonetmelik.setYonetmelikTuru(getYonetmelikTuru());
			   yonetmelik.setRGNo(getRGNo());
			   yonetmelik.setRGTarihi(getRGTarihi());
			   yonetmelik.setIlgiliKanunNo(getIlgiliKanunNo());
			   yonetmelik.setIlgiliKanunAdi(getIlgiliKanunAdi());
			   yonetmelik.setKurum(getKurum());
			   yonetmelik.setAciklama(getAciklama());
			  
			   yonetmelik.setDurumId(1);
			 
			   
			   yonetmelik.setMevzuat(mevzuatBean.getSelectedMevzuat());
			   getYonetmelikService().addYonetmelik(yonetmelik);
			  
			  
			   
			   return SUCCESS;
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		  return ERROR;
	 }

	 public void reset() {
		 this.setYonetmelikAdi(null);
		 this.setYonetmelikTuru(null);
		 this.setRGNo(0);
		 this.setRGTarihi(null);
		 this.setIlgiliKanunNo(0L);
		 this.setIlgiliKanunAdi(null);
		 this.setKurum(null);
		 this.setAciklama(null);
		 
	 }

	 public List<Yonetmelik> getMevzuatYonetmelikList() {
		  mevzuatYonetmelikList = new ArrayList<Yonetmelik>();
		  mevzuatYonetmelikList.addAll(getYonetmelikService().getYonetmeliklerByMevzuatId(getMevzuatBean().getSelectedMevzuat().getMevzuatId()));
		  return mevzuatYonetmelikList;
	 }
	 
	 public void setMevzuatYonetmelikList(List<Yonetmelik> mevzuatYonetmelikList) {
		this.mevzuatYonetmelikList = mevzuatYonetmelikList;
	}

	public IYonetmelikService getYonetmelikService() {
		return yonetmelikService;
	}

	public void setYonetmelikService(IYonetmelikService yonetmelikService) {
		this.yonetmelikService = yonetmelikService;
	}

	
	public String getYonetmelikAdi() {
		return yonetmelikAdi;
	}

	public void setYonetmelikAdi(String yonetmelikAdi) {
		this.yonetmelikAdi = yonetmelikAdi;
	}

	public String getYonetmelikTuru() {
		return yonetmelikTuru;
	}

	public void setYonetmelikTuru(String yonetmelikTuru) {
		this.yonetmelikTuru = yonetmelikTuru;
	}

	public Long getIlgiliKanunNo() {
		return ilgiliKanunNo;
	}

	public void setIlgiliKanunNo(Long ilgiliKanunNo) {
		this.ilgiliKanunNo = ilgiliKanunNo;
	}

	public String getIlgiliKanunAdi() {
		return ilgiliKanunAdi;
	}

	public void setIlgiliKanunAdi(String ilgiliKanunAdi) {
		this.ilgiliKanunAdi = ilgiliKanunAdi;
	}

	public String getKurum() {
		return kurum;
	}

	public void setKurum(String kurum) {
		this.kurum = kurum;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public Yonetmelik getSelectedYonetmelik() {
		return selectedYonetmelik;
	}

	public void setSelectedYonetmelik(Yonetmelik selectedYonetmelik) {
		this.selectedYonetmelik = selectedYonetmelik;
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

	public String getMetin() {
		return metin;
	}

	public void setMetin(String metin) {
		this.metin = metin;
	}

	public MevzuatBean getMevzuatBean() {
		return mevzuatBean;
	}

	public void setMevzuatBean(MevzuatBean mevzuatBean) {
		this.mevzuatBean = mevzuatBean;
	}
	
	public YonetmelikDataModel getYonetmeliklerModel() {
		yonetmeliklerModel = new YonetmelikDataModel(getMevzuatYonetmelikList());
		return yonetmeliklerModel;
	}

	public void setYonetmeliklerModel(YonetmelikDataModel yonetmeliklerModel) {
		this.yonetmeliklerModel = yonetmeliklerModel;
	}


	public boolean getEditModeOpen() {
		return editModeOpen;
	}

	public void setEditModeOpen(boolean editModeOpen) {
		this.editModeOpen = editModeOpen;
	}

	public void onRowSelect(SelectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Selected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
	
		
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml");
		FacesContext.getCurrentInstance().getExternalContext().redirect("yonetmelikIcerik.xhtml?id=" +((Yonetmelik) event.getObject()).getYonetmelikId());


    }
 
	
	
    public void onRowUnselect(UnselectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Unselected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml?id=" +((MevzuatSeti) event.getObject()).getMevzuatSetiId());


    }
 
    public void updateYonetmelik() {
		 if (selectedYonetmelik != null) {
			 getYonetmelikService().updateYonetmelik(selectedYonetmelik);
			
		 }
		 editModeOpen = false;
	 }

    public void deleteYonetmelik() {
    	 if (selectedYonetmelik != null) {
			 getYonetmelikService().deleteYonetmelik(selectedYonetmelik);
			
		 }
    }
    
    public void openEditMode(){
    	editModeOpen = true;
    }
}