package com.tencent.mm.modelcontrol;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.b;
import com.tencent.mm.u.l;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class c
  implements am
{
  public c()
  {
    GMTrace.i(4109075742720L, 30615);
    GMTrace.o(4109075742720L, 30615);
  }
  
  public static c Es()
  {
    try
    {
      GMTrace.i(4109209960448L, 30616);
      c localc = (c)l.o(c.class);
      GMTrace.o(4109209960448L, 30616);
      return localc;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static boolean Et()
  {
    GMTrace.i(4109478395904L, 30618);
    Object localObject = ((a)h.h(a.class)).sV().getValue("C2CImgNotAutoDownloadTimeRange");
    v.i("MicroMsg.BusyTimeControlLogic", "C2CImgNotAutoDownloadTimeRange value: " + (String)localObject);
    if (b.iU((String)localObject))
    {
      v.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C image.");
      GMTrace.o(4109478395904L, 30618);
      return false;
    }
    int i = bf.getInt(((a)h.h(a.class)).sV().getValue("ChatImgAutoDownload"), 1);
    if (i == 3)
    {
      v.i("MicroMsg.SubCoreAutoDownload", "settings is not auto download C2C image. ChatImgAutoDownload : " + i);
      GMTrace.o(4109478395904L, 30618);
      return false;
    }
    localObject = aa.getContext();
    if ((i == 2) && (al.isWifi((Context)localObject)))
    {
      v.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
      GMTrace.o(4109478395904L, 30618);
      return true;
    }
    if ((i == 1) && (al.isWifi((Context)localObject)))
    {
      v.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
      GMTrace.o(4109478395904L, 30618);
      return true;
    }
    long l2 = bf.getInt(((a)h.h(a.class)).sV().getValue("ChatImgAutoDownloadMax"), 0);
    long l1 = bf.a((Long)h.vI().vr().get(w.a.uyI, null), 0L);
    long l3 = bf.PY((String)DateFormat.format("M", System.currentTimeMillis()));
    long l4 = bf.a((Long)h.vI().vr().get(w.a.uyJ, null), 0L);
    v.d("MicroMsg.SubCoreAutoDownload", "currentmonth " + l3 + " month " + l4 + " maxcount " + l2 + " current " + l1 + " downloadMode: " + i);
    if (l3 != l4)
    {
      v.i("MicroMsg.SubCoreAutoDownload", "update month %d ", new Object[] { Long.valueOf(l3) });
      h.vI().vr().a(w.a.uyI, Long.valueOf(0L));
      h.vI().vr().a(w.a.uyJ, Long.valueOf(l3));
      l1 = 0L;
    }
    for (;;)
    {
      if ((l1 > l2) && (l2 > 0L))
      {
        v.i("MicroMsg.SubCoreAutoDownload", "this month had auto download " + l1 + " C2C image, can not auto download.");
        GMTrace.o(4109478395904L, 30618);
        return false;
      }
      if ((i == 1) && ((al.isWifi((Context)localObject)) || (al.is3G((Context)localObject)) || (al.is4G((Context)localObject))))
      {
        v.i("MicroMsg.SubCoreAutoDownload", "it is wifi or 3,4G now, auto download C2C image.");
        GMTrace.o(4109478395904L, 30618);
        return true;
      }
      v.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C image.");
      GMTrace.o(4109478395904L, 30618);
      return false;
    }
  }
  
  public static boolean Eu()
  {
    GMTrace.i(16420599496704L, 122343);
    String str = ((a)h.h(a.class)).sV().getValue("SnsImgPreLoadingAroundTimeLimit");
    v.i("MicroMsg.BusyTimeControlLogic", "SnsImgPreLoadingAroundTimeLimit value: " + str);
    if (b.iU(str))
    {
      v.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download SNS image.");
      GMTrace.o(16420599496704L, 122343);
      return false;
    }
    v.i("MicroMsg.SubCoreAutoDownload", "it is not busy time, can auto download SNS image.");
    GMTrace.o(16420599496704L, 122343);
    return true;
  }
  
  public static boolean a(PInt paramPInt1, PInt paramPInt2)
  {
    GMTrace.i(4109881049088L, 30621);
    paramPInt1.value = 0;
    int i = bf.getInt(((a)h.h(a.class)).sV().getValue("SIGHTAutoLoadNetwork"), 1);
    paramPInt2.value = i;
    if (i == 3)
    {
      v.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video[AD]");
      GMTrace.o(4109881049088L, 30621);
      return false;
    }
    boolean bool = al.isWifi(aa.getContext());
    if ((i == 2) && (!bool))
    {
      v.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video[AD].");
      GMTrace.o(4109881049088L, 30621);
      return false;
    }
    if (al.is2G(aa.getContext()))
    {
      v.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video[AD].");
      GMTrace.o(4109881049088L, 30621);
      return false;
    }
    paramPInt2 = ((a)h.h(a.class)).sV().getValue("SnsAdSightNotAutoDownloadTimeRange");
    v.i("MicroMsg.BusyTimeControlLogic", "isSnsAdSightNotAutoDownload value: " + paramPInt2);
    if (b.iU(paramPInt2))
    {
      v.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto(but need check again) download SNS short video[AD]");
      if (i == 2) {}
      for (i = 2;; i = 1)
      {
        paramPInt1.value = i;
        GMTrace.o(4109881049088L, 30621);
        return false;
      }
    }
    v.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download[AD].");
    GMTrace.o(4109881049088L, 30621);
    return true;
  }
  
  public static boolean a(PInt paramPInt1, PInt paramPInt2, PInt paramPInt3)
  {
    GMTrace.i(4109746831360L, 30620);
    paramPInt1.value = 0;
    int i = bf.getInt(((a)h.h(a.class)).sV().getValue("SIGHTAutoLoadNetwork"), 1);
    paramPInt2.value = i;
    if (i == 3)
    {
      v.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video");
      GMTrace.o(4109746831360L, 30620);
      return false;
    }
    boolean bool = al.isWifi(aa.getContext());
    if ((i == 2) && (!bool))
    {
      v.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video.");
      GMTrace.o(4109746831360L, 30620);
      return false;
    }
    if (al.is2G(aa.getContext()))
    {
      v.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video.");
      GMTrace.o(4109746831360L, 30620);
      return false;
    }
    paramPInt2 = ((a)h.h(a.class)).sV().getValue("SnsSightNoAutoDownload");
    if (!bf.mA(paramPInt2)) {
      try
      {
        v.i("MicroMsg.SubCoreAutoDownload", "dynamicConfigValSeq " + paramPInt2);
        long l1 = bf.getLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), 0L) - ((int)b.Er() - 8) * 60L / 1000L;
        String[] arrayOfString = paramPInt2.split(",");
        long l2 = bf.getLong(arrayOfString[0], 0L);
        if ((l1 <= bf.getLong(arrayOfString[1], 0L)) && (l1 >= l2))
        {
          v.i("MicroMsg.SubCoreAutoDownload", "config settings can not auto download SNS short video");
          paramPInt3.value = 1;
          GMTrace.o(4109746831360L, 30620);
          return false;
        }
      }
      catch (Exception paramPInt3)
      {
        v.e("MicroMsg.SubCoreAutoDownload", "paser error %s msg: %s", new Object[] { paramPInt2, paramPInt3.getMessage() });
      }
    }
    paramPInt2 = ((a)h.h(a.class)).sV().getValue("SnsSightNotAutoDownloadTimeRange");
    v.i("MicroMsg.BusyTimeControlLogic", "SnsSightNotAutoDownloadTimeRange value: " + paramPInt2);
    if (b.iU(paramPInt2))
    {
      v.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download(but need check again) SNS short video");
      if (i == 2) {}
      for (i = 2;; i = 1)
      {
        paramPInt1.value = i;
        GMTrace.o(4109746831360L, 30620);
        return false;
      }
    }
    v.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download.");
    GMTrace.o(4109746831360L, 30620);
    return true;
  }
  
  public static boolean l(au paramau)
  {
    GMTrace.i(4109344178176L, 30617);
    if (paramau == null)
    {
      v.w("MicroMsg.SubCoreAutoDownload", "this message is null, can not auto download.");
      GMTrace.o(4109344178176L, 30617);
      return false;
    }
    if (!paramau.bLX())
    {
      v.w("MicroMsg.SubCoreAutoDownload", "this message is not image, please tell cash.");
      GMTrace.o(4109344178176L, 30617);
      return false;
    }
    if (!m(paramau))
    {
      v.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download C2C image.");
      GMTrace.o(4109344178176L, 30617);
      return false;
    }
    boolean bool = Et();
    GMTrace.o(4109344178176L, 30617);
    return bool;
  }
  
  public static boolean m(au paramau)
  {
    GMTrace.i(4110015266816L, 30622);
    if (paramau == null)
    {
      v.w("MicroMsg.SubCoreAutoDownload", "this message is null.");
      GMTrace.o(4110015266816L, 30622);
      return false;
    }
    paramau = ay.gm(paramau.gxv);
    if (paramau == null)
    {
      v.i("MicroMsg.SubCoreAutoDownload", "this message had no msg source.");
      GMTrace.o(4110015266816L, 30622);
      return true;
    }
    paramau = paramau.hmF;
    if (bf.mA(paramau))
    {
      v.i("MicroMsg.SubCoreAutoDownload", "this message had no not auto download time range config.");
      GMTrace.o(4110015266816L, 30622);
      return true;
    }
    if (b.iU(paramau))
    {
      v.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download. timeRange : " + paramau);
      GMTrace.o(4110015266816L, 30622);
      return false;
    }
    v.i("MicroMsg.SubCoreAutoDownload", "this message need control, but it is not the time. timeRange: " + paramau);
    GMTrace.o(4110015266816L, 30622);
    return true;
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(4110417920000L, 30625);
    GMTrace.o(4110417920000L, 30625);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(4110552137728L, 30626);
    GMTrace.o(4110552137728L, 30626);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(4110283702272L, 30624);
    GMTrace.o(4110283702272L, 30624);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(4110686355456L, 30627);
    GMTrace.o(4110686355456L, 30627);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(4110149484544L, 30623);
    GMTrace.o(4110149484544L, 30623);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelcontrol/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */