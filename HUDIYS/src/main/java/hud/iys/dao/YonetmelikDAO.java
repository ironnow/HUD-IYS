package hud.iys.dao;

import java.util.List;

import hud.iys.model.Yonetmelik;

import org.hibernate.SessionFactory;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public class YonetmelikDAO implements IYonetmelikDAO
{

   private SessionFactory sessionFactory;

   public SessionFactory getSessionFactory()
   {
      return sessionFactory;
   }

   public void setSessionFactory(SessionFactory sessionFactory)
   {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void addYonetmelik(Yonetmelik Yonetmelik)
   {
      getSessionFactory().getCurrentSession().save(Yonetmelik);
   }

   @Override
   public void deleteYonetmelik(Yonetmelik Yonetmelik)
   {
      getSessionFactory().getCurrentSession().delete(Yonetmelik);
   }

   @Override
   public void updateYonetmelik(Yonetmelik Yonetmelik)
   {
      getSessionFactory().getCurrentSession().update(Yonetmelik);
   }

   @Override
   public Yonetmelik getYonetmelikById(Long id)
   {
      List list =
            getSessionFactory().getCurrentSession()
                  .createQuery("from Yonetmelik where id=?").setParameter(0, id).list();
      return (Yonetmelik) list.get(0);
   }

   @Override
   public List<Yonetmelik> getYonetmelikler()
   {
      List list =
            getSessionFactory().getCurrentSession().createQuery("from Yonetmelik").list();
      return list;
   }

   @Override
   public List<Yonetmelik> getYonetmeliklerByMevzuatId(Long mevzuatId)
   {
      List list =
            getSessionFactory().getCurrentSession()
            .createQuery("from Yonetmelik where MevzuatId=?")
                  .setParameter(0, mevzuatId).list();
      return list;
   }

}
