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
import hud.iys.model.Cvoa;
import hud.iys.service.IKanunIcerikService;
import hud.iys.service.IKanunService;
import hud.iys.service.IMaddeIcerikService;
import hud.iys.service.ICvoaService;
import hud.iys.view.KanunDataModel;
import hud.iys.view.CvoaDataModel;


@ManagedBean(name="cvoaMB")
@SessionScoped
public class CVOABean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 @ManagedProperty(value="#{CvoaService}")
	 ICvoaService cvoaService;
	 
	
	 @ManagedProperty(value="#{mevzuatMB}")
	 private MevzuatBean mevzuatBean;
	 
	 private List<Cvoa> mevzuatCvoaList;
	 private CvoaDataModel cvoalarModel;
	
	
	
	 private String anlasmaAdi;
	 private String tarafDevlet;
	 private int RGNo;
	 private Date RGTarihi; 
	 private Date yururlukTarihi; 
	 private Date uygulanmaTarihi; 
	 private Date imzaTarihi; 
	 private String aciklama;
	 private String anlasmaMetni;
	 private Cvoa selectedCvoa;
	 
	 private boolean editModeOpen;

	 @PostConstruct
     public void init() {
		 editModeOpen = false;
		 
	 }

	 public String addCvoa() {
		  try {
			   Cvoa cvoa = new Cvoa();
			   cvoa.setAnlasmaAdi(getAnlasmaAdi());
			   cvoa.setTarafDevlet(getTarafDevlet());
			   cvoa.setRGNo(getRGNo());
			   cvoa.setRGTarihi(getRGTarihi());
			   cvoa.setYururlukTarihi(getYururlukTarihi());
			   cvoa.setUygulanmaTarihi(getUygulanmaTarihi());
			   cvoa.setImzaTarihi(getImzaTarihi());
			   cvoa.setAciklama(getAciklama());
			   cvoa.setAnlasmaMetni(getAnlasmaMetni());
			   cvoa.setDurumId(1);
			 
			   cvoa.setMevzuat(mevzuatBean.getSelectedMevzuat());
			   getCvoaService().addCvoa(cvoa);
			  
			   return SUCCESS;
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		  return ERROR;
	 }

	 public void reset() {
		 this.setAnlasmaAdi(null);
		 this.setTarafDevlet(null);
		 this.setRGNo(0);
		 this.setRGTarihi(null);
		 this.setYururlukTarihi(null);
		 this.setUygulanmaTarihi(null);
		 this.setImzaTarihi(null);
		 this.setAciklama(null);
		 this.setAnlasmaMetni(null);
	 }

	 public List<Cvoa> getMevzuatCvoaList() {
		  mevzuatCvoaList = new ArrayList<Cvoa>();
		  mevzuatCvoaList.addAll(getCvoaService().getCvoalarByMevzuatId(getMevzuatBean().getSelectedMevzuat().getMevzuatId()));
		  return mevzuatCvoaList;
	 }
	 
	 public void setMevzuatCvoaList(List<Cvoa> mevzuatCvoaList) {
		this.mevzuatCvoaList = mevzuatCvoaList;
	}

	public ICvoaService getCvoaService() {
		return cvoaService;
	}

	public void setCvoaService(ICvoaService cvoaService) {
		this.cvoaService = cvoaService;
	}

	public String getAnlasmaAdi() {
		return anlasmaAdi;
	}

	public void setAnlasmaAdi(String anlasmaAdi) {
		this.anlasmaAdi = anlasmaAdi;
	}

	public String getTarafDevlet() {
		return tarafDevlet;
	}

	public void setTarafDevlet(String tarafDevlet) {
		this.tarafDevlet = tarafDevlet;
	}

	

	public Date getYururlukTarihi() {
		return yururlukTarihi;
	}

	public void setYururlukTarihi(Date yururlukTarihi) {
		this.yururlukTarihi = yururlukTarihi;
	}

	public Date getUygulanmaTarihi() {
		return uygulanmaTarihi;
	}

	public void setUygulanmaTarihi(Date uygulanmaTarihi) {
		this.uygulanmaTarihi = uygulanmaTarihi;
	}

	public Date getImzaTarihi() {
		return imzaTarihi;
	}

	public void setImzaTarihi(Date imzaTarihi) {
		this.imzaTarihi = imzaTarihi;
	}

	public String getAnlasmaMetni() {
		return anlasmaMetni;
	}

	public void setAnlasmaMetni(String anlasmaMetni) {
		this.anlasmaMetni = anlasmaMetni;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public Cvoa getSelectedCvoa() {
		return selectedCvoa;
	}

	public void setSelectedCvoa(Cvoa selectedCvoa) {
		this.selectedCvoa = selectedCvoa;
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


		
	public MevzuatBean getMevzuatBean() {
		return mevzuatBean;
	}

	public void setMevzuatBean(MevzuatBean mevzuatBean) {
		this.mevzuatBean = mevzuatBean;
	}
	
	public CvoaDataModel getCvoalarModel() {
		cvoalarModel = new CvoaDataModel(getMevzuatCvoaList());
		return cvoalarModel;
	}

	public void setCvoalarModel(CvoaDataModel cvoalarModel) {
		this.cvoalarModel = cvoalarModel;
	}

	

	public void onRowSelect(SelectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Selected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
	
		
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml");
		FacesContext.getCurrentInstance().getExternalContext().redirect("cvoAnlasmaIcerik.xhtml?id=" +((Cvoa) event.getObject()).getCvoaId());


    }
 
	
	
    public void onRowUnselect(UnselectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Unselected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml?id=" +((MevzuatSeti) event.getObject()).getMevzuatSetiId());


    }
 
    public void updateCvoa() {
		 if (selectedCvoa != null) {
			 getCvoaService().updateCvoa(selectedCvoa);
			
		 }
		 editModeOpen = false;
	 }

    public void deleteCvoa() {
    	 if (selectedCvoa != null) {
			 getCvoaService().deleteCvoa(selectedCvoa);
			
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