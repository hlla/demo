package com.tencent.mm.sandbox.monitor;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.b.a;
import com.tencent.mm.sandbox.updater.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

public abstract class c
  implements com.tencent.mm.sandbox.b
{
  public static final String uoj;
  public int uok;
  public int uol;
  public int uom;
  public String uon;
  private boolean uoo;
  
  static
  {
    GMTrace.i(3603209125888L, 26846);
    uoj = com.tencent.mm.compatible.util.e.hgk;
    GMTrace.o(3603209125888L, 26846);
  }
  
  public c(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    GMTrace.i(3602269601792L, 26839);
    this.uoo = false;
    this.uol = paramInt1;
    this.uon = paramString;
    this.uok = paramInt2;
    this.uoo = paramBoolean;
    this.uom = com.tencent.mm.a.e.aN(aLu());
    paramString = new File(uoj);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    v.d("MM.GetUpdatePack", "NetSceneGetUpdatePack : temp path = " + aLu() + " packOffset = " + this.uom);
    GMTrace.o(3602269601792L, 26839);
  }
  
  public static String DC(String paramString)
  {
    GMTrace.i(3602940690432L, 26844);
    String str1 = uoj + paramString + ".temp";
    String str4 = uoj + paramString + ".apk";
    if ((com.tencent.mm.a.e.aO(str1)) && ((a.ba(str1)) || (paramString.equalsIgnoreCase(com.tencent.mm.a.g.aV(str1)))))
    {
      com.tencent.mm.a.e.h(uoj, paramString + ".temp", paramString + ".apk");
      GMTrace.o(3602940690432L, 26844);
      return str4;
    }
    if (com.tencent.mm.a.e.aO(str4))
    {
      if (a.ba(str4))
      {
        v.i("MM.GetUpdatePack", "summertoken getReadyPack checkApkMd5 update pack ok");
        GMTrace.o(3602940690432L, 26844);
        return str4;
      }
      for (;;)
      {
        try
        {
          str1 = com.tencent.mm.b.c.h(new File(str4));
          String str2 = str1;
          v.w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + localException1.getMessage());
        }
        catch (Exception localException1)
        {
          try
          {
            if (bf.mA(str1))
            {
              com.tencent.mm.plugin.report.service.g.oSF.a(322L, 10L, 1L, false);
              com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(4010) });
              str2 = str1;
            }
            v.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", new Object[] { str2 });
            if (!bf.mA(str2)) {
              break;
            }
            if (!paramString.equalsIgnoreCase(com.tencent.mm.a.g.aV(str4))) {
              break label471;
            }
            v.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
            GMTrace.o(3602940690432L, 26844);
            return str4;
          }
          catch (Exception localException2)
          {
            String str3;
            for (;;) {}
          }
          localException1 = localException1;
          str1 = null;
        }
        com.tencent.mm.plugin.report.service.g.oSF.a(322L, 9L, 1L, false);
        com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(4009), localException1.getMessage() });
        str3 = str1;
      }
      paramString = i.bHO();
      v.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", new Object[] { str3, paramString });
      if (str3.equals(paramString))
      {
        v.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
        GMTrace.o(3602940690432L, 26844);
        return str4;
      }
      v.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
      com.tencent.mm.plugin.report.service.g.oSF.a(322L, 11L, 1L, false);
      com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(4011), String.format("%s,%s", new Object[] { paramString, str3 }) });
      label471:
      v.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
      com.tencent.mm.loader.stub.b.deleteFile(str4);
    }
    GMTrace.o(3602940690432L, 26844);
    return null;
  }
  
  public static boolean OV(String paramString)
  {
    GMTrace.i(3602806472704L, 26843);
    if (com.tencent.mm.a.e.aO(uoj + paramString + ".temp"))
    {
      GMTrace.o(3602806472704L, 26843);
      return true;
    }
    GMTrace.o(3602806472704L, 26843);
    return false;
  }
  
  public String aLu()
  {
    GMTrace.i(3602403819520L, 26840);
    String str = uoj + this.uon + ".temp";
    GMTrace.o(3602403819520L, 26840);
    return str;
  }
  
  public String bHC()
  {
    GMTrace.i(3602538037248L, 26841);
    String str = uoj + this.uon + ".apk";
    GMTrace.o(3602538037248L, 26841);
    return str;
  }
  
  public final boolean bHD()
  {
    GMTrace.i(3603074908160L, 26845);
    if (this.uoo)
    {
      if (!al.isWifi(aa.getContext()))
      {
        GMTrace.o(3603074908160L, 26845);
        return true;
      }
      GMTrace.o(3603074908160L, 26845);
      return false;
    }
    GMTrace.o(3603074908160L, 26845);
    return false;
  }
  
  public final void deleteTempFile()
  {
    GMTrace.i(3602672254976L, 26842);
    try
    {
      v.d("MM.GetUpdatePack", "deleteTempFile");
      File localFile = new File(aLu());
      if (localFile.exists()) {
        localFile.delete();
      }
      GMTrace.o(3602672254976L, 26842);
      return;
    }
    catch (Exception localException)
    {
      v.e("MM.GetUpdatePack", "error in deleteTempFile");
      GMTrace.o(3602672254976L, 26842);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sandbox/monitor/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */