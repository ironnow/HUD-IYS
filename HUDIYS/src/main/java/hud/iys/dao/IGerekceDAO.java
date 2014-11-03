package hud.iys.dao;

import java.util.List;

import hud.iys.model.Gerekce;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public interface IGerekceDAO
{
   public void addGerekce(Gerekce gerekce);

   public void updateGerekce(Gerekce gerekce);

   public void deleteGerekce(Gerekce gerekce);

   public Gerekce getGerekceById(Long id);

   public List<Gerekce> getGerekceler();

   public List<Gerekce> getGerekcelerByMevzuatId(Long mevzuatId);
}
