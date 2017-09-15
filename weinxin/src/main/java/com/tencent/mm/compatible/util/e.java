package com.tencent.mm.compatible.util;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class e
  extends a
{
  public static String gSA;
  public static String gSB;
  public static String gSC;
  public static String gSD;
  public static final String gSm;
  public static String gSn;
  public static String gSo;
  public static String gSp;
  public static String gSq;
  public static String gSr;
  public static String gSs;
  public static String gSt;
  public static String gSu;
  public static String gSv;
  public static String gSw;
  public static String gSx;
  public static String gSy;
  public static String gSz;
  
  static
  {
    GMTrace.i(13789126721536L, 102737);
    gSm = h.getExternalStorageDirectory().getParent();
    gSn = hgk + "Download/";
    gSq = hgk + "vusericon/";
    gSr = hgk + "Game/";
    gSs = hgk + "CDNTemp/";
    gSt = hgk + "Download/VoiceRemind";
    gSu = hgk + "watchdog/";
    gSv = hgk + "xlog";
    gSw = hgk + "avatar/";
    gSx = hgk + "exdevice/";
    gSy = hgk + "newyear/";
    gSz = hgk + "expose/";
    gSA = hgk + "f2flucky/";
    gSB = hgk + "WebviewCache/";
    gSC = hgk + "pattern_recognition/";
    gSD = hgk + "sniffer/";
    GMTrace.o(13789126721536L, 102737);
  }
  
  public static void dw(String paramString)
  {
    GMTrace.i(13788992503808L, 102736);
    v.i("MicroMsg.CConstants", "initSdCardPath start SDCARD_ROOT: " + hgi);
    if (bf.mA(paramString))
    {
      paramString = au.bJs();
      int j = paramString.size();
      int i = 0;
      while (i < j)
      {
        v.i("MicroMsg.CConstants", "initSdCardPath start list i = " + i + " StatMountParse: " + paramString.get(i));
        i += 1;
      }
      if (j > 1) {
        Collections.sort(paramString, new Comparator() {});
      }
      if ((j > 0) && (paramString.get(0) != null) && (!bf.mA(((au.a)paramString.get(0)).utF)))
      {
        hgi = ((au.a)paramString.get(0)).utF;
        i = 0;
        while (i < j)
        {
          v.i("MicroMsg.CConstants", "initSdCardPath end list i = " + i + " StatMountParse: " + paramString.get(i));
          i += 1;
        }
      }
    }
    else
    {
      hgi = paramString;
    }
    hgk = hgi + hgj;
    gSn = hgk + "Download/";
    gSq = hgk + "vusericon/";
    gSr = hgk + "Game/";
    gSs = hgk + "CDNTemp/";
    gSu = hgk + "watchdog/";
    gSv = hgk + "xlog";
    hgl = hgk + "crash/";
    gSw = hgk + "avatar/";
    gSo = hgk + "Cache/";
    String str = hgk + "WeChat/";
    paramString = hgk + "WeiXin/";
    if (!com.tencent.mm.a.e.aO(str)) {
      if (!com.tencent.mm.a.e.aO(paramString)) {}
    }
    for (;;)
    {
      gSp = paramString;
      v.i("MicroMsg.CConstants", "initSdCardPath end SDCARD_ROOT: " + hgi);
      GMTrace.o(13788992503808L, 102736);
      return;
      if (!u.bID().equals("zh_CN")) {
        paramString = str;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/util/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */