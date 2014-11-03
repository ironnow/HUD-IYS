package hud.iys.service;

import java.util.List;

import hud.iys.dao.ITuzukDAO;
import hud.iys.model.Tuzuk;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class TuzukService implements ITuzukService
{

   // UserDAO is injected...
   ITuzukDAO TuzukDAO;

   @Transactional(readOnly = false)
   @Override
   public void addTuzuk(final Tuzuk Tuzuk)
   {
      getTuzukDAO().addTuzuk(Tuzuk);
   }

   @Transactional(readOnly = false)
   @Override
   public void deleteTuzuk(final Tuzuk Tuzuk)
   {
      getTuzukDAO().deleteTuzuk(Tuzuk);
   }

   @Transactional(readOnly = false)
   @Override
   public void updateTuzuk(final Tuzuk Tuzuk)
   {
      getTuzukDAO().updateTuzuk(Tuzuk);
   }

   @Override
   public Tuzuk getTuzukById(final Long id)
   {
      return getTuzukDAO().getTuzukById(id);
   }

   @Override
   public List<Tuzuk> getTuzukler()
   {
      return getTuzukDAO().getTuzukler();
   }

   @Override
   public List<Tuzuk> getTuzuklerByMevzuatId(final Long mevzuatId)
   {
      return getTuzukDAO().getTuzuklerByMevzuatId(mevzuatId);
   }

   public ITuzukDAO getTuzukDAO()
   {
      return TuzukDAO;
   }

   public void setTuzukDAO(final ITuzukDAO TuzukDAO)
   {
      this.TuzukDAO = TuzukDAO;
   }
}