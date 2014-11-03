package hud.iys.service;

import java.util.List;

import hud.iys.dao.IVkbdaDAO;
import hud.iys.model.Vkbda;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class VkbdaService implements IVkbdaService
{

   // UserDAO is injected...
   IVkbdaDAO VkbdaDAO;

   @Transactional(readOnly = false)
   @Override
   public void addVkbda(final Vkbda Vkbda)
   {
      getVkbdaDAO().addVkbda(Vkbda);
   }

   @Transactional(readOnly = false)
   @Override
   public void deleteVkbda(final Vkbda Vkbda)
   {
      getVkbdaDAO().deleteVkbda(Vkbda);
   }

   @Transactional(readOnly = false)
   @Override
   public void updateVkbda(final Vkbda Vkbda)
   {
      getVkbdaDAO().updateVkbda(Vkbda);
   }

   @Override
   public Vkbda getVkbdaById(final Long id)
   {
      return getVkbdaDAO().getVkbdaById(id);
   }

   @Override
   public List<Vkbda> getVkbdalar()
   {
      return getVkbdaDAO().getVkbdalar();
   }

   @Override
   public List<Vkbda> getVkbdalarByMevzuatId(final Long mevzuatId)
   {
      return getVkbdaDAO().getVkbdalarByMevzuatId(mevzuatId);
   }

   public IVkbdaDAO getVkbdaDAO()
   {
      return VkbdaDAO;
   }

   public void setVkbdaDAO(final IVkbdaDAO VkbdaDAO)
   {
      this.VkbdaDAO = VkbdaDAO;
   }
}