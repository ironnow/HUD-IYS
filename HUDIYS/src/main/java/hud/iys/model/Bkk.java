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
@Table(name = "Bkk")
public class Bkk
{
   private Long bkkId;
   private Long bkkNo;
   private Date kararTarihi;
   private String bkkAdi;
   private Date RGTarihi;
   private int RGNo;
   private String aciklama;
   private String kararMetni;
   private Mevzuat mevzuat;

   private int durumId;
   
   @Id
   @Column(name = "BkkId", unique = true, nullable = false)
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getBkkId()
   {
      return bkkId;
   }

   public void setBkkId(final Long bkkId)
   {
      this.bkkId = bkkId;
   }

   @Column(name = "BkkNo")
   public Long getBkkNo()
   {
      return bkkNo;
   }

   public void setBkkNo(final Long bkkNo)
   {
      this.bkkNo = bkkNo;
   }

   @Column(name = "BkkAdi")
   public String getBkkAdi()
   {
      return bkkAdi;
   }

   public void setBkkAdi(final String bkkAdi)
   {
      this.bkkAdi = bkkAdi;
   }

   @Column(name = "KararTarihi")
   public Date getKararTarihi()
   {
      return kararTarihi;
   }

   public void setKararTarihi(final Date kararTarihi)
   {
      this.kararTarihi = kararTarihi;
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

   @Column(name = "KararMetni")
   public String getKararMetni()
   {
      return kararMetni;
   }

   public void setKararMetni(final String kararMetni)
   {
      this.kararMetni = kararMetni;
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
