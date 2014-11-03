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
@Table(name = "DanismaKomisyonuKarari")
public class DanismaKomisyonuKarari
{
   private Long danismaKomisyonuKarariId;
   private int yayinSiraNo;
   private int kararNo;
   private Date kararTarihi;
   private String kararOzu;
   private String kararMetni;
   private int durumId;
   private Mevzuat mevzuat;

   @Id
   @Column(name = "DanismaKomisyonuKarariId", unique = true, nullable = false)
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getDanismaKomisyonuKarariId()
   {
      return danismaKomisyonuKarariId;
   }

   public void setDanismaKomisyonuKarariId(final Long danismaKomisyonuKarariId)
   {
      this.danismaKomisyonuKarariId = danismaKomisyonuKarariId;
   }

   @Column(name = "YayinSiraNo")
   public int getYayinSiraNo()
   {
      return yayinSiraNo;
   }

   public void setYayinSiraNo(final int yayinSiraNo)
   {
      this.yayinSiraNo = yayinSiraNo;
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

   @Column(name = "KararTarihi")
   public Date getKararTarihi()
   {
      return kararTarihi;
   }

   public void setKararTarihi(final Date kararTarihi)
   {
      this.kararTarihi = kararTarihi;
   }

   @Column(name = "KararOzu")
   public String getKararOzu()
   {
      return kararOzu;
   }

   public void setKararOzu(final String kararOzu)
   {
      this.kararOzu = kararOzu;
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
