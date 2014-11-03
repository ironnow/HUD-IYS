package hud.iys.dao;

import java.util.List;

import hud.iys.model.Gerekce;

import org.hibernate.SessionFactory;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public class GerekceDAO implements IGerekceDAO
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
   public void addGerekce(final Gerekce gerekce)
   {
      getSessionFactory().getCurrentSession().save(gerekce);
   }

   @Override
   public void deleteGerekce(final Gerekce gerekce)
   {
      getSessionFactory().getCurrentSession().delete(gerekce);
   }

   @Override
   public void updateGerekce(final Gerekce gerekce)
   {
      getSessionFactory().getCurrentSession().update(gerekce);
   }

   @Override
   public Gerekce getGerekceById(final Long id)
   {
      List list =
            getSessionFactory().getCurrentSession()
            .createQuery("from Gerekce where id=?").setParameter(0, id).list();
      return (Gerekce) list.get(0);
   }

   @Override
   public List<Gerekce> getGerekceler()
   {
      List list =
            getSessionFactory().getCurrentSession().createQuery("from Gerekce").list();
      return list;
   }

   @Override
   public List<Gerekce> getGerekcelerByMevzuatId(final Long mevzuatId)
   {
      List list =
            getSessionFactory().getCurrentSession()
            .createQuery("from Gerekce where MevzuatId=?")
            .setParameter(0, mevzuatId).list();
      return list;
   }

}
