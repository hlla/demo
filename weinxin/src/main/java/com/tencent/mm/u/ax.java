package com.tencent.mm.u;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.a.g;
import java.util.ArrayList;
import java.util.List;

public class ax
{
  private static ax hmi;
  public b hmh;
  
  private ax()
  {
    GMTrace.i(687865856000L, 5125);
    GMTrace.o(687865856000L, 5125);
  }
  
  private static boolean b(String paramString, List<Integer> paramList)
  {
    GMTrace.i(688402726912L, 5129);
    ap.yY();
    Object localObject = c.ef("banner");
    if (localObject == null)
    {
      GMTrace.o(688402726912L, 5129);
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(paramString + "ArraySize", paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      ((SharedPreferences.Editor)localObject).putInt(paramString + i, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
    boolean bool = ((SharedPreferences.Editor)localObject).commit();
    GMTrace.o(688402726912L, 5129);
    return bool;
  }
  
  private static List<Integer> gg(String paramString)
  {
    GMTrace.i(688536944640L, 5130);
    ap.yY();
    SharedPreferences localSharedPreferences = c.ef("banner");
    if (localSharedPreferences == null)
    {
      GMTrace.o(688536944640L, 5130);
      return null;
    }
    int j = localSharedPreferences.getInt(paramString + "ArraySize", 0);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Integer.valueOf(localSharedPreferences.getInt(paramString + i, 0)));
      i += 1;
    }
    GMTrace.o(688536944640L, 5130);
    return localArrayList;
  }
  
  public static ax zj()
  {
    GMTrace.i(687731638272L, 5124);
    try
    {
      if (hmi == null) {
        hmi = new ax();
      }
      ax localax = hmi;
      GMTrace.o(687731638272L, 5124);
      return localax;
    }
    finally {}
  }
  
  public static aw zk()
  {
    GMTrace.i(688134291456L, 5127);
    ap.yY();
    Object localObject = c.ef("banner");
    if (localObject == null)
    {
      GMTrace.o(688134291456L, 5127);
      return null;
    }
    int i = ((SharedPreferences)localObject).getInt("CurrentType", -1);
    int j = ((SharedPreferences)localObject).getInt("CurrentShowType", -1);
    localObject = ((SharedPreferences)localObject).getString("CurrentData", "");
    if (i != -1)
    {
      switch (i)
      {
      case 4: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      default: 
      case 1: 
      case 3: 
      case 2: 
        do
        {
          int k;
          do
          {
            localObject = new aw(i, j, (String)localObject);
            GMTrace.o(688134291456L, 5127);
            return (aw)localObject;
            k = zl();
          } while ((k != a.hml) && (k != a.hmm) && (!g.Ae().Ac()));
          if (g.Ae().Ac()) {
            v.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind bind contacts banner.");
          }
          for (;;)
          {
            GMTrace.o(688134291456L, 5127);
            return null;
            v.i("MicorMsg.MainFrameBannerStorage", "already Bind the Mobile");
          }
          v.i("MicorMsg.MainFrameBannerStorage", "avatar already existed");
          GMTrace.o(688134291456L, 5127);
          return null;
        } while ((zl() != a.hml) && (!g.Ae().Ac()));
        if (g.Ae().Ac()) {
          v.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind upload contacts banner.");
        }
        for (;;)
        {
          GMTrace.o(688134291456L, 5127);
          return null;
          v.i("MicorMsg.MainFrameBannerStorage", "already upload the contacts");
        }
      case 10000: 
      case 57005: 
        GMTrace.o(688134291456L, 5127);
        return null;
      }
      GMTrace.o(688134291456L, 5127);
      return null;
    }
    GMTrace.o(688134291456L, 5127);
    return null;
  }
  
  public static int zl()
  {
    GMTrace.i(688671162368L, 5131);
    for (;;)
    {
      try
      {
        ap.yY();
        localObject3 = (String)c.vr().get(4097, "");
        ap.yY();
        String str = (String)c.vr().get(6, "");
        boolean bool = m.yo();
        v.d("MicorMsg.MainFrameBannerStorage", "isUpload " + bool + " stat " + m.xP());
        if (localObject3 != null)
        {
          Object localObject1 = localObject3;
          if (((String)localObject3).length() > 0)
          {
            if (str == null) {
              break label219;
            }
            localObject3 = str;
            if (str.length() <= 0) {
              break label219;
            }
            if ((localObject1 == null) && (localObject3 == null))
            {
              i = a.hmj;
              GMTrace.o(688671162368L, 5131);
              return i;
            }
            if ((localObject1 != null) && (localObject3 == null))
            {
              i = a.hmk;
              GMTrace.o(688671162368L, 5131);
              return i;
            }
            if (bool)
            {
              i = a.hml;
              GMTrace.o(688671162368L, 5131);
              return i;
            }
            i = a.hmm;
            GMTrace.o(688671162368L, 5131);
            return i;
          }
        }
      }
      catch (Exception localException)
      {
        int i = a.hmj;
        GMTrace.o(688671162368L, 5131);
        return i;
      }
      Object localObject2 = null;
      continue;
      label219:
      Object localObject3 = null;
    }
  }
  
  public final boolean a(aw paramaw)
  {
    boolean bool = true;
    GMTrace.i(688000073728L, 5126);
    if (paramaw.type == 10000)
    {
      ap.yY();
      paramaw = c.ef("banner");
      if (paramaw != null) {
        paramaw.edit().clear().commit();
      }
      if (this.hmh != null) {
        this.hmh.zm();
      }
      GMTrace.o(688000073728L, 5126);
      return true;
    }
    if (paramaw.type == 57005)
    {
      GMTrace.o(688000073728L, 5126);
      return false;
    }
    ap.yY();
    Object localObject = c.ef("banner");
    if (localObject == null)
    {
      GMTrace.o(688000073728L, 5126);
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    aw localaw = zk();
    if (!gg("HistoryInfo").contains(Integer.valueOf(paramaw.type))) {}
    for (;;)
    {
      if ((localaw != null) && (localaw.showType == 2))
      {
        List localList = gg("HistoryInfo");
        if (!localList.contains(Integer.valueOf(localaw.type))) {
          localList.add(Integer.valueOf(localaw.type));
        }
        b("HistoryInfo", localList);
      }
      if (bool) {
        ((SharedPreferences.Editor)localObject).putInt("CurrentType", paramaw.type).putInt("CurrentShowType", paramaw.showType).putString("CurrentData", paramaw.data).commit();
      }
      if (this.hmh != null) {
        this.hmh.zm();
      }
      GMTrace.o(688000073728L, 5126);
      return bool;
      bool = false;
    }
  }
  
  public final void aJ(int paramInt1, int paramInt2)
  {
    GMTrace.i(688268509184L, 5128);
    ap.yY();
    Object localObject = c.ef("banner");
    if (localObject == null)
    {
      GMTrace.o(688268509184L, 5128);
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (this.hmh != null) {
        this.hmh.zm();
      }
      GMTrace.o(688268509184L, 5128);
      return;
      ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
      continue;
      ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
      localObject = gg("HistoryInfo");
      if (!((List)localObject).contains(Integer.valueOf(paramInt1))) {
        ((List)localObject).add(Integer.valueOf(paramInt1));
      }
      b("HistoryInfo", (List)localObject);
      continue;
      if (paramInt1 == 3) {
        ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
      }
    }
  }
  
  public static enum a
  {
    static
    {
      GMTrace.i(630823321600L, 4700);
      hmj = 1;
      hmk = 2;
      hml = 3;
      hmm = 4;
      hmn = new int[] { hmj, hmk, hml, hmm };
      GMTrace.o(630823321600L, 4700);
    }
  }
  
  public static abstract interface b
  {
    public abstract void zm();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */