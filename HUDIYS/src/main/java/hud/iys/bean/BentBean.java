package hud.iys.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.dao.DataAccessException;

import hud.iys.model.Bent;
import hud.iys.model.Paragraf;
import hud.iys.service.IBentService;
import hud.iys.service.IParagrafService;


@ManagedBean(name="bentMB")
@SessionScoped
public class BentBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 @ManagedProperty(value="#{BentService}")
	 IBentService bentService;
	 
	 @ManagedProperty(value="#{fikraMB}")
	 private FikraBean fikraBean;
	 
	 List<Bent> bentList;
	 
	 
	 private String bentSira;
	 private String bentMetin;
	
	 private Bent selectedBent;

	 public String addBent() {
		  try {
			   Bent bent = new Bent();
			   bent.setBentSira(getBentSira());
			   bent.setBentMetin(getBentMetin());
			  
			   bent.setFikra(fikraBean.getSelectedFikra());
			   
			   getBentService().addBent(bent);
			  
			   return SUCCESS;
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		  return ERROR;
	 }

	 public void reset() {
		 this.setBentSira("");
		 this.setBentMetin("");
		 
	 }

	 public List<Bent> getBentList() {
		  bentList = new ArrayList<Bent>();
		  bentList.addAll(getBentService().getBentlerByFikraId(fikraBean.getSelectedFikra().getFikraId()));
		  return bentList;
	 }

	 
	

	public IBentService getBentService() {
		return bentService;
	}

	public void setBentService(IBentService bentService) {
		this.bentService = bentService;
	}

	public FikraBean getFikraBean() {
		return fikraBean;
	}

	public void setFikraBean(FikraBean fikraBean) {
		this.fikraBean = fikraBean;
	}

	
	public void setBentList(List<Bent> bentList) {
		this.bentList = bentList;
	}

	

	public String getBentSira() {
		return bentSira;
	}

	public void setBentSira(String bentSira) {
		this.bentSira = bentSira;
	}

	public String getBentMetin() {
		return bentMetin;
	}

	public void setBentMetin(String bentMetin) {
		this.bentMetin = bentMetin;
	}

	public Bent getSelectedBent() {
		return selectedBent;
	}

	public void setSelectedBent(Bent selectedBent) {
		this.selectedBent = selectedBent;
	}

	public void onRowSelect(SelectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Selected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
		
		
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.jsf");
		

    }
 
    public void onRowUnselect(UnselectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Unselected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.jsf?id=" +((MevzuatSeti) event.getObject()).getMevzuatSetiId());


    }
 
	 

}