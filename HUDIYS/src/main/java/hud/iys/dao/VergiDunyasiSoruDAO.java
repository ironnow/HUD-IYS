package hud.iys.dao;

import java.util.List;

import hud.iys.model.VergiDunyasiSoru;

import org.hibernate.SessionFactory;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public class VergiDunyasiSoruDAO implements IVergiDunyasiSoruDAO
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
   public void addVergiDunyasiSoru(final VergiDunyasiSoru VergiDunyasiSoru)
   {
      getSessionFactory().getCurrentSession().save(VergiDunyasiSoru);
   }

   @Override
   public void deleteVergiDunyasiSoru(final VergiDunyasiSoru VergiDunyasiSoru)
   {
      getSessionFactory().getCurrentSession().delete(VergiDunyasiSoru);
   }

   @Override
   public void updateVergiDunyasiSoru(final VergiDunyasiSoru VergiDunyasiSoru)
   {
      getSessionFactory().getCurrentSession().update(VergiDunyasiSoru);
   }

   @Override
   public VergiDunyasiSoru getVergiDunyasiSoruById(final Long id)
   {
      List list =
            getSessionFactory().getCurrentSession()
            .createQuery("from VergiDunyasiSoru where VergiDunyasiSoruId=?")
                  .setParameter(0, id).list();
      return (VergiDunyasiSoru) list.get(0);
   }

   @Override
   public List<VergiDunyasiSoru> getVergiDunyasiSorulari()
   {
      List list =
            getSessionFactory().getCurrentSession().createQuery("from VergiDunyasiSoru")
            .list();
      return list;
   }

   @Override
   public List<VergiDunyasiSoru> getVergiDunyasiSorulariByMevzuatId(final Long mevzuatId)
   {
      List list =
            getSessionFactory().getCurrentSession()
            .createQuery("from VergiDunyasiSoru where MevzuatId=?")
            .setParameter(0, mevzuatId).list();
      return list;
   }

}
