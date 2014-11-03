package hud.iys.dao;

import java.util.List;

import hud.iys.model.YargiKarari;

import org.hibernate.SessionFactory;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public class YargiKarariDAO implements IYargiKarariDAO
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
   public void addYargiKarari(final YargiKarari YargiKarari)
   {
      getSessionFactory().getCurrentSession().save(YargiKarari);
   }

   @Override
   public void deleteYargiKarari(final YargiKarari YargiKarari)
   {
      getSessionFactory().getCurrentSession().delete(YargiKarari);
   }

   @Override
   public void updateYargiKarari(final YargiKarari YargiKarari)
   {
      getSessionFactory().getCurrentSession().update(YargiKarari);
   }

   @Override
   public YargiKarari getYargiKarariById(final Long id)
   {
      List list =
            getSessionFactory().getCurrentSession()
                  .createQuery("from YargiKarari where YargiKarariId=?")
            .setParameter(0, id).list();
      return (YargiKarari) list.get(0);
   }

   @Override
   public List<YargiKarari> getYargiKararlari()
   {
      List list =
            getSessionFactory().getCurrentSession().createQuery("from YargiKarari")
                  .list();
      return list;
   }

   @Override
   public List<YargiKarari> getYargiKararlariByMevzuatId(final Long mevzuatId)
   {
      List list =
            getSessionFactory().getCurrentSession()
                  .createQuery("from YargiKarari where MevzuatId=?")
                  .setParameter(0, mevzuatId).list();
      return list;
   }

}
