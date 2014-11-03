package hud.iys.dao;

import java.util.List;

import hud.iys.model.Yonetmelik;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public interface IYonetmelikDAO
{
   public void addYonetmelik(Yonetmelik yonetmelik);

   public void updateYonetmelik(Yonetmelik yonetmelik);

   public void deleteYonetmelik(Yonetmelik yonetmelik);

   public Yonetmelik getYonetmelikById(Long id);

   public List<Yonetmelik> getYonetmelikler();

   public List<Yonetmelik> getYonetmeliklerByMevzuatId(Long mevzuatId);
}
