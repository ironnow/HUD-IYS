package hud.iys.dao;

import java.util.List;

import hud.iys.model.Mukteza;

import org.hibernate.SessionFactory;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public class MuktezaDAO implements IMuktezaDAO
{

   private SessionFactory sessionFactory;

   public SessionFactory getSessionFactory()
   {
      return sessionFactory;
   }

   public void setSessionFactory(final SessionFactory sessionFactory)
   {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void addMukteza(final Mukteza Mukteza)
   {
      getSessionFactory().getCurrentSession().save(Mukteza);
   }

   @Override
   public void deleteMukteza(final Mukteza Mukteza)
   {
      getSessionFactory().getCurrentSession().delete(Mukteza);
   }

   @Override
   public void updateMukteza(final Mukteza Mukteza)
   {
      getSessionFactory().getCurrentSession().update(Mukteza);
   }

   @Override
   public Mukteza getMuktezaById(final Long id)
   {
      List list =
            getSessionFactory().getCurrentSession()
            .createQuery("from Mukteza where id=?").setParameter(0, id).list();
      return (Mukteza) list.get(0);
   }

   @Override
   public List<Mukteza> getMuktezalar()
   {
      List list =
            getSessionFactory().getCurrentSession().createQuery("from Mukteza").list();
      return list;
   }

   @Override
   public List<Mukteza> getMuktezalarByMevzuatId(final Long mevzuatId)
   {
      List list =
            getSessionFactory().getCurrentSession()
                  .createQuery("from Mukteza where MevzuatId=?")
            .setParameter(0, mevzuatId).list();
      return list;
   }

}
