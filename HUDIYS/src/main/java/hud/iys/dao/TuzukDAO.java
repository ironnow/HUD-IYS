package hud.iys.dao;

import java.util.List;

import hud.iys.model.Tuzuk;

import org.hibernate.SessionFactory;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public class TuzukDAO implements ITuzukDAO
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
   public void addTuzuk(final Tuzuk Tuzuk)
   {
      getSessionFactory().getCurrentSession().save(Tuzuk);
   }

   @Override
   public void deleteTuzuk(final Tuzuk Tuzuk)
   {
      getSessionFactory().getCurrentSession().delete(Tuzuk);
   }

   @Override
   public void updateTuzuk(final Tuzuk Tuzuk)
   {
      getSessionFactory().getCurrentSession().update(Tuzuk);
   }

   @Override
   public Tuzuk getTuzukById(final Long id)
   {
      List list =
            getSessionFactory().getCurrentSession().createQuery("from Tuzuk where id=?")
            .setParameter(0, id).list();
      return (Tuzuk) list.get(0);
   }

   @Override
   public List<Tuzuk> getTuzukler()
   {
      List list =
            getSessionFactory().getCurrentSession().createQuery("from Tuzuk").list();
      return list;
   }

   @Override
   public List<Tuzuk> getTuzuklerByMevzuatId(final Long mevzuatId)
   {
      List list =
            getSessionFactory().getCurrentSession()
                  .createQuery("from Tuzuk where MevzuatId=?").setParameter(0, mevzuatId)
            .list();
      return list;
   }

}
