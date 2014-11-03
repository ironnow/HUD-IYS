package hud.iys.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
@Entity
@Table(name = "Vkbda")
public class Vkbda
{
   private Long vkbdaId;
   private String anlasmaAdi;
   private String tarafDevlet;
   private Date RGTarihi;
   private int RGNo;
   private Date yururlukTarihi;
   private Date uygulanmaTarihi;
   private Date imzaTarihi;
   private String aciklama;
   private String anlasmaMetni;
   private Mevzuat mevzuat;

   private int durumId;
   
   @Id
   @Column(name = "VKBDAID", unique = true, nullable = false)
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getVkbdaId()
   {
      return vkbdaId;
   }

   public void setVkbdaId(final Long vkbdaId)
   {
      this.vkbdaId = vkbdaId;
   }

   @Column(name = "AnlasmaAdi")
   public String getAnlasmaAdi()
   {
      return anlasmaAdi;
   }

   public void setAnlasmaAdi(final String anlasmaAdi)
   {
      this.anlasmaAdi = anlasmaAdi;
   }

   @Column(name = "TarafDevlet")
   public String getTarafDevlet()
   {
      return tarafDevlet;
   }

   public void setTarafDevlet(final String tarafDevlet)
   {
      this.tarafDevlet = tarafDevlet;
   }

   @Column(name = "RGTarihi")
   public Date getRGTarihi()
   {
      return RGTarihi;
   }

   public void setRGTarihi(final Date rGTarihi)
   {
      RGTarihi = rGTarihi;
   }

   @Column(name = "RGNo")
   public int getRGNo()
   {
      return RGNo;
   }

   public void setRGNo(final int rGNo)
   {
      RGNo = rGNo;
   }

   @Column(name = "YururlukTarihi")
   public Date getYururlukTarihi()
   {
      return yururlukTarihi;
   }

   public void setYururlukTarihi(final Date yururlukTarihi)
   {
      this.yururlukTarihi = yururlukTarihi;
   }

   @Column(name = "UygulanmaTarihi")
   public Date getUygulanmaTarihi()
   {
      return uygulanmaTarihi;
   }

   public void setUygulanmaTarihi(final Date uygulanmaTarihi)
   {
      this.uygulanmaTarihi = uygulanmaTarihi;
   }

   @Column(name = "ImzaTarihi")
   public Date getImzaTarihi()
   {
      return imzaTarihi;
   }

   public void setImzaTarihi(final Date imzaTarihi)
   {
      this.imzaTarihi = imzaTarihi;
   }

   @Column(name = "Aciklama")
   public String getAciklama()
   {
      return aciklama;
   }

   public void setAciklama(final String aciklama)
   {
      this.aciklama = aciklama;
   }

   @Column(name = "AnlasmaMetni")
   public String getAnlasmaMetni()
   {
      return anlasmaMetni;
   }

   public void setAnlasmaMetni(final String anlasmaMetni)
   {
      this.anlasmaMetni = anlasmaMetni;
   }
   
   @Column(name="DurumId")
   public int getDurumId() {
	   return durumId;
   }

   public void setDurumId(int durumId) {
	   this.durumId = durumId;
   }

   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "MevzuatID", nullable = false)
   public Mevzuat getMevzuat()
   {
      return mevzuat;
   }

   public void setMevzuat(final Mevzuat mevzuat)
   {
      this.mevzuat = mevzuat;
   }
}
