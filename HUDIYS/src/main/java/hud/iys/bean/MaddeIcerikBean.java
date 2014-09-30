package hud.iys.bean;

import hud.iys.model.Dipnot;
import hud.iys.model.DipnotMI;
import hud.iys.model.KanunIcerik;
import hud.iys.model.MaddeIcerik;
import hud.iys.model.Mevzuat;
import hud.iys.model.MevzuatSeti;
import hud.iys.service.IDipnotMIService;
import hud.iys.service.IMaddeIcerikService;
import hud.iys.view.tree.TreeNodeImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.TreeDragDropEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.dao.DataAccessException;


@ManagedBean(eager=true,name="maddeIcerikMB")
@SessionScoped
public class MaddeIcerikBean implements Serializable {		
	
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";
	
	private TreeNode rootNode;
	private TreeNode selectedNode;
	
	private MaddeIcerik selectedMaddeIcerik;
	
	private String maddeIcerikAdi;
	private String maddeIcerikMetin;
	
	private String dipnotNo;
	private String dipnotMetin;
	
	@ManagedProperty(value="#{MaddeIcerikService}")
	IMaddeIcerikService maddeIcerikService;
	
	@ManagedProperty(value="#{DipnotMIService}")
	IDipnotMIService dipnotMIService;
	
	@ManagedProperty(value="#{kanunIcerikMB}")
	private KanunIcerikBean kanunIcerikBean;
	
	@ManagedProperty(value="#{dipnotMB}")
	private DipnotBean dipnotBean;
	
	
	@PostConstruct
    public void init() {
		
		if(getKanunIcerikBean().getSelectedKanunIcerik() != null){
			MaddeIcerik root = getMaddeIcerikService().getMaddeIcerikById(getKanunIcerikBean().getSelectedKanunIcerik().getMaddeIcerikRoot()); // instead get root object from database 
			rootNode = newNodeWithChildren(root, null);
			rootNode.setExpanded(true);
		}
       //rootNode = null;
    }
    
    public void reset() {
		 this.setMaddeIcerikAdi("");
		 this.setMaddeIcerikMetin("");
		 
	 }

    /**
     *  recursive function that returns a new node with its children
    */
    public TreeNode newNodeWithChildren(MaddeIcerik ttParent, TreeNode parent){
         TreeNode newNode= new TreeNodeImpl(ttParent, parent);
         newNode.setExpanded(true);
         for (MaddeIcerik tt : ttParent.getChildren()){
              TreeNode newNode2= newNodeWithChildren(tt, newNode);
              newNode2.setExpanded(true);
         }
         return newNode;
    }

    public TreeNode getRootNode() {   
    	if(getKanunIcerikBean().getSelectedKanunIcerik() != null){
    		MaddeIcerik root = getMaddeIcerikService().getMaddeIcerikById(getKanunIcerikBean().getSelectedKanunIcerik().getMaddeIcerikRoot()); // instead get root object from database 
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

	public IMaddeIcerikService getMaddeIcerikService() {
		return maddeIcerikService;
	}

	public void setMaddeIcerikService(IMaddeIcerikService maddeIcerikService) {
		this.maddeIcerikService = maddeIcerikService;
	}
    
	
    public IDipnotMIService getDipnotMIService() {
		return dipnotMIService;
	}

	public void setDipnotMIService(IDipnotMIService dipnotService) {
		this.dipnotMIService = dipnotService;
	}

	public TreeNode getSelectedNode() {
        return selectedNode;
    }
 
    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }
    
    
     
    public String getMaddeIcerikAdi() {
		return maddeIcerikAdi;
	}

	public void setMaddeIcerikAdi(String maddeIcerikAdi) {
		this.maddeIcerikAdi = maddeIcerikAdi;
	}
	
	public String getMaddeIcerikMetin() {
		return maddeIcerikMetin;
	}

	public void setMaddeIcerikMetin(String maddeIcerikMetin) {
		this.maddeIcerikMetin = maddeIcerikMetin;
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

	public KanunIcerikBean getKanunIcerikBean() {
		return kanunIcerikBean;
	}

	public void setKanunIcerikBean(KanunIcerikBean kanunIcerikBean) {
		this.kanunIcerikBean = kanunIcerikBean;
	}	

	public DipnotBean getDipnotBean() {
		return dipnotBean;
	}

	public void setDipnotBean(DipnotBean dipnotBean) {
		this.dipnotBean = dipnotBean;
	}

	public MaddeIcerik getSelectedMaddeIcerik() {
		return selectedMaddeIcerik;
	}

	public void setSelectedMaddeIcerik(MaddeIcerik selectedMaddeIcerik) {
		this.selectedMaddeIcerik = selectedMaddeIcerik;
	}
	
	public void displaySelectedSingle() {
        if(selectedNode != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", selectedNode.getData().toString());
 
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
 
    public void deleteNode() {
    	 
    	getMaddeIcerikService().deleteMaddeIcerik((MaddeIcerik)selectedNode.getData());
         
        selectedNode.getChildren().clear();
        selectedNode.getParent().getChildren().remove(selectedNode);
        selectedNode.setParent(null);
         
        selectedNode = null;       
    }
    
    public void addMaddeIcerik() {
		  try {
			   MaddeIcerik maddeIcerik = new MaddeIcerik();
			   maddeIcerik.setMaddeIcerikAdi(getMaddeIcerikAdi());
			   maddeIcerik.setMaddeIcerikMetin(getMaddeIcerikMetin());
			   
			   if(selectedMaddeIcerik == null){
				   maddeIcerik.setMaddeIcerik(getMaddeIcerikService().getMaddeIcerikById(kanunIcerikBean.getSelectedKanunIcerik().getMaddeIcerikRoot()));
				   

				   List<MaddeIcerik> children = new ArrayList<MaddeIcerik>();
				   children.addAll((getMaddeIcerikService().getMaddeIcerikById(kanunIcerikBean.getSelectedKanunIcerik().getMaddeIcerikRoot())).getChildren());
				   
				   if(children.size()>0){
					   if(children.get(children.size()-1) != null){
						   maddeIcerik.setChildPosition((children.get(children.size()-1)).getChildPosition()+1);
					   }
				   }
				   else{
					   maddeIcerik.setChildPosition(0L);
				   }
				   
				   TreeNode newNode = new TreeNodeImpl(maddeIcerik, rootNode);
				   
			   }
			   else {
				   maddeIcerik.setMaddeIcerik(selectedMaddeIcerik);
				   
				   List<MaddeIcerik> children = new ArrayList<MaddeIcerik>();
				   children.addAll(((MaddeIcerik)selectedNode.getData()).getChildren());
				   
				   if(children.size()>0){
					   if(children.get(children.size()-1) != null){
						   maddeIcerik.setChildPosition((children.get(children.size()-1)).getChildPosition()+1);
					   }
				   }
				   else{
					   maddeIcerik.setChildPosition(0L);
				   }
				   
				   TreeNode newNode = new TreeNodeImpl(maddeIcerik, selectedNode);
				   //selectedNode.setExpanded(true);
			   }
			   
			   maddeIcerik.setKanunIcerik(kanunIcerikBean.getSelectedKanunIcerik());
			   		   
			  
			   getMaddeIcerikService().addMaddeIcerik(maddeIcerik);
			   
			   selectedMaddeIcerik = null;
			   selectedNode=null;
			   
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		 
	 }
    
    public void updateMaddeIcerik(){
    	if (selectedMaddeIcerik != null) {
			 getMaddeIcerikService().updateMaddeIcerik(selectedMaddeIcerik);
			
		 }
    }    

    public void deleteMaddeIcerik() {
    	 if (selectedMaddeIcerik != null) {
			 getMaddeIcerikService().deleteMaddeIcerik(selectedMaddeIcerik);
			
		 }
    }
    
    public void addDipnot() {
		  try {
			   DipnotMI dipnotMI = new DipnotMI();
			   dipnotMI.setDipnotMINo(getDipnotNo());
			   dipnotMI.setDipnotMIMetin(getDipnotMetin());
			   
			   if(selectedMaddeIcerik == null){
				   dipnotMI.setMaddeIcerik(getMaddeIcerikService().getMaddeIcerikById(kanunIcerikBean.getSelectedKanunIcerik().getMaddeIcerikRoot()));
				  
				   
			   }
			   else {
				   dipnotMI.setMaddeIcerik(selectedMaddeIcerik);
				
			   }
			   
			   getDipnotMIService().addDipnot(dipnotMI);
			   
			   selectedMaddeIcerik = null;
			   
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }  
	
		 
	 }
  
    public void onNodeSelect(NodeSelectEvent event) {
    	
    	setSelectedMaddeIcerik((MaddeIcerik)(getSelectedNode().getData())); 
    	
    	if(selectedMaddeIcerik != null){
    		ArrayList <Dipnot> dipnotlar = new ArrayList<Dipnot>();
    		for(DipnotMI dipnotMI : selectedMaddeIcerik.getDipnotlar()){
    			Dipnot newDipnot = new Dipnot();
    			newDipnot.setDipnotId(dipnotMI.getDipnotMIId());
    			newDipnot.setDipnotNo(dipnotMI.getDipnotMIMetin());
    			newDipnot.setDipnotMetin(dipnotMI.getDipnotMIMetin());
    			dipnotlar.add(newDipnot);
    		}
    		
    		dipnotBean.setDipnotlar(dipnotlar);
    		
    	}
    	
    	selectedNode.setExpanded(true);
    	
    }

    public void onDragDrop(TreeDragDropEvent event) {
		MaddeIcerik dragMaddeIcerik = (MaddeIcerik)event.getDragNode().getData();
		MaddeIcerik dropMaddeIcerik = (MaddeIcerik)event.getDropNode().getData();    
		Long dropIndex = new Long(event.getDropIndex());		 
        Long oldIndex = dragMaddeIcerik.getChildPosition();
        MaddeIcerik oldParent = dragMaddeIcerik.getMaddeIcerik();
        
        if(oldParent.getMaddeIcerikId() == dropMaddeIcerik.getMaddeIcerikId()) {
        
	        dragMaddeIcerik.setMaddeIcerik(dropMaddeIcerik);
	        
	        dragMaddeIcerik.setChildPosition(dropIndex);
	        getMaddeIcerikService().updateMaddeIcerik(dragMaddeIcerik);
	        
	        Long index = 0L;
	        System.out.println("Old Parent : " + oldParent.getMaddeIcerikAdi());
	        if(oldIndex > dropIndex){ //yukari tasinmissa
		        for(MaddeIcerik child : dropMaddeIcerik.getChildren()){
		        	if(index >= dropIndex && index < oldIndex){
		        		child.setChildPosition(child.getChildPosition()+1);
		        		getMaddeIcerikService().updateMaddeIcerik(child);
		        	}
		        	index++;
		        }
	        }
	        else if(oldIndex < dropIndex){ //asagi tasinmissa
	        	 for(MaddeIcerik child : dropMaddeIcerik.getChildren()){
	 	        	if(index <= dropIndex && index > oldIndex){
	 	        		child.setChildPosition(child.getChildPosition()-1);
	 	        		getMaddeIcerikService().updateMaddeIcerik(child);
	 	        	}
	 	        	index++;
	 	        }
	        }
        }
        else if(oldParent.getMaddeIcerikId() != dropMaddeIcerik.getMaddeIcerikId()){
        	
        	dragMaddeIcerik.setMaddeIcerik(dropMaddeIcerik);	        
        	dragMaddeIcerik.setChildPosition(dropIndex);
	        getMaddeIcerikService().updateMaddeIcerik(dragMaddeIcerik);
	        
        	//change old parent child positions
        	Long index = 0L;
        	System.out.println("Old Parent : " + oldParent.getMaddeIcerikMetin());
        	for(MaddeIcerik child : oldParent.getChildren()){
        		
        		if(index >= oldIndex){
        			if(child.getMaddeIcerikId() != dragMaddeIcerik.getMaddeIcerikId()){
	        			System.out.println("old Parent child : "+ child.getMaddeIcerikMetin());
	        			child.setChildPosition(child.getChildPosition()-1);
	 	        		getMaddeIcerikService().updateMaddeIcerik(child);
        			}
 	        	}
 	        	index++;
        	}
        	//change new parent child positions
        	index = 0L;	    
        	System.out.println("New Parent : " + dropMaddeIcerik.getMaddeIcerikMetin());
	        for(MaddeIcerik child : dropMaddeIcerik.getChildren()){
	        	if(index >= dropIndex){
	        		if(child.getMaddeIcerikId() != dragMaddeIcerik.getMaddeIcerikId()){
	        			System.out.println("new Parent child : "+ child.getMaddeIcerikMetin());
	        			child.setChildPosition(child.getChildPosition()+1);
		        		getMaddeIcerikService().updateMaddeIcerik(child);
	        		}	        		
	        	}
	        	index++;
	        }        
 	        
        }
       
    }
	
	
    
    

}
