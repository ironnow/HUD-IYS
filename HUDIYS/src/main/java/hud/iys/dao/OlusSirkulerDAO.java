package hud.iys.dao;

import java.util.List;

import hud.iys.model.OlusSirkuler;

import org.hibernate.SessionFactory;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public class OlusSirkulerDAO implements IOlusSirkulerDAO
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
   public void addOlusSirkuler(final OlusSirkuler OlusSirkuler)
   {
      getSessionFactory().getCurrentSession().save(OlusSirkuler);
   }

   @Override
   public void deleteOlusSirkuler(final OlusSirkuler OlusSirkuler)
   {
      getSessionFactory().getCurrentSession().delete(OlusSirkuler);
   }

   @Override
   public void updateOlusSirkuler(final OlusSirkuler OlusSirkuler)
   {
      getSessionFactory().getCurrentSession().update(OlusSirkuler);
   }

   @Override
   public OlusSirkuler getOlusSirkulerById(final Long id)
   {
      List list =
            getSessionFactory().getCurrentSession()
                  .createQuery("from OlusSirkuler where OlusSirkulerId=?")
                  .setParameter(0, id).list();
      return (OlusSirkuler) list.get(0);
   }

   @Override
   public List<OlusSirkuler> getOlusSirkuler()
   {
      List list =
            getSessionFactory().getCurrentSession().createQuery("from OlusSirkuler")
                  .list();
      return list;
   }

   @Override
   public List<OlusSirkuler> getOlusSirkulerByMevzuatId(final Long mevzuatId)
   {
      List list =
            getSessionFactory().getCurrentSession()
                  .createQuery("from OlusSirkuler where MevzuatId=?")
                  .setParameter(0, mevzuatId).list();
      return list;
   }

}
