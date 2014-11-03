package hud.iys.dao;

import java.util.List;

import hud.iys.model.DanismaKomisyonuKarari;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public interface IDanismaKomisyonuKarariDAO
{
   public void addDanismaKomisyonuKarari(DanismaKomisyonuKarari danismaKomisyonuKarari);

   public void updateDanismaKomisyonuKarari(DanismaKomisyonuKarari danismaKomisyonuKarari);

   public void deleteDanismaKomisyonuKarari(DanismaKomisyonuKarari danismaKomisyonuKarari);

   public DanismaKomisyonuKarari getDanismaKomisyonuKarariById(Long id);

   public List<DanismaKomisyonuKarari> getDanismaKomisyonuKararlari();

   public List<DanismaKomisyonuKarari> getDanismaKomisyonuKararlariByMevzuatId(
         Long mevzuatId);
}
