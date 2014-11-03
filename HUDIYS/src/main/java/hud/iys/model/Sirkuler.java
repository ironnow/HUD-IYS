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
@Table(name = "Sirkuler")
public class Sirkuler
{
   private Long sirkulerId;
   private String sirkulerAdi;
   private String sirkulerKonu;
   private Date tarih;
   private int sayi;
   private Long ilgiliKanunNo;
   private String ilgiliKanunAdi;
   private String aciklama;
   private String metin;
   private Mevzuat mevzuat;
   private int durumId;

   @Id
   @Column(name = "SirkulerId", unique = true, nullable = false)
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getSirkulerId()
   {
      return sirkulerId;
   }

   public void setSirkulerId(final Long sirkulerId)
   {
      this.sirkulerId = sirkulerId;
   }

   @Column(name = "SirkulerAdi")
   public String getSirkulerAdi()
   {
      return sirkulerAdi;
   }

   public void setSirkulerAdi(final String sirkulerAdi)
   {
      this.sirkulerAdi = sirkulerAdi;
   }

   @Column(name = "SirkulerKonu")
   public String getSirkulerKonu()
   {
      return sirkulerKonu;
   }

   public void setSirkulerKonu(final String sirkulerKonu)
   {
      this.sirkulerKonu = sirkulerKonu;
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

   @Column(name = "IlgiliKanunNo")
   public Long getIlgiliKanunNo()
   {
      return ilgiliKanunNo;
   }

   public void setIlgiliKanunNo(final Long ilgiliKanunNo)
   {
      this.ilgiliKanunNo = ilgiliKanunNo;
   }

   @Column(name = "IlgilikanunAdi")
   public String getIlgiliKanunAdi()
   {
      return ilgiliKanunAdi;
   }

   public void setIlgiliKanunAdi(final String ilgiliKanunAdi)
   {
      this.ilgiliKanunAdi = ilgiliKanunAdi;
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
