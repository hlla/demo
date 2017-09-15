package com.tencent.mm.u;

import android.graphics.BitmapFactory.Options;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class m
{
  public static void a(int paramInt, Map<String, String> paramMap)
  {
    GMTrace.i(13285541806080L, 98985);
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append(String.format(Locale.US, "%s\n%s\n", new Object[] { localEntry.getKey(), localEntry.getValue() }));
    }
    com.tencent.mm.kernel.h.vJ();
    if (com.tencent.mm.kernel.h.vI() != null)
    {
      com.tencent.mm.kernel.h.vJ();
      if (com.tencent.mm.kernel.h.vI().vr() != null)
      {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vI().vr().set(327682, localStringBuilder.toString());
      }
    }
    GMTrace.o(13285541806080L, 98985);
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    GMTrace.i(13285407588352L, 98984);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      v.e("MicroMsg.ConfigStorageLogic", "canSendRawImage, invalid argument");
      GMTrace.o(13285407588352L, 98984);
      return false;
    }
    if ((paramString2 != null) && (paramString2.length() > 0) && ((x.QL(paramString2)) || (x.QN(paramString2))))
    {
      GMTrace.o(13285407588352L, 98984);
      return false;
    }
    paramString2 = new BitmapFactory.Options();
    int i;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      v.e("MicroMsg.ConfigStorageLogic", "isSmallImg, invalid argument");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label220;
      }
      v.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true. isSmallImg");
      GMTrace.o(13285407588352L, 98984);
      return true;
      if (com.tencent.mm.a.e.aN(paramString1) < 65536)
      {
        i = 1;
      }
      else
      {
        paramString2.inJustDecodeBounds = true;
        MMBitmapFactory.decodeFile(paramString1, paramString2, null, 0, new int[0]);
        d1 = paramString2.outWidth;
        d2 = paramString2.outHeight;
        if ((d1 >= 100.0D) || (d2 >= 100.0D)) {
          break;
        }
        v.i("MicroMsg.ConfigStorageLogic", "isSmallImg : true, width = " + d1 + ", height = " + d2);
        i = 1;
      }
    }
    label220:
    double d1 = paramString2.outWidth;
    double d2 = paramString2.outHeight;
    if ((d1 / d2 >= 2.5D) || (d2 / d1 >= 2.5D))
    {
      i = com.tencent.mm.a.e.aN(paramString1);
      if (i < 26214400)
      {
        v.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true, width height ratio > %s, imgSize:[%s]", new Object[] { Double.valueOf(2.5D), Integer.valueOf(i) });
        GMTrace.o(13285407588352L, 98984);
        return true;
      }
      v.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : false, width height ratio > %s, imgSize:[%s]", new Object[] { Double.valueOf(2.5D), Integer.valueOf(i) });
      GMTrace.o(13285407588352L, 98984);
      return false;
    }
    if (!paramBoolean)
    {
      GMTrace.o(13285407588352L, 98984);
      return true;
    }
    GMTrace.o(13285407588352L, 98984);
    return false;
  }
  
  public static void b(int paramInt, Map<String, String> paramMap)
  {
    GMTrace.i(13285676023808L, 98986);
    paramMap.clear();
    com.tencent.mm.kernel.h.vJ();
    if (com.tencent.mm.kernel.h.vI() != null)
    {
      com.tencent.mm.kernel.h.vJ();
      if (com.tencent.mm.kernel.h.vI().vr() != null) {}
    }
    else
    {
      v.d("MicroMsg.ConfigStorageLogic", "acc stg is null");
      GMTrace.o(13285676023808L, 98986);
      return;
    }
    com.tencent.mm.kernel.h.vJ();
    Object localObject = (String)com.tencent.mm.kernel.h.vI().vr().get(327682, null);
    if (localObject == null)
    {
      GMTrace.o(13285676023808L, 98986);
      return;
    }
    localObject = ((String)localObject).split("\n");
    if (localObject.length % 2 != 0)
    {
      v.e("MicroMsg.ConfigStorageLogic", "key and value not match, len: " + String.valueOf(localObject.length));
      GMTrace.o(13285676023808L, 98986);
      return;
    }
    paramInt = 0;
    while (paramInt < localObject.length)
    {
      paramMap.put(localObject[paramInt], localObject[(paramInt + 1)]);
      paramInt += 2;
    }
    GMTrace.o(13285676023808L, 98986);
  }
  
  public static boolean eH(String paramString)
  {
    GMTrace.i(13280038879232L, 98944);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(13280038879232L, 98944);
      return false;
    }
    String str = xL();
    if ((str == null) || (str.length() <= 0))
    {
      v.e("MicroMsg.ConfigStorageLogic", "get userinfo fail");
      GMTrace.o(13280038879232L, 98944);
      return false;
    }
    boolean bool = str.equals(paramString);
    GMTrace.o(13280038879232L, 98944);
    return bool;
  }
  
  public static boolean eV(int paramInt)
  {
    GMTrace.i(13281515274240L, 98955);
    if ((paramInt & 0x2000) != 0)
    {
      GMTrace.o(13281515274240L, 98955);
      return true;
    }
    GMTrace.o(13281515274240L, 98955);
    return false;
  }
  
  public static String getUserBindEmail()
  {
    GMTrace.i(13280307314688L, 98946);
    com.tencent.mm.kernel.h.vJ();
    String str = bf.mz((String)com.tencent.mm.kernel.h.vI().vr().get(5, null));
    GMTrace.o(13280307314688L, 98946);
    return str;
  }
  
  public static e.b m(int paramInt, String paramString)
  {
    GMTrace.i(13285139152896L, 98982);
    switch (paramInt)
    {
    default: 
      paramString = null;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ().b(paramString);
      GMTrace.o(13285139152896L, 98982);
      return paramString;
      paramString = new com.tencent.mm.ao.m(paramString, 2);
      continue;
      paramString = new com.tencent.mm.ao.m(paramString, 1);
    }
  }
  
  public static int xK()
  {
    GMTrace.i(13280173096960L, 98945);
    com.tencent.mm.kernel.h.vJ();
    Integer localInteger = (Integer)com.tencent.mm.kernel.h.vI().vr().get(9, null);
    if (localInteger == null)
    {
      GMTrace.o(13280173096960L, 98945);
      return 0;
    }
    int i = localInteger.intValue();
    GMTrace.o(13280173096960L, 98945);
    return i;
  }
  
  public static String xL()
  {
    GMTrace.i(13280441532416L, 98947);
    com.tencent.mm.kernel.h.vJ();
    String str = (String)com.tencent.mm.kernel.h.vI().vr().get(2, null);
    GMTrace.o(13280441532416L, 98947);
    return str;
  }
  
  public static String xM()
  {
    GMTrace.i(13280575750144L, 98948);
    com.tencent.mm.kernel.h.vJ();
    String str = (String)com.tencent.mm.kernel.h.vI().vr().get(42, null);
    GMTrace.o(13280575750144L, 98948);
    return str;
  }
  
  public static String xN()
  {
    GMTrace.i(13280709967872L, 98949);
    com.tencent.mm.kernel.h.vJ();
    String str = (String)com.tencent.mm.kernel.h.vI().vr().get(4, null);
    GMTrace.o(13280709967872L, 98949);
    return str;
  }
  
  public static String xO()
  {
    GMTrace.i(13280844185600L, 98950);
    String str = xM();
    if (!bf.mA(str))
    {
      GMTrace.o(13280844185600L, 98950);
      return str;
    }
    str = xL();
    GMTrace.o(13280844185600L, 98950);
    return str;
  }
  
  public static int xP()
  {
    GMTrace.i(13280978403328L, 98951);
    com.tencent.mm.kernel.h.vJ();
    Integer localInteger = (Integer)com.tencent.mm.kernel.h.vI().vr().get(7, null);
    if (localInteger == null)
    {
      GMTrace.o(13280978403328L, 98951);
      return 0;
    }
    int i = localInteger.intValue();
    GMTrace.o(13280978403328L, 98951);
    return i;
  }
  
  public static long xQ()
  {
    GMTrace.i(13281112621056L, 98952);
    com.tencent.mm.kernel.h.vJ();
    Long localLong = (Long)com.tencent.mm.kernel.h.vI().vr().get(147457, null);
    if (localLong == null)
    {
      GMTrace.o(13281112621056L, 98952);
      return 0L;
    }
    long l = localLong.longValue();
    GMTrace.o(13281112621056L, 98952);
    return l;
  }
  
  public static int xR()
  {
    GMTrace.i(13281246838784L, 98953);
    com.tencent.mm.kernel.h.vJ();
    Integer localInteger = (Integer)com.tencent.mm.kernel.h.vI().vr().get(40, null);
    if (localInteger == null)
    {
      GMTrace.o(13281246838784L, 98953);
      return 0;
    }
    int i = localInteger.intValue();
    GMTrace.o(13281246838784L, 98953);
    return i;
  }
  
  public static int xS()
  {
    GMTrace.i(13281381056512L, 98954);
    com.tencent.mm.kernel.h.vJ();
    Integer localInteger = (Integer)com.tencent.mm.kernel.h.vI().vr().get(339975, null);
    if (localInteger == null)
    {
      GMTrace.o(13281381056512L, 98954);
      return 0;
    }
    int i = localInteger.intValue();
    GMTrace.o(13281381056512L, 98954);
    return i;
  }
  
  public static boolean xT()
  {
    GMTrace.i(13281649491968L, 98956);
    if ((xR() & 0x4000) != 0)
    {
      GMTrace.o(13281649491968L, 98956);
      return true;
    }
    GMTrace.o(13281649491968L, 98956);
    return false;
  }
  
  public static boolean xU()
  {
    GMTrace.i(13281783709696L, 98957);
    if ((xR() & 0x8000) != 0)
    {
      GMTrace.o(13281783709696L, 98957);
      return true;
    }
    GMTrace.o(13281783709696L, 98957);
    return false;
  }
  
  public static void xV()
  {
    GMTrace.i(13281917927424L, 98958);
    int i = xR();
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vI().vr().set(40, Integer.valueOf(i | 0x8000));
    GMTrace.o(13281917927424L, 98958);
  }
  
  public static int xW()
  {
    GMTrace.i(13282052145152L, 98959);
    com.tencent.mm.kernel.h.vJ();
    Integer localInteger = (Integer)com.tencent.mm.kernel.h.vI().vr().get(34, null);
    if (localInteger == null)
    {
      GMTrace.o(13282052145152L, 98959);
      return 0;
    }
    int i = localInteger.intValue();
    GMTrace.o(13282052145152L, 98959);
    return i;
  }
  
  public static boolean xX()
  {
    GMTrace.i(13282320580608L, 98961);
    if ((xP() & 0x40000) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      v.i("MicroMsg.ConfigStorageLogic", "isGooglePay: %s  User Status: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(xP()) });
      GMTrace.o(13282320580608L, 98961);
      return bool;
    }
  }
  
  public static boolean xY()
  {
    GMTrace.i(13282454798336L, 98962);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vI().vr().jV(true);
    if (xS() == 1)
    {
      GMTrace.o(13282454798336L, 98962);
      return true;
    }
    GMTrace.o(13282454798336L, 98962);
    return false;
  }
  
  public static boolean xZ()
  {
    GMTrace.i(13282589016064L, 98963);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vI().vr().jV(true);
    if (xS() == 2)
    {
      GMTrace.o(13282589016064L, 98963);
      return true;
    }
    GMTrace.o(13282589016064L, 98963);
    return false;
  }
  
  public static boolean ya()
  {
    GMTrace.i(13282723233792L, 98964);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vI().vr().jV(true);
    if (xS() == 4)
    {
      GMTrace.o(13282723233792L, 98964);
      return true;
    }
    GMTrace.o(13282723233792L, 98964);
    return false;
  }
  
  public static boolean yb()
  {
    GMTrace.i(13282857451520L, 98965);
    if ((xW() & 0x20) == 0)
    {
      GMTrace.o(13282857451520L, 98965);
      return true;
    }
    GMTrace.o(13282857451520L, 98965);
    return false;
  }
  
  public static boolean yc()
  {
    GMTrace.i(13282991669248L, 98966);
    if ((xP() & 0x1000) != 0)
    {
      GMTrace.o(13282991669248L, 98966);
      return true;
    }
    GMTrace.o(13282991669248L, 98966);
    return false;
  }
  
  public static boolean yd()
  {
    GMTrace.i(13283125886976L, 98967);
    ay localay = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wZ().AF("@t.qq.com");
    if ((localay != null) && (localay.isEnable()))
    {
      GMTrace.o(13283125886976L, 98967);
      return true;
    }
    GMTrace.o(13283125886976L, 98967);
    return false;
  }
  
  public static boolean ye()
  {
    GMTrace.i(13283260104704L, 98968);
    if ((xW() & 0x2) == 0)
    {
      GMTrace.o(13283260104704L, 98968);
      return true;
    }
    GMTrace.o(13283260104704L, 98968);
    return false;
  }
  
  public static boolean yf()
  {
    GMTrace.i(13283394322432L, 98969);
    if ((xW() & 0x10) == 0)
    {
      GMTrace.o(13283394322432L, 98969);
      return true;
    }
    GMTrace.o(13283394322432L, 98969);
    return false;
  }
  
  public static boolean yg()
  {
    GMTrace.i(13283528540160L, 98970);
    if ((xW() & 0x80) == 0)
    {
      GMTrace.o(13283528540160L, 98970);
      return true;
    }
    GMTrace.o(13283528540160L, 98970);
    return false;
  }
  
  public static boolean yh()
  {
    GMTrace.i(13283662757888L, 98971);
    com.tencent.mm.kernel.h.vJ();
    boolean bool = bf.f((Boolean)com.tencent.mm.kernel.h.vI().vr().get(8200, null));
    GMTrace.o(13283662757888L, 98971);
    return bool;
  }
  
  public static boolean yi()
  {
    GMTrace.i(13283796975616L, 98972);
    if ((xW() & 0x80000) == 0)
    {
      GMTrace.o(13283796975616L, 98972);
      return true;
    }
    GMTrace.o(13283796975616L, 98972);
    return false;
  }
  
  public static boolean yj()
  {
    GMTrace.i(13283931193344L, 98973);
    if ((xW() & 0x40000) == 0)
    {
      GMTrace.o(13283931193344L, 98973);
      return true;
    }
    GMTrace.o(13283931193344L, 98973);
    return false;
  }
  
  public static boolean yk()
  {
    GMTrace.i(13284065411072L, 98974);
    if ((xW() & 0x2000) == 0)
    {
      GMTrace.o(13284065411072L, 98974);
      return true;
    }
    GMTrace.o(13284065411072L, 98974);
    return false;
  }
  
  public static boolean yl()
  {
    GMTrace.i(13284199628800L, 98975);
    if ((xW() & 0x10000) == 0)
    {
      GMTrace.o(13284199628800L, 98975);
      return true;
    }
    GMTrace.o(13284199628800L, 98975);
    return false;
  }
  
  public static boolean ym()
  {
    GMTrace.i(13284333846528L, 98976);
    com.tencent.mm.kernel.h.vJ();
    String str = (String)com.tencent.mm.kernel.h.vI().vr().get(65825, null);
    if (bf.mA(str))
    {
      GMTrace.o(13284333846528L, 98976);
      return false;
    }
    if (str.equals("0"))
    {
      GMTrace.o(13284333846528L, 98976);
      return false;
    }
    try
    {
      long l = bf.c(Long.valueOf(bf.getLong(str, 0L)));
      if (l == 0L)
      {
        GMTrace.o(13284333846528L, 98976);
        return false;
      }
    }
    catch (Exception localException)
    {
      GMTrace.o(13284333846528L, 98976);
      return false;
    }
    GMTrace.o(13284333846528L, 98976);
    return true;
  }
  
  public static boolean yn()
  {
    GMTrace.i(13284468064256L, 98977);
    if ((xW() & 0x1) == 0)
    {
      GMTrace.o(13284468064256L, 98977);
      return true;
    }
    GMTrace.o(13284468064256L, 98977);
    return false;
  }
  
  public static boolean yo()
  {
    GMTrace.i(13284602281984L, 98978);
    if ((xP() & 0x20000) == 0)
    {
      GMTrace.o(13284602281984L, 98978);
      return true;
    }
    GMTrace.o(13284602281984L, 98978);
    return false;
  }
  
  public static int yp()
  {
    GMTrace.i(13284736499712L, 98979);
    com.tencent.mm.kernel.h.vJ();
    int i = bf.a((Integer)com.tencent.mm.kernel.h.vI().vr().get(8201, null), 22);
    GMTrace.o(13284736499712L, 98979);
    return i;
  }
  
  public static int yq()
  {
    GMTrace.i(13284870717440L, 98980);
    com.tencent.mm.kernel.h.vJ();
    int i = bf.a((Integer)com.tencent.mm.kernel.h.vI().vr().get(8208, null), 8);
    GMTrace.o(13284870717440L, 98980);
    return i;
  }
  
  public static x yr()
  {
    GMTrace.i(13285004935168L, 98981);
    x localx = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(xL());
    if ((localx != null) && ((int)localx.gTG > 0))
    {
      GMTrace.o(13285004935168L, 98981);
      return localx;
    }
    localx = new x();
    com.tencent.mm.kernel.h.vJ();
    String str1 = (String)com.tencent.mm.kernel.h.vI().vr().get(2, null);
    com.tencent.mm.kernel.h.vJ();
    String str2 = (String)com.tencent.mm.kernel.h.vI().vr().get(4, null);
    localx.setUsername(str1);
    localx.bR(str2);
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().R(localx);
    localx = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(str1);
    GMTrace.o(13285004935168L, 98981);
    return localx;
  }
  
  public static boolean ys()
  {
    GMTrace.i(13285273370624L, 98983);
    com.tencent.mm.kernel.h.vJ();
    if (new o(bf.f((Integer)com.tencent.mm.kernel.h.vI().vr().get(9, null))).longValue() != 0L)
    {
      GMTrace.o(13285273370624L, 98983);
      return true;
    }
    GMTrace.o(13285273370624L, 98983);
    return false;
  }
  
  public static Boolean yt()
  {
    GMTrace.i(13285810241536L, 98987);
    if (!com.tencent.mm.kernel.h.vG().uV())
    {
      v.e("MicroMsg.ConfigStorageLogic", "mmcore has not ready");
      GMTrace.o(13285810241536L, 98987);
      return Boolean.valueOf(false);
    }
    com.tencent.mm.kernel.h.vJ();
    String str = (String)com.tencent.mm.kernel.h.vI().vr().get(6, null);
    com.tencent.mm.kernel.h.vJ();
    if ((Boolean.valueOf(bf.f((Boolean)com.tencent.mm.kernel.h.vI().vr().get(340241, null))).booleanValue() == true) && (!bf.mA(str))) {
      if (!str.startsWith("+")) {
        break label164;
      }
    }
    label164:
    for (str = am.yS(str);; str = "86")
    {
      if (str == "86")
      {
        GMTrace.o(13285810241536L, 98987);
        return Boolean.valueOf(false);
      }
      GMTrace.o(13285810241536L, 98987);
      return Boolean.valueOf(true);
      GMTrace.o(13285810241536L, 98987);
      return Boolean.valueOf(false);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */