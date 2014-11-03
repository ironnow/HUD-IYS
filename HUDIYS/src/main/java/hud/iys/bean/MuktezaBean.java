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
import hud.iys.model.Mukteza;
import hud.iys.service.IKanunIcerikService;
import hud.iys.service.IKanunService;
import hud.iys.service.IMaddeIcerikService;
import hud.iys.service.IMuktezaService;
import hud.iys.view.KanunDataModel;
import hud.iys.view.MuktezaDataModel;


@ManagedBean(name="muktezaMB")
@SessionScoped
public class MuktezaBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 //Spring Kanun Service is injected...
	 @ManagedProperty(value="#{MuktezaService}")
	 IMuktezaService muktezaService;
	 
	
	 @ManagedProperty(value="#{mevzuatMB}")
	 private MevzuatBean mevzuatBean;
	 
	 private List<Mukteza> mevzuatMuktezaList;
	 private MuktezaDataModel muktezalarModel;
	
	
	 private int sayi;
	 private Date tarih; 
	 private String baslik;
	 private String verenBirim;	 
	 private Long ilgiliKanunNo;
	 private String ilgiliKanunAdi;
	 private String aciklama;
	 private String metin;
	 
	 private Mukteza selectedMukteza;
	 
	 private boolean editModeOpen;

	 @PostConstruct
     public void init() {
		 editModeOpen = false;
		 
	 }

	 public String addMukteza() {
		  try {
			   Mukteza mukteza = new Mukteza();
			   mukteza.setSayi(getSayi());
			   mukteza.setTarih(getTarih());
			   mukteza.setBaslik(getBaslik());
			   mukteza.setVerenBirim(getVerenBirim());
			   mukteza.setIlgiliKanunNo(getIlgiliKanunNo());
			   mukteza.setIlgiliKanunAdi(getIlgiliKanunAdi());
			   mukteza.setAciklama(getAciklama());
			   mukteza.setMetin(getMetin());
			   mukteza.setDurumId(1);
			 
			   mukteza.setMevzuat(mevzuatBean.getSelectedMevzuat());
			   getMuktezaService().addMukteza(mukteza);
			  
			   return SUCCESS;
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		  return ERROR;
	 }

	 public void reset() {
		 this.setSayi(0);
		 this.setTarih(null);
		 this.setBaslik(null);
		 this.setVerenBirim(null);
		 this.setIlgiliKanunNo(0L);
		 this.setIlgiliKanunAdi(null);
		 this.setMetin(null);
		 this.setAciklama(null);
		 
	 }

	 public List<Mukteza> getMevzuatMuktezaList() {
		  mevzuatMuktezaList = new ArrayList<Mukteza>();
		  mevzuatMuktezaList.addAll(getMuktezaService().getMuktezalarByMevzuatId(getMevzuatBean().getSelectedMevzuat().getMevzuatId()));
		  return mevzuatMuktezaList;
	 }
	 
	 public void setMevzuatMuktezaList(List<Mukteza> mevzuatMuktezaList) {
		this.mevzuatMuktezaList = mevzuatMuktezaList;
	}

	public IMuktezaService getMuktezaService() {
		return muktezaService;
	}

	public void setMuktezaService(IMuktezaService muktezaService) {
		this.muktezaService = muktezaService;
	}

	

	public int getSayi() {
		return sayi;
	}

	public void setSayi(int sayi) {
		this.sayi = sayi;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	public String getBaslik() {
		return baslik;
	}

	public void setBaslik(String baslik) {
		this.baslik = baslik;
	}

	public String getVerenBirim() {
		return verenBirim;
	}

	public void setVerenBirim(String verenBirim) {
		this.verenBirim = verenBirim;
	}

	public String getMetin() {
		return metin;
	}

	public void setMetin(String metin) {
		this.metin = metin;
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

	public Mukteza getSelectedMukteza() {
		return selectedMukteza;
	}

	public void setSelectedMukteza(Mukteza selectedMukteza) {
		this.selectedMukteza = selectedMukteza;
	}

	public MevzuatBean getMevzuatBean() {
		return mevzuatBean;
	}

	public void setMevzuatBean(MevzuatBean mevzuatBean) {
		this.mevzuatBean = mevzuatBean;
	}
	
	public MuktezaDataModel getMuktezalarModel() {
		muktezalarModel = new MuktezaDataModel(getMevzuatMuktezaList());
		return muktezalarModel;
	}

	public void setMuktezalarModel(MuktezaDataModel muktezalarModel) {
		this.muktezalarModel = muktezalarModel;
	}

	

	public void onRowSelect(SelectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Selected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
	
		
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml");
		FacesContext.getCurrentInstance().getExternalContext().redirect("muktezaIcerik.xhtml?id=" +((Mukteza) event.getObject()).getMuktezaId());


    }
 
	
	
    public void onRowUnselect(UnselectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Unselected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml?id=" +((MevzuatSeti) event.getObject()).getMevzuatSetiId());


    }
 
    public void updateMukteza() {
		 if (selectedMukteza != null) {
			 getMuktezaService().updateMukteza(selectedMukteza);
			
		 }
		 editModeOpen = false;
	 }

    public void deleteMukteza() {
    	 if (selectedMukteza != null) {
			 getMuktezaService().deleteMukteza(selectedMukteza);
			
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