package hud.iys.service;

import java.util.List;

import hud.iys.dao.IMuktezaDAO;
import hud.iys.model.Mukteza;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class MuktezaService implements IMuktezaService
{

   // UserDAO is injected...
   IMuktezaDAO MuktezaDAO;

   @Transactional(readOnly = false)
   @Override
   public void addMukteza(final Mukteza Mukteza)
   {
      getMuktezaDAO().addMukteza(Mukteza);
   }

   @Transactional(readOnly = false)
   @Override
   public void deleteMukteza(final Mukteza Mukteza)
   {
      getMuktezaDAO().deleteMukteza(Mukteza);
   }

   @Transactional(readOnly = false)
   @Override
   public void updateMukteza(final Mukteza Mukteza)
   {
      getMuktezaDAO().updateMukteza(Mukteza);
   }

   @Override
   public Mukteza getMuktezaById(final Long id)
   {
      return getMuktezaDAO().getMuktezaById(id);
   }

   @Override
   public List<Mukteza> getMuktezalar()
   {
      return getMuktezaDAO().getMuktezalar();
   }

   @Override
   public List<Mukteza> getMuktezalarByMevzuatId(final Long mevzuatId)
   {
      return getMuktezaDAO().getMuktezalarByMevzuatId(mevzuatId);
   }

   public IMuktezaDAO getMuktezaDAO()
   {
      return MuktezaDAO;
   }

   public void setMuktezaDAO(final IMuktezaDAO MuktezaDAO)
   {
      this.MuktezaDAO = MuktezaDAO;
   }
}