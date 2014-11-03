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
 * @version 1.0.0 @date Oct 31, 2014 @time 12:43:22 PM
 */
@Entity
@Table(name = "YargiKarari")
public class YargiKarari
{
   private Long yargiKarariId;
   private String kararVeren;
   private int kararYili;
   private int kararNo;
   private int esasYili;
   private int esasNo;
   private Date kararTarihi;
   private String aciklama;
   private String ozetMetin;
   private String kararMetni;
   private int durumId;
   private Mevzuat mevzuat;

   @Id
   @Column(name = "YargiKarariId", unique = true, nullable = false)
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getYargiKarariId()
   {
      return yargiKarariId;
   }

   public void setYargiKarariId(final Long yargiKarariId)
   {
      this.yargiKarariId = yargiKarariId;
   }

   @Column(name = "KararVeren")
   public String getKararVeren()
   {
      return kararVeren;
   }

   public void setKararVeren(final String kararVeren)
   {
      this.kararVeren = kararVeren;
   }

   @Column(name = "KararYili")
   public int getKararYili()
   {
      return kararYili;
   }

   public void setKararYili(final int kararYili)
   {
      this.kararYili = kararYili;
   }

   @Column(name = "KararNo")
   public int getKararNo()
   {
      return kararNo;
   }

   public void setKararNo(final int kararNo)
   {
      this.kararNo = kararNo;
   }

   @Column(name = "EsasYili")
   public int getEsasYili()
   {
      return esasYili;
   }

   public void setEsasYili(final int esasYili)
   {
      this.esasYili = esasYili;
   }

   @Column(name = "EsasNo")
   public int getEsasNo()
   {
      return esasNo;
   }

   public void setEsasNo(final int esasNo)
   {
      this.esasNo = esasNo;
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

   @Column(name = "Aciklama")
   public String getAciklama()
   {
      return aciklama;
   }

   public void setAciklama(final String aciklama)
   {
      this.aciklama = aciklama;
   }

   @Column(name = "OzetMetin")
   public String getOzetMetin()
   {
      return ozetMetin;
   }

   public void setOzetMetin(final String ozetMetin)
   {
      this.ozetMetin = ozetMetin;
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

   @Column(name = "DurumId")
   public int getDurumId()
   {
      return durumId;
   }

   public void setDurumId(final int durumId)
   {
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
