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

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.dao.DataAccessException;

import hud.iys.model.Kanun;
import hud.iys.model.KanunIcerik;
import hud.iys.model.MaddeIcerik;
import hud.iys.model.Mevzuat;
import hud.iys.service.IKanunIcerikService;
import hud.iys.service.IKanunService;
import hud.iys.service.IMaddeIcerikService;
import hud.iys.view.KanunDataModel;


@ManagedBean(name="kanunMB")
@SessionScoped
public class KanunBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 //Spring Kanun Service is injected...
	 @ManagedProperty(value="#{KanunService}")
	 IKanunService kanunService;
	 
	 //Spring KanunIcerik Service is injected...
	 @ManagedProperty(value="#{KanunIcerikService}")
	 IKanunIcerikService kanunIcerikService;
	 
	 @ManagedProperty(value="#{MaddeIcerikService}")
	 IMaddeIcerikService maddeIcerikService;
	
	 @ManagedProperty(value="#{mevzuatMB}")
	 private MevzuatBean mevzuatBean;
	 
	 private List<Kanun> mevzuatKanunList;
	 private KanunDataModel kanunlarModel;
	 
	 private List<KanunIcerik> selectedKanunKanunIcerikList;
	
	 private Long kanunNo;
	 private String kanunAdi;
	 private int RGNo;
	 private Date RGTarihi;
	 private Date kabulTarihi;
	 
	 private Kanun selectedKanun;

	 public String addKanun() {
		  try {
			   Kanun kanun = new Kanun();
			   kanun.setKanunNo(getKanunNo());
			   kanun.setKanunAdi(getKanunAdi());
			   kanun.setRGNo(getRGNo());
			   kanun.setRGTarihi(getRGTarihi());
			   kanun.setKabulTarihi(getKabulTarihi());
			   kanun.setDurumId(1);
			   
			   KanunIcerik kanunIcerik = new KanunIcerik();
			   kanunIcerik.setKanunIcerik(null);
			   kanunIcerik.setIcerikAdi(getKanunAdi());
			   getKanunIcerikService().addKanunIcerik(kanunIcerik);
			   
			   kanun.setKanunIcerikRoot(kanunIcerik.getIcerikId());
			   
			   kanun.setMevzuat(mevzuatBean.getSelectedMevzuat());
			   getKanunService().addKanun(kanun);
			   kanunIcerik.setKanun(kanun);
			   
			   
			   MaddeIcerik maddeIcerik = new MaddeIcerik();
			   maddeIcerik.setMaddeIcerik(null);
			   maddeIcerik.setMaddeIcerikAdi(kanunIcerik.getIcerikAdi());
			   getMaddeIcerikService().addMaddeIcerik(maddeIcerik);
			   
			   kanunIcerik.setMaddeIcerikRoot(maddeIcerik.getMaddeIcerikId());
			   
			   getKanunIcerikService().updateKanunIcerik(kanunIcerik);
			   maddeIcerik.setKanunIcerik(kanunIcerik);
			   
			   getMaddeIcerikService().updateMaddeIcerik(maddeIcerik);
			   
			   return SUCCESS;
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		  return ERROR;
	 }

	 public void reset() {
		 this.setKanunNo(0L);
		 this.setKanunAdi("");
		 this.setRGNo(0);
		 this.setRGTarihi(null);
	 }

	 public List<Kanun> getMevzuatKanunList() {
		  mevzuatKanunList = new ArrayList<Kanun>();
		  mevzuatKanunList.addAll(getKanunService().getKanunlarByMevzuatId(getMevzuatBean().getSelectedMevzuat().getMevzuatId()));
		  return mevzuatKanunList;
	 }
	 
	 public void setMevzuatKanunList(List<Kanun> mevzuatKanunList) {
		this.mevzuatKanunList = mevzuatKanunList;
	}

	public IKanunService getKanunService() {
		return kanunService;
	}

	public void setKanunService(IKanunService kanunService) {
		this.kanunService = kanunService;
	}

	public Long getKanunNo() {
		return kanunNo;
	}

	public void setKanunNo(Long kanunNo) {
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

	public Date getRGTarihi() {
		return RGTarihi;
	}

	public void setRGTarihi(Date rGTarihi) {
		RGTarihi = rGTarihi;
	}
	
	public Date getKabulTarihi() {
		return kabulTarihi;
	}

	public void setKabulTarihi(Date kabulTarihi) {
		this.kabulTarihi = kabulTarihi;
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
		kanunlarModel = new KanunDataModel(getMevzuatKanunList());
		return kanunlarModel;
	}

	public void setKanunlarModel(KanunDataModel kanunlarModel) {
		this.kanunlarModel = kanunlarModel;
	}

	public List<KanunIcerik> getSelectedKanunKanunIcerikList() {
		return selectedKanunKanunIcerikList;
	}

	public void setSelectedKanunKanunIcerikList(
			List<KanunIcerik> selectedKanunKanunIcerikList) {
		this.selectedKanunKanunIcerikList = selectedKanunKanunIcerikList;
	}
	
	
	public IKanunIcerikService getKanunIcerikService() {
		return kanunIcerikService;
	}

	public void setKanunIcerikService(IKanunIcerikService kanunIcerikService) {
		this.kanunIcerikService = kanunIcerikService;
	}

	
	public IMaddeIcerikService getMaddeIcerikService() {
		return maddeIcerikService;
	}

	public void setMaddeIcerikService(IMaddeIcerikService maddeIcerikService) {
		this.maddeIcerikService = maddeIcerikService;
	}

	public void onRowSelect(SelectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Selected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
		this.selectedKanunKanunIcerikList = new ArrayList<KanunIcerik>();
		this.selectedKanunKanunIcerikList.addAll(getKanunIcerikService().getKanunIcerikleriByKanunId(((Kanun) event.getObject()).getKanunId()));
		  
		setSelectedKanunKanunIcerikList(this.selectedKanunKanunIcerikList);
			
		
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml");
		FacesContext.getCurrentInstance().getExternalContext().redirect("kanunIcerik.xhtml?id=" +((Kanun) event.getObject()).getKanunId());


    }
 
	
	
    public void onRowUnselect(UnselectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Unselected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.xhtml?id=" +((MevzuatSeti) event.getObject()).getMevzuatSetiId());


    }
 
    public void updateKanun() {
		 if (selectedKanun != null) {
			 getKanunService().updateKanun(selectedKanun);
			
		 }
	 }

    public void deleteKanun() {
    	 if (selectedKanun != null) {
			 getKanunService().deleteKanun(selectedKanun);
			
		 }
    }
}