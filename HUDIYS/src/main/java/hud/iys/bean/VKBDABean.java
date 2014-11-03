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

import hud.iys.model.Cvoa;
import hud.iys.model.Kanun;
import hud.iys.model.KanunIcerik;
import hud.iys.model.MaddeIcerik;
import hud.iys.model.Mevzuat;
import hud.iys.model.Vkbda;
import hud.iys.service.IKanunIcerikService;
import hud.iys.service.IKanunService;
import hud.iys.service.IMaddeIcerikService;
import hud.iys.service.IVkbdaService;
import hud.iys.view.KanunDataModel;
import hud.iys.view.VkbdaDataModel;


@ManagedBean(name="vkbdaMB")
@SessionScoped
public class VKBDABean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 @ManagedProperty(value="#{VkbdaService}")
	 IVkbdaService vkbdaService;
	 
	
	 @ManagedProperty(value="#{mevzuatMB}")
	 private MevzuatBean mevzuatBean;
	 
	 private List<Vkbda> mevzuatVkbdaList;
	 private VkbdaDataModel vkbdalarModel;
	
	
	 private String anlasmaAdi;
	 private String tarafDevlet;
	 private int RGNo;
	 private Date RGTarihi; 
	 private Date yururlukTarihi; 
	 private Date uygulanmaTarihi; 
	 private Date imzaTarihi; 
	 private String aciklama;
	 private String anlasmaMetni;
	
	 private Vkbda selectedVkbda;
	 
	 private boolean editModeOpen;

	 @PostConstruct
     public void init() {
		 editModeOpen = false;
		 
	 }

	 public String addVkbda() {
		  try {
			   Vkbda vkbda = new Vkbda();
			   vkbda.setAnlasmaAdi(getAnlasmaAdi());
			   vkbda.setTarafDevlet(getTarafDevlet());
			   vkbda.setRGNo(getRGNo());
			   vkbda.setRGTarihi(getRGTarihi());
			   vkbda.setYururlukTarihi(getYururlukTarihi());
			   vkbda.setUygulanmaTarihi(getUygulanmaTarihi());
			   vkbda.setImzaTarihi(getImzaTarihi());
			   vkbda.setAciklama(getAciklama());
			   vkbda.setAnlasmaMetni(getAnlasmaMetni());
			   vkbda.setDurumId(1);
			 
			  
			   vkbda.setDurumId(1);
			 
			   
			   vkbda.setMevzuat(mevzuatBean.getSelectedMevzuat());
			   getVkbdaService().addVkbda(vkbda);
			  
			  
			   
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

	 public List<Vkbda> getMevzuatVkbdaList() {
		  mevzuatVkbdaList = new ArrayList<Vkbda>();
		  mevzuatVkbdaList.addAll(getVkbdaService().getVkbdalarByMevzuatId(getMevzuatBean().getSelectedMevzuat().getMevzuatId()));
		  return mevzuatVkbdaList;
	 }
	 
	 public void setMevzuatVkbdaList(List<Vkbda> mevzuatVkbdaList) {
		this.mevzuatVkbdaList = mevzuatVkbdaList;
	}

	public IVkbdaService getVkbdaService() {
		return vkbdaService;
	}

	public void setVkbdaService(IVkbdaService vkbdaService) {
		this.vkbdaService = vkbdaService;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public Vkbda getSelectedVkbda() {
		return selectedVkbda;
	}

	public void setSelectedVkbda(Vkbda selectedVkbda) {
		this.selectedVkbda = selectedVkbda;
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

	public MevzuatBean getMevzuatBean() {
		return mevzuatBean;
	}

	public void setMevzuatBean(MevzuatBean mevzuatBean) {
		this.mevzuatBean = mevzuatBean;
	}
	
	public VkbdaDataModel getVkbdalarModel() {
		vkbdalarModel = new VkbdaDataModel(getMevzuatVkbdaList());
		return vkbdalarModel;
	}

	public void setVkbdalarModel(VkbdaDataModel vkbdalarModel) {
		this.vkbdalarModel = vkbdalarModel;
	}

	

	public void onRowSelect(SelectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Selected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
	
		
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml");
		FacesContext.getCurrentInstance().getExternalContext().redirect("vkbdAnlasmaIcerik.xhtml?id=" +((Vkbda) event.getObject()).getVkbdaId());


    }
 
	
	
    public void onRowUnselect(UnselectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Unselected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml?id=" +((MevzuatSeti) event.getObject()).getMevzuatSetiId());


    }
 
    public void updateVkbda() {
		 if (selectedVkbda != null) {
			 getVkbdaService().updateVkbda(selectedVkbda);
			
		 }
		 editModeOpen = false;
	 }

    public void deleteVkbda() {
    	 if (selectedVkbda != null) {
			 getVkbdaService().deleteVkbda(selectedVkbda);
			
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