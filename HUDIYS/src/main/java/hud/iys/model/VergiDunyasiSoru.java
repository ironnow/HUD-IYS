package hud.iys.model;

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
@Table(name = "VergiDunyasiSoru")
public class VergiDunyasiSoru
{
   private Long vergiDunyasiSoruId;
   private int dergiSayisi;
   private String dergiTarihi;
   private String yazarinAdi;
   private String soru;
   private String aciklama;
   private String cevapMetni;
   private int durumId;
   private Mevzuat mevzuat;

   @Id
   @Column(name = "VergiDunyasiSoruId", unique = true, nullable = false)
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getVergiDunyasiSoruId()
   {
      return vergiDunyasiSoruId;
   }

   public void setVergiDunyasiSoruId(final Long vergiDunyasiSoruId)
   {
      this.vergiDunyasiSoruId = vergiDunyasiSoruId;
   }

   @Column(name = "DergiSayisi")
   public int getDergiSayisi()
   {
      return dergiSayisi;
   }

   public void setDergiSayisi(final int dergiSayisi)
   {
      this.dergiSayisi = dergiSayisi;
   }

   @Column(name = "YazarinAdi")
   public String getDergiTarihi()
   {
      return dergiTarihi;
   }

   public void setDergiTarihi(final String dergiTarihi)
   {
      this.dergiTarihi = dergiTarihi;
   }

   @Column(name = "KararVeren")
   public String getYazarinAdi()
   {
      return yazarinAdi;
   }

   public void setYazarinAdi(final String yazarinAdi)
   {
      this.yazarinAdi = yazarinAdi;
   }

   @Column(name = "Soru")
   public String getSoru()
   {
      return soru;
   }

   public void setSoru(final String soru)
   {
      this.soru = soru;
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

   @Column(name = "CevapMetni")
   public String getCevapMetni()
   {
      return cevapMetni;
   }

   public void setCevapMetni(final String cevapMetni)
   {
      this.cevapMetni = cevapMetni;
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
