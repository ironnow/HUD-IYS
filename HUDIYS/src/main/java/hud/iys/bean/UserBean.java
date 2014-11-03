package hud.iys.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import hud.iys.model.User;
import hud.iys.service.IUserService;
import hud.iys.util.SifreUtility;

import org.primefaces.context.RequestContext;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 29, 2014 @time 4:00:58 PM
 *
 */
@ManagedBean(name = "userMB")
@SessionScoped
public class UserBean implements Serializable
{

   private static final long serialVersionUID = 1L;
   private static final String SUCCESS = "success";
   private static final String ERROR = "error";

   @ManagedProperty(value = "#{UserService}")
   private IUserService userService;

   private String tcNo;
   private String unvan;
   private String ad;
   private String soyad;
   private String gsmNo;
   private String telefon;
   private String eMail;
   private String kullaniciAdi;
   private String sifre;
   private String sifreTekrar;
   private String sehir;
   private String ilce;
   private String adres;
   
   private String username;
   private String password;
   private Boolean isLogged = false;
   
   private boolean roleUserAdmin = false;
   private boolean roleSystemAdmin = false;
   private boolean roleReader = false;
   private boolean roleWriter = false;
   
   private List<User> users;
   private User selectedUser; // kullanici rol degisimleri

   public UserBean()
   {
   }

   public String addUser()
   {
      try
      {
         User user = new User();
         user.setTcNo(getTcNo());
         user.setUnvan(getUnvan());
         user.setAd(getAd());
         user.setSoyad(getSoyad());
         user.setGsmNo(getGsmNo());
         user.setTelefon(getTelefon());
         user.seteMail(geteMail());
         user.setUserName(getKullaniciAdi());
         user.setSehir(getSehir());
         user.setIlce(getIlce());
         user.setAdres(getAdres());
         user.setRoleReader(getRoleReader());
         user.setRoleWriter(getRoleWriter());
         user.setRoleUserAdmin(getRoleUserAdmin());
         user.setRoleSystemAdmin(getRoleSystemAdmin());
         if (getSifre().equals(getSifreTekrar()))
         {
            user.setPassword(SifreUtility.encrypt(getSifre()));
         }
         else
         {
            return ERROR;
         }
         getUserService().addUser(user);
         reset();
         FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
         RequestContext.getCurrentInstance().showMessageInDialog(
               new FacesMessage(
                     FacesMessage.SEVERITY_INFO,
                     "Başarılı!",
                     "Kayıt Başarılı"));
         return SUCCESS;
      }
      catch (Exception e)
      {
         e.printStackTrace();
         return ERROR;
      }
   }

   public void reset()
   {
      setTcNo("");
      setUnvan("");
      setAd("");
      setSoyad("");
      setGsmNo("");
      setTelefon("");
      seteMail("");
      setKullaniciAdi("");
      setSifre("");
      setSifreTekrar("");
      setSehir("");
      setIlce("");
      setAdres("");
   }

   public String getTcNo()
   {
      return tcNo;
   }

   public void setTcNo(final String tcNo)
   {
      this.tcNo = tcNo;
   }

   public String getUnvan()
   {
      return unvan;
   }

   public void setUnvan(final String unvan)
   {
      this.unvan = unvan;
   }

   public String getAd()
   {
      return ad;
   }

   public void setAd(final String ad)
   {
      this.ad = ad;
   }

   public String getSoyad()
   {
      return soyad;
   }

   public void setSoyad(final String soyad)
   {
      this.soyad = soyad;
   }

   public String getGsmNo()
   {
      return gsmNo;
   }

   public void setGsmNo(final String gsmNo)
   {
      this.gsmNo = gsmNo;
   }

   public String getTelefon()
   {
      return telefon;
   }

   public void setTelefon(final String telefon)
   {
      this.telefon = telefon;
   }

   public String geteMail()
   {
      return eMail;
   }

   public void seteMail(final String eMail)
   {
      this.eMail = eMail;
   }

   public String getKullaniciAdi()
   {
      return kullaniciAdi;
   }

   public void setKullaniciAdi(final String kullaniciAdi)
   {
      this.kullaniciAdi = kullaniciAdi;
   }

   public String getSehir()
   {
      return sehir;
   }

   public void setSehir(final String sehir)
   {
      this.sehir = sehir;
   }

   public String getIlce()
   {
      return ilce;
   }

   public void setIlce(final String ilce)
   {
      this.ilce = ilce;
   }

   public String getAdres()
   {
      return adres;
   }

   public void setAdres(final String adres)
   {
      this.adres = adres;
   }

   public IUserService getUserService()
   {
      return userService;
   }

   public void setUserService(final IUserService userService)
   {
      this.userService = userService;
   }

   public String getSifre()
   {
      return sifre;
   }

   public void setSifre(final String sifre)
   {
      this.sifre = sifre;
   }

   public String getSifreTekrar()
   {
      return sifreTekrar;
   }

   public void setSifreTekrar(final String sifreTekrar)
   {
      this.sifreTekrar = sifreTekrar;
   }
   
   
   
   	public String getUsername() {
	    return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
		
	public Boolean getIsLogged() {
		return isLogged;
	}

	public void setIsLogged(Boolean isLogged) {
		this.isLogged = isLogged;
	}
	
	

	public boolean getRoleUserAdmin() {
		return roleUserAdmin;
	}

	public void setRoleUserAdmin(boolean roleUserAdmin) {
		this.roleUserAdmin = roleUserAdmin;
	}

	public boolean getRoleSystemAdmin() {
		return roleSystemAdmin;
	}

	public void setRoleSystemAdmin(boolean roleSystemAdmin) {
		this.roleSystemAdmin = roleSystemAdmin;
	}

	public boolean getRoleReader() {
		return roleReader;
	}

	public void setRoleReader(boolean roleReader) {
		this.roleReader = roleReader;
	}

	public boolean getRoleWriter() {
		return roleWriter;
	}

	public void setRoleWriter(boolean roleWriter) {
		this.roleWriter = roleWriter;
	}
	
	

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public List<User> getUsers() {
		users = new ArrayList<User>();
		users.addAll(getUserService().getUserlar());
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void login() throws IOException{

		FacesMessage message = null;
		
		if (username != null && password != null ){
			User user = getUserService().getUserByUserName(username);
			
			if (user == null) {
				isLogged = false;
				message = new FacesMessage(FacesMessage.SEVERITY_WARN,"Login Olunamadı!","Kullanıcı adı hatalı!");
			}
			else if (user != null){
				if (user.getPassword() != null) {
					if (user.getPassword().equals(SifreUtility.encrypt(password))){
						 isLogged = true;
						 roleUserAdmin = user.getRoleUserAdmin();
						 roleSystemAdmin = user.getRoleSystemAdmin();
						 roleReader = user.getRoleReader();
						 roleWriter = user.getRoleWriter();
						 FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
				         message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hoşgeldiniz", username);
					}
					else {
						 isLogged = false;
						 message = new FacesMessage(FacesMessage.SEVERITY_WARN,"Login Olunamadı!","Şifre hatalı!");
					} 
				}
			}
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public void updateUser(){
		if(selectedUser != null){
			getUserService().updateUser(selectedUser);
		}
	}
}