package hud.iys.dao;

import java.util.List;

import hud.iys.model.Sirkuler;

import org.hibernate.SessionFactory;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public class SirkulerDAO implements ISirkulerDAO
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
   public void addSirkuler(final Sirkuler Sirkuler)
   {
      getSessionFactory().getCurrentSession().save(Sirkuler);
   }

   @Override
   public void deleteSirkuler(final Sirkuler Sirkuler)
   {
      getSessionFactory().getCurrentSession().delete(Sirkuler);
   }

   @Override
   public void updateSirkuler(final Sirkuler Sirkuler)
   {
      getSessionFactory().getCurrentSession().update(Sirkuler);
   }

   @Override
   public Sirkuler getSirkulerById(final Long id)
   {
      List list =
            getSessionFactory().getCurrentSession()
                  .createQuery("from Sirkuler where id=?").setParameter(0, id).list();
      return (Sirkuler) list.get(0);
   }

   @Override
   public List<Sirkuler> getSirkulerler()
   {
      List list =
            getSessionFactory().getCurrentSession().createQuery("from Sirkuler").list();
      return list;
   }

   @Override
   public List<Sirkuler> getSirkulerlerByMevzuatId(final Long mevzuatId)
   {
      List list =
            getSessionFactory().getCurrentSession()
            .createQuery("from Sirkuler where MevzuatId=?")
                  .setParameter(0, mevzuatId).list();
      return list;
   }

}
