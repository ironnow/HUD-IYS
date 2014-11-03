package hud.iys.bean;

import hud.iys.model.Kanun;
import hud.iys.model.KanunIcerik;
import hud.iys.model.Link;
import hud.iys.model.Mevzuat;
import hud.iys.model.MevzuatIcerikEsleme;
import hud.iys.model.MevzuatIcerikTip;
import hud.iys.model.MevzuatSeti;
import hud.iys.model.Teblig;
import hud.iys.model.TebligIcerik;
import hud.iys.service.IKanunIcerikService;
import hud.iys.service.IKanunService;
import hud.iys.service.ILinkService;
import hud.iys.service.IMevzuatIcerikEslemeService;
import hud.iys.service.IMevzuatIcerikTipService;
import hud.iys.service.IMevzuatService;
import hud.iys.service.IMevzuatSetiService;
import hud.iys.service.ITebligIcerikService;
import hud.iys.service.ITebligService;
import hud.iys.view.Icerik;
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
	
	public final long kanunTipId = 1L;
	public final long kanunIcerikTipId = 2L;
	public final long kanunMaddeIcerikTipId = 3L;
	public final long tebligTipId = 4L;
	public final long tebligIcerikTipId = 5L;
	public final long tebligMaddeIcerikTipId = 6L;
	
	private MevzuatSeti mevzuatSeti; 
    private Mevzuat mevzuat;
    private MevzuatIcerikTip mevzuatIcerikTip;
    private Teblig teblig;
    
    private String mevzuatSetiId;
    private String mevzuatId;
    private String mevzuatIcerikTipId;
    private String tebligId;
    private String icerikId;
    
    private List<MevzuatSeti> mevzuatSetiList;
    private List<Mevzuat> mevzuatList;
    private List<MevzuatIcerikTip> mevzuatIcerikTipList;
    private List<Teblig> tebligList;
    private List<Icerik> icerikList;
    
    
    
    private Boolean renderLinkTree;
    private TreeNode rootNode;
	private TreeNode selectedNode;
    
    @ManagedProperty(value="#{MevzuatSetiService}")
	IMevzuatSetiService mevzuatSetiService;
    
    @ManagedProperty(value="#{MevzuatService}")
	IMevzuatService mevzuatService;
    
    @ManagedProperty(value="#{KanunService}")
   	IKanunService kanunService;
    
    @ManagedProperty(value="#{TebligService}")
   	ITebligService tebligService;
    
    @ManagedProperty(value="#{TebligIcerikService}")
   	ITebligIcerikService tebligIcerikService;
    
    @ManagedProperty(value="#{KanunIcerikService}")
   	IKanunIcerikService kanunIcerikService;
    
    @ManagedProperty(value="#{MevzuatIcerikTipService}")
   	IMevzuatIcerikTipService mevzuatIcerikTipService;
    
    @ManagedProperty(value="#{MevzuatIcerikEslemeService}")
   	IMevzuatIcerikEslemeService mevzuatIcerikEslemeService;
    
    @ManagedProperty(value="#{LinkService}")
   	ILinkService linkService;
    
    @ManagedProperty(value="#{kanunIcerikMB}")
	private KanunIcerikBean kanunIcerikBean;
    
    @ManagedProperty(value="#{maddeIcerikMB}")
	private MaddeIcerikBean maddeIcerikBean;
     
    @PostConstruct
    public void init() {
    	mevzuatSetiList = new ArrayList<MevzuatSeti>();
    	mevzuatSetiList.addAll(getMevzuatSetiService().getMevzuatSetleri());
    	renderLinkTree = true;
        
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

	public String getIcerikId() {
		return icerikId;
	}
	public void setIcerikId(String icerikId) {
		this.icerikId = icerikId;
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

	public List<Icerik> getIcerikList() {
		return icerikList;
	}
	public void setIcerikList(List<Icerik> icerikList) {
		this.icerikList = icerikList;
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

	public List<MevzuatIcerikTip> getMevzuatIcerikTipList() {
		return mevzuatIcerikTipList;
	}
	public void setMevzuatIcerikTipList(
			List<MevzuatIcerikTip> mevzuatIcerikTipList) {
		this.mevzuatIcerikTipList = mevzuatIcerikTipList;
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

	public IKanunIcerikService getKanunIcerikService() {
		return kanunIcerikService;
	}


	public void setKanunIcerikService(IKanunIcerikService kanunIcerikService) {
		this.kanunIcerikService = kanunIcerikService;
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

	
	public MaddeIcerikBean getMaddeIcerikBean() {
		return maddeIcerikBean;
	}


	public void setMaddeIcerikBean(MaddeIcerikBean maddeIcerikBean) {
		this.maddeIcerikBean = maddeIcerikBean;
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
		System.out.println("------------- mevzuat change event-------------------");
		if (mevzuatId !=null && !mevzuatId.equals("")) {
			mevzuatIcerikTipList = new ArrayList<MevzuatIcerikTip>();
			mevzuatIcerikTipList.addAll(getMevzuatIcerikTipService().getMevzuatIcerikTipleri());
			
		}      
    }
	
	public void onMevzuatIcerikTipChange() {
		System.out.println("------------- mevzuat icerik tip change event-------------------");
		if (mevzuatIcerikTipId !=null && !mevzuatIcerikTipId.equals("")) {
			String icerikTipAdi = (getMevzuatIcerikTipService().getMevzuatIcerikTipById(Long.parseLong(mevzuatIcerikTipId))).getMevzuatIcerikTipAdi();
			if (icerikTipAdi !=null && !icerikTipAdi.equals("")) {
				if(icerikTipAdi.equals("Kanunlar")){
					icerikList = new ArrayList<Icerik>();
					List<Kanun> kanunList = new ArrayList<Kanun>();
					kanunList = getKanunService().getKanunlarByMevzuatId(Long.parseLong(mevzuatId));
					for(Kanun kanun : kanunList){
						Icerik icerik = new Icerik();
						icerik.setIcerikId(kanun.getKanunId());
						icerik.setIcerikAdi(kanun.getKanunAdi());
						icerik.setIcerikNo(kanun.getKanunNo());
						icerik.setMevzuat(kanun.getMevzuat());
						icerik.setDurumId(kanun.getDurumId());
						icerik.setIcerikRoot(kanun.getKanunIcerikRoot());
						icerik.setRGNo(kanun.getRGNo());
						icerik.setRGTarihi(kanun.getRGTarihi());
						
						icerikList.add(icerik);
					}
				}
				else if(icerikTipAdi.equals("Tebligler")){
					icerikList = new ArrayList<Icerik>();
					List<Teblig> tebligList = new ArrayList<Teblig>();
					tebligList = getTebligService().getTebliglerByMevzuatId(Long.parseLong(mevzuatId));
					for(Teblig teblig : tebligList){
						Icerik icerik = new Icerik();
						icerik.setIcerikId(teblig.getTebligId());
						icerik.setIcerikAdi(teblig.getTebligAdi());
						icerik.setIcerikNo(teblig.getTebligNo());
						icerik.setMevzuat(teblig.getMevzuat());
						icerik.setDurumId(teblig.getDurumId());
						icerik.setIcerikRoot(teblig.getTebligIcerikRoot());
						icerik.setRGNo(teblig.getRGNo());
						icerik.setRGTarihi(teblig.getRGTarihi());
						
						icerikList.add(icerik);
					}
				}
				else if(icerikTipAdi.equals("Yonetmelikler")){
					icerikList = new ArrayList<Icerik>();
				}
				else if(icerikTipAdi.equals("Tuzukler")){
					icerikList = new ArrayList<Icerik>();
				}
				
			}
						
		}   
	}
	
	public void onIcerikChange() {
		System.out.println("------------- icerik change event-------------------");
		if (icerikId !=null && !icerikId.equals("")) {
			System.out.println(icerikId);
			
		}      
    }
	
	
	//Link Tree 
	
	public TreeNode newKanunNodeWithChildren(KanunIcerik ttParent, TreeNode parent){
   	 TreeNode newNode= new TreeNodeImpl(ttParent, parent);
   	 for (KanunIcerik tt : ttParent.getChildren()){
       	  
             TreeNode newNode2= newKanunNodeWithChildren(tt, newNode);
             
        }
        return newNode;
    }
	

	public TreeNode newTebligNodeWithChildren(TebligIcerik ttParent, TreeNode parent){
   	 TreeNode newNode= new TreeNodeImpl(ttParent, parent);
   	 for (TebligIcerik tt : ttParent.getChildren()){
       	  
             TreeNode newNode2= newTebligNodeWithChildren(tt, newNode);
             
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
		if (icerikId !=null && !icerikId.equals("")) {
		
			if (mevzuatIcerikTipId !=null && !mevzuatIcerikTipId.equals("")) {
				String icerikTipAdi = (getMevzuatIcerikTipService().getMevzuatIcerikTipById(Long.parseLong(mevzuatIcerikTipId))).getMevzuatIcerikTipAdi();
				if (icerikTipAdi !=null && !icerikTipAdi.equals("")) {
					if(icerikTipAdi.equals("Kanunlar")){
						KanunIcerik root = getKanunIcerikService().getKanunIcerikById(getKanunService().getKanunById(Long.parseLong(icerikId)).getKanunIcerikRoot()); // instead get root object from database 
				        rootNode = newKanunNodeWithChildren(root, null);
						
					}
					else if(icerikTipAdi.equals("Tebligler")){
						TebligIcerik root = getTebligIcerikService().getTebligIcerikById(getTebligService().getTebligById(Long.parseLong(icerikId)).getTebligIcerikRoot()); // instead get root object from database 
				        rootNode = newTebligNodeWithChildren(root, null);
						
					}
					else if(icerikTipAdi.equals("Yonetmelikler")){
						
					}
					else if(icerikTipAdi.equals("Tuzukler")){
						
					}
					
				}
			
			}
			
		}
		else rootNode = null;
	}

    
    //link Olusturma
    
    public void createKILink(){       	
    	
    	Link newLink = new Link();
    	newLink.setFromId(getKanunIcerikBean().getSelectedKanunIcerik().getIcerikId());
    	newLink.setFromTypeId(kanunIcerikTipId);
    	if(icerikId !=null && !icerikId.equals("")){   
    		
        	if (mevzuatIcerikTipId !=null && !mevzuatIcerikTipId.equals("")) {
				String icerikTipAdi = (getMevzuatIcerikTipService().getMevzuatIcerikTipById(Long.parseLong(mevzuatIcerikTipId))).getMevzuatIcerikTipAdi();
				if (icerikTipAdi !=null && !icerikTipAdi.equals("")) {
					if(icerikTipAdi.equals("Kanunlar")){
						if(selectedNode == null){
							newLink.setToTypeId(kanunTipId);
							newLink.setToId(Long.parseLong(icerikId));
						}
						else if(selectedNode != null){
							newLink.setToTypeId(kanunIcerikTipId);
							newLink.setToId(((KanunIcerik)selectedNode.getData()).getIcerikId());	
						}
					}
					else if(icerikTipAdi.equals("Tebligler")){
						if(selectedNode == null){
							newLink.setToTypeId(tebligTipId);
							newLink.setToId(Long.parseLong(icerikId));
						}
						else if(selectedNode != null){
							newLink.setToTypeId(tebligIcerikTipId);
							newLink.setToId(((TebligIcerik)selectedNode.getData()).getIcerikId());	
						}
					}
					else if(icerikTipAdi.equals("Yonetmelikler")){						
					}
					else if(icerikTipAdi.equals("Tuzukler")){						
					}					
				}			
			}
        	
    	}
    	getLinkService().addLink(newLink);
    	
    	
    	
    	if(getKanunIcerikBean().getSelectedKanunIcerik() != null){
    		List<Kanun> ilgiliKanunList = new ArrayList<Kanun>();	 
	    	List<KanunIcerik> ilgiliKanunIcerikList = new ArrayList<KanunIcerik>();	 
	    	List<Teblig> ilgiliTebligList = new ArrayList<Teblig>();
	    	List<TebligIcerik> ilgiliTebligIcerikList = new ArrayList<TebligIcerik>();
	    	
			List<Link> linkList = getLinkService().getLinklerByFromId(getKanunIcerikBean().getSelectedKanunIcerik().getIcerikId());
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
			getKanunIcerikBean().setIlgiliKanunList(ilgiliKanunList);
			getKanunIcerikBean().setIlgiliKanunIcerikList(ilgiliKanunIcerikList);
			getKanunIcerikBean().setIlgiliTebligList(ilgiliTebligList);
			getKanunIcerikBean().setIlgiliTebligIcerikList(ilgiliTebligIcerikList);
    	}
    	
    		setMevzuatSetiId(null);
    		setMevzuatId(null);
    		setMevzuatIcerikTipId(null);
    		setIcerikId(null);
    		setSelectedNode(null);
    		setRootNode(null);
    	
    }
    
    //KanunMaddeIcerik Link
    public void createKMILink(){   
    	Link newLink = new Link();
    	newLink.setFromId(getMaddeIcerikBean().getSelectedMaddeIcerik().getMaddeIcerikId());
    	newLink.setFromTypeId(kanunMaddeIcerikTipId);
    	if(icerikId !=null && !icerikId.equals("")){   
    		
        	if (mevzuatIcerikTipId !=null && !mevzuatIcerikTipId.equals("")) {
				String icerikTipAdi = (getMevzuatIcerikTipService().getMevzuatIcerikTipById(Long.parseLong(mevzuatIcerikTipId))).getMevzuatIcerikTipAdi();
				if (icerikTipAdi !=null && !icerikTipAdi.equals("")) {
					if(icerikTipAdi.equals("Kanunlar")){
						if(selectedNode == null){
							newLink.setToTypeId(kanunTipId);
							newLink.setToId(Long.parseLong(icerikId));
						}
						else if(selectedNode != null){
							newLink.setToTypeId(kanunIcerikTipId);
							newLink.setToId(((KanunIcerik)selectedNode.getData()).getIcerikId());	
						}
					}
					else if(icerikTipAdi.equals("Tebligler")){
						if(selectedNode == null){
							newLink.setToTypeId(tebligTipId);
							newLink.setToId(Long.parseLong(icerikId));
						}
						else if(selectedNode != null){
							newLink.setToTypeId(tebligIcerikTipId);
							newLink.setToId(((TebligIcerik)selectedNode.getData()).getIcerikId());	
						}
					}
					else if(icerikTipAdi.equals("Yonetmelikler")){						
					}
					else if(icerikTipAdi.equals("Tuzukler")){						
					}					
				}			
			}
        	
    	}
    	getLinkService().addLink(newLink);
      	
    	if(getMaddeIcerikBean().getSelectedMaddeIcerik() != null){
    		List<Kanun> ilgiliKanunList = new ArrayList<Kanun>();	 
	    	List<KanunIcerik> ilgiliKanunIcerikList = new ArrayList<KanunIcerik>();	 
	    	List<Teblig> ilgiliTebligList = new ArrayList<Teblig>();
	    	List<TebligIcerik> ilgiliTebligIcerikList = new ArrayList<TebligIcerik>();
	    	
			List<Link> linkList = getLinkService().getLinklerByFromId(getMaddeIcerikBean().getSelectedMaddeIcerik().getMaddeIcerikId());
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
			getMaddeIcerikBean().setIlgiliKanunList(ilgiliKanunList);
			getMaddeIcerikBean().setIlgiliKanunIcerikList(ilgiliKanunIcerikList);
			getMaddeIcerikBean().setIlgiliTebligList(ilgiliTebligList);
			getMaddeIcerikBean().setIlgiliTebligIcerikList(ilgiliTebligIcerikList);
    	}
    	
		setMevzuatSetiId(null);
		setMevzuatId(null);
		setMevzuatIcerikTipId(null);
		setIcerikId(null);
		setSelectedNode(null);
		setRootNode(null);
    }
    
    public void reset() {
		this.mevzuatId=null;
		this.mevzuatSetiId=null;
		this.tebligId=null;
		rootNode = null;
		
	}
    
    public void onNodeSelect(NodeSelectEvent event) {
    	if(selectedNode != null){
    		System.out.println("Selected Node : " + ((TebligIcerik)selectedNode.getData()).getIcerikAdi());
    	}
    }

}