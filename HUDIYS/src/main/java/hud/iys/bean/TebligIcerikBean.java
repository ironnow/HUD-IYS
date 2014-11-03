package hud.iys.bean;

import hud.iys.model.DipnotKI;
import hud.iys.model.DipnotTI;
import hud.iys.model.KanunIcerik;
import hud.iys.model.MaddeIcerik;
import hud.iys.model.TebligIcerik;
import hud.iys.model.TebligMaddeIcerik;
import hud.iys.model.Mevzuat;
import hud.iys.model.MevzuatSeti;
import hud.iys.service.IDipnotKIService;
import hud.iys.service.IDipnotTIService;
import hud.iys.service.ITebligIcerikService;
import hud.iys.service.ITebligMaddeIcerikService;
import hud.iys.view.KanunMetin;
import hud.iys.view.TebligMetin;
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
import org.primefaces.event.TreeDragDropEvent;
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
	
	private String icerikNo;
	private String icerikAdi;
	private String icerikAyraci;
	private String icerikMetin;
	
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
	 
	private TreeNode tebligMetniRootNode;	
	private List<TebligMetin> tebligMetinleri;
	private Boolean readModeAcik;
	
	private TreeNode maddeIcerikRootNode; 
	
    @PostConstruct
    public void init() {
    	TebligIcerik root = getTebligIcerikService().getTebligIcerikById(getTebligBean().getSelectedTeblig().getTebligIcerikRoot()); // instead get root object from database 
        rootNode = newNodeWithChildren(root, null);
        setSelectedTebligIcerik((TebligIcerik)rootNode.getData());
        
        tebligMetinleri = new ArrayList<TebligMetin>();
        
        tebligMetniRootNode = newFullNodeWithChildren(root, null,tebligMetinleri);
        readModeAcik = true;

		if(getSelectedTebligIcerik() != null){
			TebligMaddeIcerik rootTebligMaddeIcerik = getTebligMaddeIcerikService().getTebligMaddeIcerikById(getSelectedTebligIcerik().getMaddeIcerikRoot()); // instead get root object from database 
			maddeIcerikRootNode = newNodeTMIWithChildren(rootTebligMaddeIcerik, null);
			maddeIcerikRootNode.setExpanded(true);
		}
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
		this.setIcerikNo(null);
		this.setIcerikAdi("");
		this.setIcerikAyraci("");
		this.setIcerikMetin("");
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
        
     
   
	
	
	

	public TreeNode getMaddeIcerikRootNode() {
		return maddeIcerikRootNode;
	}

	public void setMaddeIcerikRootNode(TreeNode maddeIcerikRootNode) {
		this.maddeIcerikRootNode = maddeIcerikRootNode;
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

	public String getIcerikAyraci() {
		return icerikAyraci;
	}

	public void setIcerikAyraci(String icerikAyraci) {
		this.icerikAyraci = icerikAyraci;
	}

	public String getIcerikMetin() {
		return icerikMetin;
	}

	public void setIcerikMetin(String icerikMetin) {
		this.icerikMetin = icerikMetin;
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
	
	

	public TreeNode getTebligMetniRootNode() {
		return tebligMetniRootNode;
	}

	public void setTebligMetniRootNode(TreeNode tebligMetniRootNode) {
		this.tebligMetniRootNode = tebligMetniRootNode;
	}

	public List<TebligMetin> getTebligMetinleri() {
		tebligMetinleri = new ArrayList<TebligMetin>();
		TebligIcerik root = getTebligIcerikService().getTebligIcerikById(getTebligBean().getSelectedTeblig().getTebligIcerikRoot()); // instead get root object from database 
        tebligMetniRootNode = newFullNodeWithChildren(root, null,tebligMetinleri);
		return tebligMetinleri;
	}

	public void setTebligMetinleri(List<TebligMetin> tebligMetinleri) {
		this.tebligMetinleri = tebligMetinleri;
	}
	
	

	public Boolean getReadModeAcik() {
		return readModeAcik;
	}

	public void setReadModeAcik(Boolean readModeAcik) {
		this.readModeAcik = readModeAcik;
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
			   tebligIcerik.setIcerikNo(getIcerikNo());
			   tebligIcerik.setIcerikAdi(getIcerikAdi());
			   tebligIcerik.setIcerikAyraci(getIcerikAyraci());
			   tebligIcerik.setIcerikMetin(getIcerikMetin());
			   
			   
			   TebligMaddeIcerik tebligMaddeIcerik = new TebligMaddeIcerik();
			   tebligMaddeIcerik.setTebligMaddeIcerik(null);
			   tebligMaddeIcerik.setTebligMaddeIcerikAdi(getIcerikAdi());
			   getTebligMaddeIcerikService().addTebligMaddeIcerik(tebligMaddeIcerik);
			   
			   tebligIcerik.setMaddeIcerikRoot(tebligMaddeIcerik.getTebligMaddeIcerikId());
			   
			  
			   
			   if(selectedNode == null){
				   tebligIcerik.setTebligIcerik(getTebligIcerikService().getTebligIcerikById(tebligBean.getSelectedTeblig().getTebligIcerikRoot()));
				   TreeNode newNode = new TreeNodeImpl(tebligIcerik, rootNode);
				   
				   List<TebligIcerik> children = new ArrayList<TebligIcerik>();
				   children.addAll((getTebligIcerikService().getTebligIcerikById(tebligBean.getSelectedTeblig().getTebligIcerikRoot())).getChildren());
				   
				   if(children.size()>0){
					   if(children.get(children.size()-1) != null){
						   tebligIcerik.setChildPosition((children.get(children.size()-1)).getChildPosition()+1);
					   }
				   }
				   else{
					   tebligIcerik.setChildPosition(0L);
				   }
				   
			   }
			   else {
				   tebligIcerik.setTebligIcerik((TebligIcerik)selectedNode.getData());
				   TreeNode newNode = new TreeNodeImpl(tebligIcerik, selectedNode);
				   				   
				   List<TebligIcerik> children = new ArrayList<TebligIcerik>();
				   children.addAll(((TebligIcerik)selectedNode.getData()).getChildren());
				   
				   if(children.size()>0){
					   if(children.get(children.size()-1) != null){
						   tebligIcerik.setChildPosition((children.get(children.size()-1)).getChildPosition()+1);
					   }
				   }
				   else{
					   tebligIcerik.setChildPosition(0L);
				   }
				   
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
    	
    	readModeAcik = false;
    	
    	selectedTebligIcerik=(TebligIcerik)(getSelectedNode().getData()); 
    	
    	if(getSelectedTebligIcerik() != null){
			TebligMaddeIcerik rootTebligMaddeIcerik = getTebligMaddeIcerikService().getTebligMaddeIcerikById(getSelectedTebligIcerik().getMaddeIcerikRoot()); // instead get root object from database 
			maddeIcerikRootNode = newNodeTMIWithChildren(rootTebligMaddeIcerik, null);
			maddeIcerikRootNode.setExpanded(true);
		}
    	
    	selectedNode.setExpanded(true);
    	
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
	 
	 
	 //okuma modu
	 public TreeNode newMaddeIcerikNodeWithChildren(TebligMaddeIcerik ttParent, TreeNode parent, List<TebligMetin> tebligMetinleri){
	    	
    	TebligMetin tebligMetin = new TebligMetin(ttParent.getTebligMaddeIcerikAdi(),ttParent.getTebligMaddeIcerikMetin());
    	tebligMetin.setType("metin");
    	tebligMetin.setIcerikId(ttParent.getTebligMaddeIcerikId());
    	tebligMetinleri.add(tebligMetin);
    	TreeNode newNode= new TreeNodeImpl(tebligMetin, parent);
        newNode.setExpanded(true);
        for (TebligMaddeIcerik tt : ttParent.getChildren()){
             TreeNode newNode2= newMaddeIcerikNodeWithChildren(tt, newNode,tebligMetinleri);
             newNode2.setExpanded(true);
        }
        return newNode;
    }

	 public TreeNode newFullNodeWithChildren(TebligIcerik ttParent, TreeNode parent, List<TebligMetin> tebligMetinleri){
	    	
    	TebligMetin tebligMetin = new TebligMetin(); 
    	
    	tebligMetin.setIcerikId(ttParent.getIcerikId());
    	
   	 	TreeNode newNode= new TreeNodeImpl(tebligMetin, parent);
   	 	newNode.setExpanded(true);
	   	TebligMaddeIcerik rootMaddeIcerik = getTebligMaddeIcerikService().getTebligMaddeIcerikById(ttParent.getMaddeIcerikRoot()); // instead get root object from database
	   	if(rootMaddeIcerik !=null){
	   		if((rootMaddeIcerik.getChildren()).size() > 0 ){
	   			tebligMetin.setType("madde");
	   			tebligMetin.setIcerikMetin(ttParent.getIcerikNo()+" - "+ttParent.getIcerikAdi());
	   		}
	   		else {
	   			tebligMetin.setType("baslik"); // KanunIcerik
	   			tebligMetin.setIcerikMetin(ttParent.getIcerikAdi());
	   		}
	   		
	   		tebligMetinleri.add(tebligMetin);
	   		
	   		if(ttParent.getIcerikMetin() != null && !(ttParent.getIcerikMetin().equals("")) ){
	   			TebligMetin tebligMetinMetin = new TebligMetin();
	   			tebligMetinMetin.setIcerikMetin(ttParent.getIcerikMetin());
	   			tebligMetinMetin.setType("metin");
	   			tebligMetinleri.add(tebligMetinMetin);
	   		}
	    		
	   		for (TebligMaddeIcerik mi : rootMaddeIcerik.getChildren()){
	         	  
	             TreeNode newMaddeIcerikNode= newMaddeIcerikNodeWithChildren(mi, newNode, tebligMetinleri);
	             newMaddeIcerikNode.setExpanded(true);
	        }
	   		
	   		//TreeNode newMaddeIcerikNode = newMaddeIcerikNodeWithChildren(rootMaddeIcerik, newNode);
	   		//newMaddeIcerikNode.setExpanded(true);
		}
	   
	   	
   	 	for (TebligIcerik tt : ttParent.getChildren()){
       	  
             TreeNode newNode2= newFullNodeWithChildren(tt, newNode,tebligMetinleri);
             newNode2.setExpanded(true);
        }
        return newNode;
    }
	 
	 public void openReadMode(){
		 readModeAcik = true;
	 }
	 
	 
	 public void onDragDrop(TreeDragDropEvent event) {
		TebligIcerik dragTebligIcerik = (TebligIcerik)event.getDragNode().getData();
		TebligIcerik dropTebligIcerik = (TebligIcerik)event.getDropNode().getData();    
		Long dropIndex = new Long(event.getDropIndex());		 
        Long oldIndex = dragTebligIcerik.getChildPosition();
        TebligIcerik oldParent = dragTebligIcerik.getTebligIcerik();
        
        if( oldParent.getIcerikId().equals(dropTebligIcerik.getIcerikId())) {
        	Long index = 0L;
	        if(oldIndex > dropIndex){ //yukari tasinmissa
		        for(TebligIcerik child : dropTebligIcerik.getChildren()){
		        	if(index >= dropIndex && index < oldIndex){
		        		child.setChildPosition(child.getChildPosition()+1);
		        		getTebligIcerikService().updateTebligIcerik(child);
		        	}
		        	index++;
		        }
	        }
	        
	        else if(oldIndex < dropIndex){ //asagi tasinmissa
	        	 for(TebligIcerik child : dropTebligIcerik.getChildren()){
	 	        	if(index <= dropIndex && index > oldIndex){
	 	        		child.setChildPosition(child.getChildPosition()-1);
	 	        		getTebligIcerikService().updateTebligIcerik(child);
	 	        	}
	 	        	index++;
	 	        }
	        }
	        
	        dragTebligIcerik.setTebligIcerik(dropTebligIcerik);
	        dragTebligIcerik.setChildPosition(dropIndex);
    		getTebligIcerikService().updateTebligIcerik(dragTebligIcerik);
        }
        else if(! oldParent.getIcerikId().equals(dropTebligIcerik.getIcerikId())){
        	//change old parent child positions
        	Long index = 0L;
        	for(TebligIcerik child : oldParent.getChildren()){
        		if(index >= oldIndex){
        			child.setChildPosition(child.getChildPosition()-1);
 	        		getTebligIcerikService().updateTebligIcerik(child);
 	        	}
 	        	index++;
        	}
        	//change new parent child positions
        	index = 0L;	    
        	for(TebligIcerik child : dropTebligIcerik.getChildren()){
	        	if(index >= dropIndex){
	        		if(child.getIcerikId() != dragTebligIcerik.getIcerikId()){
	        			child.setChildPosition(child.getChildPosition()+1);
		        		getTebligIcerikService().updateTebligIcerik(child);
	        		}	        		
	        	}
	        	index++;
	        }  
	        
	        dragTebligIcerik.setTebligIcerik(dropTebligIcerik);	        
	        dragTebligIcerik.setChildPosition(dropIndex);
	        getTebligIcerikService().updateTebligIcerik(dragTebligIcerik);
 	        
        }
    }
	 
	 public TreeNode newNodeTMIWithChildren(TebligMaddeIcerik ttParent, TreeNode parent){
         TreeNode newNode= new TreeNodeImpl(ttParent, parent);
         newNode.setExpanded(true);
         for (TebligMaddeIcerik tt : ttParent.getChildren()){
             TreeNode newNode2= newNodeTMIWithChildren(tt, newNode);
             newNode2.setExpanded(true);
         }
         return newNode;
     }
		
}
