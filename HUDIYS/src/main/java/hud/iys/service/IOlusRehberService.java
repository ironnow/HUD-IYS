package hud.iys.service;

import java.util.List;

import hud.iys.model.OlusRehber;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public interface IOlusRehberService
{
   public void addOlusRehber(OlusRehber olusRehber);

   public void updateOlusRehber(OlusRehber olusRehber);

   public void deleteOlusRehber(OlusRehber olusRehber);

   public OlusRehber getOlusRehberById(Long id);

   public List<OlusRehber> getOlusRehberler();

   public List<OlusRehber> getOlusRehberlerByMevzuatId(Long mevzuatId);
}
