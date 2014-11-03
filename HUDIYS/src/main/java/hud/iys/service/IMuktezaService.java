package hud.iys.service;

import java.util.List;

import hud.iys.model.Mukteza;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public interface IMuktezaService
{
   public void addMukteza(Mukteza mukteza);

   public void updateMukteza(Mukteza mukteza);

   public void deleteMukteza(Mukteza mukteza);

   public Mukteza getMuktezaById(Long id);

   public List<Mukteza> getMuktezalar();

   public List<Mukteza> getMuktezalarByMevzuatId(Long mevzuatId);
}
