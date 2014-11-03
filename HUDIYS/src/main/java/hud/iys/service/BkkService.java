package hud.iys.service;

import java.util.List;

import hud.iys.dao.IBkkDAO;
import hud.iys.model.Bkk;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class BkkService implements IBkkService
{

   // UserDAO is injected...
   IBkkDAO BkkDAO;

   @Transactional(readOnly = false)
   @Override
   public void addBkk(final Bkk Bkk)
   {
      getBkkDAO().addBkk(Bkk);
   }

   @Transactional(readOnly = false)
   @Override
   public void deleteBkk(final Bkk Bkk)
   {
      getBkkDAO().deleteBkk(Bkk);
   }

   @Transactional(readOnly = false)
   @Override
   public void updateBkk(final Bkk Bkk)
   {
      getBkkDAO().updateBkk(Bkk);
   }

   @Override
   public Bkk getBkkById(final Long id)
   {
      return getBkkDAO().getBkkById(id);
   }

   @Override
   public List<Bkk> getBkklar()
   {
      return getBkkDAO().getBkklar();
   }

   @Override
   public List<Bkk> getBkklarByMevzuatId(final Long mevzuatId)
   {
      return getBkkDAO().getBkklarByMevzuatId(mevzuatId);
   }

   public IBkkDAO getBkkDAO()
   {
      return BkkDAO;
   }

   public void setBkkDAO(final IBkkDAO BkkDAO)
   {
      this.BkkDAO = BkkDAO;
   }
}