package hud.iys.service;

import java.util.List;

import hud.iys.dao.IOlusSirkulerDAO;
import hud.iys.model.OlusSirkuler;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class OlusSirkulerService implements IOlusSirkulerService
{

   // UserDAO is injected...
   IOlusSirkulerDAO OlusSirkulerDAO;

   @Transactional(readOnly = false)
   @Override
   public void addOlusSirkuler(final OlusSirkuler OlusSirkuler)
   {
      getOlusSirkulerDAO().addOlusSirkuler(OlusSirkuler);
   }

   @Transactional(readOnly = false)
   @Override
   public void deleteOlusSirkuler(final OlusSirkuler OlusSirkuler)
   {
      getOlusSirkulerDAO().deleteOlusSirkuler(OlusSirkuler);
   }

   @Transactional(readOnly = false)
   @Override
   public void updateOlusSirkuler(final OlusSirkuler OlusSirkuler)
   {
      getOlusSirkulerDAO().updateOlusSirkuler(OlusSirkuler);
   }

   @Override
   public OlusSirkuler getOlusSirkulerById(final Long id)
   {
      return getOlusSirkulerDAO().getOlusSirkulerById(id);
   }

   @Override
   public List<OlusSirkuler> getOlusSirkuler()
   {
      return getOlusSirkulerDAO().getOlusSirkuler();
   }

   @Override
   public List<OlusSirkuler> getOlusSirkulerByMevzuatId(final Long mevzuatId)
   {
      return getOlusSirkulerDAO().getOlusSirkulerByMevzuatId(mevzuatId);
   }

   public IOlusSirkulerDAO getOlusSirkulerDAO()
   {
      return OlusSirkulerDAO;
   }

   public void setOlusSirkulerDAO(final IOlusSirkulerDAO OlusSirkulerDAO)
   {
      this.OlusSirkulerDAO = OlusSirkulerDAO;
   }
}