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
import hud.iys.model.Khk;
import hud.iys.service.IKanunIcerikService;
import hud.iys.service.IKanunService;
import hud.iys.service.IMaddeIcerikService;
import hud.iys.service.IKhkService;
import hud.iys.view.KanunDataModel;
import hud.iys.view.KhkDataModel;


@ManagedBean(name="khkMB")
@SessionScoped
public class KHKBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 @ManagedProperty(value="#{KhkService}")
	 IKhkService khkService;
	 
	
	 @ManagedProperty(value="#{mevzuatMB}")
	 private MevzuatBean mevzuatBean;
	 
	 private List<Khk> mevzuatKhkList;
	 private KhkDataModel khklarModel;
	
	
	 private Long khkNo;
	 private String khkAdi;
	 private int RGNo;
	 private Date RGTarihi; 
	 private Date kabulTarihi; 
	 private String aciklama;
	 private String khkMetni;
	 
	 private Khk selectedKhk;
	 
	 private boolean editModeOpen;

	 @PostConstruct
     public void init() {
		 editModeOpen = false;
		 
	 }

	 public String addKhk() {
		  try {
			   Khk khk = new Khk();
			   khk.setKhkNo(getKhkNo());
			   khk.setKhkAdi(getKhkAdi());
			   khk.setRGNo(getRGNo());
			   khk.setRGTarihi(getRGTarihi());
			   khk.setKabulTarihi(getKabulTarihi());
			   khk.setAciklama(getAciklama());
			   khk.setKhkMetni(getKhkMetni());
			  
			   khk.setDurumId(1);
			 
			   
			   khk.setMevzuat(mevzuatBean.getSelectedMevzuat());
			   getKhkService().addKhk(khk);
			  
			  
			   
			   return SUCCESS;
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		  return ERROR;
	 }

	 public void reset() {
		 this.setKhkNo(0L);
		 this.setKhkAdi(null);
		 this.setRGNo(0);
		 this.setRGTarihi(null);
		 this.setKabulTarihi(null);
		 this.setAciklama(null);
		 this.setKhkMetni(null);
		 
	 }

	 public List<Khk> getMevzuatKhkList() {
		  mevzuatKhkList = new ArrayList<Khk>();
		  mevzuatKhkList.addAll(getKhkService().getKhklarByMevzuatId(getMevzuatBean().getSelectedMevzuat().getMevzuatId()));
		  return mevzuatKhkList;
	 }
	 
	 public void setMevzuatKhkList(List<Khk> mevzuatKhkList) {
		this.mevzuatKhkList = mevzuatKhkList;
	}

	public IKhkService getKhkService() {
		return khkService;
	}

	public void setKhkService(IKhkService khkService) {
		this.khkService = khkService;
	}

	
	public String getKhkAdi() {
		return khkAdi;
	}

	public void setKhkAdi(String khkAdi) {
		this.khkAdi = khkAdi;
	}


	public Long getKhkNo() {
		return khkNo;
	}

	public void setKhkNo(Long khkNo) {
		this.khkNo = khkNo;
	}

	public Date getKabulTarihi() {
		return kabulTarihi;
	}

	public void setKabulTarihi(Date kabulTarihi) {
		this.kabulTarihi = kabulTarihi;
	}

	public String getKhkMetni() {
		return khkMetni;
	}

	public void setKhkMetni(String khkMetni) {
		this.khkMetni = khkMetni;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public Khk getSelectedKhk() {
		return selectedKhk;
	}

	public void setSelectedKhk(Khk selectedKhk) {
		this.selectedKhk = selectedKhk;
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
	
	public KhkDataModel getKhklarModel() {
		khklarModel = new KhkDataModel(getMevzuatKhkList());
		return khklarModel;
	}

	public void setKhklarModel(KhkDataModel khklarModel) {
		this.khklarModel = khklarModel;
	}

	

	public void onRowSelect(SelectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Selected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
	
		
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml");
		FacesContext.getCurrentInstance().getExternalContext().redirect("khkIcerik.xhtml?id=" +((Khk) event.getObject()).getKhkId());


    }
 
	
	
    public void onRowUnselect(UnselectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Unselected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml?id=" +((MevzuatSeti) event.getObject()).getMevzuatSetiId());


    }
 
    public void updateKhk() {
		 if (selectedKhk != null) {
			 getKhkService().updateKhk(selectedKhk);
			
		 }
		 editModeOpen = false;
	 }

    public void deleteKhk() {
    	 if (selectedKhk != null) {
			 getKhkService().deleteKhk(selectedKhk);
			
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