package hud.iys.dao;

import java.util.List;

import hud.iys.model.Cvoa;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public interface ICvoaDAO
{
   public void addCvoa(Cvoa cvoa);

   public void updateCvoa(Cvoa cvoa);

   public void deleteCvoa(Cvoa cvoa);

   public Cvoa getCvoaById(Long id);

   public List<Cvoa> getCvoalar();

   public List<Cvoa> getCvoalarByMevzuatId(Long mevzuatId);
}
