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
import hud.iys.model.IcGenelge;
import hud.iys.service.IKanunIcerikService;
import hud.iys.service.IKanunService;
import hud.iys.service.IMaddeIcerikService;
import hud.iys.service.IIcGenelgeService;
import hud.iys.view.KanunDataModel;
import hud.iys.view.IcGenelgeDataModel;


@ManagedBean(name="icGenelgeMB")
@SessionScoped
public class IcGenelgeBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 //Spring Kanun Service is injected...
	 @ManagedProperty(value="#{IcGenelgeService}")
	 IIcGenelgeService icGenelgeService;
	 
	
	 @ManagedProperty(value="#{mevzuatMB}")
	 private MevzuatBean mevzuatBean;
	 
	 private List<IcGenelge> mevzuatIcGenelgeList;
	 private IcGenelgeDataModel icGenelgelerModel;
	
	 private String icGenelgeAdi;
	 private String icGenelgeKonu;
	 private int siraNo;
	 private int sayi;
	 private Date tarih; 
	 private Long ilgiliKanunNo;
	 private String ilgiliKanunAdi;
	 private String metin;
	 private String aciklama;
	 
	 private IcGenelge selectedIcGenelge;
	 
	 private boolean editModeOpen;

	 @PostConstruct
     public void init() {
		 editModeOpen = false;
		 
	 }

	 public String addIcGenelge() {
		  try {
			   IcGenelge icGenelge = new IcGenelge();
			   icGenelge.setIcGenelgeAdi(getIcGenelgeAdi());
			   icGenelge.setIcGenelgeKonu(getIcGenelgeKonu());
			   icGenelge.setSayi(getSayi());
			   icGenelge.setSiraNo(getSiraNo());
			   icGenelge.setTarih(getTarih());
			   icGenelge.setIlgiliKanunNo(getIlgiliKanunNo());
			   icGenelge.setIlgiliKanunAdi(getIlgiliKanunAdi());
			   icGenelge.setMetin(getMetin());
			   icGenelge.setAciklama(getAciklama());
			  
			   icGenelge.setDurumId(1);
			 
			   
			   icGenelge.setMevzuat(mevzuatBean.getSelectedMevzuat());
			   getIcGenelgeService().addIcGenelge(icGenelge);
			  
			  
			   
			   return SUCCESS;
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		  return ERROR;
	 }

	 public void reset() {
		 this.setIcGenelgeAdi(null);
		 this.setIcGenelgeKonu(null);
		 this.setSayi(0);
		 this.setSiraNo(0);
		 this.setTarih(null);
		 this.setIlgiliKanunNo(0L);
		 this.setIlgiliKanunAdi(null);
		 this.setMetin(null);
		 this.setAciklama(null);
		 
	 }

	 public List<IcGenelge> getMevzuatIcGenelgeList() {
		  mevzuatIcGenelgeList = new ArrayList<IcGenelge>();
		  mevzuatIcGenelgeList.addAll(getIcGenelgeService().getIcGenelgelerByMevzuatId(getMevzuatBean().getSelectedMevzuat().getMevzuatId()));
		  return mevzuatIcGenelgeList;
	 }
	 
	 public void setMevzuatIcGenelgeList(List<IcGenelge> mevzuatIcGenelgeList) {
		this.mevzuatIcGenelgeList = mevzuatIcGenelgeList;
	}

	public IIcGenelgeService getIcGenelgeService() {
		return icGenelgeService;
	}

	public void setIcGenelgeService(IIcGenelgeService icGenelgeService) {
		this.icGenelgeService = icGenelgeService;
	}

	
	public String getIcGenelgeAdi() {
		return icGenelgeAdi;
	}

	public void setIcGenelgeAdi(String icGenelgeAdi) {
		this.icGenelgeAdi = icGenelgeAdi;
	}


	public String getIcGenelgeKonu() {
		return icGenelgeKonu;
	}

	public void setIcGenelgeKonu(String icGenelgeKonu) {
		this.icGenelgeKonu = icGenelgeKonu;
	}

	public int getSiraNo() {
		return siraNo;
	}

	public void setSiraNo(int siraNo) {
		this.siraNo = siraNo;
	}

	public int getSayi() {
		return sayi;
	}

	public void setSayi(int sayi) {
		this.sayi = sayi;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	public String getMetin() {
		return metin;
	}

	public void setMetin(String metin) {
		this.metin = metin;
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

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public IcGenelge getSelectedIcGenelge() {
		return selectedIcGenelge;
	}

	public void setSelectedIcGenelge(IcGenelge selectedIcGenelge) {
		this.selectedIcGenelge = selectedIcGenelge;
	}

	
		
	public MevzuatBean getMevzuatBean() {
		return mevzuatBean;
	}

	public void setMevzuatBean(MevzuatBean mevzuatBean) {
		this.mevzuatBean = mevzuatBean;
	}
	
	public IcGenelgeDataModel getIcGenelgelerModel() {
		icGenelgelerModel = new IcGenelgeDataModel(getMevzuatIcGenelgeList());
		return icGenelgelerModel;
	}

	public void setIcGenelgelerModel(IcGenelgeDataModel icGenelgelerModel) {
		this.icGenelgelerModel = icGenelgelerModel;
	}

	

	public void onRowSelect(SelectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Selected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
	
		
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml");
		FacesContext.getCurrentInstance().getExternalContext().redirect("icGenelgeIcerik.xhtml?id=" +((IcGenelge) event.getObject()).getIcGenelgeId());


    }
 
	
	
    public void onRowUnselect(UnselectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Unselected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml?id=" +((MevzuatSeti) event.getObject()).getMevzuatSetiId());


    }
 
    public void updateIcGenelge() {
		 if (selectedIcGenelge != null) {
			 getIcGenelgeService().updateIcGenelge(selectedIcGenelge);
			
		 }
		 editModeOpen = false;
	 }

    public void deleteIcGenelge() {
    	 if (selectedIcGenelge != null) {
			 getIcGenelgeService().deleteIcGenelge(selectedIcGenelge);
			
		 }
    }
    
    public boolean getEditModeOpen() {
		return editModeOpen;
	}

	public void setEditModeOpen(boolean editModeOpen) {
		this.editModeOpen = editModeOpen;
	}
    
	public void openEditMode(){
    	editModeOpen = true;
    }
}