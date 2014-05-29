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
import hud.iys.service.IParagrafService;


@ManagedBean(name="paragrafMB")
@SessionScoped
public class ParagrafBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 //Spring Paragraf Service is injected...
	 @ManagedProperty(value="#{ParagrafService}")
	 IParagrafService paragrafService;
	 
	 @ManagedProperty(value="#{kanunIcerikMB}")
	 private KanunIcerikBean kanunIcerikBean;
	 
	 List<Paragraf> paragrafList;
	 
	 List<Bent> selectedParagrafBentList;
	
	 private Long paragrafNo;
	 private String paragrafMetin;
	
	 private Paragraf selectedParagraf;

	 public String addParagraf() {
		  try {
			   Paragraf paragraf = new Paragraf();
			   paragraf.setParagrafNo(getParagrafNo());
			   paragraf.setParagrafMetin(getParagrafMetin());
			  
			   paragraf.setKanunIcerik(kanunIcerikBean.getSelectedKanunIcerik());
			   getParagrafService().addParagraf(paragraf);
			  
			   return SUCCESS;
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		  return ERROR;
	 }

	 public void reset() {
		 this.setParagrafNo(0L);
		 this.setParagrafMetin("");
		 
	 }

	 public List<Paragraf> getPragrafList() {
		  paragrafList = new ArrayList<Paragraf>();
		  paragrafList.addAll(getParagrafService().getParagraflarByKanunIcerikId(kanunIcerikBean.getSelectedKanunIcerik().getKanunIcerikId()));
		  return paragrafList;
	 }

	 
	

	public IParagrafService getParagrafService() {
		return paragrafService;
	}

	public void setParagrafService(IParagrafService paragrafService) {
		this.paragrafService = paragrafService;
	}

	public KanunIcerikBean getKanunIcerikBean() {
		return kanunIcerikBean;
	}

	public void setKanunIcerikBean(KanunIcerikBean kanunIcerikBean) {
		this.kanunIcerikBean = kanunIcerikBean;
	}

	public List<Paragraf> getParagrafList() {
		return paragrafList;
	}

	public void setParagrafList(List<Paragraf> paragrafList) {
		this.paragrafList = paragrafList;
	}

	public List<Bent> getSelectedParagrafBentList() {
		return selectedParagrafBentList;
	}

	public void setSelectedParagrafBentList(List<Bent> selectedParagrafBentList) {
		this.selectedParagrafBentList = selectedParagrafBentList;
	}

	public Long getParagrafNo() {
		return paragrafNo;
	}

	public void setParagrafNo(Long paragrafNo) {
		this.paragrafNo = paragrafNo;
	}

	public String getParagrafMetin() {
		return paragrafMetin;
	}

	public void setParagrafMetin(String paragrafMetin) {
		this.paragrafMetin = paragrafMetin;
	}

	public Paragraf getSelectedParagraf() {
		return selectedParagraf;
	}

	public void setSelectedParagraf(Paragraf selectedParagraf) {
		this.selectedParagraf = selectedParagraf;
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