package hud.iys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
@Entity
@Table(name = "User")
public class User
{
   private Long userId;
   private String tcNo;
   private String unvan;
   private String ad;
   private String soyad;
   private String gsmNo;
   private String telefon;
   private String eMail;  
   private String sehir;
   private String ilce;
   private String adres;
   
   private String userName;
   private String password;
   
   private boolean roleUserAdmin;
   private boolean roleSystemAdmin;
   private boolean roleReader;
   private boolean roleWriter;

   @Id
   @Column(name = "UserId", unique = true, nullable = false)
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getUserId()
   {
      return userId;
   }

   public void setUserId(final Long userId)
   {
      this.userId = userId;
   }

   @Column(name = "TcNo")
   public String getTcNo()
   {
      return tcNo;
   }

   public void setTcNo(final String tcNo)
   {
      this.tcNo = tcNo;
   }

   @Column(name = "Unvan")
   public String getUnvan()
   {
      return unvan;
   }

   public void setUnvan(final String unvan)
   {
      this.unvan = unvan;
   }

   @Column(name = "Ad")
   public String getAd()
   {
      return ad;
   }

   public void setAd(final String ad)
   {
      this.ad = ad;
   }

   @Column(name = "Soyad")
   public String getSoyad()
   {
      return soyad;
   }

   public void setSoyad(final String soyad)
   {
      this.soyad = soyad;
   }

   @Column(name = "GsmNo")
   public String getGsmNo()
   {
      return gsmNo;
   }

   public void setGsmNo(final String gsmNo)
   {
      this.gsmNo = gsmNo;
   }

   @Column(name = "Telefon")
   public String getTelefon()
   {
      return telefon;
   }

   public void setTelefon(final String telefon)
   {
      this.telefon = telefon;
   }

   @Column(name = "EMail")
   public String geteMail()
   {
      return eMail;
   }

   public void seteMail(final String eMail)
   {
      this.eMail = eMail;
   }

   @Column(name = "userName")
   public String getUserName()
   {
      return userName;
   }

   public void setUserName(final String userName)
   {
      this.userName = userName;
   }

   @Column(name = "Sehir")
   public String getSehir()
   {
      return sehir;
   }

   public void setSehir(final String sehir)
   {
      this.sehir = sehir;
   }

   @Column(name = "Ilce")
   public String getIlce()
   {
      return ilce;
   }

   public void setIlce(final String ilce)
   {
      this.ilce = ilce;
   }

   @Column(name = "Adres")
   public String getAdres()
   {
      return adres;
   }

   public void setAdres(final String adres)
   {
      this.adres = adres;
   }

   @Column(name = "password")
   public String getPassword()
   {
      return password;
   }

   public void setPassword(final String password)
   {
      this.password = password;
   }

    @Column(name = "roleUserAdmin")
	public boolean getRoleUserAdmin() {
		return roleUserAdmin;
	}
	
	public void setRoleUserAdmin(boolean roleUserAdmin) {
		this.roleUserAdmin = roleUserAdmin;
	}
	
	@Column(name = "roleSystemAdmin")
	public boolean getRoleSystemAdmin() {
		return roleSystemAdmin;
	}
	
	public void setRoleSystemAdmin(boolean roleSystemAdmin) {
		this.roleSystemAdmin = roleSystemAdmin;
	}
	
	@Column(name = "roleReader")
	public boolean getRoleReader() {
		return roleReader;
	}
	
	public void setRoleReader(boolean roleReader) {
		this.roleReader = roleReader;
	}
	
	@Column(name = "roleWriter")
	public boolean getRoleWriter() {
		return roleWriter;
	}

	public void setRoleWriter(boolean roleWriter) {
		this.roleWriter = roleWriter;
	}
	   
   
}
