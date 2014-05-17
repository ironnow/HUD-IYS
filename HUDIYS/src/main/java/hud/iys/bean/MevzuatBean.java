package hud.iys.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.dao.DataAccessException;

import hud.iys.model.Mevzuat;
import hud.iys.model.MevzuatSeti;
import hud.iys.service.IMevzuatService;
import hud.iys.service.IMevzuatSetiService;


@ManagedBean(name="mevzuatMB")
@SessionScoped
public class MevzuatBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 //Spring Mevzuat Service is injected...
	 @ManagedProperty(value="#{MevzuatService}")
	 IMevzuatService mevzuatService;
	 
	 @ManagedProperty(value="#{MevzuatSetiService}")
	 IMevzuatSetiService mevzuatSetiService;
	 
	 @ManagedProperty(value="#{mevzuatSetiMB}")
	 private MevzuatSetiBean mevzuatSetiBean;
	 
	 
	 private Mevzuat selectedMevzuat;
		
	 List<Mevzuat> mevzuatList;
	
	 private String mevzuatAdi;
	 private String mevzuatAciklama;
	 private int mevzuatSetiId;

	 public String addMevzuat() {
		  try {
			   Mevzuat mevzuat = new Mevzuat();
			   mevzuat.setMevzuatAdi(getMevzuatAdi());
			   mevzuat.setMevzuatAciklama(getMevzuatAciklama());
			   
			   mevzuat.setMevzuatSeti(mevzuatSetiBean.getSelectedMevzuatSeti());
			  
			   getMevzuatService().addMevzuat(mevzuat);
			   return SUCCESS;
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		  return ERROR;
	 }

	 public void reset() {
		 this.setMevzuatAdi("");
		 this.setMevzuatAciklama("");
	 }

	 public List<Mevzuat> getMevzuatList() {
		  mevzuatList = new ArrayList<Mevzuat>();
		  mevzuatList.addAll(getMevzuatService().getMevzuatlar());
		  return mevzuatList;
	 }

	public IMevzuatService getMevzuatService() {
		return mevzuatService;
	}

	public void setMevzuatService(IMevzuatService mevzuatService) {
		this.mevzuatService = mevzuatService;
	}
	
	public IMevzuatSetiService getMevzuatSetiService() {
		return mevzuatSetiService;
	}

	public void setMevzuatSetiService(IMevzuatSetiService mevzuatSetiService) {
		this.mevzuatSetiService = mevzuatSetiService;
	}

	
	public String getMevzuatAdi() {
		return mevzuatAdi;
	}

	public void setMevzuatAdi(String mevzuatAdi) {
		this.mevzuatAdi = mevzuatAdi;
	}


	public String getMevzuatAciklama() {
		return mevzuatAciklama;
	}

	public void setMevzuatAciklama(String mevzuatAciklama) {
		this.mevzuatAciklama = mevzuatAciklama;
	}

	public int getMevzuatSetiId() {
		return mevzuatSetiId;
	}

	public void setMevzuatSetiId(int mevzuatSetiId) {
		this.mevzuatSetiId = mevzuatSetiId;
	}

	
	public void setMevzuatList(List<Mevzuat> mevzuatList) {
		this.mevzuatList = mevzuatList;
	}

	public MevzuatSetiBean getMevzuatSetiBean() {
		return mevzuatSetiBean;
	}

	public void setMevzuatSetiBean(MevzuatSetiBean mevzuatSetiBean) {
		this.mevzuatSetiBean = mevzuatSetiBean;
	}

	public Mevzuat getSelectedMevzuat() {
		return selectedMevzuat;
	}

	public void setSelectedMevzuat(Mevzuat selectedMevzuat) {
		this.selectedMevzuat = selectedMevzuat;
	}

	
	
	public void onRowSelect(SelectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Selected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
       
        FacesContext.getCurrentInstance().getExternalContext().redirect("MevzuatIcerik.jsf");


    }
 
    public void onRowUnselect(UnselectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Unselected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.jsf?id=" +((MevzuatSeti) event.getObject()).getMevzuatSetiId());


    }
	 
	 

}