package hud.iys.dao;

import java.util.List;

import hud.iys.model.Makale;

import org.hibernate.SessionFactory;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public class MakaleDAO implements IMakaleDAO
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
   public void addMakale(final Makale Makale)
   {
      getSessionFactory().getCurrentSession().save(Makale);
   }

   @Override
   public void deleteMakale(final Makale Makale)
   {
      getSessionFactory().getCurrentSession().delete(Makale);
   }

   @Override
   public void updateMakale(final Makale Makale)
   {
      getSessionFactory().getCurrentSession().update(Makale);
   }

   @Override
   public Makale getMakaleById(final Long id)
   {
      List list =
            getSessionFactory().getCurrentSession()
            .createQuery("from Makale where MakaleId=?").setParameter(0, id).list();
      return (Makale) list.get(0);
   }

   @Override
   public List<Makale> getMakaleler()
   {
      List list =
            getSessionFactory().getCurrentSession().createQuery("from Makale").list();
      return list;
   }

   @Override
   public List<Makale> getMakalelerByMevzuatId(final Long mevzuatId)
   {
      List list =
            getSessionFactory().getCurrentSession()
            .createQuery("from Makale where MevzuatId=?")
            .setParameter(0, mevzuatId).list();
      return list;
   }

}
