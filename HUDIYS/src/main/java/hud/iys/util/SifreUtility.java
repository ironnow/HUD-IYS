package hud.iys.util;

import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 29, 2014 @time 9:19:06 PM
 */
public class SifreUtility
{

   public static String encrypt(final String plaintext)
   {
      try
      {
         MessageDigest md = MessageDigest.getInstance("SHA");
         md.update("HUD".getBytes("UTF-8"));
         md.update(plaintext.getBytes("UTF-8"));
         md.update("HUD".getBytes("UTF-8"));
         byte[] raw = md.digest();
         String hash = DatatypeConverter.printBase64Binary(raw);
         return hash;
      }
      catch (Exception e)
      {
         e.printStackTrace();
         return "";
      }
   }
}
