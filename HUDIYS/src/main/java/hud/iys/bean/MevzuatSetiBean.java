package hud.iys.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Transient;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.dao.DataAccessException;

import hud.iys.model.Mevzuat;
import hud.iys.model.MevzuatSeti;
import hud.iys.service.IMevzuatService;
import hud.iys.service.IMevzuatSetiService;
import hud.iys.view.MevzuatDataModel;
import hud.iys.view.MevzuatSetiDataModel;


@ManagedBean(name="mevzuatSetiMB")
@SessionScoped
public class MevzuatSetiBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 //Spring MevzuatSeti Service is injected...
	 @ManagedProperty(value="#{MevzuatSetiService}")
	 IMevzuatSetiService mevzuatSetiService;
	 
	 @Transient
	 @ManagedProperty(value="#{MevzuatService}")
	 IMevzuatService mevzuatService;
	
	 List<MevzuatSeti> mevzuatSetiList;
	 
	 
	
	 private String mevzuatSetiAdi;
	 private String mevzuatSetiAciklama;
	 
	 private MevzuatSeti selectedMevzuatSeti;
	 
	 private MevzuatSetiDataModel mevzuatSetleriModel;
	 
	
	 
	 
	 public String addMevzuatSeti() {
		  try {
			   MevzuatSeti mevzuatSeti = new MevzuatSeti();
			   mevzuatSeti.setMevzuatSetiAdi(getMevzuatSetiAdi());
			   mevzuatSeti.setMevzuatSetiAciklama(getMevzuatSetiAciklama());
			  
			   getMevzuatSetiService().addMevzuatSeti(mevzuatSeti);
			   return SUCCESS;
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		  return ERROR;
	 }

	 public void reset() {
		 this.setMevzuatSetiAdi("");
		 this.setMevzuatSetiAciklama("");
	 }

	 public List<MevzuatSeti> getMevzuatSetiList() {
		  mevzuatSetiList = new ArrayList<MevzuatSeti>();
		  mevzuatSetiList.addAll(getMevzuatSetiService().getMevzuatSetleri());
		  return mevzuatSetiList;
	 }
	 
	

	public IMevzuatSetiService getMevzuatSetiService() {
		return mevzuatSetiService;
	}

	public void setMevzuatSetiService(IMevzuatSetiService mevzuatSetiService) {
		this.mevzuatSetiService = mevzuatSetiService;
	}

	public IMevzuatService getMevzuatService() {
		return mevzuatService;
	}

	public void setMevzuatService(IMevzuatService mevzuatService) {
		this.mevzuatService = mevzuatService;
	}

	
	public String getMevzuatSetiAdi() {
		return mevzuatSetiAdi;
	}

	public void setMevzuatSetiAdi(String mevzuatSetiAdi) {
		this.mevzuatSetiAdi = mevzuatSetiAdi;
	}


	public String getMevzuatSetiAciklama() {
		return mevzuatSetiAciklama;
	}

	public void setMevzuatSetiAciklama(String mevzuatSetiAciklama) {
		this.mevzuatSetiAciklama = mevzuatSetiAciklama;
	}

	public void setMevzuatSetiList(List<MevzuatSeti> mevzuatSetiList) {
		this.mevzuatSetiList = mevzuatSetiList;
	}

	public MevzuatSeti getSelectedMevzuatSeti() {
		return selectedMevzuatSeti;
	}

	public void setSelectedMevzuatSeti(MevzuatSeti selectedMevzuatSeti) {
		this.selectedMevzuatSeti = selectedMevzuatSeti;
	}

 	
	
	
	public MevzuatSetiDataModel getMevzuatSetleriModel() {
		mevzuatSetleriModel = new MevzuatSetiDataModel(getMevzuatSetiList());
		return mevzuatSetleriModel;
	}

	public void setMevzuatSetleriModel(MevzuatSetiDataModel mevzuatSetleriModel) {
		this.mevzuatSetleriModel = mevzuatSetleriModel;
	}
	
	
	
	
	

	public void onRowSelect(SelectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Selected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
       
		
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml");
		FacesContext.getCurrentInstance().getExternalContext().redirect("mevzuat.xhtml?id=" +((MevzuatSeti) event.getObject()).getMevzuatSetiId());


    }
 
    public void onRowUnselect(UnselectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Unselected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml?id=" +((MevzuatSeti) event.getObject()).getMevzuatSetiId());


    }
	 

}