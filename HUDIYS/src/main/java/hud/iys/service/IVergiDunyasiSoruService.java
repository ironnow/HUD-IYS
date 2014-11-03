package hud.iys.service;

import java.util.List;

import hud.iys.model.VergiDunyasiSoru;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public interface IVergiDunyasiSoruService
{
   public void addVergiDunyasiSoru(VergiDunyasiSoru vergiDunyasiSoru);

   public void updateVergiDunyasiSoru(VergiDunyasiSoru vergiDunyasiSoru);

   public void deleteVergiDunyasiSoru(VergiDunyasiSoru vergiDunyasiSoru);

   public VergiDunyasiSoru getVergiDunyasiSoruById(Long id);

   public List<VergiDunyasiSoru> getVergiDunyasiSorulari();

   public List<VergiDunyasiSoru> getVergiDunyasiSorulariByMevzuatId(Long mevzuatId);
}
