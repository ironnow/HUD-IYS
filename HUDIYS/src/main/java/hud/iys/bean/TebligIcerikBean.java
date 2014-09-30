package hud.iys.bean;

import hud.iys.model.DipnotKI;
import hud.iys.model.DipnotTI;
import hud.iys.model.TebligIcerik;
import hud.iys.model.TebligMaddeIcerik;
import hud.iys.model.Mevzuat;
import hud.iys.model.MevzuatSeti;
import hud.iys.service.IDipnotKIService;
import hud.iys.service.IDipnotTIService;
import hud.iys.service.ITebligIcerikService;
import hud.iys.service.ITebligMaddeIcerikService;
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


@ManagedBean(eager=true,name="tebligIcerikMB")
@SessionScoped
public class TebligIcerikBean implements Serializable {		
	
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";
	
	private TreeNode rootNode;
	private TreeNode selectedNode;
	
	private TebligIcerik selectedTebligIcerik;
	
	private String tebligIcerikNo;
	private String tebligIcerikAdi;
	private String tebligIcerikAyraci;
	private String tebligIcerikMetin;
	
	private String dipnotNo;
	private String dipnotMetin;
	
	@ManagedProperty(value="#{TebligIcerikService}")
	ITebligIcerikService tebligIcerikService;
	
	
	
	@ManagedProperty(value="#{TebligMaddeIcerikService}")
	ITebligMaddeIcerikService tebligMaddeIcerikService;
	
	@ManagedProperty(value="#{DipnotTIService}")
	IDipnotTIService dipnotTIService;
	
	@ManagedProperty(value="#{tebligMB}")
	private TebligBean tebligBean;
	 
		
	
    @PostConstruct
    public void init() {
    	TebligIcerik root = getTebligIcerikService().getTebligIcerikById(getTebligBean().getSelectedTeblig().getTebligIcerikRoot()); // instead get root object from database 
        rootNode = newNodeWithChildren(root, null);
        setSelectedTebligIcerik((TebligIcerik)rootNode.getData());
       
    }

    /**
     *  recursive function that returns a new node with its children
    */
    public TreeNode newNodeWithChildren(TebligIcerik ttParent, TreeNode parent){
         TreeNode newNode= new TreeNodeImpl(ttParent, parent);
         for (TebligIcerik tt : ttParent.getChildren()){
              TreeNode newNode2= newNodeWithChildren(tt, newNode);
         }
         return newNode;
    }

    public TreeNode getRootNode() {    	
    	TebligIcerik root = getTebligIcerikService().getTebligIcerikById(getTebligBean().getSelectedTeblig().getTebligIcerikRoot()); // instead get root object from database 
        rootNode = newNodeWithChildren(root, null);
        return rootNode;
    }

    public void setRootNode(TreeNode node) {
        rootNode = node;
    }
    
    public void reset() {
		this.setTebligIcerikNo(null);
		this.setTebligIcerikAdi("");
		this.setTebligIcerikAyraci("");
		this.setTebligIcerikMetin("");
	}

	public ITebligIcerikService getTebligIcerikService() {
		return tebligIcerikService;
	}

	public void setTebligIcerikService(ITebligIcerikService tebligIcerikService) {
		this.tebligIcerikService = tebligIcerikService;
	}
    
	
    public TreeNode getSelectedNode() {
        return selectedNode;
    }
 
    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }
        
     
    public String getTebligIcerikNo() {
		return tebligIcerikNo;
	}

	public void setTebligIcerikNo(String tebligIcerikNo) {
		this.tebligIcerikNo = tebligIcerikNo;
	}

	public String getTebligIcerikAdi() {
		return tebligIcerikAdi;
	}

	public void setTebligIcerikAdi(String tebligIcerikAdi) {
		this.tebligIcerikAdi = tebligIcerikAdi;
	}
	
	
	public String getTebligIcerikAyraci() {
		return tebligIcerikAyraci;
	}

	public void setTebligIcerikAyraci(String tebligIcerikAyraci) {
		this.tebligIcerikAyraci = tebligIcerikAyraci;
	}

	public String getTebligIcerikMetin() {
		return tebligIcerikMetin;
	}

	public void setTebligIcerikMetin(String tebligIcerikMetin) {
		this.tebligIcerikMetin = tebligIcerikMetin;
	}
	
	

	public TebligBean getTebligBean() {
		return tebligBean;
	}

	public void setTebligBean(TebligBean tebligBean) {
		this.tebligBean = tebligBean;
	}


	
	public ITebligMaddeIcerikService getTebligMaddeIcerikService() {
		return tebligMaddeIcerikService;
	}

	public void setTebligMaddeIcerikService(ITebligMaddeIcerikService tebligMaddeIcerikService) {
		this.tebligMaddeIcerikService = tebligMaddeIcerikService;
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

	
	public IDipnotTIService getDipnotTIService() {
		return dipnotTIService;
	}

	public void setDipnotTIService(IDipnotTIService dipnotTIService) {
		this.dipnotTIService = dipnotTIService;
	}

	public void displaySelectedSingle() {
        if(selectedNode != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", selectedNode.getData().toString());
 
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
 
    public void deleteNode() {
    	 
    	getTebligIcerikService().deleteTebligIcerik((TebligIcerik)selectedNode.getData());
         
        selectedNode.getChildren().clear();
        selectedNode.getParent().getChildren().remove(selectedNode);
        selectedNode.setParent(null);
         
        selectedNode = null;       
    }
    
    public void addTebligIcerik() {
		  try {
			   TebligIcerik tebligIcerik = new TebligIcerik();
			   tebligIcerik.setTebligIcerikNo(getTebligIcerikNo());
			   tebligIcerik.setTebligIcerikAdi(getTebligIcerikAdi());
			   tebligIcerik.setTebligIcerikAyraci(getTebligIcerikAyraci());
			   tebligIcerik.setTebligIcerikMetin(getTebligIcerikMetin());
			   
			   
			   TebligMaddeIcerik tebligMaddeIcerik = new TebligMaddeIcerik();
			   tebligMaddeIcerik.setTebligMaddeIcerik(null);
			   tebligMaddeIcerik.setTebligMaddeIcerikAdi(getTebligIcerikAdi());
			   getTebligMaddeIcerikService().addTebligMaddeIcerik(tebligMaddeIcerik);
			   
			   tebligIcerik.setTebligMaddeIcerikRoot(tebligMaddeIcerik.getTebligMaddeIcerikId());
			   
			  
			   
			   if(selectedNode == null){
				   tebligIcerik.setTebligIcerik(getTebligIcerikService().getTebligIcerikById(tebligBean.getSelectedTeblig().getTebligIcerikRoot()));
				   TreeNode newNode = new TreeNodeImpl(tebligIcerik, rootNode);
				   
			   }
			   else {
				   tebligIcerik.setTebligIcerik((TebligIcerik)selectedNode.getData());
				   TreeNode newNode = new TreeNodeImpl(tebligIcerik, selectedNode);
				   selectedNode.setExpanded(true);
				   collapsingORexpanding(newNode,true);
				   
			   }
			   
			   tebligIcerik.setTeblig(tebligBean.getSelectedTeblig());
			   
			   
			  
			   getTebligIcerikService().addTebligIcerik(tebligIcerik);
			   tebligMaddeIcerik.setTebligIcerik(tebligIcerik);
			   
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		 
	 }
    
    public void addDipnot() {
		  try {
			   DipnotTI dipnotTI = new DipnotTI();
			   dipnotTI.setDipnotTINo(getDipnotNo());
			   dipnotTI.setDipnotTIMetin(getDipnotMetin());
			   
			   if(selectedTebligIcerik == null){
				  //dipnotKI.setKanunIcerik(getKanunIcerikService().getKanunIcerikById(kanunBean.getSelectedKanun().getKanunIcerikRoot()));
				  
			   }
			   else {
				   dipnotTI.setTebligIcerik(selectedTebligIcerik);				
			   }
			   
			   getDipnotTIService().addDipnot(dipnotTI);
			   
			   selectedTebligIcerik = null;
			   
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  		 
	 }
    
    
    public void collapsingORexpanding(TreeNode node, boolean option) {

    	if(node.getChildren().size() == 0) {
    	    node.setSelected(false);
    	}
    	else {
    	    for(TreeNode s: node.getChildren()) {
    	        collapsingORexpanding(s, option);
    	    }
    	    node.setExpanded(option);
    	    node.setSelected(false);
    	}
    }
    
    
    public void onNodeSelect(NodeSelectEvent event) {
    	
    	//selectedKanunIcerik=new KanunIcerik();
    	
    	selectedTebligIcerik=(TebligIcerik)(getSelectedNode().getData()); 
    	
    	if(selectedTebligIcerik != null){
    		
    		
    		// MaddeIcerik root = getMaddeIcerikService().getMaddeIcerikById(selectedKanunIcerik.getMaddeIcerikRoot()); // instead get root object from database 
    	    // rootNode = newNodeWithChildren(root, null);
    		
    	}
    	
    	selectedNode.setExpanded(true);
    	
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", event.getTreeNode().toString());
 
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public TebligIcerik getSelectedTebligIcerik() {
		return selectedTebligIcerik;
	}

	public void setSelectedTebligIcerik(TebligIcerik selectedTebligIcerik) {
		this.selectedTebligIcerik = selectedTebligIcerik;
	}
    
	public void updateTebligIcerik() {
		 if (selectedTebligIcerik != null) {
			 getTebligIcerikService().updateTebligIcerik(selectedTebligIcerik);
			 expandFromNode(selectedNode);
		 }
	 }

	 private void expandFromNode(TreeNode node) {
	    while ((node = node.getParent()) != null) {
	        node.setExpanded(true);
	    }
	}

}
