package com.tencent.mm.modelcdntran;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.m;

public final class d
{
  public static int hyh;
  public static int hyi;
  public static int hyj;
  public static int hyk;
  public static int hyl;
  public static int hym;
  public static int hyn;
  public static int hyo;
  public static int hyp;
  public static int hyq;
  public static int hyr;
  public static int hys;
  public static int hyt;
  
  static
  {
    GMTrace.i(573378134016L, 4272);
    hyh = 1;
    hyi = 2;
    hyj = 3;
    hyk = -1;
    hyl = 3;
    hym = 4;
    hyn = 5;
    hyo = 1;
    hyp = 2;
    hyq = 55535;
    hyr = 55534;
    hys = 55533;
    hyt = 55532;
    GMTrace.o(573378134016L, 4272);
  }
  
  public static String a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    GMTrace.i(572975480832L, 4269);
    v.d("MicroMsg.CdnUtil", "cdntra genClientId prefix[%s] createtime:%d talker[%s] suffix:[%s] stack[%s]", new Object[] { paramString1, Long.valueOf(paramLong), paramString2, paramString3, bf.bJP() });
    if (bf.mA(iR(paramString1)))
    {
      GMTrace.o(572975480832L, 4269);
      return null;
    }
    if (bf.mA(paramString2))
    {
      GMTrace.o(572975480832L, 4269);
      return null;
    }
    if (paramLong <= 0L)
    {
      GMTrace.o(572975480832L, 4269);
      return null;
    }
    paramString3 = bf.mz(iR(paramString3));
    paramString2 = g.n((m.xL() + "-" + paramString2).getBytes());
    paramString2 = "a" + paramString1 + "_" + paramString2.substring(0, 16) + "_" + paramLong;
    paramString1 = paramString2;
    if (!bf.mA(paramString3)) {
      paramString1 = paramString2 + "_" + paramString3;
    }
    GMTrace.o(572975480832L, 4269);
    return paramString1;
  }
  
  public static void a(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    GMTrace.i(572707045376L, 4267);
    byte[] arrayOfByte = paramArrayOfByte;
    if (bf.bm(paramArrayOfByte)) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte = new String(arrayOfByte);
    if (paramInt == 4)
    {
      v.e(paramString, paramArrayOfByte);
      GMTrace.o(572707045376L, 4267);
      return;
    }
    if (paramInt == 3)
    {
      v.w(paramString, paramArrayOfByte);
      GMTrace.o(572707045376L, 4267);
      return;
    }
    if (paramInt == 2)
    {
      v.i(paramString, paramArrayOfByte);
      GMTrace.o(572707045376L, 4267);
      return;
    }
    if (paramInt == 1)
    {
      v.d(paramString, paramArrayOfByte);
      GMTrace.o(572707045376L, 4267);
      return;
    }
    if (paramInt == 0) {
      v.v(paramString, paramArrayOfByte);
    }
    GMTrace.o(572707045376L, 4267);
  }
  
  public static int aT(Context paramContext)
  {
    GMTrace.i(573109698560L, 4270);
    int i;
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        i = hyh;
        GMTrace.o(573109698560L, 4270);
        return i;
      }
      if (paramContext.getType() == 1)
      {
        i = hyj;
        GMTrace.o(573109698560L, 4270);
        return i;
      }
      if (paramContext.getSubtype() == 1)
      {
        i = hyh;
        GMTrace.o(573109698560L, 4270);
        return i;
      }
      if (paramContext.getSubtype() == 2)
      {
        i = hyh;
        GMTrace.o(573109698560L, 4270);
        return i;
      }
      if (paramContext.getSubtype() >= 3)
      {
        i = hyi;
        GMTrace.o(573109698560L, 4270);
        return i;
      }
      i = hyh;
      GMTrace.o(573109698560L, 4270);
      return i;
    }
    catch (NullPointerException paramContext)
    {
      v.e("MicroMsg.CdnUtil", "exception:%s", new Object[] { bf.g(paramContext) });
      i = hyh;
      GMTrace.o(573109698560L, 4270);
    }
    return i;
  }
  
  public static int aU(Context paramContext)
  {
    GMTrace.i(573243916288L, 4271);
    int i = al.getNetType(paramContext);
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext == null)
    {
      i = hyk;
      GMTrace.o(573243916288L, 4271);
      return i;
    }
    if (paramContext.getType() == 1)
    {
      i = hyo;
      GMTrace.o(573243916288L, 4271);
      return i;
    }
    if ((paramContext.getSubtype() == 1) || (paramContext.getSubtype() == 2))
    {
      i = hyl;
      GMTrace.o(573243916288L, 4271);
      return i;
    }
    if (paramContext.getSubtype() >= 13)
    {
      i = hyn;
      GMTrace.o(573243916288L, 4271);
      return i;
    }
    if (paramContext.getSubtype() >= 3)
    {
      i = hym;
      GMTrace.o(573243916288L, 4271);
      return i;
    }
    if (al.isWap(i))
    {
      i = hyp;
      GMTrace.o(573243916288L, 4271);
      return i;
    }
    i = hyl;
    GMTrace.o(573243916288L, 4271);
    return i;
  }
  
  private static String iR(String paramString)
  {
    GMTrace.i(572841263104L, 4268);
    if (!bf.mA(paramString))
    {
      int i = 0;
      while (i < paramString.length())
      {
        char c = paramString.charAt(i);
        if ((!bf.j(c)) && (!bf.k(c)))
        {
          GMTrace.o(572841263104L, 4268);
          return null;
        }
        i += 1;
      }
    }
    GMTrace.o(572841263104L, 4268);
    return paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelcdntran/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */