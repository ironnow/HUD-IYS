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
@Table(name = "Mukteza")
public class Mukteza
{
   private Long muktezaId;
   private int sayi;
   private Date tarih;
   private String baslik;
   private String verenBirim;
   private Long ilgiliKanunNo;
   private String ilgiliKanunAdi;
   private String aciklama;
   private String metin;
   private Mevzuat mevzuat;
   private int durumId;

   @Id
   @Column(name = "MuktezaId", unique = true, nullable = false)
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getMuktezaId()
   {
      return muktezaId;
   }

   public void setMuktezaId(final Long muktezaId)
   {
      this.muktezaId = muktezaId;
   }

   @Column(name = "Baslik")
   public String getBaslik()
   {
      return baslik;
   }

   public void setBaslik(final String baslik)
   {
      this.baslik = baslik;
   }

   @Column(name = "VerenBirim")
   public String getVerenBirim()
   {
      return verenBirim;
   }

   public void setVerenBirim(final String verenBirim)
   {
      this.verenBirim = verenBirim;
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

   @Column(name = "IlgiliKanunAdi")
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
