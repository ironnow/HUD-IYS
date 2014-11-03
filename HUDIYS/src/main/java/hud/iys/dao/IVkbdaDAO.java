package hud.iys.dao;

import java.util.List;

import hud.iys.model.Vkbda;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public interface IVkbdaDAO
{
   public void addVkbda(Vkbda vkbda);

   public void updateVkbda(Vkbda vkbda);

   public void deleteVkbda(Vkbda vkbda);

   public Vkbda getVkbdaById(Long id);

   public List<Vkbda> getVkbdalar();

   public List<Vkbda> getVkbdalarByMevzuatId(Long mevzuatId);
}
