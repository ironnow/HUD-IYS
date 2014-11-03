package hud.iys.service;

import java.util.List;

import hud.iys.dao.IYonetmelikDAO;
import hud.iys.model.Yonetmelik;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class YonetmelikService implements IYonetmelikService
{

   // UserDAO is injected...
   IYonetmelikDAO YonetmelikDAO;

   @Transactional(readOnly = false)
   @Override
   public void addYonetmelik(Yonetmelik Yonetmelik)
   {
      getYonetmelikDAO().addYonetmelik(Yonetmelik);
   }

   @Transactional(readOnly = false)
   @Override
   public void deleteYonetmelik(Yonetmelik Yonetmelik)
   {
      getYonetmelikDAO().deleteYonetmelik(Yonetmelik);
   }

   @Transactional(readOnly = false)
   @Override
   public void updateYonetmelik(Yonetmelik Yonetmelik)
   {
      getYonetmelikDAO().updateYonetmelik(Yonetmelik);
   }

   @Override
   public Yonetmelik getYonetmelikById(Long id)
   {
      return getYonetmelikDAO().getYonetmelikById(id);
   }

   @Override
   public List<Yonetmelik> getYonetmelikler()
   {
      return getYonetmelikDAO().getYonetmelikler();
   }

   @Override
   public List<Yonetmelik> getYonetmeliklerByMevzuatId(Long mevzuatId)
   {
      return getYonetmelikDAO().getYonetmeliklerByMevzuatId(mevzuatId);
   }

   public IYonetmelikDAO getYonetmelikDAO()
   {
      return YonetmelikDAO;
   }

   public void setYonetmelikDAO(IYonetmelikDAO YonetmelikDAO)
   {
      this.YonetmelikDAO = YonetmelikDAO;
   }
}