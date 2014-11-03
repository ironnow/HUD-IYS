package hud.iys.service;

import java.util.List;

import hud.iys.dao.IGerekceDAO;
import hud.iys.model.Gerekce;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class GerekceService implements IGerekceService
{

   // UserDAO is injected...
   IGerekceDAO GerekceDAO;

   @Transactional(readOnly = false)
   @Override
   public void addGerekce(final Gerekce Gerekce)
   {
      getGerekceDAO().addGerekce(Gerekce);
   }

   @Transactional(readOnly = false)
   @Override
   public void deleteGerekce(final Gerekce Gerekce)
   {
      getGerekceDAO().deleteGerekce(Gerekce);
   }

   @Transactional(readOnly = false)
   @Override
   public void updateGerekce(final Gerekce Gerekce)
   {
      getGerekceDAO().updateGerekce(Gerekce);
   }

   @Override
   public Gerekce getGerekceById(final Long id)
   {
      return getGerekceDAO().getGerekceById(id);
   }

   @Override
   public List<Gerekce> getGerekceler()
   {
      return getGerekceDAO().getGerekceler();
   }

   @Override
   public List<Gerekce> getGerekcelerByMevzuatId(final Long mevzuatId)
   {
      return getGerekceDAO().getGerekcelerByMevzuatId(mevzuatId);
   }

   public IGerekceDAO getGerekceDAO()
   {
      return GerekceDAO;
   }

   public void setGerekceDAO(final IGerekceDAO GerekceDAO)
   {
      this.GerekceDAO = GerekceDAO;
   }
}