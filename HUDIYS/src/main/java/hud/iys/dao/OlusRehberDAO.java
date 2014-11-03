package hud.iys.dao;

import java.util.List;

import hud.iys.model.OlusRehber;

import org.hibernate.SessionFactory;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public class OlusRehberDAO implements IOlusRehberDAO
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
   public void addOlusRehber(final OlusRehber OlusRehber)
   {
      getSessionFactory().getCurrentSession().save(OlusRehber);
   }

   @Override
   public void deleteOlusRehber(final OlusRehber OlusRehber)
   {
      getSessionFactory().getCurrentSession().delete(OlusRehber);
   }

   @Override
   public void updateOlusRehber(final OlusRehber OlusRehber)
   {
      getSessionFactory().getCurrentSession().update(OlusRehber);
   }

   @Override
   public OlusRehber getOlusRehberById(final Long id)
   {
      List list =
            getSessionFactory().getCurrentSession()
                  .createQuery("from OlusRehber where OlusRehberId=?")
                  .setParameter(0, id).list();
      return (OlusRehber) list.get(0);
   }

   @Override
   public List<OlusRehber> getOlusRehberler()
   {
      List list =
            getSessionFactory().getCurrentSession().createQuery("from OlusRehber").list();
      return list;
   }

   @Override
   public List<OlusRehber> getOlusRehberlerByMevzuatId(final Long mevzuatId)
   {
      List list =
            getSessionFactory().getCurrentSession()
                  .createQuery("from OlusRehber where MevzuatId=?")
                  .setParameter(0, mevzuatId).list();
      return list;
   }

}
