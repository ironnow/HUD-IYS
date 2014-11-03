package hud.iys.service;

import java.util.List;

import hud.iys.model.IcGenelge;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public interface IIcGenelgeService
{
   public void addIcGenelge(IcGenelge icGenelge);

   public void updateIcGenelge(IcGenelge icGenelge);

   public void deleteIcGenelge(IcGenelge icGenelge);

   public IcGenelge getIcGenelgeById(Long id);

   public List<IcGenelge> getIcGenelgeler();

   public List<IcGenelge> getIcGenelgelerByMevzuatId(Long mevzuatId);
}
