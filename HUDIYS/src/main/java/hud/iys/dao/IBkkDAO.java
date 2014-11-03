package hud.iys.dao;

import java.util.List;

import hud.iys.model.Bkk;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public interface IBkkDAO
{
   public void addBkk(Bkk bkk);

   public void updateBkk(Bkk bkk);

   public void deleteBkk(Bkk bkk);

   public Bkk getBkkById(Long id);

   public List<Bkk> getBkklar();

   public List<Bkk> getBkklarByMevzuatId(Long mevzuatId);
}
