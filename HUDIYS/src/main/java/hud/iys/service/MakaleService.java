package hud.iys.service;

import java.util.List;

import hud.iys.dao.IMakaleDAO;
import hud.iys.model.Makale;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class MakaleService implements IMakaleService
{

   // UserDAO is injected...
   IMakaleDAO MakaleDAO;

   @Transactional(readOnly = false)
   @Override
   public void addMakale(final Makale Makale)
   {
      getMakaleDAO().addMakale(Makale);
   }

   @Transactional(readOnly = false)
   @Override
   public void deleteMakale(final Makale Makale)
   {
      getMakaleDAO().deleteMakale(Makale);
   }

   @Transactional(readOnly = false)
   @Override
   public void updateMakale(final Makale Makale)
   {
      getMakaleDAO().updateMakale(Makale);
   }

   @Override
   public Makale getMakaleById(final Long id)
   {
      return getMakaleDAO().getMakaleById(id);
   }

   @Override
   public List<Makale> getMakaleler()
   {
      return getMakaleDAO().getMakaleler();
   }

   @Override
   public List<Makale> getMakalelerByMevzuatId(final Long mevzuatId)
   {
      return getMakaleDAO().getMakalelerByMevzuatId(mevzuatId);
   }

   public IMakaleDAO getMakaleDAO()
   {
      return MakaleDAO;
   }

   public void setMakaleDAO(final IMakaleDAO MakaleDAO)
   {
      this.MakaleDAO = MakaleDAO;
   }
}