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
 * @version 1.0.0 @date Oct 24, 2014 @time 1:54:06 PM
 */
@Entity
@Table(name = "Tuzuk")
public class Tuzuk
{
   private Long tuzukId;
   private String tuzukAdi;
   private int bkkNo;
   private Date bkkTarihi;
   private Date dayandigiKanunTarihi;
   private int dayandigiKanunNo;
   private Date RGTarihi;
   private int RGNo;
   private String aciklama;
   private String kararMetni;
   private int dusturTertibi;
   private int dusturCildi;
   private int dusturSayfasi;
   private Mevzuat mevzuat;

   private int durumId;
   
   @Id
   @Column(name = "TuzukId", unique = true, nullable = false)
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getTuzukId()
   {
      return tuzukId;
   }

   public void setTuzukId(final Long tuzukId)
   {
      this.tuzukId = tuzukId;
   }

   @Column(name = "TuzukAdi")
   public String getTuzukAdi()
   {
      return tuzukAdi;
   }

   public void setTuzukAdi(final String tuzukAdi)
   {
      this.tuzukAdi = tuzukAdi;
   }

   @Column(name = "BkkNo")
   public int getBkkNo()
   {
      return bkkNo;
   }

   public void setBkkNo(final int bkkNo)
   {
      this.bkkNo = bkkNo;
   }

   @Column(name = "BkkTarihi")
   public Date getBkkTarihi()
   {
      return bkkTarihi;
   }

   public void setBkkTarihi(final Date bkkTarihi)
   {
      this.bkkTarihi = bkkTarihi;
   }

   @Column(name = "DayandigiKanunTarihi")
   public Date getDayandigiKanunTarihi()
   {
      return dayandigiKanunTarihi;
   }

   public void setDayandigiKanunTarihi(final Date dayandigiKanunTarihi)
   {
      this.dayandigiKanunTarihi = dayandigiKanunTarihi;
   }

   @Column(name = "DayandigiKanunNo")
   public int getDayandigiKanunNo()
   {
      return dayandigiKanunNo;
   }

   public void setDayandigiKanunNo(final int dayandigiKanunNo)
   {
      this.dayandigiKanunNo = dayandigiKanunNo;
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

   @Column(name = "DusturTertibi")
   public int getDusturTertibi()
   {
      return dusturTertibi;
   }

   public void setDusturTertibi(final int dusturTertibi)
   {
      this.dusturTertibi = dusturTertibi;
   }

   @Column(name = "DusturCildi")
   public int getDusturCildi()
   {
      return dusturCildi;
   }

   public void setDusturCildi(final int dusturcildi)
   {
      this.dusturCildi = dusturcildi;
   }

   @Column(name = "DusturSayfasi")
   public int getDusturSayfasi()
   {
      return dusturSayfasi;
   }

   public void setDusturSayfasi(final int dusturSayfasi)
   {
      this.dusturSayfasi = dusturSayfasi;
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

   @Column(name="DurumId")
   public int getDurumId() {
	   return durumId;
   }

   public void setDurumId(int durumId) {
	   this.durumId = durumId;
   }
}
