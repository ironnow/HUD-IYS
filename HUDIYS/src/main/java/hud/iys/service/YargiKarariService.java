package hud.iys.service;

import java.util.List;

import hud.iys.dao.IYargiKarariDAO;
import hud.iys.model.YargiKarari;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class YargiKarariService implements IYargiKarariService
{

   // UserDAO is injected...
   IYargiKarariDAO YargiKarariDAO;

   @Transactional(readOnly = false)
   @Override
   public void addYargiKarari(final YargiKarari YargiKarari)
   {
      getYargiKarariDAO().addYargiKarari(YargiKarari);
   }

   @Transactional(readOnly = false)
   @Override
   public void deleteYargiKarari(final YargiKarari YargiKarari)
   {
      getYargiKarariDAO().deleteYargiKarari(YargiKarari);
   }

   @Transactional(readOnly = false)
   @Override
   public void updateYargiKarari(final YargiKarari YargiKarari)
   {
      getYargiKarariDAO().updateYargiKarari(YargiKarari);
   }

   @Override
   public YargiKarari getYargiKarariById(final Long id)
   {
      return getYargiKarariDAO().getYargiKarariById(id);
   }

   @Override
   public List<YargiKarari> getYargiKararlari()
   {
      return getYargiKarariDAO().getYargiKararlari();
   }

   @Override
   public List<YargiKarari> getYargiKararlariByMevzuatId(final Long mevzuatId)
   {
      return getYargiKarariDAO().getYargiKararlariByMevzuatId(mevzuatId);
   }

   public IYargiKarariDAO getYargiKarariDAO()
   {
      return YargiKarariDAO;
   }

   public void setYargiKarariDAO(final IYargiKarariDAO YargiKarariDAO)
   {
      this.YargiKarariDAO = YargiKarariDAO;
   }
}