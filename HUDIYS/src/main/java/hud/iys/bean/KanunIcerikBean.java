package hud.iys.bean;

import hud.iys.model.Dipnot;
import hud.iys.model.DipnotKI;
import hud.iys.model.DipnotMI;
import hud.iys.model.KanunIcerik;
import hud.iys.model.MaddeIcerik;
import hud.iys.model.Mevzuat;
import hud.iys.model.MevzuatSeti;
import hud.iys.service.IDipnotKIService;
import hud.iys.service.IDipnotMIService;
import hud.iys.service.IKanunIcerikService;
import hud.iys.service.IMaddeIcerikService;
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
	
	private TreeNode rootNode;
	private TreeNode selectedNode;
	
	private KanunIcerik selectedKanunIcerik;
	
	private String kanunIcerikNo;
	private String kanunIcerikAdi;
	private String kanunIcerikMetin;
	
	private String dipnotNo;
	private String dipnotMetin;
	
	@ManagedProperty(value="#{KanunIcerikService}")
	IKanunIcerikService kanunIcerikService;	
	
	
	@ManagedProperty(value="#{MaddeIcerikService}")
	IMaddeIcerikService maddeIcerikService;
	
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
	//root node of clicked node
	private TreeNode maddeIcerikRootNode; 
	
	
	
    @PostConstruct
    public void init() {
    	KanunIcerik root = getKanunIcerikService().getKanunIcerikById(getKanunBean().getSelectedKanun().getKanunIcerikRoot()); // instead get root object from database 
    	
		rootNode = newNodeWithChildren(root, null);
		kanunMetniRootNode = newFullNodeWithChildren(root, null);
		
		setSelectedKanunIcerik((KanunIcerik)rootNode.getData());
		
		if(getSelectedKanunIcerik() != null){
			MaddeIcerik rootMaddeIcerik = getMaddeIcerikService().getMaddeIcerikById(getSelectedKanunIcerik().getMaddeIcerikRoot()); // instead get root object from database 
			maddeIcerikRootNode = newNodeMIWithChildren(rootMaddeIcerik, null);
			maddeIcerikRootNode.setExpanded(true);
		}
		
		icerikRootNode = maddeIcerikRootNode;
       
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
    	
    	kanunMetniRootNode = newFullNodeWithChildren(root, null);
		icerikRootNode = kanunMetniRootNode;
		selectedKanunIcerik = root;
    }
   
	/**
     *  recursive function that returns a new node with its children
    */
   
    
    public TreeNode newNodeWithChildren(KanunIcerik ttParent, TreeNode parent){
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
    	 for (KanunIcerik tt : ttParent.getChildren()){        	  
              TreeNode newNode2= newNodeWithChildren(tt, newNode);              
         }
         return newNode;
    }
    
    public TreeNode newMaddeIcerikNodeWithChildren(MaddeIcerik ttParent, TreeNode parent){
    	
    	KanunMetin kanunMetin = new KanunMetin(ttParent.getMaddeIcerikAdi(),ttParent.getMaddeIcerikMetin());
    	kanunMetin.setType(2);
    	kanunMetin.setIcerikId(ttParent.getMaddeIcerikId());
        TreeNode newNode= new TreeNodeImpl(kanunMetin, parent);
        newNode.setExpanded(true);
        for (MaddeIcerik tt : ttParent.getChildren()){
             TreeNode newNode2= newMaddeIcerikNodeWithChildren(tt, newNode);
             newNode2.setExpanded(true
            		 );
        }
        return newNode;
    }
    
    public TreeNode newFullNodeWithChildren(KanunIcerik ttParent, TreeNode parent){
    	String metin = ttParent.getKanunIcerikAdi();
    	if(ttParent.getKanunIcerikMetin() != null) 
    		metin.concat(ttParent.getKanunIcerikMetin());
    	KanunMetin kanunMetin = new KanunMetin(ttParent.getKanunIcerikAdi(),metin);
    	kanunMetin.setType(1); // KanunIcerik
    	kanunMetin.setIcerikId(ttParent.getKanunIcerikId());
   	 	TreeNode newNode= new TreeNodeImpl(kanunMetin, parent);
   	 	newNode.setExpanded(true);
	   	MaddeIcerik rootMaddeIcerik = getMaddeIcerikService().getMaddeIcerikById(ttParent.getMaddeIcerikRoot()); // instead get root object from database
	   	if(rootMaddeIcerik !=null){
	   		for (MaddeIcerik mi : rootMaddeIcerik.getChildren()){
	         	  
	             TreeNode newMaddeIcerikNode= newMaddeIcerikNodeWithChildren(mi, newNode);
	             newMaddeIcerikNode.setExpanded(true);
	        }
	   		
	   		//TreeNode newMaddeIcerikNode = newMaddeIcerikNodeWithChildren(rootMaddeIcerik, newNode);
	   		//newMaddeIcerikNode.setExpanded(true);
		}
		
   	 	for (KanunIcerik tt : ttParent.getChildren()){
       	  
             TreeNode newNode2= newFullNodeWithChildren(tt, newNode);
             newNode2.setExpanded(true);
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
    
    

   


	public TreeNode getKanunMetniRootNode() {
		KanunIcerik root = getKanunIcerikService().getKanunIcerikById(getKanunBean().getSelectedKanun().getKanunIcerikRoot()); // instead get root object from database 
    	kanunMetniRootNode = newFullNodeWithChildren(root, null);
        
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
		this.setKanunIcerikNo(null);
		this.setKanunIcerikAdi("");
		this.setKanunIcerikMetin("");
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
				   children.addAll(((KanunIcerik)selectedNode.getData()).getChildren());
				   
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
	
		  showExpanded(rootNode);
		  newNode.setExpanded(true);
		  expand(newNode);
		  showExpanded(rootNode);
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
    		
    		ArrayList <Dipnot> dipnotlar = new ArrayList<Dipnot>();
    		for(DipnotKI dipnotKI : selectedKanunIcerik.getDipnotlar()){
    			Dipnot newDipnot = new Dipnot();
    			newDipnot.setDipnotId(dipnotKI.getDipnotKIId());
    			newDipnot.setDipnotNo(dipnotKI.getDipnotKIMetin());
    			newDipnot.setDipnotMetin(dipnotKI.getDipnotKIMetin());
    			dipnotlar.add(newDipnot);
    		}
    		
    		dipnotBean.setDipnotlar(dipnotlar);
    		
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
    
	public void onDragDrop(TreeDragDropEvent event) {
		KanunIcerik dragKanunIcerik = (KanunIcerik)event.getDragNode().getData();
		KanunIcerik dropKanunIcerik = (KanunIcerik)event.getDropNode().getData();    
		Long dropIndex = new Long(event.getDropIndex());		 
        Long oldIndex = dragKanunIcerik.getChildPosition();
        KanunIcerik oldParent = dragKanunIcerik.getKanunIcerik();
        
        if(oldParent.getKanunIcerikId() == dropKanunIcerik.getKanunIcerikId()) {
        
	        dragKanunIcerik.setKanunIcerik(dropKanunIcerik);
	        
	        dragKanunIcerik.setChildPosition(dropIndex);
	        getKanunIcerikService().updateKanunIcerik(dragKanunIcerik);
	        
	        Long index = 0L;
	        System.out.println("Old Parent : " + oldParent.getKanunIcerikAdi());
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
        }
        else if(oldParent.getKanunIcerikId() != dropKanunIcerik.getKanunIcerikId()){
        	
        	dragKanunIcerik.setKanunIcerik(dropKanunIcerik);	        
	        dragKanunIcerik.setChildPosition(dropIndex);
	        getKanunIcerikService().updateKanunIcerik(dragKanunIcerik);
	        
        	//change old parent child positions
        	Long index = 0L;
        	System.out.println("Old Parent : " + oldParent.getKanunIcerikAdi());
        	for(KanunIcerik child : oldParent.getChildren()){
        		
        		if(index >= oldIndex){
        			System.out.println("old Parent child : "+ child.getKanunIcerikAdi());
        			child.setChildPosition(child.getChildPosition()-1);
 	        		getKanunIcerikService().updateKanunIcerik(child);
 	        	}
 	        	index++;
        	}
        	//change new parent child positions
        	index = 0L;	    
        	System.out.println("New Parent : " + dropKanunIcerik.getKanunIcerikAdi());
	        for(KanunIcerik child : dropKanunIcerik.getChildren()){
	        	if(index >= dropIndex){
	        		if(child.getKanunIcerikId() != dragKanunIcerik.getKanunIcerikId()){
	        			System.out.println("new Parent child : "+ child.getKanunIcerikAdi());
	        			child.setChildPosition(child.getChildPosition()+1);
		        		getKanunIcerikService().updateKanunIcerik(child);
	        		}	        		
	        	}
	        	index++;
	        }        
 	        
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
		 System.out.println(((KanunIcerik)(root.getData())).getKanunIcerikAdi() + " is Expanded : " + root.isExpanded());
		 
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
