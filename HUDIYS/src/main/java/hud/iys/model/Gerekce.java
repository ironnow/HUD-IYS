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
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
@Entity
@Table(name = "Gerekce")
public class Gerekce
{
   private Long gerekceId;
   private String gerekceMetni;
   private Long ilgiliKanunNo;
   private String ilgiliKanunAdi;
   private String aciklama;
   private Mevzuat mevzuat;
   
   private int durumId;

   @Id
   @Column(name = "GerekceID", unique = true, nullable = false)
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getGerekceId()
   {
      return gerekceId;
   }

   public void setGerekceId(final Long gerekceId)
   {
      this.gerekceId = gerekceId;
   }

   @Column(name = "GerekceMetni")
   public String getGerekceMetni()
   {
      return gerekceMetni;
   }

   public void setGerekceMetni(final String gerekceMetni)
   {
      this.gerekceMetni = gerekceMetni;
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
