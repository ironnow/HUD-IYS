package hud.iys.service;

import java.util.List;

import hud.iys.dao.ISirkulerDAO;
import hud.iys.model.Sirkuler;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class SirkulerService implements ISirkulerService
{

   // UserDAO is injected...
   ISirkulerDAO SirkulerDAO;

   @Transactional(readOnly = false)
   @Override
   public void addSirkuler(final Sirkuler Sirkuler)
   {
      getSirkulerDAO().addSirkuler(Sirkuler);
   }

   @Transactional(readOnly = false)
   @Override
   public void deleteSirkuler(final Sirkuler Sirkuler)
   {
      getSirkulerDAO().deleteSirkuler(Sirkuler);
   }

   @Transactional(readOnly = false)
   @Override
   public void updateSirkuler(final Sirkuler Sirkuler)
   {
      getSirkulerDAO().updateSirkuler(Sirkuler);
   }

   @Override
   public Sirkuler getSirkulerById(final Long id)
   {
      return getSirkulerDAO().getSirkulerById(id);
   }

   @Override
   public List<Sirkuler> getSirkulerler()
   {
      return getSirkulerDAO().getSirkulerler();
   }

   @Override
   public List<Sirkuler> getSirkulerlerByMevzuatId(final Long mevzuatId)
   {
      return getSirkulerDAO().getSirkulerlerByMevzuatId(mevzuatId);
   }

   public ISirkulerDAO getSirkulerDAO()
   {
      return SirkulerDAO;
   }

   public void setSirkulerDAO(final ISirkulerDAO SirkulerDAO)
   {
      this.SirkulerDAO = SirkulerDAO;
   }
}