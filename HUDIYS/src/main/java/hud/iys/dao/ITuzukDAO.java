package hud.iys.dao;

import java.util.List;

import hud.iys.model.Tuzuk;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public interface ITuzukDAO
{
   public void addTuzuk(Tuzuk tuzuk);

   public void updateTuzuk(Tuzuk tuzuk);

   public void deleteTuzuk(Tuzuk tuzuk);

   public Tuzuk getTuzukById(Long id);

   public List<Tuzuk> getTuzukler();

   public List<Tuzuk> getTuzuklerByMevzuatId(Long mevzuatId);
}
