package hud.iys.bean;

import hud.iys.model.Fikra;
import hud.iys.model.KanunIcerik;
import hud.iys.model.MaddeIcerik;
import hud.iys.model.Mevzuat;
import hud.iys.model.MevzuatSeti;
import hud.iys.model.Paragraf;
import hud.iys.service.IBentService;
import hud.iys.service.IFikraService;
import hud.iys.service.IKanunIcerikService;
import hud.iys.service.IMaddeIcerikService;
import hud.iys.service.IParagrafService;
import hud.iys.view.tree.TreeNodeImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.dao.DataAccessException;


@ManagedBean(eager=true,name="kanunIcerikMB")
@SessionScoped
public class KanunIcerikBean implements Serializable {		
	
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";
	
	private TreeNode rootNode;
	private TreeNode selectedNode;
	
	private KanunIcerik selectedKanunIcerik;
	
	private String kanunIcerikNo;
	private String kanunIcerikAdi;
	private String kanunIcerikMetin;
	
	@ManagedProperty(value="#{KanunIcerikService}")
	IKanunIcerikService kanunIcerikService;
	
	@ManagedProperty(value="#{ParagrafService}")
	IParagrafService paragrafService;
	
	@ManagedProperty(value="#{FikraService}")
	IFikraService fikraService;
	
	@ManagedProperty(value="#{BentService}")
	IBentService bentService;
	
	@ManagedProperty(value="#{MaddeIcerikService}")
	IMaddeIcerikService maddeIcerikService;
	
	@ManagedProperty(value="#{kanunMB}")
	private KanunBean kanunBean;
	 
	List<Paragraf> selectedKanunIcerikParagrafList;
	List<Fikra> selectedKanunIcerikFikraList;
	
	
	
    @PostConstruct
    public void init() {
        KanunIcerik root = getKanunIcerikService().getKanunIcerikById(getKanunBean().getSelectedKanun().getKanunIcerikRoot()); // instead get root object from database 
        rootNode = newNodeWithChildren(root, null);
        setSelectedKanunIcerik((KanunIcerik)rootNode.getData());
       
    }

    /**
     *  recursive function that returns a new node with its children
    */
    public TreeNode newNodeWithChildren(KanunIcerik ttParent, TreeNode parent){
         TreeNode newNode= new TreeNodeImpl(ttParent, parent);
         for (KanunIcerik tt : ttParent.getChildren()){
              TreeNode newNode2= newNodeWithChildren(tt, newNode);
         }
         return newNode;
    }

    public TreeNode getRootNode() {    	
    	KanunIcerik root = getKanunIcerikService().getKanunIcerikById(getKanunBean().getSelectedKanun().getKanunIcerikRoot()); // instead get root object from database 
        rootNode = newNodeWithChildren(root, null);
        return rootNode;
    }

    public void setRootNode(TreeNode node) {
        rootNode = node;
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
    
    
     
    public String getKanunIcerikNo() {
		return kanunIcerikNo;
	}

	public void setKanunIcerikNo(String kanunIcerikNo) {
		this.kanunIcerikNo = kanunIcerikNo;
	}

	public String getKanunIcerikAdi() {
		return kanunIcerikAdi;
	}

	public void setKanunIcerikAdi(String kanunIcerikAdi) {
		this.kanunIcerikAdi = kanunIcerikAdi;
	}
	
	public String getKanunIcerikMetin() {
		return kanunIcerikMetin;
	}

	public void setKanunIcerikMetin(String kanunIcerikMetin) {
		this.kanunIcerikMetin = kanunIcerikMetin;
	}
	
	

	public KanunBean getKanunBean() {
		return kanunBean;
	}

	public void setKanunBean(KanunBean kanunBean) {
		this.kanunBean = kanunBean;
	}

		

	public IParagrafService getParagrafService() {
		return paragrafService;
	}

	public void setParagrafService(IParagrafService paragrafService) {
		this.paragrafService = paragrafService;
	}

	public IFikraService getFikraService() {
		return fikraService;
	}

	public void setFikraService(IFikraService fikraService) {
		this.fikraService = fikraService;
	}

	public IBentService getBentService() {
		return bentService;
	}

	public void setBentService(IBentService bentService) {
		this.bentService = bentService;
	}
	
	public IMaddeIcerikService getMaddeIcerikService() {
		return maddeIcerikService;
	}

	public void setMaddeIcerikService(IMaddeIcerikService maddeIcerikService) {
		this.maddeIcerikService = maddeIcerikService;
	}

	public List<Paragraf> getSelectedKanunIcerikParagrafList() {
		return selectedKanunIcerikParagrafList;
	}

	public void setSelectedKanunIcerikParagrafList(
			List<Paragraf> selectedKanunIcerikParagrafList) {
		this.selectedKanunIcerikParagrafList = selectedKanunIcerikParagrafList;
	}

	public List<Fikra> getSelectedKanunIcerikFikraList() {
		return selectedKanunIcerikFikraList;
	}

	public void setSelectedKanunIcerikFikraList(
			List<Fikra> selectedKanunIcerikFikraList) {
		this.selectedKanunIcerikFikraList = selectedKanunIcerikFikraList;
	}

	public void displaySelectedSingle() {
        if(selectedNode != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", selectedNode.getData().toString());
 
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
 
    public void deleteNode() {
    	 
    	getKanunIcerikService().deleteKanunIcerik((KanunIcerik)selectedNode.getData());
         
        selectedNode.getChildren().clear();
        selectedNode.getParent().getChildren().remove(selectedNode);
        selectedNode.setParent(null);
         
        selectedNode = null;       
    }
    
    public void addKanunIcerik() {
		  try {
			   KanunIcerik kanunIcerik = new KanunIcerik();
			   kanunIcerik.setKanunIcerikNo(getKanunIcerikNo());
			   kanunIcerik.setKanunIcerikAdi(getKanunIcerikAdi());
			   kanunIcerik.setKanunIcerikMetin(getKanunIcerikMetin());
			   
			   
			   MaddeIcerik maddeIcerik = new MaddeIcerik();
			   maddeIcerik.setMaddeIcerik(null);
			   maddeIcerik.setMaddeIcerikAdi(getKanunIcerikAdi());
			   getMaddeIcerikService().addMaddeIcerik(maddeIcerik);
			   
			   kanunIcerik.setMaddeIcerikRoot(maddeIcerik.getMaddeIcerikId());
			   
			  
			   
			   if(selectedNode == null){
				   kanunIcerik.setKanunIcerik(getKanunIcerikService().getKanunIcerikById(kanunBean.getSelectedKanun().getKanunIcerikRoot()));
				   TreeNode newNode = new TreeNodeImpl(kanunIcerik, rootNode);
				   
			   }
			   else {
				   kanunIcerik.setKanunIcerik((KanunIcerik)selectedNode.getData());
				   TreeNode newNode = new TreeNodeImpl(kanunIcerik, selectedNode);
				   selectedNode.setExpanded(true);
			   }
			   
			   kanunIcerik.setKanun(kanunBean.getSelectedKanun());
			   
			   
			  
			   getKanunIcerikService().addKanunIcerik(kanunIcerik);
			   maddeIcerik.setKanunIcerik(kanunIcerik);
			   
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		 
	 }
    
    public void onNodeSelect(NodeSelectEvent event) {
    	
    	//selectedKanunIcerik=new KanunIcerik();
    	
    	selectedKanunIcerik=(KanunIcerik)(getSelectedNode().getData()); 
    	
    	if(selectedKanunIcerik != null){
    		
    		
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
    
    

}
