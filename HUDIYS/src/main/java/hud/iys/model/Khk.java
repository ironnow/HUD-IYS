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
@Table(name = "Khk")
public class Khk
{
   private Long khkId;
   private Long khkNo;
   private String khkAdi;
   private Date kabulTarihi;
   private Date RGTarihi;
   private int RGNo;
   private String aciklama;
   private String khkMetni;
   private Mevzuat mevzuat;
   
   private int durumId;

   @Id
   @Column(name = "KhkId", unique = true, nullable = false)
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getKhkId()
   {
      return khkId;
   }

   public void setKhkId(final Long khkId)
   {
      this.khkId = khkId;
   }

   @Column(name = "KhkNo")
   public Long getKhkNo()
   {
      return khkNo;
   }

   public void setKhkNo(final Long khkNo)
   {
      this.khkNo = khkNo;
   }

   @Column(name = "KhkAdi")
   public String getKhkAdi()
   {
      return khkAdi;
   }

   public void setKhkAdi(final String khkAdi)
   {
      this.khkAdi = khkAdi;
   }

   @Column(name = "RGTarihi")
   public Date getRGTarihi()
   {
      return RGTarihi;
   }

   public void setRGTarihi(final Date RGTarihi)
   {
      this.RGTarihi = RGTarihi;
   }

   @Column(name = "KabulTarihi")
   public Date getKabulTarihi()
   {
      return kabulTarihi;
   }

   public void setKabulTarihi(final Date kabulTarihi)
   {
      this.kabulTarihi = kabulTarihi;
   }

   @Column(name = "RGNo")
   public int getRGNo()
   {
      return RGNo;
   }

   public void setRGNo(final int RGNo)
   {
      this.RGNo = RGNo;
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

   @Column(name = "KhkMetni")
   public String getKhkMetni()
   {
      return khkMetni;
   }

   public void setKhkMetni(final String khkMetni)
   {
      this.khkMetni = khkMetni;
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
