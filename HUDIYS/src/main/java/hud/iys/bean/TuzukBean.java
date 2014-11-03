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
import hud.iys.model.Tuzuk;
import hud.iys.service.IKanunIcerikService;
import hud.iys.service.IKanunService;
import hud.iys.service.IMaddeIcerikService;
import hud.iys.service.ITuzukService;
import hud.iys.view.KanunDataModel;
import hud.iys.view.TuzukDataModel;


@ManagedBean(name="tuzukMB")
@SessionScoped
public class TuzukBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 //Spring Kanun Service is injected...
	 @ManagedProperty(value="#{TuzukService}")
	 ITuzukService tuzukService;
	 
	
	 @ManagedProperty(value="#{mevzuatMB}")
	 private MevzuatBean mevzuatBean;
	 
	 private List<Tuzuk> mevzuatTuzukList;
	 private TuzukDataModel tuzuklerModel;
	
	
	
	 private String tuzukAdi;
	 private int bkkNo;
	 private Date bkkTarihi;
	 private int dayandigiKanunNo;
	 private Date dayandigiKanunTarihi; 
	 private int RGNo;
	 private Date RGTarihi;	
	 private String aciklama;
	 private String kararMetni;
	 private int dusturTertibi;
	 private int dusturCildi;
	 private int dusturSayfasi;
	 
	 private Tuzuk selectedTuzuk;
	 
	 private boolean editModeOpen;

	 @PostConstruct
     public void init() {
		 editModeOpen = false;
		 
	 }

	 public String addTuzuk() {
		  try {
			   Tuzuk tuzuk = new Tuzuk();
			   tuzuk.setTuzukAdi(getTuzukAdi());
			   tuzuk.setBkkNo(getBkkNo());
			   tuzuk.setBkkTarihi(getBkkTarihi());
			   tuzuk.setRGNo(getRGNo());
			   tuzuk.setRGTarihi(getRGTarihi());
			   tuzuk.setDayandigiKanunNo(getDayandigiKanunNo());
			   tuzuk.setDayandigiKanunTarihi(getDayandigiKanunTarihi());
			   tuzuk.setAciklama(getAciklama());
			   tuzuk.setKararMetni(getKararMetni());
			   tuzuk.setDusturTertibi(getDusturTertibi());
			   tuzuk.setDusturCildi(getDusturCildi());
			   tuzuk.setDusturSayfasi(getDusturSayfasi());
			   tuzuk.setDurumId(1);			 
			   
			   tuzuk.setMevzuat(mevzuatBean.getSelectedMevzuat());
			   getTuzukService().addTuzuk(tuzuk);			  
			   
			   return SUCCESS;
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		  return ERROR;
	 }

	 public void reset() {
		 this.setTuzukAdi(null);
		 this.setBkkNo(0);
		 this.setBkkTarihi(null);
		 this.setRGNo(0);
		 this.setRGTarihi(null);
		 this.setDayandigiKanunNo(0);
		 this.setDayandigiKanunTarihi(null);
		 this.setDusturCildi(0);
		 this.setDusturTertibi(0);
		 this.setDusturSayfasi(0);
		 this.setAciklama(null);
		 this.setKararMetni(null);
	 }

	 public List<Tuzuk> getMevzuatTuzukList() {
		  mevzuatTuzukList = new ArrayList<Tuzuk>();
		  mevzuatTuzukList.addAll(getTuzukService().getTuzuklerByMevzuatId(getMevzuatBean().getSelectedMevzuat().getMevzuatId()));
		  return mevzuatTuzukList;
	 }
	 
	 public void setMevzuatTuzukList(List<Tuzuk> mevzuatTuzukList) {
		this.mevzuatTuzukList = mevzuatTuzukList;
	}

	public ITuzukService getTuzukService() {
		return tuzukService;
	}

	public void setTuzukService(ITuzukService tuzukService) {
		this.tuzukService = tuzukService;
	}

	
	public String getTuzukAdi() {
		return tuzukAdi;
	}

	public void setTuzukAdi(String tuzukAdi) {
		this.tuzukAdi = tuzukAdi;
	}


	public int getBkkNo() {
		return bkkNo;
	}

	public void setBkkNo(int bkkNo) {
		this.bkkNo = bkkNo;
	}

	public Date getBkkTarihi() {
		return bkkTarihi;
	}

	public void setBkkTarihi(Date bkkTarihi) {
		this.bkkTarihi = bkkTarihi;
	}

	public int getDayandigiKanunNo() {
		return dayandigiKanunNo;
	}

	public void setDayandigiKanunNo(int dayandigiKanunNo) {
		this.dayandigiKanunNo = dayandigiKanunNo;
	}

	public Date getDayandigiKanunTarihi() {
		return dayandigiKanunTarihi;
	}

	public void setDayandigiKanunTarihi(Date dayandigiKanunTarihi) {
		this.dayandigiKanunTarihi = dayandigiKanunTarihi;
	}

	public String getKararMetni() {
		return kararMetni;
	}

	public void setKararMetni(String kararMetni) {
		this.kararMetni = kararMetni;
	}

	public int getDusturTertibi() {
		return dusturTertibi;
	}

	public void setDusturTertibi(int dusturTertibi) {
		this.dusturTertibi = dusturTertibi;
	}

	public int getDusturCildi() {
		return dusturCildi;
	}

	public void setDusturCildi(int dusturCildi) {
		this.dusturCildi = dusturCildi;
	}

	public int getDusturSayfasi() {
		return dusturSayfasi;
	}

	public void setDusturSayfasi(int dusturSayfasi) {
		this.dusturSayfasi = dusturSayfasi;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public Tuzuk getSelectedTuzuk() {
		return selectedTuzuk;
	}

	public void setSelectedTuzuk(Tuzuk selectedTuzuk) {
		this.selectedTuzuk = selectedTuzuk;
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
	
	public TuzukDataModel getTuzuklerModel() {
		tuzuklerModel = new TuzukDataModel(getMevzuatTuzukList());
		return tuzuklerModel;
	}

	public void setTuzuklerModel(TuzukDataModel tuzuklerModel) {
		this.tuzuklerModel = tuzuklerModel;
	}

	

	public void onRowSelect(SelectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Selected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
	
		
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml");
		FacesContext.getCurrentInstance().getExternalContext().redirect("tuzukIcerik.xhtml?id=" +((Tuzuk) event.getObject()).getTuzukId());


    }
 
	
	
    public void onRowUnselect(UnselectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Unselected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml?id=" +((MevzuatSeti) event.getObject()).getMevzuatSetiId());


    }
 
    public void updateTuzuk() {
		 if (selectedTuzuk != null) {
			 getTuzukService().updateTuzuk(selectedTuzuk);
			
		 }
		 editModeOpen = false;
	 }

    public void deleteTuzuk() {
    	 if (selectedTuzuk != null) {
			 getTuzukService().deleteTuzuk(selectedTuzuk);
			
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