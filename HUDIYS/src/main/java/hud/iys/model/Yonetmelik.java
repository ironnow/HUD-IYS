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
 * @version 1.0.0 @date Oct 24, 2014 @time 2:04:01 PM
 */
@Entity
@Table(name = "Yonetmelik")
public class Yonetmelik
{
   private Long yonetmelikId;
   private String yonetmelikAdi;
   private Date RGTarihi;
   private int RGNo;
   private Long ilgiliKanunNo;
   private String ilgiliKanunAdi;
   private String yonetmelikTuru;
   private String kurum;
   private String aciklama;
   private String metin;
   private Mevzuat mevzuat;
   
   private int durumId;

   @Id
   @Column(name = "YonetmelikId", unique = true, nullable = false)
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getYonetmelikId()
   {
      return yonetmelikId;
   }

   public void setYonetmelikId(final Long yonetmelikId)
   {
      this.yonetmelikId = yonetmelikId;
   }

   @Column(name = "YonetmelikAdi")
   public String getYonetmelikAdi()
   {
      return yonetmelikAdi;
   }

   public void setYonetmelikAdi(final String yonetmelikAdi)
   {
      this.yonetmelikAdi = yonetmelikAdi;
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

   @Column(name = "IlgiliKanunNo")
   public Long getIlgiliKanunNo()
   {
      return ilgiliKanunNo;
   }

   public void setIlgiliKanunNo(final Long ilgiliKanunNo)
   {
      this.ilgiliKanunNo = ilgiliKanunNo;
   }

   @Column(name = "IlgiliKanunAdi")
   public String getIlgiliKanunAdi()
   {
      return ilgiliKanunAdi;
   }

   public void setIlgiliKanunAdi(final String ilgiliKanunAdi)
   {
      this.ilgiliKanunAdi = ilgiliKanunAdi;
   }

   @Column(name = "YonetmelikTuru")
   public String getYonetmelikTuru()
   {
      return yonetmelikTuru;
   }

   public void setYonetmelikTuru(final String yonetmelikTuru)
   {
      this.yonetmelikTuru = yonetmelikTuru;
   }

   @Column(name = "Kurum")
   public String getKurum()
   {
      return kurum;
   }

   public void setKurum(final String kurum)
   {
      this.kurum = kurum;
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

   @Column(name = "Metin")
   public String getMetin()
   {
      return metin;
   }

   public void setMetin(final String metin)
   {
      this.metin = metin;
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
