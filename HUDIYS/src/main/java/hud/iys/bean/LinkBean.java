package hud.iys.bean;

import hud.iys.model.KanunIcerik;
import hud.iys.model.Link;
import hud.iys.model.Mevzuat;
import hud.iys.model.MevzuatIcerikEsleme;
import hud.iys.model.MevzuatIcerikTip;
import hud.iys.model.MevzuatSeti;
import hud.iys.model.Teblig;
import hud.iys.model.TebligIcerik;
import hud.iys.service.ILinkService;
import hud.iys.service.IMevzuatIcerikEslemeService;
import hud.iys.service.IMevzuatIcerikTipService;
import hud.iys.service.IMevzuatService;
import hud.iys.service.IMevzuatSetiService;
import hud.iys.service.ITebligIcerikService;
import hud.iys.service.ITebligService;
import hud.iys.view.tree.TreeNodeImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.TreeNode;
 
@ManagedBean(name="linkMB")
@SessionScoped
public class LinkBean implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private MevzuatSeti mevzuatSeti; 
    private Mevzuat mevzuat;
    private MevzuatIcerikTip mevzuatIcerikTip;
    private Teblig teblig;
    
    private String mevzuatSetiId;
    private String mevzuatId;
    private String mevzuatIcerikTipId;
    private String tebligId;
    
    private List<MevzuatSeti> mevzuatSetiList;
    private List<Mevzuat> mevzuatList;
    private List<MevzuatIcerikTip> mevzuatIcerikTipListesi;
    private List<Teblig> tebligList;
    
    private Boolean renderLinkTree;
    private TreeNode rootNode;
	private TreeNode selectedNode;
    
    @ManagedProperty(value="#{MevzuatSetiService}")
	IMevzuatSetiService mevzuatSetiService;
    
    @ManagedProperty(value="#{MevzuatService}")
	IMevzuatService mevzuatService;
    
    @ManagedProperty(value="#{TebligService}")
   	ITebligService tebligService;
    
    @ManagedProperty(value="#{TebligIcerikService}")
   	ITebligIcerikService tebligIcerikService;
    
    @ManagedProperty(value="#{MevzuatIcerikTipService}")
   	IMevzuatIcerikTipService mevzuatIcerikTipService;
    
    @ManagedProperty(value="#{MevzuatIcerikEslemeService}")
   	IMevzuatIcerikEslemeService mevzuatIcerikEslemeService;
    
    @ManagedProperty(value="#{LinkService}")
   	ILinkService linkService;
    
    @ManagedProperty(value="#{kanunIcerikMB}")
	private KanunIcerikBean kanunIcerikBean;
     
    @PostConstruct
    public void init() {
    	mevzuatSetiList = new ArrayList<MevzuatSeti>();
    	mevzuatSetiList.addAll(getMevzuatSetiService().getMevzuatSetleri());
    	
    	renderLinkTree = false;
        
    }
 

	public MevzuatSeti getMevzuatSeti() {
		return mevzuatSeti;
	}



	public void setMevzuatSeti(MevzuatSeti mevzuatSeti) {
		this.mevzuatSeti = mevzuatSeti;
	}



	public Mevzuat getMevzuat() {
		return mevzuat;
	}



	public void setMevzuat(Mevzuat mevzuat) {
		this.mevzuat = mevzuat;
	}



	public Teblig getTeblig() {
		return teblig;
	}



	public void setTeblig(Teblig teblig) {
		this.teblig = teblig;
	}



	public String getMevzuatSetiId() {
		return mevzuatSetiId;
	}



	public void setMevzuatSetiId(String mevzuatSetiId) {
		this.mevzuatSetiId = mevzuatSetiId;
	}

	

	public String getMevzuatId() {
		return mevzuatId;
	}



	public void setMevzuatId(String mevzuatId) {
		this.mevzuatId = mevzuatId;
	}



	public String getMevzuatIcerikTipId() {
		return mevzuatIcerikTipId;
	}



	public void setMevzuatIcerikTipId(String mevzuatIcerikTipId) {
		this.mevzuatIcerikTipId = mevzuatIcerikTipId;
	}



	public String getTebligId() {
		return tebligId;
	}

	public void setTebligId(String tebligId) {
		this.tebligId = tebligId;
	}



	public MevzuatIcerikTip getMevzuatIcerikTip() {
		return mevzuatIcerikTip;
	}



	public void setMevzuatIcerikTip(MevzuatIcerikTip mevzuatIcerikTip) {
		this.mevzuatIcerikTip = mevzuatIcerikTip;
	}



	public List<MevzuatSeti> getMevzuatSetiList() {
		return mevzuatSetiList;
	}


	public void setMevzuatSetiList(List<MevzuatSeti> mevzuatSetiList) {
		this.mevzuatSetiList = mevzuatSetiList;
	}


	public List<Mevzuat> getMevzuatList() {
		return mevzuatList;
	}


	public void setMevzuatList(List<Mevzuat> mevzuatList) {
		this.mevzuatList = mevzuatList;
	}


	public List<Teblig> getTebligList() {
		return tebligList;
	}



	public void setTebligList(List<Teblig> tebligList) {
		this.tebligList = tebligList;
	}



	public IMevzuatSetiService getMevzuatSetiService() {
		return mevzuatSetiService;
	}


	public void setMevzuatSetiService(IMevzuatSetiService mevzuatSetiService) {
		this.mevzuatSetiService = mevzuatSetiService;
	}


	public IMevzuatService getMevzuatService() {
		return mevzuatService;
	}


	public void setMevzuatService(IMevzuatService mevzuatService) {
		this.mevzuatService = mevzuatService;
	}

	

	public ITebligService getTebligService() {
		return tebligService;
	}



	public void setTebligService(ITebligService tebligService) {
		this.tebligService = tebligService;
	}



	public List<MevzuatIcerikTip> getMevzuatIcerikTipListesi() {
		return mevzuatIcerikTipListesi;
	}



	public void setMevzuatIcerikTipListesi(
			List<MevzuatIcerikTip> mevzuatIcerikTipListesi) {
		this.mevzuatIcerikTipListesi = mevzuatIcerikTipListesi;
	}



	public IMevzuatIcerikTipService getMevzuatIcerikTipService() {
		return mevzuatIcerikTipService;
	}



	public void setMevzuatIcerikTipService(
			IMevzuatIcerikTipService mevzuatIcerikTipService) {
		this.mevzuatIcerikTipService = mevzuatIcerikTipService;
	}



	public IMevzuatIcerikEslemeService getMevzuatIcerikEslemeService() {
		return mevzuatIcerikEslemeService;
	}



	public void setMevzuatIcerikEslemeService(
			IMevzuatIcerikEslemeService mevzuatIcerikEslemeService) {
		this.mevzuatIcerikEslemeService = mevzuatIcerikEslemeService;
	}


	public ITebligIcerikService getTebligIcerikService() {
		return tebligIcerikService;
	}



	public void setTebligIcerikService(ITebligIcerikService tebligIcerikService) {
		this.tebligIcerikService = tebligIcerikService;
	}



	public ILinkService getLinkService() {
		return linkService;
	}


	public void setLinkService(ILinkService linkService) {
		this.linkService = linkService;
	}


	public KanunIcerikBean getKanunIcerikBean() {
		return kanunIcerikBean;
	}


	public void setKanunIcerikBean(KanunIcerikBean kanunIcerikBean) {
		this.kanunIcerikBean = kanunIcerikBean;
	}


	public Boolean getRenderLinkTree() {
		return renderLinkTree;
	}

	public void setRenderLinkTree(Boolean renderLinkTree) {
		this.renderLinkTree = renderLinkTree;
	}
	
	


	public void onMevzuatSetiChange() {
		System.out.println("------------- mevzuat seti change event-------------------");
		if (mevzuatSetiId !=null && !mevzuatSetiId.equals("")) {
		    mevzuatList = new ArrayList<Mevzuat>();
        	mevzuatList.addAll(getMevzuatService().getMevzuatlarByMevzuatSetiId(Long.parseLong(mevzuatSetiId)));        
		}      
    }
     
	public void onMevzuatChange() {
		System.out.println("------------- change event-------------------");
		if (mevzuatId !=null && !mevzuatId.equals("")) {
			
			tebligList = new ArrayList<Teblig>();
			tebligList.addAll(getTebligService().getTebliglerByMevzuatId(Long.parseLong(mevzuatId)));
			for (Teblig tblg : tebligList) {
				System.out.println(tblg.getTebligAdi());
			}
		}      
    }
	
	public void onTebligChange() {
		System.out.println("------------- teblig change event-------------------");
		if (tebligId !=null && !tebligId.equals("")) {
			
			TebligIcerik root = getTebligIcerikService().getTebligIcerikById(getTebligService().getTebligById(Long.parseLong(tebligId)).getTebligIcerikRoot()); // instead get root object from database 
		    rootNode = newNodeWithChildren(root, null);
		}      
    }
	
	
	//Link Tree 
	
	public TreeNode newNodeWithChildren(TebligIcerik ttParent, TreeNode parent){
   	 TreeNode newNode= new TreeNodeImpl(ttParent, parent);
   	 for (TebligIcerik tt : ttParent.getChildren()){
       	  
             TreeNode newNode2= newNodeWithChildren(tt, newNode);
             
        }
        return newNode;
    }
	
	public TreeNode getRootNode() {    	
		
        return rootNode;
    }

    public void setRootNode(TreeNode node) {
        rootNode = node;
    }
    
    public TreeNode getSelectedNode() {
        return selectedNode;
    }
 
    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }
   
    
    public void showLinkTree(){
		renderLinkTree = true;
		if (tebligId !=null && !tebligId.equals("")) {
			TebligIcerik root = getTebligIcerikService().getTebligIcerikById(getTebligService().getTebligById(Long.parseLong(tebligId)).getTebligIcerikRoot()); // instead get root object from database 
	        rootNode = newNodeWithChildren(root, null);
		}
		else rootNode = null;
	}

    
    //link Olusturma
    
    public void createLink(){
    	
    	Link newLink = new Link();
    	newLink.setFromId(getKanunIcerikBean().getSelectedKanunIcerik().getKanunIcerikId());
    	newLink.setFromTypeId(1L);
    	newLink.setToTypeId(2L);
    	if(selectedNode != null) {
    		newLink.setToId(((TebligIcerik)selectedNode.getData()).getTebligIcerikId());
    	}
    	
    	getLinkService().addLink(newLink);
    }
    
    public void reset() {
		this.mevzuatId=null;
		this.mevzuatSetiId=null;
		this.tebligId=null;
		rootNode = null;
		
	}
    
    public void onNodeSelect(NodeSelectEvent event) {
    	if(selectedNode != null){
    		System.out.println("Selected Node : " + ((TebligIcerik)selectedNode.getData()).getTebligIcerikAdi());
    	}
    }

}