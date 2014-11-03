package hud.iys.dao;

import java.util.List;

import hud.iys.model.DanismaKomisyonuKarari;

import org.hibernate.SessionFactory;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public class DanismaKomisyonuKarariDAO implements IDanismaKomisyonuKarariDAO
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
   public void addDanismaKomisyonuKarari(
         final DanismaKomisyonuKarari DanismaKomisyonuKarari)
   {
      getSessionFactory().getCurrentSession().save(DanismaKomisyonuKarari);
   }

   @Override
   public void deleteDanismaKomisyonuKarari(
         final DanismaKomisyonuKarari DanismaKomisyonuKarari)
   {
      getSessionFactory().getCurrentSession().delete(DanismaKomisyonuKarari);
   }

   @Override
   public void updateDanismaKomisyonuKarari(
         final DanismaKomisyonuKarari DanismaKomisyonuKarari)
   {
      getSessionFactory().getCurrentSession().update(DanismaKomisyonuKarari);
   }

   @Override
   public DanismaKomisyonuKarari getDanismaKomisyonuKarariById(final Long id)
   {
      List list =
            getSessionFactory()
                  .getCurrentSession()
                  .createQuery(
                        "from DanismaKomisyonuKarari where DanismaKomisyonuKarariId=?")
            .setParameter(0, id).list();
      return (DanismaKomisyonuKarari) list.get(0);
   }

   @Override
   public List<DanismaKomisyonuKarari> getDanismaKomisyonuKararlari()
   {
      List list =
            getSessionFactory().getCurrentSession()
                  .createQuery("from DanismaKomisyonuKarari").list();
      return list;
   }

   @Override
   public List<DanismaKomisyonuKarari> getDanismaKomisyonuKararlariByMevzuatId(
         final Long mevzuatId)
   {
      List list =
            getSessionFactory().getCurrentSession()
                  .createQuery("from DanismaKomisyonuKarari where MevzuatId=?")
                  .setParameter(0, mevzuatId).list();
      return list;
   }

}
