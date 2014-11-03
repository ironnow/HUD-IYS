package hud.iys.bean;

import hud.iys.model.Dipnot;
import hud.iys.model.DipnotKI;
import hud.iys.model.DipnotMI;
import hud.iys.model.Kanun;
import hud.iys.model.KanunIcerik;
import hud.iys.model.Link;
import hud.iys.model.MaddeIcerik;
import hud.iys.model.Mevzuat;
import hud.iys.model.MevzuatSeti;
import hud.iys.model.Teblig;
import hud.iys.model.TebligIcerik;
import hud.iys.model.TebligMaddeIcerik;
import hud.iys.service.IDipnotKIService;
import hud.iys.service.IDipnotMIService;
import hud.iys.service.IKanunIcerikService;
import hud.iys.service.IKanunService;
import hud.iys.service.ILinkService;
import hud.iys.service.IMaddeIcerikService;
import hud.iys.service.ITebligIcerikService;
import hud.iys.service.ITebligMaddeIcerikService;
import hud.iys.service.ITebligService;
import hud.iys.view.KanunMetin;
import hud.iys.view.tree.TreeNodeImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.TreeDragDropEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.dao.DataAccessException;


@ManagedBean(eager=true,name="kanunIcerikMB")
@SessionScoped
public class KanunIcerikBean implements Serializable {		
	
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";
	
	public final long kanunTipId = 1L;
	public final long kanunIcerikTipId = 2L;
	public final long kanunMaddeIcerikTipId = 3L;
	public final long tebligTipId = 4L;
	public final long tebligIcerikTipId = 5L;
	public final long tebligMaddeIcerikTipId = 6L;
	
	private TreeNode rootNode;
	private TreeNode hierarchyRootNode;
	private TreeNode maddelerRootNode;
	private TreeNode selectedNode;
	
	private KanunIcerik selectedKanunIcerik;
	
	private String icerikNo;
	private String icerikAdi;
	private String icerikMetin;
	
	private String dipnotNo;
	private String dipnotMetin;
	
		
	@ManagedProperty(value="#{KanunIcerikService}")
	IKanunIcerikService kanunIcerikService;	
	
	@ManagedProperty(value="#{KanunService}")
	IKanunService kanunService;	
	
	@ManagedProperty(value="#{TebligService}")
	ITebligService tebligService;	

	@ManagedProperty(value="#{TebligIcerikService}")
	ITebligIcerikService tebligIcerikService;	
	
	@ManagedProperty(value="#{MaddeIcerikService}")
	IMaddeIcerikService maddeIcerikService;
	
	@ManagedProperty(value="#{TebligMaddeIcerikService}")
	ITebligMaddeIcerikService tebligMaddeIcerikService;
	
	@ManagedProperty(value="#{LinkService}")
	ILinkService linkService;
	
	@ManagedProperty(value="#{kanunMB}")
	private KanunBean kanunBean;
	
	@ManagedProperty(value="#{DipnotKIService}")
	IDipnotKIService dipnotKIService;

	@ManagedProperty(value="#{dipnotMB}")
	private DipnotBean dipnotBean;
	
	//center tree table root node
	private TreeNode icerikRootNode;
	//root node of all nodes of kanun
	private TreeNode kanunMetniRootNode;
	private List<KanunMetin> kanunMetinleri;
	//root node of clicked node
	private TreeNode maddeIcerikRootNode; 
	
	private List<Kanun> ilgiliKanunList;
	private List<KanunIcerik> ilgiliKanunIcerikList;
	private List<Teblig> ilgiliTebligList;
    private List<TebligIcerik> ilgiliTebligIcerikList;
    
    private KanunIcerik selectedIlgiliKanunIcerik;
    private TreeNode rootNodeRelatedKIMI;
    
    private KanunIcerik selectedIlgiliTebligIcerik;
    private TreeNode rootNodeRelatedKITMI;
    
    private List<DipnotKI> dipnotlarKI;
    private List<DipnotMI> dipnotlarMI;
    
    private List<KanunIcerik> maddeler;
    private boolean isShowOnlyMaddeler;
	
    @PostConstruct
    public void init() {
    	KanunIcerik root = getKanunIcerikService().getKanunIcerikById(getKanunBean().getSelectedKanun().getKanunIcerikRoot()); // instead get root object from database 
    	maddeler = new ArrayList<KanunIcerik>();
    	isShowOnlyMaddeler = false;
    	hierarchyRootNode = newNodeWithChildren(root, null, maddeler);
		rootNode = hierarchyRootNode;
		
		maddelerRootNode = new DefaultTreeNode(root, null);
    	
    	for (KanunIcerik kanunIcerik : maddeler){
    		TreeNode newNode= new TreeNodeImpl(kanunIcerik, maddelerRootNode);
    		System.out.println("Yeni Madde : "+kanunIcerik.getIcerikAdi());
    	}
		
		if(getSelectedIlgiliKanunIcerik() != null){
			MaddeIcerik rootKIMI = getMaddeIcerikService().getMaddeIcerikById(getSelectedIlgiliKanunIcerik().getMaddeIcerikRoot()); // instead get root object from database 
			rootNodeRelatedKIMI = newNodeWithChildren(rootKIMI, null);
			rootNodeRelatedKIMI.setExpanded(true);
		}
		
		if(getSelectedIlgiliTebligIcerik() != null){
			TebligMaddeIcerik rootKITMI = getTebligMaddeIcerikService().getTebligMaddeIcerikById(getSelectedIlgiliTebligIcerik().getMaddeIcerikRoot()); // instead get root object from database 
			rootNodeRelatedKITMI = newNodeWithChildren(rootKITMI, null);
			rootNodeRelatedKITMI.setExpanded(true);
		}
		setSelectedKanunIcerik((KanunIcerik)rootNode.getData());
		
		if(getSelectedKanunIcerik() != null){
			MaddeIcerik rootMaddeIcerik = getMaddeIcerikService().getMaddeIcerikById(getSelectedKanunIcerik().getMaddeIcerikRoot()); // instead get root object from database 
			maddeIcerikRootNode = newNodeMIWithChildren(rootMaddeIcerik, null);
			maddeIcerikRootNode.setExpanded(true);
		}
		
		icerikRootNode = maddeIcerikRootNode;
		ilgiliKanunIcerikList = new ArrayList<KanunIcerik>();
		ilgiliTebligIcerikList = new ArrayList<TebligIcerik>();
    }
    public TreeNode newNodeMIWithChildren(MaddeIcerik ttParent, TreeNode parent){
        TreeNode newNode= new TreeNodeImpl(ttParent, parent);
        newNode.setExpanded(true);
        for (MaddeIcerik tt : ttParent.getChildren()){
             TreeNode newNode2= newNodeMIWithChildren(tt, newNode);
             newNode2.setExpanded(true);
        }
        return newNode;
   }
    
    public void changeRootNode(){
    	KanunIcerik root = getKanunIcerikService().getKanunIcerikById(getKanunBean().getSelectedKanun().getKanunIcerikRoot()); // instead get root object from database 
    	
    	kanunMetniRootNode = newFullNodeWithChildren(root, null,kanunMetinleri);
		icerikRootNode = kanunMetniRootNode;
		selectedKanunIcerik = root;
    }
   
	/**
     *  recursive function that returns a new node with its children
    */
   
    public void showOnlyMaddeler(){
    
    	if(isShowOnlyMaddeler == false ){
    		KanunIcerik root = getKanunIcerikService().getKanunIcerikById(getKanunBean().getSelectedKanun().getKanunIcerikRoot()); // instead get root object from database 
        	
    		maddeler = new ArrayList<KanunIcerik>();
        	hierarchyRootNode = newNodeWithChildren(root, null, maddeler);
    		//rootNode = hierarchyRootNode;
    		
    		maddelerRootNode = new DefaultTreeNode(root, null);
        	
        	for (KanunIcerik kanunIcerik : maddeler){
        		TreeNode newNode= new TreeNodeImpl(kanunIcerik, maddelerRootNode);
        		System.out.println("Yeni Madde : "+kanunIcerik.getIcerikAdi());
        	}
	    	rootNode = maddelerRootNode;
	    	isShowOnlyMaddeler = true;
    	}
    	else if (isShowOnlyMaddeler == true){
    		KanunIcerik root = getKanunIcerikService().getKanunIcerikById(getKanunBean().getSelectedKanun().getKanunIcerikRoot()); // instead get root object from database 
        	maddeler = new ArrayList<KanunIcerik>();
        	hierarchyRootNode = newNodeWithChildren(root, null, maddeler);
    		rootNode = hierarchyRootNode;
    		
    		isShowOnlyMaddeler = false;
    	}
    }
    
    public TreeNode newNodeWithChildren(KanunIcerik ttParent, TreeNode parent, List<KanunIcerik> maddeler){
    	 TreeNode newNode= new TreeNodeImpl(ttParent, parent);
//    	 List<KanunIcerik> childList = new ArrayList<KanunIcerik>();
//    	 childList.addAll(ttParent.getChildren());
//    	 
//    	 if (childList.size() > 0) {
//		    Collections.sort(childList, new Comparator<KanunIcerik>() {
//		        @Override
//		        public int compare(final KanunIcerik object1, final KanunIcerik object2) {
//		            return object1.getLeftId().compareTo(object2.getLeftId());
//		        }
//		       } );
//		  }
//    	 for (KanunIcerik tt : childList){
//    		 System.out.println("sirali :" +tt.getKanunIcerikAdi());
//    	 }
//    	
    	 if(ttParent.getChildren().size() <= 0){
    		 maddeler.add(ttParent);
    	 }
    	 for (KanunIcerik tt : ttParent.getChildren()){        	  
              TreeNode newNode2= newNodeWithChildren(tt, newNode,maddeler);              
         }
         return newNode;
    }
    
    public TreeNode newMaddeIcerikNodeWithChildren(MaddeIcerik ttParent, TreeNode parent, List<KanunMetin> kanunMetinleri){
    	
    	KanunMetin kanunMetin = new KanunMetin(ttParent.getMaddeIcerikAdi(),ttParent.getMaddeIcerikMetin());
    	kanunMetin.setType("metin");
    	kanunMetin.setIcerikId(ttParent.getMaddeIcerikId());
    	kanunMetinleri.add(kanunMetin);
        TreeNode newNode= new TreeNodeImpl(kanunMetin, parent);
        newNode.setExpanded(true);
        for (MaddeIcerik tt : ttParent.getChildren()){
             TreeNode newNode2= newMaddeIcerikNodeWithChildren(tt, newNode,kanunMetinleri);
             newNode2.setExpanded(true);
        }
        return newNode;
    }
    
    public TreeNode newFullNodeWithChildren(KanunIcerik ttParent, TreeNode parent, List<KanunMetin> kanunMetinleri){
    	    	
    	KanunMetin kanunMetin = new KanunMetin(); 
    	
    	kanunMetin.setIcerikId(ttParent.getIcerikId());
    	
   	 	TreeNode newNode= new TreeNodeImpl(kanunMetin, parent);
   	 	newNode.setExpanded(true);
	   	MaddeIcerik rootMaddeIcerik = getMaddeIcerikService().getMaddeIcerikById(ttParent.getMaddeIcerikRoot()); // instead get root object from database
	   	if(rootMaddeIcerik !=null){
	   		if((rootMaddeIcerik.getChildren()).size() > 0 ){
	   			kanunMetin.setType("madde");
	   			kanunMetin.setIcerikMetin(ttParent.getIcerikNo()+" - "+ttParent.getIcerikAdi());
	   		}
	   		else {
	   			kanunMetin.setType("baslik"); // KanunIcerik
	   			kanunMetin.setIcerikMetin(ttParent.getIcerikAdi());
	   		}
	   		
	   		kanunMetinleri.add(kanunMetin);
	   		
	   		if(ttParent.getIcerikMetin() != null && !(ttParent.getIcerikMetin().equals("")) ){
	   			KanunMetin kanunMetinMetin = new KanunMetin();
	   			kanunMetinMetin.setIcerikMetin(ttParent.getIcerikMetin());
	   			kanunMetinMetin.setType("metin");
	   			kanunMetinleri.add(kanunMetinMetin);
	   		}
	    		
	   		for (MaddeIcerik mi : rootMaddeIcerik.getChildren()){
	         	  
	             TreeNode newMaddeIcerikNode= newMaddeIcerikNodeWithChildren(mi, newNode, kanunMetinleri);
	             newMaddeIcerikNode.setExpanded(true);
	        }
	   		
	   		//TreeNode newMaddeIcerikNode = newMaddeIcerikNodeWithChildren(rootMaddeIcerik, newNode);
	   		//newMaddeIcerikNode.setExpanded(true);
		}
	   
	   	
   	 	for (KanunIcerik tt : ttParent.getChildren()){
       	  
             TreeNode newNode2= newFullNodeWithChildren(tt, newNode,kanunMetinleri);
             newNode2.setExpanded(true);
        }
        return newNode;
    }
   
    public TreeNode getRootNode() {    	
    	//KanunIcerik root = getKanunIcerikService().getKanunIcerikById(getKanunBean().getSelectedKanun().getKanunIcerikRoot()); // instead get root object from database 
        //rootNode = newNodeWithChildren(root, null, maddeler);
        return rootNode;
    }

    public void setRootNode(TreeNode node) {
        rootNode = node;
    }
    
    
    
    public List<KanunIcerik> getMaddeler() {
		return maddeler;
	}
	public void setMaddeler(List<KanunIcerik> maddeler) {
		this.maddeler = maddeler;
	}
	public void createReadMode(){
    	kanunMetinleri = new ArrayList<KanunMetin>();
    	KanunIcerik root = getKanunIcerikService().getKanunIcerikById(getKanunBean().getSelectedKanun().getKanunIcerikRoot()); // instead get root object from database 
    	kanunMetniRootNode = newFullNodeWithChildren(root, null,kanunMetinleri);
       
    }
   


	public TreeNode getKanunMetniRootNode() {
		kanunMetinleri = new ArrayList<KanunMetin>();
		KanunIcerik root = getKanunIcerikService().getKanunIcerikById(getKanunBean().getSelectedKanun().getKanunIcerikRoot()); // instead get root object from database 
    	kanunMetniRootNode = newFullNodeWithChildren(root, null,kanunMetinleri);
        
		return kanunMetniRootNode;
	}


	public void setKanunMetniRootNode(TreeNode kanunMetniRootNode) {
		this.kanunMetniRootNode = kanunMetniRootNode;
	}


	public TreeNode getIcerikRootNode() {
		return icerikRootNode;
	}


	public void setIcerikRootNode(TreeNode icerikRootNode) {
		this.icerikRootNode = icerikRootNode;
	}


	public TreeNode getMaddeIcerikRootNode() {
		return maddeIcerikRootNode;
	}


	public void setMaddeIcerikRootNode(TreeNode maddeIcerikRootNode) {
		this.maddeIcerikRootNode = maddeIcerikRootNode;
	}


	public void reset() {
		this.setIcerikNo(null);
		this.setIcerikAdi("");
		this.setIcerikMetin("");
	}

	public IKanunIcerikService getKanunIcerikService() {
		return kanunIcerikService;
	}

	public void setKanunIcerikService(IKanunIcerikService kanunIcerikService) {
		this.kanunIcerikService = kanunIcerikService;
	}
    
	
    public TreeNode getSelectedNode() {
        return selectedNode;
    }
 
    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
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
	public void setTebligService(ITebligService tebligService) {
		this.tebligService = tebligService;
	}
	public String getIcerikNo() {
		return icerikNo;
	}
	public void setIcerikNo(String icerikNo) {
		this.icerikNo = icerikNo;
	}
	public String getIcerikAdi() {
		return icerikAdi;
	}
	public void setIcerikAdi(String icerikAdi) {
		this.icerikAdi = icerikAdi;
	}
	public String getIcerikMetin() {
		return icerikMetin;
	}
	public void setIcerikMetin(String icerikMetin) {
		this.icerikMetin = icerikMetin;
	}
	public KanunBean getKanunBean() {
		return kanunBean;
	}

	public void setKanunBean(KanunBean kanunBean) {
		this.kanunBean = kanunBean;
	}
	

	public IDipnotKIService getDipnotKIService() {
		return dipnotKIService;
	}

	public void setDipnotKIService(IDipnotKIService dipnotKIService) {
		this.dipnotKIService = dipnotKIService;
	}

	public DipnotBean getDipnotBean() {
		return dipnotBean;
	}

	public void setDipnotBean(DipnotBean dipnotBean) {
		this.dipnotBean = dipnotBean;
	}

	
	public String getDipnotNo() {
		return dipnotNo;
	}

	public void setDipnotNo(String dipnotNo) {
		this.dipnotNo = dipnotNo;
	}

	public String getDipnotMetin() {
		return dipnotMetin;
	}

	public void setDipnotMetin(String dipnotMetin) {
		this.dipnotMetin = dipnotMetin;
	}

	
	public IMaddeIcerikService getMaddeIcerikService() {
		return maddeIcerikService;
	}

	public void setMaddeIcerikService(IMaddeIcerikService maddeIcerikService) {
		this.maddeIcerikService = maddeIcerikService;
	}



	
	public ITebligIcerikService getTebligIcerikService() {
		return tebligIcerikService;
	}
	public void setTebligIcerikService(ITebligIcerikService tebligIcerikService) {
		this.tebligIcerikService = tebligIcerikService;
	}
	public List<KanunIcerik> getIlgiliKanunIcerikList() {
		return ilgiliKanunIcerikList;
	}
	public void setIlgiliKanunIcerikList(List<KanunIcerik> ilgiliKanunIcerikList) {
		this.ilgiliKanunIcerikList = ilgiliKanunIcerikList;
	}
	public List<TebligIcerik> getIlgiliTebligIcerikList() {
		return ilgiliTebligIcerikList;
	}
	public void setIlgiliTebligIcerikList(List<TebligIcerik> ilgiliTebligIcerikList) {
		this.ilgiliTebligIcerikList = ilgiliTebligIcerikList;
	}
		
	public List<Kanun> getIlgiliKanunList() {
		return ilgiliKanunList;
	}
	public void setIlgiliKanunList(List<Kanun> ilgiliKanunList) {
		this.ilgiliKanunList = ilgiliKanunList;
	}
	public List<Teblig> getIlgiliTebligList() {
		return ilgiliTebligList;
	}
	public void setIlgiliTebligList(List<Teblig> ilgiliTebligList) {
		this.ilgiliTebligList = ilgiliTebligList;
	}
	
	
	public List<DipnotKI> getDipnotlarKI() {
		return dipnotlarKI;
	}
	public void setDipnotlarKI(List<DipnotKI> dipnotlarKI) {
		this.dipnotlarKI = dipnotlarKI;
	}
	public List<DipnotMI> getDipnotlarMI() {
		return dipnotlarMI;
	}
	public void setDipnotlarMI(List<DipnotMI> dipnotlarMI) {
		this.dipnotlarMI = dipnotlarMI;
	}
	public KanunIcerik getSelectedIlgiliTebligIcerik() {
		return selectedIlgiliTebligIcerik;
	}
	public void setSelectedIlgiliTebligIcerik(KanunIcerik selectedIlgiliTebligIcerik) {
		this.selectedIlgiliTebligIcerik = selectedIlgiliTebligIcerik;
	}
	public TreeNode getRootNodeRelatedKITMI() {
		if(getSelectedIlgiliTebligIcerik() != null){
			TebligMaddeIcerik rootKITMI = getTebligMaddeIcerikService().getTebligMaddeIcerikById(getSelectedIlgiliTebligIcerik().getMaddeIcerikRoot()); // instead get root object from database 
			rootNodeRelatedKITMI = newNodeWithChildren(rootKITMI, null);
			rootNodeRelatedKITMI.setExpanded(true);
		}
		return rootNodeRelatedKITMI;
	}
	public void setRootNodeRelatedKITMI(TreeNode rootNodeRelatedKITMI) {
		this.rootNodeRelatedKITMI = rootNodeRelatedKITMI;
	}
	public List<KanunMetin> getKanunMetinleri() {
		kanunMetinleri = new ArrayList<KanunMetin>();
    	KanunIcerik root = getKanunIcerikService().getKanunIcerikById(getKanunBean().getSelectedKanun().getKanunIcerikRoot()); // instead get root object from database 
    	kanunMetniRootNode = newFullNodeWithChildren(root, null,kanunMetinleri);
      	return kanunMetinleri;
	}
	public void setKanunMetinleri(List<KanunMetin> kanunMetinleri) {
		this.kanunMetinleri = kanunMetinleri;
	}
	public ILinkService getLinkService() {
		return linkService;
	}
	public void setLinkService(ILinkService linkService) {
		this.linkService = linkService;
	}
	
	
	public ITebligMaddeIcerikService getTebligMaddeIcerikService() {
		return tebligMaddeIcerikService;
	}
	public void setTebligMaddeIcerikService(
			ITebligMaddeIcerikService tebligMaddeIcerikService) {
		this.tebligMaddeIcerikService = tebligMaddeIcerikService;
	}
	public void displaySelectedSingle() {
        if(selectedNode != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", selectedNode.getData().toString());
 
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
 
    public void deleteNode() {
    	if(selectedNode != null) {
	    	getKanunIcerikService().deleteKanunIcerik((KanunIcerik)selectedNode.getData());
	         
	        selectedNode.getChildren().clear();
	        selectedNode.getParent().getChildren().remove(selectedNode);
	        selectedNode.setParent(null);
	         
	        selectedNode = null;  
    	}
    }
    
    public void addKanunIcerik() {
    	TreeNode newNode = null;  
    	try {
			   KanunIcerik kanunIcerik = new KanunIcerik();
			   kanunIcerik.setIcerikNo(getIcerikNo());
			   kanunIcerik.setIcerikAdi(getIcerikAdi());
			   kanunIcerik.setIcerikMetin(getIcerikMetin());
			   
			   
			   MaddeIcerik maddeIcerik = new MaddeIcerik();
			   maddeIcerik.setMaddeIcerik(null);
			   maddeIcerik.setMaddeIcerikAdi(getIcerikAdi());
			   getMaddeIcerikService().addMaddeIcerik(maddeIcerik);
			   
			   kanunIcerik.setMaddeIcerikRoot(maddeIcerik.getMaddeIcerikId());
			   			   
			   if(selectedNode == null){
				   kanunIcerik.setKanunIcerik(getKanunIcerikService().getKanunIcerikById(kanunBean.getSelectedKanun().getKanunIcerikRoot()));
			   
				   List<KanunIcerik> children = new ArrayList<KanunIcerik>();
				   children.addAll((getKanunIcerikService().getKanunIcerikById(kanunBean.getSelectedKanun().getKanunIcerikRoot())).getChildren());
				   
				   if(children.size()>0){
					   if(children.get(children.size()-1) != null){
						   kanunIcerik.setChildPosition((children.get(children.size()-1)).getChildPosition()+1);
					   }
				   }
				   else{
					   kanunIcerik.setChildPosition(0L);
				   }
				   
				   newNode = new TreeNodeImpl(kanunIcerik, rootNode);
				   newNode.setExpanded(true);
				   newNode.setSelected(true);
				   expand(newNode);
			   }
			   else {
				   kanunIcerik.setKanunIcerik((KanunIcerik)selectedNode.getData());
				  
				   List<KanunIcerik> children = new ArrayList<KanunIcerik>();
				   if(((KanunIcerik)selectedNode.getData()).getChildren() != null){
					   children.addAll(((KanunIcerik)selectedNode.getData()).getChildren());
				   }
				   
				   if(children.size()>0){
					   if(children.get(children.size()-1) != null){
						   kanunIcerik.setChildPosition((children.get(children.size()-1)).getChildPosition()+1);
					   }
				   }
				   else{
					   kanunIcerik.setChildPosition(0L);
				   }
				   
				   newNode = new TreeNodeImpl(kanunIcerik, selectedNode);
				   newNode.setExpanded(true);
				   newNode.setSelected(true);
				   expand(newNode);
			   }
			   
			   kanunIcerik.setKanun(kanunBean.getSelectedKanun());
			  
			  
			   getKanunIcerikService().addKanunIcerik(kanunIcerik);
			   maddeIcerik.setKanunIcerik(kanunIcerik);			 
			   RequestContext.getCurrentInstance().update(":formTree:tree");
			   
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		 // showExpanded(rootNode);
		  //newNode.setExpanded(true);
		 // expand(newNode);
		 // showExpanded(rootNode);
	 }
    
    public void addDipnot() {
		  try {
			   DipnotKI dipnotKI = new DipnotKI();
			   dipnotKI.setDipnotKINo(getDipnotNo());
			   dipnotKI.setDipnotKIMetin(getDipnotMetin());
			   
			   if(selectedKanunIcerik == null){
				  //dipnotKI.setKanunIcerik(getKanunIcerikService().getKanunIcerikById(kanunBean.getSelectedKanun().getKanunIcerikRoot()));
				   
				   
			   }
			   else {
				   dipnotKI.setKanunIcerik(selectedKanunIcerik);				
			   }
			   
			   getDipnotKIService().addDipnot(dipnotKI);
			   
			   selectedKanunIcerik = null;
			   
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  		 
	 }
    
    public void onNodeSelect(NodeSelectEvent event) {
    	
    	//selectedKanunIcerik=new KanunIcerik();
    	
    	
    	selectedKanunIcerik=(KanunIcerik)(getSelectedNode().getData()); 
    	MaddeIcerik rootMaddeIcerik = getMaddeIcerikService().getMaddeIcerikById(getSelectedKanunIcerik().getMaddeIcerikRoot()); // instead get root object from database 
		maddeIcerikRootNode = newNodeMIWithChildren(rootMaddeIcerik, null);
		maddeIcerikRootNode.setExpanded(true);
    	icerikRootNode = maddeIcerikRootNode;
    	
    	
    	if(selectedKanunIcerik != null){
    		
    		dipnotlarKI = new ArrayList<DipnotKI>();
    		if(selectedKanunIcerik.getDipnotlar() != null){
    			dipnotlarKI.addAll(selectedKanunIcerik.getDipnotlar());
    		}
    		    		
    		
    		ilgiliKanunList = new ArrayList<Kanun>();
    		ilgiliKanunIcerikList = new ArrayList<KanunIcerik>();
    		ilgiliTebligList = new ArrayList<Teblig>();
    		ilgiliTebligIcerikList = new ArrayList<TebligIcerik>();
    		List<Link> linkList = getLinkService().getLinklerByFromId(selectedKanunIcerik.getIcerikId());
    		
    		for(Link link : linkList){
				if(link.getToTypeId() == kanunTipId){
					ilgiliKanunList.add(getKanunService().getKanunById(link.getToId()));
					
				}
				else if(link.getToTypeId() == kanunIcerikTipId){    				
					ilgiliKanunIcerikList.add(getKanunIcerikService().getKanunIcerikById(link.getToId()));
					
				}
				else if(link.getToTypeId() == tebligTipId){
					ilgiliTebligList.add(getTebligService().getTebligById(link.getToId()));
					
				}
				else if(link.getToTypeId() == tebligIcerikTipId){    				
					ilgiliTebligIcerikList.add(getTebligIcerikService().getTebligIcerikById(link.getToId()));
					
				}
			}
    		// MaddeIcerik root = getMaddeIcerikService().getMaddeIcerikById(selectedKanunIcerik.getMaddeIcerikRoot()); // instead get root object from database 
    	    // rootNode = newNodeWithChildren(root, null);
    		
    	}
    	
    	selectedNode.setExpanded(true);
    	
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", event.getTreeNode().toString());
 
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public KanunIcerik getSelectedKanunIcerik() {
		return selectedKanunIcerik;
	}

	public void setSelectedKanunIcerik(KanunIcerik selectedKanunIcerik) {
		this.selectedKanunIcerik = selectedKanunIcerik;
	}
    
	
	
	public KanunIcerik getSelectedIlgiliKanunIcerik() {
		return selectedIlgiliKanunIcerik;
	}
	public void setSelectedIlgiliKanunIcerik(KanunIcerik selectedIlgiliKanunIcerik) {
		this.selectedIlgiliKanunIcerik = selectedIlgiliKanunIcerik;
	}
	
	public void setIlgiliKIMI(){
		if(getSelectedIlgiliKanunIcerik() != null){
			MaddeIcerik root = getMaddeIcerikService().getMaddeIcerikById(getSelectedIlgiliKanunIcerik().getMaddeIcerikRoot()); // instead get root object from database 
			rootNodeRelatedKIMI = newNodeWithChildren(root, null);
			rootNodeRelatedKIMI.setExpanded(true);
		}
	}
	public void setIlgiliKITMI(){
		if(getSelectedIlgiliTebligIcerik() != null){
			TebligMaddeIcerik rootKITMI = getTebligMaddeIcerikService().getTebligMaddeIcerikById(getSelectedIlgiliTebligIcerik().getMaddeIcerikRoot()); // instead get root object from database 
			rootNodeRelatedKITMI = newNodeWithChildren(rootKITMI, null);
			rootNodeRelatedKITMI.setExpanded(true);
		}
	}
	
	public TreeNode getRootNodeRelatedKIMI() {
		if(getSelectedIlgiliKanunIcerik() != null){
			MaddeIcerik root = getMaddeIcerikService().getMaddeIcerikById(getSelectedIlgiliKanunIcerik().getMaddeIcerikRoot()); // instead get root object from database 
			rootNodeRelatedKIMI = newNodeWithChildren(root, null);
			rootNodeRelatedKIMI.setExpanded(true);
		}
		return rootNodeRelatedKIMI;
	}
	public void setRootNodeRelatedKIMI(TreeNode rootNodeRelatedKIMI) {
		this.rootNodeRelatedKIMI = rootNodeRelatedKIMI;
	}
	 public TreeNode newNodeWithChildren(MaddeIcerik ttParent, TreeNode parent){
         TreeNode newNode= new TreeNodeImpl(ttParent, parent);
         newNode.setExpanded(true);
         for (MaddeIcerik tt : ttParent.getChildren()){
              TreeNode newNode2= newNodeWithChildren(tt, newNode);
              newNode2.setExpanded(true);
         }
         return newNode;
    }
	
	 
	 public TreeNode newNodeWithChildren(TebligMaddeIcerik ttParent, TreeNode parent){
         TreeNode newNode= new TreeNodeImpl(ttParent, parent);
         newNode.setExpanded(true);
         for (TebligMaddeIcerik tt : ttParent.getChildren()){
              TreeNode newNode2= newNodeWithChildren(tt, newNode);
              newNode2.setExpanded(true);
         }
         return newNode;
     }
	 
	public void onDragDrop(TreeDragDropEvent event) {
		KanunIcerik dragKanunIcerik = (KanunIcerik)event.getDragNode().getData();
		KanunIcerik dropKanunIcerik = (KanunIcerik)event.getDropNode().getData();    
		Long dropIndex = new Long(event.getDropIndex());		 
        Long oldIndex = dragKanunIcerik.getChildPosition();
        KanunIcerik oldParent = dragKanunIcerik.getKanunIcerik();
        
        if( oldParent.getIcerikId().equals(dropKanunIcerik.getIcerikId())) {
        	Long index = 0L;
	        if(oldIndex > dropIndex){ //yukari tasinmissa
		        for(KanunIcerik child : dropKanunIcerik.getChildren()){
		        	if(index >= dropIndex && index < oldIndex){
		        		child.setChildPosition(child.getChildPosition()+1);
		        		getKanunIcerikService().updateKanunIcerik(child);
		        	}
		        	index++;
		        }
	        }
	        
	        else if(oldIndex < dropIndex){ //asagi tasinmissa
	        	 for(KanunIcerik child : dropKanunIcerik.getChildren()){
	 	        	if(index <= dropIndex && index > oldIndex){
	 	        		child.setChildPosition(child.getChildPosition()-1);
	 	        		getKanunIcerikService().updateKanunIcerik(child);
	 	        	}
	 	        	index++;
	 	        }
	        }
	        
	        dragKanunIcerik.setKanunIcerik(dropKanunIcerik);
	        dragKanunIcerik.setChildPosition(dropIndex);
    		getKanunIcerikService().updateKanunIcerik(dragKanunIcerik);
        }
        else if(! oldParent.getIcerikId().equals(dropKanunIcerik.getIcerikId())){
        	//change old parent child positions
        	Long index = 0L;
        	for(KanunIcerik child : oldParent.getChildren()){
        		if(index >= oldIndex){
        			child.setChildPosition(child.getChildPosition()-1);
        			getKanunIcerikService().updateKanunIcerik(child);
 	        	}
 	        	index++;
        	}
        	//change new parent child positions
        	index = 0L;	    
        	for(KanunIcerik child : dropKanunIcerik.getChildren()){
	        	if(index >= dropIndex){
	        		if(child.getIcerikId() != dragKanunIcerik.getIcerikId()){
	        			child.setChildPosition(child.getChildPosition()+1);
	        			getKanunIcerikService().updateKanunIcerik(child);
	        		}	        		
	        	}
	        	index++;
	        }  
	        
	        dragKanunIcerik.setKanunIcerik(dropKanunIcerik);	        
	        dragKanunIcerik.setChildPosition(dropIndex);
	        getKanunIcerikService().updateKanunIcerik(dragKanunIcerik);
 	        
        }
       
    }
	
	
	 public void updateKanunIcerik() {
		 if (selectedKanunIcerik != null) {
			 getKanunIcerikService().updateKanunIcerik(selectedKanunIcerik);
			 expand(selectedNode);
		 }
	 }

	 public void showExpanded(TreeNode root){
		 root.setExpanded(true);
		 System.out.println(((KanunIcerik)(root.getData())).getIcerikAdi() + " is Expanded : " + root.isExpanded());
		 
		 for(TreeNode treeNode : root.getChildren()){
			 showExpanded(treeNode);
		 }
	 }
	 
	 public void expand(TreeNode treeNode){
		 treeNode.setExpanded(true);
		 //((KanunIcerik)treeNode.getData()).setKanunIcerikAdi("secili");
//		  if (treeNode.getParent()!=null){
//			  TreeNode newN = (TreeNode)treeNode.getParent();
//			  System.out.println("parent adi :::::::::::::::: "+((KanunIcerik)newN).getKanunIcerikAdi());
//		  }
	    if (treeNode.getParent()!=null){
	    	TreeNode newNode = treeNode.getParent();
	    	newNode.setExpanded(true);
	        treeNode.getParent().setExpanded(true);
	        treeNode.setParent(newNode);
	        expand(newNode);
	        System.out.println("data --------------------------->  : " + treeNode.getParent().getData().toString()+" expanded : "+treeNode.getParent().isExpanded());
	    }
	}
}
