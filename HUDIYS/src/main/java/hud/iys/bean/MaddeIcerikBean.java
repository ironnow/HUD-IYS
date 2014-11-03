package hud.iys.bean;

import hud.iys.model.Attachment;
import hud.iys.model.Dipnot;
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
import hud.iys.service.IAttachmentService;
import hud.iys.service.IDipnotMIService;
import hud.iys.service.IKanunIcerikService;
import hud.iys.service.IKanunService;
import hud.iys.service.ILinkService;
import hud.iys.service.IMaddeIcerikService;
import hud.iys.service.ITebligIcerikService;
import hud.iys.service.ITebligMaddeIcerikService;
import hud.iys.service.ITebligService;
import hud.iys.view.tree.TreeNodeImpl;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.TreeDragDropEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.primefaces.model.UploadedFile;
import org.springframework.dao.DataAccessException;


@ManagedBean(eager=true,name="maddeIcerikMB")
@SessionScoped
public class MaddeIcerikBean implements Serializable {		
	
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
	private TreeNode selectedNode;
	
	private MaddeIcerik selectedMaddeIcerik;
	
	private String maddeIcerikAdi;
	private String maddeIcerikMetin;
	
	private String dipnotNo;
	private String dipnotMetin;
	
	private UploadedFile file;
	private List<Attachment> attachmentList;
	
	@ManagedProperty(value="#{DipnotMIService}")
	IDipnotMIService dipnotMIService;
	
	@ManagedProperty(value="#{kanunIcerikMB}")
	private KanunIcerikBean kanunIcerikBean;
	
	@ManagedProperty(value="#{dipnotMB}")
	private DipnotBean dipnotBean;
	
	@ManagedProperty(value="#{AttachmentService}")
	IAttachmentService attachmentService;
	
	@ManagedProperty(value="#{KanunService}")
	IKanunService kanunService;	
	
	@ManagedProperty(value="#{KanunIcerikService}")
	IKanunIcerikService kanunIcerikService;	
	
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
	
	private List<Kanun> ilgiliKanunList;
	private List<KanunIcerik> ilgiliKanunIcerikList;
	private List<Teblig> ilgiliTebligList;
    private List<TebligIcerik> ilgiliTebligIcerikList;
    
    private KanunIcerik selectedIlgiliKanunIcerik;
    private TreeNode rootNodeRelatedMIMI;
    
    private KanunIcerik selectedIlgiliTebligIcerik;
    private TreeNode rootNodeRelatedMITMI;
	
	@PostConstruct
    public void init() {
		
		if(getKanunIcerikBean().getSelectedKanunIcerik() != null){
			MaddeIcerik root = getMaddeIcerikService().getMaddeIcerikById(getKanunIcerikBean().getSelectedKanunIcerik().getMaddeIcerikRoot()); // instead get root object from database 
			rootNode = newNodeWithChildren(root, null);
			rootNode.setExpanded(true);
		}
		
		if(getSelectedIlgiliKanunIcerik() != null){
			MaddeIcerik rootKIMI = getMaddeIcerikService().getMaddeIcerikById(getSelectedIlgiliKanunIcerik().getMaddeIcerikRoot()); // instead get root object from database 
			rootNodeRelatedMIMI = newNodeWithChildren(rootKIMI, null);
			rootNodeRelatedMIMI.setExpanded(true);
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
	
	
	
	public List<Kanun> getIlgiliKanunList() {
		return ilgiliKanunList;
	}

	public void setIlgiliKanunList(List<Kanun> ilgiliKanunList) {
		this.ilgiliKanunList = ilgiliKanunList;
	}

	public List<KanunIcerik> getIlgiliKanunIcerikList() {
		return ilgiliKanunIcerikList;
	}

	public void setIlgiliKanunIcerikList(List<KanunIcerik> ilgiliKanunIcerikList) {
		this.ilgiliKanunIcerikList = ilgiliKanunIcerikList;
	}

	public List<Teblig> getIlgiliTebligList() {
		return ilgiliTebligList;
	}

	public void setIlgiliTebligList(List<Teblig> ilgiliTebligList) {
		this.ilgiliTebligList = ilgiliTebligList;
	}

	public List<TebligIcerik> getIlgiliTebligIcerikList() {
		return ilgiliTebligIcerikList;
	}

	public void setIlgiliTebligIcerikList(List<TebligIcerik> ilgiliTebligIcerikList) {
		this.ilgiliTebligIcerikList = ilgiliTebligIcerikList;
	}

	
	
	public KanunIcerik getSelectedIlgiliKanunIcerik() {
		return selectedIlgiliKanunIcerik;
	}

	public void setSelectedIlgiliKanunIcerik(KanunIcerik selectedIlgiliKanunIcerik) {
		this.selectedIlgiliKanunIcerik = selectedIlgiliKanunIcerik;
	}

	
	
	public ITebligMaddeIcerikService getTebligMaddeIcerikService() {
		return tebligMaddeIcerikService;
	}

	public void setTebligMaddeIcerikService(
			ITebligMaddeIcerikService tebligMaddeIcerikService) {
		this.tebligMaddeIcerikService = tebligMaddeIcerikService;
	}

	public void setIlgiliMIMI(){
		if(getSelectedIlgiliKanunIcerik() != null){
			MaddeIcerik root = getMaddeIcerikService().getMaddeIcerikById(getSelectedIlgiliKanunIcerik().getMaddeIcerikRoot()); // instead get root object from database 
			rootNodeRelatedMIMI = newNodeWithChildren(root, null);
			rootNodeRelatedMIMI.setExpanded(true);
		}
	}

	public void setIlgiliMITMI(){
		if(getSelectedIlgiliTebligIcerik() != null){
			TebligMaddeIcerik root = getTebligMaddeIcerikService().getTebligMaddeIcerikById(getSelectedIlgiliTebligIcerik().getMaddeIcerikRoot()); // instead get root object from database 
			rootNodeRelatedMITMI = newNodeWithChildren(root, null);
			rootNodeRelatedMITMI.setExpanded(true);
		}
	}
	
	public TreeNode getRootNodeRelatedMIMI() {
		if(getSelectedIlgiliKanunIcerik() != null){
			MaddeIcerik root = getMaddeIcerikService().getMaddeIcerikById(getSelectedIlgiliKanunIcerik().getMaddeIcerikRoot()); // instead get root object from database 
			rootNodeRelatedMIMI = newNodeWithChildren(root, null);
			rootNodeRelatedMIMI.setExpanded(true);
		}
		return rootNodeRelatedMIMI;
	}

	public void setRootNodeRelatedMIMI(TreeNode rootNodeRelatedMIMI) {
		this.rootNodeRelatedMIMI = rootNodeRelatedMIMI;
	}

	public KanunIcerik getSelectedIlgiliTebligIcerik() {
		return selectedIlgiliTebligIcerik;
	}

	public void setSelectedIlgiliTebligIcerik(KanunIcerik selectedIlgiliTebligIcerik) {
		this.selectedIlgiliTebligIcerik = selectedIlgiliTebligIcerik;
	}

	public TreeNode getRootNodeRelatedMITMI() {
		if(getSelectedIlgiliTebligIcerik() != null){
			TebligMaddeIcerik root = getTebligMaddeIcerikService().getTebligMaddeIcerikById(getSelectedIlgiliTebligIcerik().getMaddeIcerikRoot()); // instead get root object from database 
			rootNodeRelatedMITMI = newNodeWithChildren(root, null);
			rootNodeRelatedMITMI.setExpanded(true);
		}
		return rootNodeRelatedMITMI;
	}

	public void setRootNodeRelatedMITMI(TreeNode rootNodeRelatedMITMI) {
		this.rootNodeRelatedMITMI = rootNodeRelatedMITMI;
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
	
	

	public List<Attachment> getAttachmentList() {
		attachmentList = new ArrayList<Attachment>();
		if(selectedMaddeIcerik != null){			
			if(getAttachmentService().getAttachmentlarByTypeAndFromId(3, selectedMaddeIcerik.getMaddeIcerikId()) != null){
				attachmentList.addAll(getAttachmentService().getAttachmentlarByTypeAndFromId(3, selectedMaddeIcerik.getMaddeIcerikId()));
			}			
		}
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public IKanunIcerikService getKanunIcerikService() {
		return kanunIcerikService;
	}

	public void setKanunIcerikService(IKanunIcerikService kanunIcerikService) {
		this.kanunIcerikService = kanunIcerikService;
	}

	
	public IAttachmentService getAttachmentService() {
		return attachmentService;
	}

	public void setAttachmentService(IAttachmentService attachmentService) {
		this.attachmentService = attachmentService;
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
    	if(selectedMaddeIcerik == null){
    		FacesContext context = FacesContext.getCurrentInstance();            
            context.addMessage(null, new FacesMessage("Uyarı!",  "Lütfen silinecek içeriği seçiniz!") );            
    	}
    	else if (selectedMaddeIcerik != null) {
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
    	
    	
    	getKanunIcerikBean().setIlgiliKanunList(null);
		getKanunIcerikBean().setIlgiliKanunIcerikList(null);
		getKanunIcerikBean().setIlgiliTebligList(null);
		getKanunIcerikBean().setIlgiliTebligIcerikList(null);

		ilgiliKanunList = new ArrayList<Kanun>();
		ilgiliKanunIcerikList = new ArrayList<KanunIcerik>();
		ilgiliTebligList = new ArrayList<Teblig>();
		ilgiliTebligIcerikList = new ArrayList<TebligIcerik>();
		List<Link> linkList = getLinkService().getLinklerByFromId(selectedMaddeIcerik.getMaddeIcerikId());
		
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
    	
    }

    public void onDragDrop(TreeDragDropEvent event) {
		MaddeIcerik dragMaddeIcerik = (MaddeIcerik)event.getDragNode().getData();
		MaddeIcerik dropMaddeIcerik = (MaddeIcerik)event.getDropNode().getData();    
		Long dropIndex = new Long(event.getDropIndex());		 
        Long oldIndex = dragMaddeIcerik.getChildPosition();
        MaddeIcerik oldParent = dragMaddeIcerik.getMaddeIcerik();
        
        if( oldParent.getMaddeIcerikId().equals(dropMaddeIcerik.getMaddeIcerikId())) {
        	System.out.println("------------------parentler ayni");
        	Long index = 0L;
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
	        
	        dragMaddeIcerik.setMaddeIcerik(dropMaddeIcerik);
	        dragMaddeIcerik.setChildPosition(dropIndex);
    		getMaddeIcerikService().updateMaddeIcerik(dragMaddeIcerik);
        }
        else if(! oldParent.getMaddeIcerikId().equals(dropMaddeIcerik.getMaddeIcerikId())){
        	System.out.println("------------------parentler farkli");
        	//change old parent child positions
        	Long index = 0L;
        	for(MaddeIcerik child : oldParent.getChildren()){
        		if(index >= oldIndex){
        			child.setChildPosition(child.getChildPosition()-1);
        			System.out.println("----------------eski parent in childi :"+child.getMaddeIcerikMetin());
 	        		getMaddeIcerikService().updateMaddeIcerik(child);
 	        	}
 	        	index++;
        	}
        	//change new parent child positions
        	index = 0L;	    
        	for(MaddeIcerik child : dropMaddeIcerik.getChildren()){
	        	if(index >= dropIndex){
	        		if(child.getMaddeIcerikId() != dragMaddeIcerik.getMaddeIcerikId()){
	        			child.setChildPosition(child.getChildPosition()+1);
	        			System.out.println("----------------yeni parent in childi :"+child.getMaddeIcerikMetin());
		        		getMaddeIcerikService().updateMaddeIcerik(child);
	        		}	        		
	        	}
	        	index++;
	        }  
	        
	        dragMaddeIcerik.setMaddeIcerik(dropMaddeIcerik);	        
	        dragMaddeIcerik.setChildPosition(dropIndex);
	        getMaddeIcerikService().updateMaddeIcerik(dragMaddeIcerik);
 	        
        }
       
    }
	
	public void showYeniMetinDialog(){
		if(selectedMaddeIcerik == null){
    		FacesContext context = FacesContext.getCurrentInstance();            
            context.addMessage(null, new FacesMessage("Uyarı!",  "Lütfen alt metin eklenecek içeriği seçiniz!") );            
    	}
    	else if (selectedMaddeIcerik != null) {
    		RequestContext.getCurrentInstance().execute("PF('dlgYeniMetin').show()");
    	}
	}
    
	public void showLinkMIDialog(){
		if(selectedMaddeIcerik == null){
    		FacesContext context = FacesContext.getCurrentInstance();            
            context.addMessage(null, new FacesMessage("Uyarı!",  "Lütfen ilişkilendirilecek içeriği seçiniz!") );            
    	}
    	else if (selectedMaddeIcerik != null) {
    		RequestContext.getCurrentInstance().execute("PF('dlgLinkMI').show()");
    	}
	}
	
	public void showDipnotMIDialog(){
		if(selectedMaddeIcerik == null){
    		FacesContext context = FacesContext.getCurrentInstance();            
            context.addMessage(null, new FacesMessage("Uyarı!",  "Lütfen dipnot eklenecek içeriği seçiniz!") );            
    	}
    	else if (selectedMaddeIcerik != null) {
    		RequestContext.getCurrentInstance().execute("PF('dlgDipnotMI').show()");
    	}
	}

	public void showAttachmentDialog(){
		if(selectedMaddeIcerik == null){
    		FacesContext context = FacesContext.getCurrentInstance();            
            context.addMessage(null, new FacesMessage("Uyarı!",  "Lütfen dosya eklenecek içeriği seçiniz!") );            
    	}
    	else if (selectedMaddeIcerik != null) {
    		RequestContext.getCurrentInstance().execute("PF('dlgAttachment').show()");
    	}
	}
	
	public void showUpdateMIDialog(){
		if(selectedMaddeIcerik == null){
    		FacesContext context = FacesContext.getCurrentInstance();            
            context.addMessage(null, new FacesMessage("Uyarı!",  "Lütfen düzenlenecek içeriği seçiniz!") );            
    	}
    	else if (selectedMaddeIcerik != null) {
    		RequestContext.getCurrentInstance().execute("PF('dlgDuzenleMetin').show()");
    	}
	}
	
	
	public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
    	this.file = file;
    }
     
    public void addAttachment(FileUploadEvent event) throws IOException {
    	
    	file = event.getFile();         
          
        byte[] fileContent = IOUtils.toByteArray(file.getInputstream());         
          
        if(file != null) {
            FacesMessage message = new FacesMessage("Başarılı", file.getFileName() + " sisteme yüklendi.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            if(selectedMaddeIcerik != null) {
            	Attachment newAttachment = new Attachment();
            	newAttachment.setAttachmentAdi(file.getFileName());
            	newAttachment.setFromTypeId(3);
            	newAttachment.setFromId(selectedMaddeIcerik.getMaddeIcerikId());
            	newAttachment.setContent(fileContent);
            	
            	
            	getAttachmentService().addAttachment(newAttachment);
            	
            }             
        }
       
    }
}
