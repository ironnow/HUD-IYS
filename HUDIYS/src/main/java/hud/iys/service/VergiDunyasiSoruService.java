package hud.iys.service;

import java.util.List;

import hud.iys.dao.IVergiDunyasiSoruDAO;
import hud.iys.model.VergiDunyasiSoru;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class VergiDunyasiSoruService implements IVergiDunyasiSoruService
{

   // UserDAO is injected...
   IVergiDunyasiSoruDAO VergiDunyasiSoruDAO;

   @Transactional(readOnly = false)
   @Override
   public void addVergiDunyasiSoru(final VergiDunyasiSoru VergiDunyasiSoru)
   {
      getVergiDunyasiSoruDAO().addVergiDunyasiSoru(VergiDunyasiSoru);
   }

   @Transactional(readOnly = false)
   @Override
   public void deleteVergiDunyasiSoru(final VergiDunyasiSoru VergiDunyasiSoru)
   {
      getVergiDunyasiSoruDAO().deleteVergiDunyasiSoru(VergiDunyasiSoru);
   }

   @Transactional(readOnly = false)
   @Override
   public void updateVergiDunyasiSoru(final VergiDunyasiSoru VergiDunyasiSoru)
   {
      getVergiDunyasiSoruDAO().updateVergiDunyasiSoru(VergiDunyasiSoru);
   }

   @Override
   public VergiDunyasiSoru getVergiDunyasiSoruById(final Long id)
   {
      return getVergiDunyasiSoruDAO().getVergiDunyasiSoruById(id);
   }

   @Override
   public List<VergiDunyasiSoru> getVergiDunyasiSorulari()
   {
      return getVergiDunyasiSoruDAO().getVergiDunyasiSorulari();
   }

   @Override
   public List<VergiDunyasiSoru> getVergiDunyasiSorulariByMevzuatId(final Long mevzuatId)
   {
      return getVergiDunyasiSoruDAO().getVergiDunyasiSorulariByMevzuatId(mevzuatId);
   }

   public IVergiDunyasiSoruDAO getVergiDunyasiSoruDAO()
   {
      return VergiDunyasiSoruDAO;
   }

   public void setVergiDunyasiSoruDAO(final IVergiDunyasiSoruDAO VergiDunyasiSoruDAO)
   {
      this.VergiDunyasiSoruDAO = VergiDunyasiSoruDAO;
   }
}