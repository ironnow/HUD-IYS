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
@Table(name = "Makale")
public class Makale
{
   private Long makaleId;
   private String konu;
   private String yayinlandigiYer;
   private Date tarih;
   private int sayi;
   private String yazarinAdi;
   private String aciklama;
   private String metin;
   private int durumId;
   private Mevzuat mevzuat;

   @Id
   @Column(name = "MakaleId", unique = true, nullable = false)
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getMakaleId()
   {
      return makaleId;
   }

   public void setMakaleId(final Long makaleId)
   {
      this.makaleId = makaleId;
   }

   @Column(name = "Konu")
   public String getKonu()
   {
      return konu;
   }

   public void setKonu(final String konu)
   {
      this.konu = konu;
   }

   @Column(name = "YayinlandigiYer")
   public String getYayinlandigiYer()
   {
      return yayinlandigiYer;
   }

   public void setYayinlandigiYer(final String yayinlandigiYer)
   {
      this.yayinlandigiYer = yayinlandigiYer;
   }

   @Column(name = "Tarih")
   public Date getTarih()
   {
      return tarih;
   }

   public void setTarih(final Date tarih)
   {
      this.tarih = tarih;
   }

   @Column(name = "Sayi")
   public int getSayi()
   {
      return sayi;
   }

   public void setSayi(final int sayi)
   {
      this.sayi = sayi;
   }

   @Column(name = "YazarinAdi")
   public String getYazarinAdi()
   {
      return yazarinAdi;
   }

   public void setYazarinAdi(final String yazarinAdi)
   {
      this.yazarinAdi = yazarinAdi;
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
