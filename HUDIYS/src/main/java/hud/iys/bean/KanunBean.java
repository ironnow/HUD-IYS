package hud.iys.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.dao.DataAccessException;

import hud.iys.model.Kanun;
import hud.iys.model.Mevzuat;
import hud.iys.service.IKanunService;
import hud.iys.view.KanunDataModel;


@ManagedBean(name="kanunMB")
@RequestScoped
public class KanunBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 //Spring Kanun Service is injected...
	 @ManagedProperty(value="#{KanunService}")
	 IKanunService kanunService;
	
	 @ManagedProperty(value="#{mevzuatMB}")
	 private MevzuatBean mevzuatBean;
	 
	 List<Kanun> kanunList;
	
	 private int kanunNo;
	 private String kanunAdi;
	 private int RGNo;
	 private String RGTarihi;
	 
	 private Kanun selectedKanun;
	 
	 private KanunDataModel kanunlarModel;
	 
	 private int mevzuatId;

	 public String addKanun() {
		  try {
			   Kanun kanun = new Kanun();
			   kanun.setKanunNo(getKanunNo());
			   kanun.setKanunAdi(getKanunAdi());
			   kanun.setRGNo(getRGNo());
			   kanun.setRGTarihi(getRGTarihi());
			  
			   kanun.setMevzuat(mevzuatBean.getSelectedMevzuat());
			   getKanunService().addKanun(kanun);
			   return SUCCESS;
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		  return ERROR;
	 }

	 public void reset() {
		 this.setKanunNo(0);
		 this.setKanunAdi("");
		 this.setRGNo(0);
		 this.setRGTarihi("");
	 }

	 public List<Kanun> getKanunList() {
		  kanunList = new ArrayList<Kanun>();
		  kanunList.addAll(getKanunService().getKanunlarByMevzuatId(mevzuatId));
		  return kanunList;
	 }

	public IKanunService getKanunService() {
		return kanunService;
	}

	public void setKanunService(IKanunService kanunService) {
		this.kanunService = kanunService;
	}

	public int getKanunNo() {
		return kanunNo;
	}

	public void setKanunNo(int kanunNo) {
		this.kanunNo = kanunNo;
	}

	public String getKanunAdi() {
		return kanunAdi;
	}

	public void setKanunAdi(String kanunAdi) {
		this.kanunAdi = kanunAdi;
	}

	public int getRGNo() {
		return RGNo;
	}

	public void setRGNo(int rGNo) {
		RGNo = rGNo;
	}

	public String getRGTarihi() {
		return RGTarihi;
	}

	public void setRGTarihi(String rGTarihi) {
		RGTarihi = rGTarihi;
	}

	public void setKanunList(List<Kanun> kanunList) {
		this.kanunList = kanunList;
	}

	
	
	public Kanun getSelectedKanun() {
		return selectedKanun;
	}

	public void setSelectedKanun(Kanun selectedKanun) {
		this.selectedKanun = selectedKanun;
	}

		
	public MevzuatBean getMevzuatBean() {
		return mevzuatBean;
	}

	public void setMevzuatBean(MevzuatBean mevzuatBean) {
		this.mevzuatBean = mevzuatBean;
	}
	
	
	

	public KanunDataModel getKanunlarModel() {
		kanunlarModel = new KanunDataModel(getKanunList());
		return kanunlarModel;
	}

	public void setKanunlarModel(KanunDataModel kanunlarModel) {
		this.kanunlarModel = kanunlarModel;
	}
	

	public int getMevzuatId() {
		return mevzuatId;
	}

	public void setMevzuatId(int mevzuatId) {
		this.mevzuatId = mevzuatId;
	}

	public void onRowSelect(SelectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Selected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
       
		
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.jsf");
		FacesContext.getCurrentInstance().getExternalContext().redirect("kanunIcerik.jsf?id=" +((Kanun) event.getObject()).getKanunId());


    }
 
    public void onRowUnselect(UnselectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Unselected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.jsf?id=" +((MevzuatSeti) event.getObject()).getMevzuatSetiId());


    }
 
	 

}