package hud.iys.service;

import java.util.List;

import hud.iys.model.OlusSirkuler;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public interface IOlusSirkulerService
{
   public void addOlusSirkuler(OlusSirkuler olusSirkuler);

   public void updateOlusSirkuler(OlusSirkuler olusSirkuler);

   public void deleteOlusSirkuler(OlusSirkuler olusSirkuler);

   public OlusSirkuler getOlusSirkulerById(Long id);

   public List<OlusSirkuler> getOlusSirkuler();

   public List<OlusSirkuler> getOlusSirkulerByMevzuatId(Long mevzuatId);
}
