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
import hud.iys.model.Sirkuler;
import hud.iys.service.IKanunIcerikService;
import hud.iys.service.IKanunService;
import hud.iys.service.IMaddeIcerikService;
import hud.iys.service.ISirkulerService;
import hud.iys.view.KanunDataModel;
import hud.iys.view.SirkulerDataModel;


@ManagedBean(name="sirkulerMB")
@SessionScoped
public class SirkulerBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 //Spring Kanun Service is injected...
	 @ManagedProperty(value="#{SirkulerService}")
	 ISirkulerService sirkulerService;
	 
	
	 @ManagedProperty(value="#{mevzuatMB}")
	 private MevzuatBean mevzuatBean;
	 
	 private List<Sirkuler> mevzuatSirkulerList;
	 private SirkulerDataModel sirkulerlerModel;
	
	
	
	 private String sirkulerAdi;
	 private String sirkulerKonu;
	 private int sayi;
	 private Date tarih; 
	 private Long ilgiliKanunNo;
	 private String ilgiliKanunAdi;
	 private String aciklama;
	 private String metin;
	 
	 private Sirkuler selectedSirkuler;
	 
	 private boolean editModeOpen;

	 @PostConstruct
     public void init() {
		 editModeOpen = false;
		 
	 }

	 public String addSirkuler() {
		  try {
			   Sirkuler sirkuler = new Sirkuler();
			   sirkuler.setSirkulerAdi(getSirkulerAdi());
			   sirkuler.setSirkulerKonu(getSirkulerKonu());
			   sirkuler.setSayi(getSayi());
			   sirkuler.setTarih(getTarih());
			   sirkuler.setIlgiliKanunNo(getIlgiliKanunNo());
			   sirkuler.setIlgiliKanunAdi(getIlgiliKanunAdi());
			   sirkuler.setAciklama(getAciklama());
			   sirkuler.setMetin(getMetin());
			   sirkuler.setDurumId(1);
			 
			   
			   sirkuler.setMevzuat(mevzuatBean.getSelectedMevzuat());
			   getSirkulerService().addSirkuler(sirkuler);
			  
			  
			   
			   return SUCCESS;
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		  return ERROR;
	 }

	 public void reset() {
		 this.setSirkulerAdi(null);
		 this.setSirkulerKonu(null);
		 this.setSayi(0);
		 this.setTarih(null);
		 this.setIlgiliKanunNo(0L);
		 this.setIlgiliKanunAdi(null);
		 this.setMetin(null);
		 this.setAciklama(null);
		 
	 }

	 public List<Sirkuler> getMevzuatSirkulerList() {
		  mevzuatSirkulerList = new ArrayList<Sirkuler>();
		  mevzuatSirkulerList.addAll(getSirkulerService().getSirkulerlerByMevzuatId(getMevzuatBean().getSelectedMevzuat().getMevzuatId()));
		  return mevzuatSirkulerList;
	 }
	 
	 public void setMevzuatSirkulerList(List<Sirkuler> mevzuatSirkulerList) {
		this.mevzuatSirkulerList = mevzuatSirkulerList;
	}

	public ISirkulerService getSirkulerService() {
		return sirkulerService;
	}

	public void setSirkulerService(ISirkulerService sirkulerService) {
		this.sirkulerService = sirkulerService;
	}

	
	public String getSirkulerAdi() {
		return sirkulerAdi;
	}

	public void setSirkulerAdi(String sirkulerAdi) {
		this.sirkulerAdi = sirkulerAdi;
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

	public Sirkuler getSelectedSirkuler() {
		return selectedSirkuler;
	}

	public void setSelectedSirkuler(Sirkuler selectedSirkuler) {
		this.selectedSirkuler = selectedSirkuler;
	}

		
	public String getSirkulerKonu() {
		return sirkulerKonu;
	}

	public void setSirkulerKonu(String sirkulerKonu) {
		this.sirkulerKonu = sirkulerKonu;
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

	public MevzuatBean getMevzuatBean() {
		return mevzuatBean;
	}

	public void setMevzuatBean(MevzuatBean mevzuatBean) {
		this.mevzuatBean = mevzuatBean;
	}
	
	public SirkulerDataModel getSirkulerlerModel() {
		sirkulerlerModel = new SirkulerDataModel(getMevzuatSirkulerList());
		return sirkulerlerModel;
	}

	public void setSirkulerlerModel(SirkulerDataModel sirkulerlerModel) {
		this.sirkulerlerModel = sirkulerlerModel;
	}

	

	public void onRowSelect(SelectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Selected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
	
		
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml");
		FacesContext.getCurrentInstance().getExternalContext().redirect("sirkulerIcerik.xhtml?id=" +((Sirkuler) event.getObject()).getSirkulerId());


    }
 
	
	
    public void onRowUnselect(UnselectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Unselected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml?id=" +((MevzuatSeti) event.getObject()).getMevzuatSetiId());


    }
 
    public void updateSirkuler() {
		 if (selectedSirkuler != null) {
			 getSirkulerService().updateSirkuler(selectedSirkuler);
			
		 }
		 editModeOpen = false;
	 }

    public void deleteSirkuler() {
    	 if (selectedSirkuler != null) {
			 getSirkulerService().deleteSirkuler(selectedSirkuler);
			
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