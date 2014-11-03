package hud.iys.dao;

import java.util.List;

import hud.iys.model.Vkbda;

import org.hibernate.SessionFactory;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public class VkbdaDAO implements IVkbdaDAO
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
   public void addVkbda(final Vkbda vkbda)
   {
      getSessionFactory().getCurrentSession().save(vkbda);
   }

   @Override
   public void deleteVkbda(final Vkbda vkbda)
   {
      getSessionFactory().getCurrentSession().delete(vkbda);
   }

   @Override
   public void updateVkbda(final Vkbda vkbda)
   {
      getSessionFactory().getCurrentSession().update(vkbda);
   }

   @Override
   public Vkbda getVkbdaById(final Long id)
   {
      List list =
            getSessionFactory().getCurrentSession().createQuery("from Vkbda where id=?")
            .setParameter(0, id).list();
      return (Vkbda) list.get(0);
   }

   @Override
   public List<Vkbda> getVkbdalar()
   {
      List list =
            getSessionFactory().getCurrentSession().createQuery("from Vkbda").list();
      return list;
   }

   @Override
   public List<Vkbda> getVkbdalarByMevzuatId(final Long mevzuatId)
   {
      List list =
            getSessionFactory().getCurrentSession()
            .createQuery("from Vkbda where MevzuatId=?").setParameter(0, mevzuatId)
            .list();
      return list;
   }

}
