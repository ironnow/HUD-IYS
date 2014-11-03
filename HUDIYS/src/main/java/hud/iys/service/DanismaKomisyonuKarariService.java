package hud.iys.service;

import java.util.List;

import hud.iys.dao.IDanismaKomisyonuKarariDAO;
import hud.iys.model.DanismaKomisyonuKarari;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class DanismaKomisyonuKarariService implements IDanismaKomisyonuKarariService
{

   // UserDAO is injected...
   IDanismaKomisyonuKarariDAO DanismaKomisyonuKarariDAO;

   @Transactional(readOnly = false)
   @Override
   public void addDanismaKomisyonuKarari(
         final DanismaKomisyonuKarari DanismaKomisyonuKarari)
   {
      getDanismaKomisyonuKarariDAO().addDanismaKomisyonuKarari(DanismaKomisyonuKarari);
   }

   @Transactional(readOnly = false)
   @Override
   public void deleteDanismaKomisyonuKarari(
         final DanismaKomisyonuKarari DanismaKomisyonuKarari)
   {
      getDanismaKomisyonuKarariDAO().deleteDanismaKomisyonuKarari(DanismaKomisyonuKarari);
   }

   @Transactional(readOnly = false)
   @Override
   public void updateDanismaKomisyonuKarari(
         final DanismaKomisyonuKarari DanismaKomisyonuKarari)
   {
      getDanismaKomisyonuKarariDAO().updateDanismaKomisyonuKarari(DanismaKomisyonuKarari);
   }

   @Override
   public DanismaKomisyonuKarari getDanismaKomisyonuKarariById(final Long id)
   {
      return getDanismaKomisyonuKarariDAO().getDanismaKomisyonuKarariById(id);
   }

   @Override
   public List<DanismaKomisyonuKarari> getDanismaKomisyonuKararlari()
   {
      return getDanismaKomisyonuKarariDAO().getDanismaKomisyonuKararlari();
   }

   @Override
   public List<DanismaKomisyonuKarari> getDanismaKomisyonuKararlariByMevzuatId(
         final Long mevzuatId)
   {
      return getDanismaKomisyonuKarariDAO().getDanismaKomisyonuKararlariByMevzuatId(
            mevzuatId);
   }

   public IDanismaKomisyonuKarariDAO getDanismaKomisyonuKarariDAO()
   {
      return DanismaKomisyonuKarariDAO;
   }

   public void setDanismaKomisyonuKarariDAO(
         final IDanismaKomisyonuKarariDAO DanismaKomisyonuKarariDAO)
   {
      this.DanismaKomisyonuKarariDAO = DanismaKomisyonuKarariDAO;
   }
}