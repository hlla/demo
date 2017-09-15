package com.tencent.mm.plugin.ext.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public final class a
{
  private static char[] jNh;
  private static SecretKey lop;
  
  static
  {
    GMTrace.i(5711098544128L, 42551);
    lop = null;
    jNh = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    GMTrace.o(5711098544128L, 42551);
  }
  
  private static void aqK()
  {
    GMTrace.i(5710293237760L, 42545);
    try
    {
      if (lop == null)
      {
        ObjectInputStream localObjectInputStream = new ObjectInputStream(new ByteArrayInputStream(rN("aced00057372001f6a617661782e63727970746f2e737065632e5365637265744b6579537065635b470b66e230614d0200024c0009616c676f726974686d7400124c6a6176612f6c616e672f537472696e673b5b00036b65797400025b427870740003414553757200025b42acf317f8060854e0020000787000000010402a2173bd6f2542e5e71ee414b2e1e8")));
        lop = (SecretKey)localObjectInputStream.readObject();
        localObjectInputStream.close();
      }
      GMTrace.o(5710293237760L, 42545);
      return;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.AESUtil", localException, "", new Object[0]);
      GMTrace.o(5710293237760L, 42545);
    }
  }
  
  public static String bK(long paramLong)
  {
    GMTrace.i(5710561673216L, 42547);
    Object localObject = vv(String.valueOf(paramLong));
    if (localObject == null)
    {
      GMTrace.o(5710561673216L, 42547);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(localObject.length * 2);
    int i = 0;
    while (i < localObject.length)
    {
      localStringBuilder.append(jNh[((localObject[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(jNh[(localObject[i] & 0xF)]);
      i += 1;
    }
    localObject = localStringBuilder.toString();
    GMTrace.o(5710561673216L, 42547);
    return (String)localObject;
  }
  
  private static String rJ(String paramString)
  {
    GMTrace.i(5710695890944L, 42548);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(5710695890944L, 42548);
      return null;
    }
    aqK();
    Cipher localCipher = Cipher.getInstance("AES");
    localCipher.init(2, lop);
    paramString = new String(localCipher.doFinal(rN(paramString)), "UTF8");
    GMTrace.o(5710695890944L, 42548);
    return paramString;
  }
  
  private static byte[] rN(String paramString)
  {
    GMTrace.i(5710964326400L, 42550);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(5710964326400L, 42550);
      return null;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)Integer.parseInt(paramString.substring(i * 2, i * 2 + 2), 16));
      i += 1;
    }
    GMTrace.o(5710964326400L, 42550);
    return arrayOfByte;
  }
  
  private static byte[] vv(String paramString)
  {
    GMTrace.i(5710427455488L, 42546);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(5710427455488L, 42546);
      return null;
    }
    aqK();
    Cipher localCipher = Cipher.getInstance("AES");
    localCipher.init(1, lop);
    paramString = localCipher.doFinal(paramString.getBytes("UTF8"));
    GMTrace.o(5710427455488L, 42546);
    return paramString;
  }
  
  public static long vw(String paramString)
  {
    GMTrace.i(5710830108672L, 42549);
    long l = Long.valueOf(rJ(paramString).trim()).longValue();
    GMTrace.o(5710830108672L, 42549);
    return l;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/ext/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */