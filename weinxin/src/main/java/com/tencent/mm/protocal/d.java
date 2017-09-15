package com.tencent.mm.protocal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class d
  extends e
{
  public static String DEVICE_TYPE;
  public static final String sXa;
  public static final String sXb;
  public static String sXc;
  public static final String sXd;
  public static String sXe;
  public static final String sXf;
  public static long sXg;
  public static int sXh;
  public static boolean sXi;
  public static boolean sXj;
  public static boolean sXk;
  public static boolean sXl;
  public static int sXm;
  public static final byte[] sXn;
  public static final byte[] sXo;
  public static final byte[] sXp;
  
  static
  {
    GMTrace.i(13572767744000L, 101125);
    DEVICE_TYPE = "android-" + Build.VERSION.SDK_INT;
    sXa = Build.BRAND;
    sXb = Build.MODEL + Build.CPU_ABI;
    sXc = "android-" + Build.VERSION.SDK_INT;
    sXd = "android-" + Build.MANUFACTURER;
    sXe = Build.VERSION.SDK_INT;
    sXf = Build.MANUFACTURER + "-" + Build.MODEL;
    sXg = 0L;
    sXh = Integer.decode("0x26050D33").intValue();
    try
    {
      int i = aa.getContext().getPackageManager().getApplicationInfo(aa.getPackageName(), 128).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
      if ((i > sXh) && (i - sXh < 255) && ((i & 0xFF) >= 48)) {
        sXh = i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.h("MicroMsg.ConstantsProtocal", "", new Object[] { localException });
      }
    }
    sXi = bGX();
    sXj = bGW();
    sXk = bGV();
    sXl = bGU();
    sXm = 5;
    sXn = null;
    sXo = null;
    sXp = null;
    GMTrace.o(13572767744000L, 101125);
  }
  
  private static boolean bGU()
  {
    GMTrace.i(13572230873088L, 101121);
    if (((sXh & 0xFF) >= 32) && ((sXh & 0xFF) <= 47))
    {
      GMTrace.o(13572230873088L, 101121);
      return true;
    }
    GMTrace.o(13572230873088L, 101121);
    return false;
  }
  
  private static boolean bGV()
  {
    GMTrace.i(13572365090816L, 101122);
    if (((sXh & 0xFF) >= 0) && ((sXh & 0xFF) <= 31))
    {
      GMTrace.o(13572365090816L, 101122);
      return true;
    }
    GMTrace.o(13572365090816L, 101122);
    return false;
  }
  
  private static boolean bGW()
  {
    GMTrace.i(13572499308544L, 101123);
    if (((sXh & 0xFF) >= 96) && ((sXh & 0xFF) <= 159))
    {
      GMTrace.o(13572499308544L, 101123);
      return true;
    }
    GMTrace.o(13572499308544L, 101123);
    return false;
  }
  
  private static boolean bGX()
  {
    GMTrace.i(13572633526272L, 101124);
    if (((sXh & 0xFF) >= 48) && ((sXh & 0xFF) <= 95))
    {
      GMTrace.o(13572633526272L, 101124);
      return true;
    }
    GMTrace.o(13572633526272L, 101124);
    return false;
  }
  
  public static void xR(int paramInt)
  {
    GMTrace.i(13572096655360L, 101120);
    sXh = paramInt;
    sXk = bGV();
    sXl = bGU();
    sXi = bGX();
    sXj = bGW();
    GMTrace.o(13572096655360L, 101120);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */