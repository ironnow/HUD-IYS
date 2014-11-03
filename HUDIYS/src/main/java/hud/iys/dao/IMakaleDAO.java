package hud.iys.dao;

import java.util.List;

import hud.iys.model.Makale;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public interface IMakaleDAO
{
   public void addMakale(Makale makale);

   public void updateMakale(Makale makale);

   public void deleteMakale(Makale makale);

   public Makale getMakaleById(Long id);

   public List<Makale> getMakaleler();

   public List<Makale> getMakalelerByMevzuatId(Long mevzuatId);
}
