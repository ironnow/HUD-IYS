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
import hud.iys.model.Khk;
import hud.iys.model.MaddeIcerik;
import hud.iys.model.Mevzuat;
import hud.iys.model.Bkk;
import hud.iys.service.IKanunIcerikService;
import hud.iys.service.IKanunService;
import hud.iys.service.IMaddeIcerikService;
import hud.iys.service.IBkkService;
import hud.iys.view.KanunDataModel;
import hud.iys.view.BkkDataModel;


@ManagedBean(name="bkkMB")
@SessionScoped
public class BKKBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 @ManagedProperty(value="#{BkkService}")
	 IBkkService bkkService;
	 
	
	 @ManagedProperty(value="#{mevzuatMB}")
	 private MevzuatBean mevzuatBean;
	 
	 private List<Bkk> mevzuatBkkList;
	 private BkkDataModel bkklarModel;
	
	
	 private Long bkkNo;
	 private String bkkAdi;
	 private int RGNo;
	 private Date RGTarihi; 
	 private Date kararTarihi; 
	 private String aciklama;
	 private String kararMetni;
	 
	 private Bkk selectedBkk;
	 
	 private boolean editModeOpen;

	 @PostConstruct
     public void init() {
		 editModeOpen = false;
		 
	 }
	 
	 public String addBkk() {
		  try {
			   Bkk bkk = new Bkk();
			   bkk.setBkkNo(getBkkNo());
			   bkk.setBkkAdi(getBkkAdi());
			   bkk.setRGNo(getRGNo());
			   bkk.setRGTarihi(getRGTarihi());
			   bkk.setKararTarihi(getKararTarihi());
			   bkk.setAciklama(getAciklama());
			   bkk.setKararMetni(getKararMetni());
			  
			   bkk.setDurumId(1);
			 
			   bkk.setMevzuat(mevzuatBean.getSelectedMevzuat());
			   getBkkService().addBkk(bkk);
			  
			   return SUCCESS;
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		  return ERROR;
	 }

	 public void reset() {
		 this.setBkkNo(0L);
		 this.setBkkAdi(null);
		 this.setRGNo(0);
		 this.setRGTarihi(null);
		 this.setKararTarihi(null);
		 this.setAciklama(null);
		 this.setKararMetni(null);
		 
	 }

	 public List<Bkk> getMevzuatBkkList() {
		  mevzuatBkkList = new ArrayList<Bkk>();
		  mevzuatBkkList.addAll(getBkkService().getBkklarByMevzuatId(getMevzuatBean().getSelectedMevzuat().getMevzuatId()));
		  return mevzuatBkkList;
	 }
	 
	 public void setMevzuatBkkList(List<Bkk> mevzuatBkkList) {
		this.mevzuatBkkList = mevzuatBkkList;
	}

	public IBkkService getBkkService() {
		return bkkService;
	}

	public void setBkkService(IBkkService bKKService) {
		this.bkkService = bKKService;
	}

	
	

	public Long getBkkNo() {
		return bkkNo;
	}

	public void setBkkNo(Long bkkNo) {
		this.bkkNo = bkkNo;
	}

	public String getBkkAdi() {
		return bkkAdi;
	}

	public void setBkkAdi(String bkkAdi) {
		this.bkkAdi = bkkAdi;
	}

	public Date getKararTarihi() {
		return kararTarihi;
	}

	public void setKararTarihi(Date kararTarihi) {
		this.kararTarihi = kararTarihi;
	}

	public String getKararMetni() {
		return kararMetni;
	}

	public void setKararMetni(String kararMetni) {
		this.kararMetni = kararMetni;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public Bkk getSelectedBkk() {
		return selectedBkk;
	}

	public void setSelectedBkk(Bkk selectedBkk) {
		this.selectedBkk = selectedBkk;
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
	
	public BkkDataModel getBkklarModel() {
		bkklarModel = new BkkDataModel(getMevzuatBkkList());
		return bkklarModel;
	}

	public void setBkklarModel(BkkDataModel bkklarModel) {
		this.bkklarModel = bkklarModel;
	}

	

	public void onRowSelect(SelectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Selected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
	
		
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml");
		FacesContext.getCurrentInstance().getExternalContext().redirect("bkkIcerik.xhtml?id=" +((Bkk) event.getObject()).getBkkId());


    }
 
	
	
    public void onRowUnselect(UnselectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Unselected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml?id=" +((MevzuatSeti) event.getObject()).getMevzuatSetiId());


    }
 
    public void updateBkk() {
		 if (selectedBkk != null) {
			 getBkkService().updateBkk(selectedBkk);
			
		 }
		 editModeOpen = false;
	 }

    public void deleteBkk() {
    	 if (selectedBkk != null) {
			 getBkkService().deleteBkk(selectedBkk);
			
		 }
    }

	public boolean isEditModeOpen() {
		return editModeOpen;
	}

	public void setEditModeOpen(boolean editModeOpen) {
		this.editModeOpen = editModeOpen;
	}
    
	public void openEditMode(){
    	editModeOpen = true;
    }
}