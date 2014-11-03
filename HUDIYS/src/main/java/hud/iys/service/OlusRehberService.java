package hud.iys.service;

import java.util.List;

import hud.iys.dao.IOlusRehberDAO;
import hud.iys.model.OlusRehber;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class OlusRehberService implements IOlusRehberService
{

   // UserDAO is injected...
   IOlusRehberDAO OlusRehberDAO;

   @Transactional(readOnly = false)
   @Override
   public void addOlusRehber(final OlusRehber OlusRehber)
   {
      getOlusRehberDAO().addOlusRehber(OlusRehber);
   }

   @Transactional(readOnly = false)
   @Override
   public void deleteOlusRehber(final OlusRehber OlusRehber)
   {
      getOlusRehberDAO().deleteOlusRehber(OlusRehber);
   }

   @Transactional(readOnly = false)
   @Override
   public void updateOlusRehber(final OlusRehber OlusRehber)
   {
      getOlusRehberDAO().updateOlusRehber(OlusRehber);
   }

   @Override
   public OlusRehber getOlusRehberById(final Long id)
   {
      return getOlusRehberDAO().getOlusRehberById(id);
   }

   @Override
   public List<OlusRehber> getOlusRehberler()
   {
      return getOlusRehberDAO().getOlusRehberler();
   }

   @Override
   public List<OlusRehber> getOlusRehberlerByMevzuatId(final Long mevzuatId)
   {
      return getOlusRehberDAO().getOlusRehberlerByMevzuatId(mevzuatId);
   }

   public IOlusRehberDAO getOlusRehberDAO()
   {
      return OlusRehberDAO;
   }

   public void setOlusRehberDAO(final IOlusRehberDAO OlusRehberDAO)
   {
      this.OlusRehberDAO = OlusRehberDAO;
   }
}