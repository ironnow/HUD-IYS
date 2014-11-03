package hud.iys.dao;

import java.util.List;

import hud.iys.model.Khk;

import org.hibernate.SessionFactory;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public class KhkDAO implements IKhkDAO
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
   public void addKhk(final Khk khk)
   {
      getSessionFactory().getCurrentSession().save(khk);
   }

   @Override
   public void deleteKhk(final Khk khk)
   {
      getSessionFactory().getCurrentSession().delete(khk);
   }

   @Override
   public void updateKhk(final Khk khk)
   {
      getSessionFactory().getCurrentSession().update(khk);
   }

   @Override
   public Khk getKhkById(final Long id)
   {
      List list =
            getSessionFactory().getCurrentSession().createQuery("from Khk where id=?")
            .setParameter(0, id).list();
      return (Khk) list.get(0);
   }

   @Override
   public List<Khk> getKhklar()
   {
      List list = getSessionFactory().getCurrentSession().createQuery("from Khk").list();
      return list;
   }

   @Override
   public List<Khk> getKhklarByMevzuatId(final Long mevzuatId)
   {
      List list =
            getSessionFactory().getCurrentSession()
                  .createQuery("from Khk where MevzuatId=?").setParameter(0, mevzuatId)
            .list();
      return list;
   }

}
