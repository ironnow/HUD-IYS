package hud.iys.service;

import java.util.List;

import hud.iys.model.Sirkuler;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public interface ISirkulerService
{
   public void addSirkuler(Sirkuler sirkuler);

   public void updateSirkuler(Sirkuler sirkuler);

   public void deleteSirkuler(Sirkuler sirkuler);

   public Sirkuler getSirkulerById(Long id);

   public List<Sirkuler> getSirkulerler();

   public List<Sirkuler> getSirkulerlerByMevzuatId(Long mevzuatId);
}
