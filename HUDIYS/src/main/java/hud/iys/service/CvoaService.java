package hud.iys.service;

import java.util.List;

import hud.iys.dao.ICvoaDAO;
import hud.iys.model.Cvoa;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class CvoaService implements ICvoaService
{

   // UserDAO is injected...
   ICvoaDAO CvoaDAO;

   @Transactional(readOnly = false)
   @Override
   public void addCvoa(final Cvoa cvoa)
   {
      getCvoaDAO().addCvoa(cvoa);
   }

   @Transactional(readOnly = false)
   @Override
   public void deleteCvoa(final Cvoa cvoa)
   {
      getCvoaDAO().deleteCvoa(cvoa);
   }

   @Transactional(readOnly = false)
   @Override
   public void updateCvoa(final Cvoa cvoa)
   {
      getCvoaDAO().updateCvoa(cvoa);
   }

   @Override
   public Cvoa getCvoaById(final Long id)
   {
      return getCvoaDAO().getCvoaById(id);
   }

   @Override
   public List<Cvoa> getCvoalar()
   {
      return getCvoaDAO().getCvoalar();
   }

   @Override
   public List<Cvoa> getCvoalarByMevzuatId(final Long mevzuatId)
   {
      return getCvoaDAO().getCvoalarByMevzuatId(mevzuatId);
   }

   public ICvoaDAO getCvoaDAO()
   {
      return CvoaDAO;
   }

   public void setCvoaDAO(final ICvoaDAO CvoaDAO)
   {
      this.CvoaDAO = CvoaDAO;
   }
}