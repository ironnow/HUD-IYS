package hud.iys.service;

import java.util.List;

import hud.iys.model.Khk;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public interface IKhkService
{
   public void addKhk(Khk khk);

   public void updateKhk(Khk khk);

   public void deleteKhk(Khk khk);

   public Khk getKhkById(Long id);

   public List<Khk> getKhklar();

   public List<Khk> getKhklarByMevzuatId(Long mevzuatId);
}
