package hud.iys.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

import hud.iys.model.Dipnot;
import hud.iys.model.DipnotMI;
import hud.iys.model.Kanun;
import hud.iys.model.Mevzuat;
import hud.iys.model.MevzuatSeti;
import hud.iys.model.Teblig;
import hud.iys.service.IDipnotMIService;
import hud.iys.service.IKanunService;
import hud.iys.service.ITebligService;
import hud.iys.service.IMevzuatService;
import hud.iys.service.IMevzuatSetiService;
import hud.iys.view.KanunDataModel;
import hud.iys.view.MevzuatDataModel;
import hud.iys.view.MevzuatSetiDataModel;
import hud.iys.view.TebligDataModel;


@ManagedBean(name="dipnotMB")
@SessionScoped
public class DipnotBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 @ManagedProperty(value="#{DipnotService}")
	 IDipnotMIService dipnotService;
	 
	 private ArrayList<Dipnot> dipnotlar;
		
	
	 private String dipnotNo;
	 private String dipnotMetin;
	 
	 
	 public IDipnotMIService getDipnotService() {
		 return dipnotService;
	 }
	 
	 public void setDipnotService(IDipnotMIService dipnotService) {
		 this.dipnotService = dipnotService;
	 }
	 
	
	 
	 public ArrayList<Dipnot> getDipnotlar() {
		return dipnotlar;
	}

	public void setDipnotlar(ArrayList<Dipnot> dipnotlar) {
		this.dipnotlar = dipnotlar;
	}

	public String getDipnotNo() {
		 return dipnotNo;
	 }
	 
	 public void setDipnotNo(String dipnotNo) {
		 this.dipnotNo = dipnotNo;
	 }
	 
	 public String getDipnotMetin() {
		 return dipnotMetin;
	 }
	 
	 public void setDipnotMetin(String dipnotMetin) {
		 this.dipnotMetin = dipnotMetin;
	 }	 
	 
	 

}