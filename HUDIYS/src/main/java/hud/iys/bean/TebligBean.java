package hud.iys.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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

import hud.iys.model.Teblig;
import hud.iys.model.TebligIcerik;
import hud.iys.model.TebligMaddeIcerik;
import hud.iys.model.Mevzuat;
import hud.iys.service.ITebligIcerikService;
import hud.iys.service.ITebligService;
import hud.iys.service.ITebligMaddeIcerikService;
import hud.iys.view.TebligDataModel;


@ManagedBean(name="tebligMB")
@SessionScoped
public class TebligBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 @ManagedProperty(value="#{TebligService}")
	 ITebligService tebligService;
	 
	 @ManagedProperty(value="#{TebligIcerikService}")
	 ITebligIcerikService tebligIcerikService;
	 
	 @ManagedProperty(value="#{TebligMaddeIcerikService}")
	 ITebligMaddeIcerikService tebligMaddeIcerikService;
	
	 @ManagedProperty(value="#{mevzuatMB}")
	 private MevzuatBean mevzuatBean;
	 
	 List<Teblig> tebligList;
	 
	 private TebligDataModel tebliglerModel;
	 
	 private List<Teblig> mevzuatTebligList;
	 
	 List<TebligIcerik> selectedTebligTebligIcerikList;
	
	 private Long tebligNo;
	 private String tebligAdi;
	 private String tebligAciklama;
	 private Long RGNo;
	 private Date RGTarihi;
		 
	 private Teblig selectedTeblig;

	 public String addTeblig() {
		  try {
			   Teblig teblig = new Teblig();	
			   teblig.setTebligNo(getTebligNo());
			   teblig.setTebligAdi(getTebligAdi());
			   teblig.setTebligAciklama(getTebligAciklama());
			   teblig.setRGNo(getRGNo());
			   teblig.setRGTarihi(getRGTarihi());
			   teblig.setDurumId(1);
			   
			   TebligIcerik tebligIcerik = new TebligIcerik();
			   tebligIcerik.setTebligIcerik(null);
			   tebligIcerik.setTebligIcerikAdi(getTebligAdi());
			   getTebligIcerikService().addTebligIcerik(tebligIcerik);
			   
			   teblig.setTebligIcerikRoot(tebligIcerik.getTebligIcerikId());
			   
			   teblig.setMevzuat(mevzuatBean.getSelectedMevzuat());
			   getTebligService().addTeblig(teblig);
			   tebligIcerik.setTeblig(teblig);
			   
			   
			   TebligMaddeIcerik tebligMaddeIcerik = new TebligMaddeIcerik();
			   tebligMaddeIcerik.setTebligMaddeIcerik(null);
			   tebligMaddeIcerik.setTebligMaddeIcerikAdi(tebligIcerik.getTebligIcerikAdi());
			   getTebligMaddeIcerikService().addTebligMaddeIcerik(tebligMaddeIcerik);
			   
			   tebligIcerik.setTebligMaddeIcerikRoot(tebligMaddeIcerik.getTebligMaddeIcerikId());
			   
			   getTebligIcerikService().updateTebligIcerik(tebligIcerik);
			   tebligMaddeIcerik.setTebligIcerik(tebligIcerik);
			   
			   getTebligMaddeIcerikService().updateTebligMaddeIcerik(tebligMaddeIcerik);
			   
			   return SUCCESS;
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		  return ERROR;
	 }

	 public void reset() {
		 this.setTebligNo((long) 0);
		 this.setRGNo((long) 0);
		 this.setTebligAdi("");
		 this.setTebligAciklama("");		
	 }

	 public List<Teblig> getTebligList() {
		  tebligList = new ArrayList<Teblig>();
		  tebligList.addAll(getTebligService().getTebligler());
		  return tebligList;
	 }

	public ITebligService getTebligService() {
		return tebligService;
	}

	public void setTebligService(ITebligService tebligService) {
		this.tebligService = tebligService;
	}

	

	public Long getTebligNo() {
		return tebligNo;
	}

	public void setTebligNo(Long tebligNo) {
		this.tebligNo = tebligNo;
	}

	public String getTebligAdi() {
		return tebligAdi;
	}

	public void setTebligAdi(String tebligAdi) {
		this.tebligAdi = tebligAdi;
	}

	
	public String getTebligAciklama() {
		return tebligAciklama;
	}

	public void setTebligAciklama(String tebligAciklama) {
		this.tebligAciklama = tebligAciklama;
	}

	public Long getRGNo() {
		return RGNo;
	}

	public void setRGNo(Long rGNo) {
		RGNo = rGNo;
	}

	public Date getRGTarihi() {
		return RGTarihi;
	}

	public void setRGTarihi(Date rGTarihi) {
		RGTarihi = rGTarihi;
	}

	public void setTebligList(List<Teblig> tebligList) {
		this.tebligList = tebligList;
	}

	
	
	public Teblig getSelectedTeblig() {
		return selectedTeblig;
	}

	public void setSelectedTeblig(Teblig selectedTeblig) {
		this.selectedTeblig = selectedTeblig;
	}

		
	public MevzuatBean getMevzuatBean() {
		return mevzuatBean;
	}

	public void setMevzuatBean(MevzuatBean mevzuatBean) {
		this.mevzuatBean = mevzuatBean;
	}
	
		

	public List<TebligIcerik> getSelectedTebligTebligIcerikList() {
		return selectedTebligTebligIcerikList;
	}

	public void setSelectedTebligTebligIcerikList(
			List<TebligIcerik> selectedTebligTebligIcerikList) {
		this.selectedTebligTebligIcerikList = selectedTebligTebligIcerikList;
	}
	
	
	public ITebligIcerikService getTebligIcerikService() {
		return tebligIcerikService;
	}

	public void setTebligIcerikService(ITebligIcerikService tebligIcerikService) {
		this.tebligIcerikService = tebligIcerikService;
	}

	
	public ITebligMaddeIcerikService getTebligMaddeIcerikService() {
		return tebligMaddeIcerikService;
	}

	public void setTebligMaddeIcerikService(ITebligMaddeIcerikService tebligMaddeIcerikService) {
		this.tebligMaddeIcerikService = tebligMaddeIcerikService;
	}
	
	public TebligDataModel getTebliglerModel() {
		tebliglerModel = new TebligDataModel(getMevzuatTebligList());
		return tebliglerModel;
	}

	public void setTebliglerModel(TebligDataModel tebliglerModel) {
		this.tebliglerModel = tebliglerModel;
	}

	public List<Teblig> getMevzuatTebligList() {
		mevzuatTebligList = new ArrayList<Teblig>();
		mevzuatTebligList.addAll(getTebligService().getTebliglerByMevzuatId(getMevzuatBean().getSelectedMevzuat().getMevzuatId()));
		return mevzuatTebligList;
	}

	public void setMevzuatTebligList(List<Teblig> mevzuatTebligList) {
		this.mevzuatTebligList = mevzuatTebligList;
	}
	

	public void onRowSelect(SelectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Selected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
		this.selectedTebligTebligIcerikList = new ArrayList<TebligIcerik>();
		this.selectedTebligTebligIcerikList.addAll(getTebligIcerikService().getTebligIcerikleriByTebligId(((Teblig) event.getObject()).getTebligId()));
		  
		setSelectedTebligTebligIcerikList(this.selectedTebligTebligIcerikList);
			
		
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.jsf");
		FacesContext.getCurrentInstance().getExternalContext().redirect("tebligIcerik.jsf?id=" +((Teblig) event.getObject()).getTebligId());


    }
 
    public void onRowUnselect(UnselectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Unselected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.jsf?id=" +((MevzuatSeti) event.getObject()).getMevzuatSetiId());

    }
    
    public void updateTeblig() {
		 if (selectedTeblig != null) {
			 getTebligService().updateTeblig(selectedTeblig);
			
		 }
	 }

    public void deleteTeblig() {
    	if (selectedTeblig != null) {
			getTebligService().deleteTeblig(selectedTeblig);
			
		}
    }
 
	 

}