package hud.iys.dao;

import java.util.List;

import hud.iys.model.Cvoa;

import org.hibernate.SessionFactory;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public class CvoaDAO implements ICvoaDAO
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
   public void addCvoa(final Cvoa cvoa)
   {
      getSessionFactory().getCurrentSession().save(cvoa);
   }

   @Override
   public void deleteCvoa(final Cvoa cvoa)
   {
      getSessionFactory().getCurrentSession().delete(cvoa);
   }

   @Override
   public void updateCvoa(final Cvoa cvoa)
   {
      getSessionFactory().getCurrentSession().update(cvoa);
   }

   @Override
   public Cvoa getCvoaById(final Long id)
   {
      List list =
            getSessionFactory().getCurrentSession().createQuery("from Cvoa where id=?")
            .setParameter(0, id).list();
      return (Cvoa) list.get(0);
   }

   @Override
   public List<Cvoa> getCvoalar()
   {
      List list = getSessionFactory().getCurrentSession().createQuery("from Cvoa").list();
      return list;
   }

   @Override
   public List<Cvoa> getCvoalarByMevzuatId(final Long mevzuatId)
   {
      List list =
            getSessionFactory().getCurrentSession()
            .createQuery("from Cvoa where MevzuatId=?").setParameter(0, mevzuatId)
            .list();
      return list;
   }

}
