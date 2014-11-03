package hud.iys.service;

import java.util.List;

import hud.iys.dao.IKhkDAO;
import hud.iys.model.Khk;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class KhkService implements IKhkService
{

   // UserDAO is injected...
   IKhkDAO KhkDAO;

   @Transactional(readOnly = false)
   @Override
   public void addKhk(final Khk Khk)
   {
      getKhkDAO().addKhk(Khk);
   }

   @Transactional(readOnly = false)
   @Override
   public void deleteKhk(final Khk Khk)
   {
      getKhkDAO().deleteKhk(Khk);
   }

   @Transactional(readOnly = false)
   @Override
   public void updateKhk(final Khk Khk)
   {
      getKhkDAO().updateKhk(Khk);
   }

   @Override
   public Khk getKhkById(final Long id)
   {
      return getKhkDAO().getKhkById(id);
   }

   @Override
   public List<Khk> getKhklar()
   {
      return getKhkDAO().getKhklar();
   }

   @Override
   public List<Khk> getKhklarByMevzuatId(final Long mevzuatId)
   {
      return getKhkDAO().getKhklarByMevzuatId(mevzuatId);
   }

   public IKhkDAO getKhkDAO()
   {
      return KhkDAO;
   }

   public void setKhkDAO(final IKhkDAO KhkDAO)
   {
      this.KhkDAO = KhkDAO;
   }
}