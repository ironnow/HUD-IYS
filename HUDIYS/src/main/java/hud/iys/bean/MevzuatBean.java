package hud.iys.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;
import org.springframework.dao.DataAccessException;

import hud.iys.model.Kanun;
import hud.iys.model.KanunIcerik;
import hud.iys.model.Mevzuat;
import hud.iys.model.MevzuatIcerikEsleme;
import hud.iys.model.MevzuatIcerikTip;
import hud.iys.model.MevzuatSeti;
import hud.iys.model.Teblig;
import hud.iys.service.IKanunService;
import hud.iys.service.IMevzuatIcerikEslemeService;
import hud.iys.service.IMevzuatIcerikTipService;
import hud.iys.service.ITebligService;
import hud.iys.service.IMevzuatService;
import hud.iys.service.IMevzuatSetiService;
import hud.iys.view.KanunDataModel;
import hud.iys.view.MevzuatDataModel;
import hud.iys.view.MevzuatSetiDataModel;
import hud.iys.view.TebligDataModel;


@ManagedBean(name="mevzuatMB")
@SessionScoped
public class MevzuatBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 @ManagedProperty(value="#{MevzuatService}")
	 IMevzuatService mevzuatService;
	 
	 @ManagedProperty(value="#{MevzuatSetiService}")
	 IMevzuatSetiService mevzuatSetiService;
	 
	 //Spring Kanun Service is injected...
	 @ManagedProperty(value="#{KanunService}")
	 IKanunService kanunService;
	 
	 @ManagedProperty(value="#{TebligService}")
	 ITebligService tebligService;
	 
	 @ManagedProperty(value="#{MevzuatIcerikEslemeService}")
	 IMevzuatIcerikEslemeService mevzuatIcerikEslemeService;
	 
	 @ManagedProperty(value="#{MevzuatIcerikTipService}")
	 IMevzuatIcerikTipService mevzuatIcerikTipService;
	 
	 @ManagedProperty(value="#{mevzuatSetiMB}")
	 private MevzuatSetiBean mevzuatSetiBean;
	 
	 
	 private Mevzuat selectedMevzuat;
	 
	 private MevzuatDataModel mevzuatlarModel;
	 private List<Mevzuat> mevzuatSetiMevzuatList;
		
	 List<Mevzuat> mevzuatList;
	
	 List<Mevzuat> selectedMevzuatSetiMevzuatList;
	 	 
	 List<MevzuatIcerikTip> mevzuatIcerikTipListesi;
	 
	 MevzuatIcerikTip selectedMevzuatIcerikTip;
	 
	 
	 private DualListModel<MevzuatIcerikTip> icerikTipleri;
	 
	
	 
	 private MevzuatSetiDataModel mevzuatSetleriModel;
	 
	 private String mevzuatAdi;
	 private String mevzuatAciklama;
	 
	 private int mevzuatSetiId;
	 
	 @PostConstruct
    public void init() {
		mevzuatIcerikTipListesi = new ArrayList<MevzuatIcerikTip>();		
			
		 
	    List<MevzuatIcerikTip> unselectedMevzuatIcerikTipleri = new ArrayList<MevzuatIcerikTip>();
	    unselectedMevzuatIcerikTipleri = getMevzuatIcerikTipService().getMevzuatIcerikTipleri();
    	for(MevzuatIcerikTip mevIcerikTip1 : unselectedMevzuatIcerikTipleri) {
    		
    		for(MevzuatIcerikTip mevIcerikTip2 : mevzuatIcerikTipListesi) {
    			if(mevIcerikTip1.getMevzuatIcerikTipId() == mevIcerikTip2.getMevzuatIcerikTipId()){
    				unselectedMevzuatIcerikTipleri.remove(mevIcerikTip1);
    			}
    		}
    	}
        List<MevzuatIcerikTip> selectedMevzuatIcerikTipleri = new ArrayList<MevzuatIcerikTip>();
        
        icerikTipleri = new DualListModel<MevzuatIcerikTip>(unselectedMevzuatIcerikTipleri, selectedMevzuatIcerikTipleri);
       
    }

	 public String addMevzuat() {
		  try {
			   Mevzuat mevzuat = new Mevzuat();
			   mevzuat.setMevzuatAdi(getMevzuatAdi());
			   mevzuat.setMevzuatAciklama(getMevzuatAciklama());
			   
			   mevzuat.setMevzuatSeti(mevzuatSetiBean.getSelectedMevzuatSeti());
			  
			   getMevzuatService().addMevzuat(mevzuat);
			   return SUCCESS;
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		  return ERROR;
	 }

	 public void reset() {
		 this.setMevzuatAdi("");
		 this.setMevzuatAciklama("");
	 }

	 public List<Mevzuat> getMevzuatList() {
		  mevzuatList = new ArrayList<Mevzuat>();
		  mevzuatList.addAll(getMevzuatService().getMevzuatlar());
		  return mevzuatList;
	 }

	public IMevzuatService getMevzuatService() {
		return mevzuatService;
	}

	public void setMevzuatService(IMevzuatService mevzuatService) {
		this.mevzuatService = mevzuatService;
	}
	
	public IMevzuatSetiService getMevzuatSetiService() {
		return mevzuatSetiService;
	}

	public void setMevzuatSetiService(IMevzuatSetiService mevzuatSetiService) {
		this.mevzuatSetiService = mevzuatSetiService;
	}

	
	public IKanunService getKanunService() {
		return kanunService;
	}

	public void setKanunService(IKanunService kanunService) {
		this.kanunService = kanunService;
	}

	public ITebligService getTebligService() {
		return tebligService;
	}
	
	

	public IMevzuatIcerikEslemeService getMevzuatIcerikEslemeService() {
		return mevzuatIcerikEslemeService;
	}

	public void setMevzuatIcerikEslemeService(
			IMevzuatIcerikEslemeService mevzuatIcerikEslemeService) {
		this.mevzuatIcerikEslemeService = mevzuatIcerikEslemeService;
	}

	public IMevzuatIcerikTipService getMevzuatIcerikTipService() {
		return mevzuatIcerikTipService;
	}

	public void setMevzuatIcerikTipService(
			IMevzuatIcerikTipService mevzuatIcerikTipService) {
		this.mevzuatIcerikTipService = mevzuatIcerikTipService;
	}

	public List<MevzuatIcerikTip> getMevzuatIcerikTipListesi() {
		return mevzuatIcerikTipListesi;
	}

	public void setMevzuatIcerikTipListesi(
			List<MevzuatIcerikTip> mevzuatIcerikTipListesi) {
		this.mevzuatIcerikTipListesi = mevzuatIcerikTipListesi;
	}

	public void setTebligService(ITebligService tebligService) {
		this.tebligService = tebligService;
	}
	
	public String getMevzuatAdi() {
		return mevzuatAdi;
	}

	public void setMevzuatAdi(String mevzuatAdi) {
		this.mevzuatAdi = mevzuatAdi;
	}


	public String getMevzuatAciklama() {
		return mevzuatAciklama;
	}

	public void setMevzuatAciklama(String mevzuatAciklama) {
		this.mevzuatAciklama = mevzuatAciklama;
	}

	public int getMevzuatSetiId() {
		return mevzuatSetiId;
	}

	public void setMevzuatSetiId(int mevzuatSetiId) {
		this.mevzuatSetiId = mevzuatSetiId;
	}

	
	public void setMevzuatList(List<Mevzuat> mevzuatList) {
		this.mevzuatList = mevzuatList;
	}

	public MevzuatSetiBean getMevzuatSetiBean() {
		return mevzuatSetiBean;
	}

	public void setMevzuatSetiBean(MevzuatSetiBean mevzuatSetiBean) {
		this.mevzuatSetiBean = mevzuatSetiBean;
	}

	public Mevzuat getSelectedMevzuat() {
		return selectedMevzuat;
	}

	public void setSelectedMevzuat(Mevzuat selectedMevzuat) {
		this.selectedMevzuat = selectedMevzuat;
	}
	
	
	public MevzuatIcerikTip getSelectedMevzuatIcerikTip() {
		return selectedMevzuatIcerikTip;
	}

	public void setSelectedMevzuatIcerikTip(
			MevzuatIcerikTip selectedMevzuatIcerikTip) {
		this.selectedMevzuatIcerikTip = selectedMevzuatIcerikTip;
	}
	
	public MevzuatDataModel getMevzuatlarModel() {
		mevzuatlarModel = new MevzuatDataModel(getMevzuatSetiMevzuatList());
		return mevzuatlarModel;
	}

	public void setMevzuatlarModel(MevzuatDataModel mevzuatlarModel) {
		this.mevzuatlarModel = mevzuatlarModel;
	}
	
	public List<Mevzuat> getMevzuatSetiMevzuatList() {			 
        mevzuatSetiMevzuatList = new ArrayList<Mevzuat>();
		mevzuatSetiMevzuatList.addAll(getMevzuatService().getMevzuatlarByMevzuatSetiId(getMevzuatSetiBean().getSelectedMevzuatSeti().getMevzuatSetiId()));
		return mevzuatSetiMevzuatList;
	}

	public void setMevzuatSetiMevzuatList(List<Mevzuat> mevzuatSetiMevzuatList) {
		this.mevzuatSetiMevzuatList = mevzuatSetiMevzuatList;
	}


	public MevzuatSetiDataModel getMevzuatSetleriModel() {
		return mevzuatSetleriModel;
	}

	public void setMevzuatSetleriModel(MevzuatSetiDataModel mevzuatSetleriModel) {
		this.mevzuatSetleriModel = mevzuatSetleriModel;
	}

		
	
	public void onRowSelect(SelectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Selected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
       
		
			  
		
		mevzuatIcerikTipListesi = new ArrayList<MevzuatIcerikTip>();
		List<MevzuatIcerikEsleme> mevzuatIcerikEslemeleri = new ArrayList<MevzuatIcerikEsleme>();
		mevzuatIcerikEslemeleri.addAll(getMevzuatIcerikEslemeService().getMevzuatIcerikEslemeleriByMevzuatId(((Mevzuat) event.getObject()).getMevzuatId()));
		
		for(int i=0; i < mevzuatIcerikEslemeleri.size(); i++){
			mevzuatIcerikTipListesi.add(getMevzuatIcerikTipService().getMevzuatIcerikTipById(mevzuatIcerikEslemeleri.get(i).getMevzuatIcerikTipId()));
		}
		
		
		
		
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.jsf");
		FacesContext.getCurrentInstance().getExternalContext().redirect("mevzuatIcerik.jsf?id=" +((Mevzuat) event.getObject()).getMevzuatId());


    }
 
    public void onRowUnselect(UnselectEvent event) throws IOException {
        //FacesMessage msg = new FacesMessage("MevzuatSeti Unselected", ((MevzuatSeti) event.getObject()).getMevzuatSetiAdi());
 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("Mevzuat.jsf?id=" +((MevzuatSeti) event.getObject()).getMevzuatSetiId());


    }
    
    public void MevzuatIcerikSec() throws IOException{
    	FacesContext.getCurrentInstance().getExternalContext().redirect( selectedMevzuatIcerikTip.getMevzuatIcerikTipAdi() + ".jsf");
    }
    	 
    public void mevzuatIcerikDuzenleClick () {
    	
    	List<MevzuatIcerikEsleme> mevzuatIcerikEslemeleri = new ArrayList<MevzuatIcerikEsleme>();
		mevzuatIcerikEslemeleri.addAll(getMevzuatIcerikEslemeService().getMevzuatIcerikEslemeleriByMevzuatId(selectedMevzuat.getMevzuatId()));
		
		for(int i=0; i < mevzuatIcerikEslemeleri.size(); i++){
			mevzuatIcerikTipListesi.add(getMevzuatIcerikTipService().getMevzuatIcerikTipById(mevzuatIcerikEslemeleri.get(i).getMevzuatIcerikTipId()));
		}
		    	
    	
    	List<MevzuatIcerikTip> unselectedMevzuatIcerikTipleri = new ArrayList<MevzuatIcerikTip>();
    	unselectedMevzuatIcerikTipleri = getMevzuatIcerikTipService().getMevzuatIcerikTipleri();
    	for(MevzuatIcerikTip mevIcerikTip1 : unselectedMevzuatIcerikTipleri) {
    		for(MevzuatIcerikTip mevIcerikTip2 : mevzuatIcerikTipListesi) {
    			if(mevIcerikTip1.getMevzuatIcerikTipId() == mevIcerikTip2.getMevzuatIcerikTipId()){
    				unselectedMevzuatIcerikTipleri.remove(mevIcerikTip1);
    			}
    		}
    	}
        List<MevzuatIcerikTip> selectedMevzuatIcerikTipleri = new ArrayList<MevzuatIcerikTip>();
       
        
        icerikTipleri = new DualListModel<MevzuatIcerikTip>(unselectedMevzuatIcerikTipleri, selectedMevzuatIcerikTipleri);
    }

	public DualListModel<MevzuatIcerikTip> getIcerikTipleri() {
		return icerikTipleri;
	}

	public void setIcerikTipleri(
			DualListModel<MevzuatIcerikTip> icerikTipleri) {
		this.icerikTipleri = icerikTipleri;
	}
	 
	 public void onTransfer(TransferEvent event) {
        for(Object item : event.getItems()) {
        	mevzuatIcerikTipListesi.add(getMevzuatIcerikTipService().getMevzuatIcerikTipById(Long.parseLong((String)item)));
        	MevzuatIcerikEsleme newMevzuatIcerikEsleme = new MevzuatIcerikEsleme();
        	newMevzuatIcerikEsleme.setMevzuatId(selectedMevzuat.getMevzuatId());
        	newMevzuatIcerikEsleme.setMevzuatIcerikTipId(Long.parseLong((String)item));
        	
        	getMevzuatIcerikEslemeService().addMevzuatIcerikEsleme(newMevzuatIcerikEsleme);
        	
            
        }
       
    }  
    

}