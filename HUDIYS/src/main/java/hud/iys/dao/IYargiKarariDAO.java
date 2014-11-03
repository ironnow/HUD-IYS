package hud.iys.dao;

import java.util.List;

import hud.iys.model.YargiKarari;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public interface IYargiKarariDAO
{
   public void addYargiKarari(YargiKarari yargiKarari);

   public void updateYargiKarari(YargiKarari yargiKarari);

   public void deleteYargiKarari(YargiKarari yargiKarari);

   public YargiKarari getYargiKarariById(Long id);

   public List<YargiKarari> getYargiKararlari();

   public List<YargiKarari> getYargiKararlariByMevzuatId(Long mevzuatId);
}
