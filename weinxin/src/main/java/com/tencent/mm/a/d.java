package com.tencent.mm.a;

import android.util.Base64;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class d
{
  private Cipher fuE;
  private Cipher fuF;
  
  public d(String paramString)
  {
    GMTrace.i(13859591028736L, 103262);
    try
    {
      paramString = new DESKeySpec(paramString.getBytes("UTF8"));
      paramString = SecretKeyFactory.getInstance("DES").generateSecret(paramString);
      IvParameterSpec localIvParameterSpec = new IvParameterSpec("manifest".getBytes("UTF8"));
      this.fuE = Cipher.getInstance("DES/CBC/PKCS5Padding");
      this.fuE.init(1, paramString, localIvParameterSpec);
      this.fuF = Cipher.getInstance("DES/CBC/PKCS5Padding");
      this.fuF.init(2, paramString, localIvParameterSpec);
      GMTrace.o(13859591028736L, 103262);
      return;
    }
    catch (Exception paramString)
    {
      v.printErrStackTrace("MicroMsg.DESUtil", paramString, "", new Object[0]);
      GMTrace.o(13859591028736L, 103262);
    }
  }
  
  public final String aM(String paramString)
  {
    GMTrace.i(13859725246464L, 103263);
    try
    {
      Object localObject = Base64.decode(paramString, 0);
      localObject = new String(this.fuF.doFinal((byte[])localObject), "UTF8");
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramString = "[des]" + paramString + "|" + localException.toString();
      }
    }
    GMTrace.o(13859725246464L, 103263);
    return paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */