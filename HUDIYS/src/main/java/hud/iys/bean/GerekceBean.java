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
import hud.iys.model.Gerekce;
import hud.iys.service.IKanunIcerikService;
import hud.iys.service.IKanunService;
import hud.iys.service.IMaddeIcerikService;
import hud.iys.service.IGerekceService;
import hud.iys.view.KanunDataModel;
import hud.iys.view.GerekceDataModel;


@ManagedBean(name="gerekceMB")
@SessionScoped
public class GerekceBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 //Spring Kanun Service is injected...
	 @ManagedProperty(value="#{GerekceService}")
	 IGerekceService gerekceService;
	 
	
	 @ManagedProperty(value="#{mevzuatMB}")
	 private MevzuatBean mevzuatBean;
	 
	 private List<Gerekce> mevzuatGerekceList;
	 private GerekceDataModel gerekcelerModel;
	
	
	
	 private String gerekceMetni;
	 private Long ilgiliKanunNo;
	 private String ilgiliKanunAdi;
	 private String aciklama;
	 
	 private Gerekce selectedGerekce;
	 
	 private boolean editModeOpen;

	 @PostConstruct
     public void init() {
		 editModeOpen = false;
		 
	 }

	 public String addGerekce() {
		  try {
			   Gerekce gerekce = new Gerekce();
			   gerekce.setGerekceMetni(getGerekceMetni());
			   gerekce.setIlgiliKanunNo(getIlgiliKanunNo());
			   gerekce.setIlgiliKanunAdi(getIlgiliKanunAdi());
			   gerekce.setAciklama(getAciklama());
			  
			   gerekce.setDurumId(1);
			 
			   gerekce.setMevzuat(mevzuatBean.getSelectedMevzuat());
			   getGerekceService().addGerekce(gerekce);
			  
			  
			   
			   return SUCCESS;
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		  return ERROR;
	 }

	 public void reset() {
		 this.setGerekceMetni(null);
		 this.setIlgiliKanunNo(0L);
		 this.setIlgiliKanunAdi(null);
		 this.setAciklama(null);
		 
	 }

	 public List<Gerekce> getMevzuatGerekceList() {
		  mevzuatGerekceList = new ArrayList<Gerekce>();
		  mevzuatGerekceList.addAll(getGerekceService().getGerekcelerByMevzuatId(getMevzuatBean().getSelectedMevzuat().getMevzuatId()));
		  return mevzuatGerekceList;
	 }
	 
	 public void setMevzuatGerekceList(List<Gerekce> mevzuatGerekceList) {
		this.mevzuatGerekceList = mevzuatGerekceList;
	}

	public IGerekceService getGerekceService() {
		return gerekceService;
	}

	public void setGerekceService(IGerekceService gerekceService) {
		this.gerekceService = gerekceService;
	}

	
	
	public String getGerekceMetni() {
		return gerekceMetni;
	}

	public void setGerekceMetni(String gerekceMetni) {
		this.gerekceMetni = gerekceMetni;
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

	public Gerekce getSelectedGerekce() {
		return selectedGerekce;
	}

	public void setSelectedGerekce(Gerekce selectedGerekce) {
		this.selectedGerekce = selectedGerekce;
	}

	
		
	public MevzuatBean getMevzuatBean() {
		return mevzuatBean;
	}

	public void setMevzuatBean(MevzuatBean mevzuatBean) {
		this.mevzuatBean = mevzuatBean;
	}
	
	public GerekceDataModel getGerekcelerModel() {
		gerekcelerModel = new GerekceDataModel(getMevzuatGerekceList());
		return gerekcelerModel;
	}

	public void setGerekcelerModel(GerekceDataModel gerekcelerModel) {
		this.gerekcelerModel = gerekcelerModel;
	}

	

	public void onRowSelect(SelectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Selected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
	
		
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml");
		FacesContext.getCurrentInstance().getExternalContext().redirect("gerekceIcerik.xhtml?id=" +((Gerekce) event.getObject()).getGerekceId());


    }
 
    public void onRowUnselect(UnselectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Unselected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml?id=" +((MevzuatSeti) event.getObject()).getMevzuatSetiId());


    }
 
    public void updateGerekce() {
		 if (selectedGerekce != null) {
			 getGerekceService().updateGerekce(selectedGerekce);
			
		 }
		 editModeOpen = false;
	 }

    public void deleteGerekce() {
    	 if (selectedGerekce != null) {
			 getGerekceService().deleteGerekce(selectedGerekce);
			
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