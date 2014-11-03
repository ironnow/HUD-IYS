package hud.iys.service;

import java.util.List;

import hud.iys.dao.IIcGenelgeDAO;
import hud.iys.model.IcGenelge;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class IcGenelgeService implements IIcGenelgeService
{

   // UserDAO is injected...
   IIcGenelgeDAO IcGenelgeDAO;

   @Transactional(readOnly = false)
   @Override
   public void addIcGenelge(final IcGenelge IcGenelge)
   {
      getIcGenelgeDAO().addIcGenelge(IcGenelge);
   }

   @Transactional(readOnly = false)
   @Override
   public void deleteIcGenelge(final IcGenelge IcGenelge)
   {
      getIcGenelgeDAO().deleteIcGenelge(IcGenelge);
   }

   @Transactional(readOnly = false)
   @Override
   public void updateIcGenelge(final IcGenelge IcGenelge)
   {
      getIcGenelgeDAO().updateIcGenelge(IcGenelge);
   }

   @Override
   public IcGenelge getIcGenelgeById(final Long id)
   {
      return getIcGenelgeDAO().getIcGenelgeById(id);
   }

   @Override
   public List<IcGenelge> getIcGenelgeler()
   {
      return getIcGenelgeDAO().getIcGenelgeler();
   }

   @Override
   public List<IcGenelge> getIcGenelgelerByMevzuatId(final Long mevzuatId)
   {
      return getIcGenelgeDAO().getIcGenelgelerByMevzuatId(mevzuatId);
   }

   public IIcGenelgeDAO getIcGenelgeDAO()
   {
      return IcGenelgeDAO;
   }

   public void setIcGenelgeDAO(final IIcGenelgeDAO IcGenelgeDAO)
   {
      this.IcGenelgeDAO = IcGenelgeDAO;
   }
}