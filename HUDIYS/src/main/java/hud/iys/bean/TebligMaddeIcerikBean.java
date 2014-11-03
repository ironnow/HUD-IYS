package hud.iys.bean;


import hud.iys.model.DipnotMI;
import hud.iys.model.MaddeIcerik;
import hud.iys.model.TebligIcerik;
import hud.iys.model.TebligMaddeIcerik;
import hud.iys.model.Mevzuat;
import hud.iys.model.MevzuatSeti;
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

import org.primefaces.context.RequestContext;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.TreeDragDropEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.dao.DataAccessException;


@ManagedBean(eager=true,name="tebligMaddeIcerikMB")
@SessionScoped
public class TebligMaddeIcerikBean implements Serializable {		
	
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";
	
	private TreeNode rootNode;
	private TreeNode selectedNode;
	
	private TebligMaddeIcerik selectedTebligMaddeIcerik;
	
	private String tebligMaddeIcerikAdi;
	private String tebligMaddeIcerikMetin;
	
	
	
	@ManagedProperty(value="#{TebligMaddeIcerikService}")
	ITebligMaddeIcerikService tebligMaddeIcerikService;
	

	@ManagedProperty(value="#{tebligIcerikMB}")
	private TebligIcerikBean tebligIcerikBean;
	
	
	@PostConstruct
    public void init() {
		if(getTebligIcerikBean().getSelectedTebligIcerik() != null){
			TebligMaddeIcerik root = getTebligMaddeIcerikService().getTebligMaddeIcerikById(getTebligIcerikBean().getSelectedTebligIcerik().getMaddeIcerikRoot()); // instead get root object from database 
			rootNode = newNodeWithChildren(root, null);
			rootNode.setExpanded(true);
		}
       //rootNode = null;
    }
    
    public void reset() {
		 this.setTebligMaddeIcerikAdi("");
		 this.setTebligMaddeIcerikMetin("");
		 
	 }

    /**
     *  recursive function that returns a new node with its children
    */
    public TreeNode newNodeWithChildren(TebligMaddeIcerik ttParent, TreeNode parent){
         TreeNode newNode= new TreeNodeImpl(ttParent, parent);
         newNode.setExpanded(true);
         for (TebligMaddeIcerik tt : ttParent.getChildren()){
              TreeNode newNode2= newNodeWithChildren(tt, newNode);
              newNode2.setExpanded(true);
         }
         return newNode;
    }

    public TreeNode getRootNode() {   
    	if(getTebligIcerikBean().getSelectedTebligIcerik() != null){
    		TebligMaddeIcerik root = getTebligMaddeIcerikService().getTebligMaddeIcerikById(getTebligIcerikBean().getSelectedTebligIcerik().getMaddeIcerikRoot()); // instead get root object from database 
    		if(root !=null){
    			rootNode = newNodeWithChildren(root, null);
    		} else {
    			rootNode = null;
    		}
    	}
    	else{
    		rootNode = null;
    	}
        return rootNode;
    }

    public void setRootNode(TreeNode node) {
        rootNode = node;
    }

	public ITebligMaddeIcerikService getTebligMaddeIcerikService() {
		return tebligMaddeIcerikService;
	}

	public void setTebligMaddeIcerikService(ITebligMaddeIcerikService tebligMaddeIcerikService) {
		this.tebligMaddeIcerikService = tebligMaddeIcerikService;
	}
    

	public TreeNode getSelectedNode() {
        return selectedNode;
    }
 
    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }
    
    
     
    public String getTebligMaddeIcerikAdi() {
		return tebligMaddeIcerikAdi;
	}

	public void setTebligMaddeIcerikAdi(String tebligMaddeIcerikAdi) {
		this.tebligMaddeIcerikAdi = tebligMaddeIcerikAdi;
	}
	
	public String getTebligMaddeIcerikMetin() {
		return tebligMaddeIcerikMetin;
	}

	public void setTebligMaddeIcerikMetin(String tebligMaddeIcerikMetin) {
		this.tebligMaddeIcerikMetin = tebligMaddeIcerikMetin;
	}
	

	public TebligIcerikBean getTebligIcerikBean() {
		return tebligIcerikBean;
	}

	public void setTebligIcerikBean(TebligIcerikBean tebligIcerikBean) {
		this.tebligIcerikBean = tebligIcerikBean;
	}

	

	public void displaySelectedSingle() {
        if(selectedNode != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", selectedNode.getData().toString());
 
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
 
    public void deleteNode() {
    	 
    	getTebligMaddeIcerikService().deleteTebligMaddeIcerik((TebligMaddeIcerik)selectedNode.getData());
         
        selectedNode.getChildren().clear();
        selectedNode.getParent().getChildren().remove(selectedNode);
        selectedNode.setParent(null);
         
        selectedNode = null;       
    }
    
    public void addTebligMaddeIcerik() {
		  try {
			   TebligMaddeIcerik tebligMaddeIcerik = new TebligMaddeIcerik();
			   tebligMaddeIcerik.setTebligMaddeIcerikAdi(getTebligMaddeIcerikAdi());
			   tebligMaddeIcerik.setTebligMaddeIcerikMetin(getTebligMaddeIcerikMetin());
			   
			   if(selectedTebligMaddeIcerik == null){
				   tebligMaddeIcerik.setTebligMaddeIcerik(getTebligMaddeIcerikService().getTebligMaddeIcerikById(tebligIcerikBean.getSelectedTebligIcerik().getMaddeIcerikRoot()));
				   TreeNode newNode = new TreeNodeImpl(tebligMaddeIcerik, rootNode);
				   
				   List<TebligMaddeIcerik> children = new ArrayList<TebligMaddeIcerik>();
				   children.addAll((getTebligMaddeIcerikService().getTebligMaddeIcerikById(tebligIcerikBean.getSelectedTebligIcerik().getMaddeIcerikRoot())).getChildren());
				   
				   if(children.size()>0){
					   if(children.get(children.size()-1) != null){
						   tebligMaddeIcerik.setChildPosition((children.get(children.size()-1)).getChildPosition()+1);
					   }
				   }
				   else{
					   tebligMaddeIcerik.setChildPosition(0L);
				   }
			   }
			   else {
				   tebligMaddeIcerik.setTebligMaddeIcerik(selectedTebligMaddeIcerik);
				   TreeNode newNode = new TreeNodeImpl(tebligMaddeIcerik, selectedNode);
				   
				   List<TebligMaddeIcerik> children = new ArrayList<TebligMaddeIcerik>();
				   children.addAll(((TebligMaddeIcerik)selectedNode.getData()).getChildren());
				   
				   if(children.size()>0){
					   if(children.get(children.size()-1) != null){
						   tebligMaddeIcerik.setChildPosition((children.get(children.size()-1)).getChildPosition()+1);
					   }
				   }
				   else{
					   tebligMaddeIcerik.setChildPosition(0L);
				   }
				   //selectedNode.setExpanded(true);
			   }
			   
			   tebligMaddeIcerik.setTebligIcerik(tebligIcerikBean.getSelectedTebligIcerik());
			   		   
			  
			   getTebligMaddeIcerikService().addTebligMaddeIcerik(tebligMaddeIcerik);
			   
			   selectedTebligMaddeIcerik = null;
			   selectedNode=null;
			   
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		 
	 }
    
    
  
    public void onNodeSelect(NodeSelectEvent event) {
    	
    	//selectedKanunIcerik=new KanunIcerik();
    	
    	selectedTebligMaddeIcerik=(TebligMaddeIcerik)(getSelectedNode().getData()); 
    	
    	if(selectedTebligMaddeIcerik != null){
    		
    		
    	}
    	
    	selectedNode.setExpanded(true);
    	
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", event.getTreeNode().toString());
 
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public TebligMaddeIcerik getSelectedTebligMaddeIcerik() {
		return selectedTebligMaddeIcerik;
	}

	public void setSelectedTebligMaddeIcerik(TebligMaddeIcerik selectedTebligMaddeIcerik) {
		this.selectedTebligMaddeIcerik = selectedTebligMaddeIcerik;
	}
    
	public void updateTebligMaddeIcerik(){
    	if (selectedTebligMaddeIcerik != null) {
			 getTebligMaddeIcerikService().updateTebligMaddeIcerik(selectedTebligMaddeIcerik);
			
		 }
    }    

    public void deleteTebligMaddeIcerik() {
    	 if (selectedTebligMaddeIcerik != null) {
			 getTebligMaddeIcerikService().deleteTebligMaddeIcerik(selectedTebligMaddeIcerik);
			
		 }
    }
    
    

	public void showYeniMetinDialog(){
		if(selectedTebligMaddeIcerik == null){
    		FacesContext context = FacesContext.getCurrentInstance();            
            context.addMessage(null, new FacesMessage("Uyarı!",  "Lütfen alt metin eklenecek içeriği seçiniz!") );            
    	}
    	else if (selectedTebligMaddeIcerik != null) {
    		RequestContext.getCurrentInstance().execute("PF('dlgYeniMetin').show()");
    	}
	}
	
	public void showUpdateMIDialog(){
		if(selectedTebligMaddeIcerik == null){
    		FacesContext context = FacesContext.getCurrentInstance();            
            context.addMessage(null, new FacesMessage("Uyarı!",  "Lütfen düzenlenecek içeriği seçiniz!") );            
    	}
    	else if (selectedTebligMaddeIcerik != null) {
    		RequestContext.getCurrentInstance().execute("PF('dlgDuzenleMetin').show()");
    	}
	}
   
	public void onDragDrop(TreeDragDropEvent event) {
		TebligMaddeIcerik dragTebligMaddeIcerik = (TebligMaddeIcerik)event.getDragNode().getData();
		TebligMaddeIcerik dropTebligMaddeIcerik = (TebligMaddeIcerik)event.getDropNode().getData();    
		Long dropIndex = new Long(event.getDropIndex());		 
        Long oldIndex = dragTebligMaddeIcerik.getChildPosition();
        TebligMaddeIcerik oldParent = dragTebligMaddeIcerik.getTebligMaddeIcerik();
        
        if( oldParent.getTebligMaddeIcerikId().equals(dropTebligMaddeIcerik.getTebligMaddeIcerikId())) {
        	System.out.println("------------------parentler ayni");
        	Long index = 0L;
	        if(oldIndex > dropIndex){ //yukari tasinmissa
		        for(TebligMaddeIcerik child : dropTebligMaddeIcerik.getChildren()){
		        	if(index >= dropIndex && index < oldIndex){
		        		child.setChildPosition(child.getChildPosition()+1);
		        		getTebligMaddeIcerikService().updateTebligMaddeIcerik(child);
		        	}
		        	index++;
		        }
	        }
	        
	        else if(oldIndex < dropIndex){ //asagi tasinmissa
	        	 for(TebligMaddeIcerik child : dropTebligMaddeIcerik.getChildren()){
	 	        	if(index <= dropIndex && index > oldIndex){
	 	        		child.setChildPosition(child.getChildPosition()-1);
	 	        		getTebligMaddeIcerikService().updateTebligMaddeIcerik(child);
	 	        	}
	 	        	index++;
	 	        }
	        }
	        
	        dragTebligMaddeIcerik.setTebligMaddeIcerik(dropTebligMaddeIcerik);
	        dragTebligMaddeIcerik.setChildPosition(dropIndex);
    		getTebligMaddeIcerikService().updateTebligMaddeIcerik(dragTebligMaddeIcerik);
        }
        else if(! oldParent.getTebligMaddeIcerikId().equals(dropTebligMaddeIcerik.getTebligMaddeIcerikId())){
        	System.out.println("------------------parentler farkli");
        	//change old parent child positions
        	Long index = 0L;
        	for(TebligMaddeIcerik child : oldParent.getChildren()){
        		if(index >= oldIndex){
        			child.setChildPosition(child.getChildPosition()-1);
        			System.out.println("----------------eski parent in childi :"+child.getTebligMaddeIcerikMetin());
 	        		getTebligMaddeIcerikService().updateTebligMaddeIcerik(child);
 	        	}
 	        	index++;
        	}
        	//change new parent child positions
        	index = 0L;	    
        	for(TebligMaddeIcerik child : dropTebligMaddeIcerik.getChildren()){
	        	if(index >= dropIndex){
	        		if(child.getTebligMaddeIcerikId() != dragTebligMaddeIcerik.getTebligMaddeIcerikId()){
	        			child.setChildPosition(child.getChildPosition()+1);
	        			System.out.println("----------------yeni parent in childi :"+child.getTebligMaddeIcerikMetin());
		        		getTebligMaddeIcerikService().updateTebligMaddeIcerik(child);
	        		}	        		
	        	}
	        	index++;
	        }  
	        
	        dragTebligMaddeIcerik.setTebligMaddeIcerik(dropTebligMaddeIcerik);	        
	        dragTebligMaddeIcerik.setChildPosition(dropIndex);
	        getTebligMaddeIcerikService().updateTebligMaddeIcerik(dragTebligMaddeIcerik);
 	        
        }
       
    }
	
}
