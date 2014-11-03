package hud.iys.dao;

import java.util.List;

import hud.iys.model.Bkk;

import org.hibernate.SessionFactory;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public class BkkDAO implements IBkkDAO
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
   public void addBkk(final Bkk bkk)
   {
      getSessionFactory().getCurrentSession().save(bkk);
   }

   @Override
   public void deleteBkk(final Bkk bkk)
   {
      getSessionFactory().getCurrentSession().delete(bkk);
   }

   @Override
   public void updateBkk(final Bkk bkk)
   {
      getSessionFactory().getCurrentSession().update(bkk);
   }

   @Override
   public Bkk getBkkById(final Long id)
   {
      List list =
            getSessionFactory().getCurrentSession().createQuery("from Bkk where id=?")
            .setParameter(0, id).list();
      return (Bkk) list.get(0);
   }

   @Override
   public List<Bkk> getBkklar()
   {
      List list = getSessionFactory().getCurrentSession().createQuery("from Bkk").list();
      return list;
   }

   @Override
   public List<Bkk> getBkklarByMevzuatId(final Long mevzuatId)
   {
      List list =
            getSessionFactory().getCurrentSession()
                  .createQuery("from Bkk where MevzuatId=?").setParameter(0, mevzuatId)
            .list();
      return list;
   }

}
