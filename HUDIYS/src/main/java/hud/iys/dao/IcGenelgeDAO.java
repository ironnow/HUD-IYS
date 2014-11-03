package hud.iys.dao;

import java.util.List;

import hud.iys.model.IcGenelge;

import org.hibernate.SessionFactory;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public class IcGenelgeDAO implements IIcGenelgeDAO
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
   public void addIcGenelge(final IcGenelge IcGenelge)
   {
      getSessionFactory().getCurrentSession().save(IcGenelge);
   }

   @Override
   public void deleteIcGenelge(final IcGenelge IcGenelge)
   {
      getSessionFactory().getCurrentSession().delete(IcGenelge);
   }

   @Override
   public void updateIcGenelge(final IcGenelge IcGenelge)
   {
      getSessionFactory().getCurrentSession().update(IcGenelge);
   }

   @Override
   public IcGenelge getIcGenelgeById(final Long id)
   {
      List list =
            getSessionFactory().getCurrentSession()
                  .createQuery("from IcGenelge where id=?").setParameter(0, id).list();
      return (IcGenelge) list.get(0);
   }

   @Override
   public List<IcGenelge> getIcGenelgeler()
   {
      List list =
            getSessionFactory().getCurrentSession().createQuery("from IcGenelge").list();
      return list;
   }

   @Override
   public List<IcGenelge> getIcGenelgelerByMevzuatId(final Long mevzuatId)
   {
      List list =
            getSessionFactory().getCurrentSession()
            .createQuery("from IcGenelge where MevzuatId=?")
                  .setParameter(0, mevzuatId).list();
      return list;
   }

}
