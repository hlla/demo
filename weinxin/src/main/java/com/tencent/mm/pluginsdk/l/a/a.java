package com.tencent.mm.pluginsdk.l.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class a
{
  public static final String[] sFC;
  public String desc;
  public String hoe;
  public String hof;
  public String id;
  public int oKP;
  public String platform;
  public Rect sFA;
  public Map<String, String> sFB;
  public String sFv;
  public boolean sFw;
  public boolean sFx;
  public int sFy;
  public Rect sFz;
  public String title;
  public String url;
  
  static
  {
    GMTrace.i(840739848192L, 6264);
    sFC = new String[] { "LDPI", "HDPI", "MDPI" };
    GMTrace.o(840739848192L, 6264);
  }
  
  private a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(839666106368L, 6256);
    this.id = paramString1;
    this.platform = paramString2;
    this.sFv = paramString3;
    this.sFw = paramBoolean1;
    this.sFx = paramBoolean2;
    GMTrace.o(839666106368L, 6256);
  }
  
  public static String My(String paramString)
  {
    GMTrace.i(840068759552L, 6259);
    Object localObject = Mz(paramString);
    if (localObject == a.sFD)
    {
      GMTrace.o(840068759552L, 6259);
      return paramString;
    }
    if (localObject == a.sFE)
    {
      if (paramString == null) {
        paramString = null;
      }
      while (paramString == null)
      {
        GMTrace.o(840068759552L, 6259);
        return null;
        int i = paramString.lastIndexOf("/");
        if ((i < 0) || (i >= paramString.length() - 1)) {
          paramString = null;
        } else {
          paramString = paramString.substring(i + 1);
        }
      }
      localObject = new StringBuilder();
      ap.yY();
      paramString = c.xb() + paramString;
      GMTrace.o(840068759552L, 6259);
      return paramString;
    }
    GMTrace.o(840068759552L, 6259);
    return null;
  }
  
  public static a Mz(String paramString)
  {
    GMTrace.i(840202977280L, 6260);
    if (paramString.indexOf("tips/") == 0)
    {
      paramString = a.sFD;
      GMTrace.o(840202977280L, 6260);
      return paramString;
    }
    if (paramString.indexOf("weixin://") == 0)
    {
      paramString = a.sFE;
      GMTrace.o(840202977280L, 6260);
      return paramString;
    }
    paramString = a.sFF;
    GMTrace.o(840202977280L, 6260);
    return paramString;
  }
  
  private boolean Ne()
  {
    GMTrace.i(839800324096L, 6257);
    long l3 = bf.NA();
    long l1 = Long.MAX_VALUE;
    long l2 = 0L;
    try
    {
      if (this.hof != null) {
        l1 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.hof).getTime();
      }
      if (this.hoe != null) {
        l2 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.hoe).getTime();
      }
      v.d("MicroMsg.PushMessage", "CHECKTIME : [" + l2 + "," + l1 + "]");
      if (l1 <= l3) {
        break label158;
      }
      if (l2 > l3)
      {
        GMTrace.o(839800324096L, 6257);
        return false;
      }
    }
    catch (Exception localException)
    {
      GMTrace.o(839800324096L, 6257);
      return true;
    }
    GMTrace.o(839800324096L, 6257);
    return true;
    label158:
    GMTrace.o(839800324096L, 6257);
    return false;
  }
  
  public static ArrayList<a> aT(Context paramContext, String paramString)
  {
    GMTrace.i(840337195008L, 6261);
    if ((paramString == null) || (paramString.length() < 0))
    {
      GMTrace.o(840337195008L, 6261);
      return null;
    }
    Object localObject1 = paramContext.getResources().getDisplayMetrics();
    Object localObject2 = ((DisplayMetrics)localObject1).heightPixels + "x" + ((DisplayMetrics)localObject1).widthPixels;
    if (localObject2 == null)
    {
      paramContext = null;
      if ((paramContext == null) || (paramContext.size() <= 0))
      {
        GMTrace.o(840337195008L, 6261);
        return null;
      }
    }
    else
    {
      localObject1 = new HashSet();
      ((HashSet)localObject1).add(localObject2);
      paramContext = BackwardSupportUtil.b.dV(paramContext);
      v.d("MicroMsg.PushMessage", "getDisplaySizeType :" + paramContext);
      if (paramContext != null)
      {
        paramContext = paramContext.split("_");
        if ((paramContext != null) && (paramContext.length >= 2)) {
          break label224;
        }
      }
      label224:
      for (paramContext = null;; paramContext = paramContext[0])
      {
        ((HashSet)localObject1).add(paramContext + "_L");
        ((HashSet)localObject1).add(paramContext + "_P");
        paramContext = (Context)localObject1;
        break;
      }
    }
    localObject1 = bg.q(paramString, "tips");
    if (localObject1 == null)
    {
      GMTrace.o(840337195008L, 6261);
      return null;
    }
    localObject2 = new ArrayList();
    int i = 0;
    for (;;)
    {
      Object localObject3 = new StringBuilder(".tips.tip");
      Object localObject4;
      int j;
      HashMap localHashMap;
      label1197:
      Object localObject5;
      if (i > 0)
      {
        paramString = Integer.valueOf(i);
        localObject3 = paramString;
        if (((Map)localObject1).get(localObject3) == null) {
          break;
        }
        paramString = (String)((Map)localObject1).get((String)localObject3 + ".$id");
        v.d("MicroMsg.PushMessage", "parseMessages id:" + paramString);
        localObject4 = (String)((Map)localObject1).get((String)localObject3 + ".$platform");
        if (!((String)localObject4).equals("android")) {
          break label1397;
        }
        localObject4 = new a(paramString, (String)localObject4, (String)((Map)localObject1).get((String)localObject3 + ".$device"), bf.e(Boolean.valueOf((String)((Map)localObject1).get((String)localObject3 + ".$enableclose"))), bf.e(Boolean.valueOf((String)((Map)localObject1).get((String)localObject3 + ".$transparentclose"))));
        j = bf.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$x"), 0);
        int k = bf.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$y"), 0);
        int m = bf.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$width"), 0);
        int n = bf.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$font"), 0);
        int i1 = bf.PP((String)((Map)localObject1).get((String)localObject3 + ".title.$color"));
        ((a)localObject4).title = ((String)((Map)localObject1).get((String)localObject3 + ".title"));
        ((a)localObject4).sFy = i1;
        ((a)localObject4).sFz = new Rect(j, k, m + j, n + k);
        j = bf.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$x"), 0);
        k = bf.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$y"), 0);
        m = bf.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$width"), 0);
        n = bf.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$font"), 0);
        i1 = bf.PP((String)((Map)localObject1).get((String)localObject3 + ".description.$color"));
        ((a)localObject4).desc = ((String)((Map)localObject1).get((String)localObject3 + ".description"));
        ((a)localObject4).oKP = i1;
        ((a)localObject4).sFA = new Rect(j, k, m + j, n + k);
        ((a)localObject4).url = ((String)((Map)localObject1).get((String)localObject3 + ".url"));
        ((a)localObject4).hoe = ((String)((Map)localObject1).get((String)localObject3 + ".time.start"));
        ((a)localObject4).hof = ((String)((Map)localObject1).get((String)localObject3 + ".time.end"));
        v.d("MicroMsg.PushMessage", "parseMessages id:" + ((a)localObject4).id + " start:" + ((a)localObject4).hoe + " end:" + ((a)localObject4).hof);
        localHashMap = new HashMap();
        j = 0;
        localObject5 = new StringBuilder().append((String)localObject3).append(".images.image");
        if (j <= 0) {
          break label1341;
        }
      }
      label1341:
      for (paramString = Integer.valueOf(j);; paramString = "")
      {
        localObject5 = paramString;
        paramString = (String)((Map)localObject1).get(localObject5);
        v.d("MicroMsg.PushMessage", " img res:" + paramString);
        if (paramString == null) {
          break label1348;
        }
        localObject5 = (String)((Map)localObject1).get((String)localObject5 + ".$type");
        if (paramContext.contains(localObject5)) {
          localHashMap.put(localObject5, paramString);
        }
        j += 1;
        break label1197;
        paramString = "";
        break;
      }
      label1348:
      if (localHashMap.size() > 0) {
        ((a)localObject4).sFB = localHashMap;
      }
      v.d("MicroMsg.PushMessage", "msgid :" + ((a)localObject4).id);
      ((ArrayList)localObject2).add(localObject4);
      label1397:
      i += 1;
    }
    v.d("MicroMsg.PushMessage", "msgs size: " + ((ArrayList)localObject2).size());
    if (((ArrayList)localObject2).size() > 0)
    {
      GMTrace.o(840337195008L, 6261);
      return (ArrayList<a>)localObject2;
    }
    GMTrace.o(840337195008L, 6261);
    return null;
  }
  
  public static void bDB()
  {
    GMTrace.i(840471412736L, 6262);
    ap.yY();
    c.vr().set(8193, "");
    ap.yY();
    c.vr().set(8449, Long.valueOf(0L));
    GMTrace.o(840471412736L, 6262);
  }
  
  public static a dB(Context paramContext)
  {
    int i = 1;
    GMTrace.i(840605630464L, 6263);
    ap.yY();
    long l1 = bf.n(c.vr().get(8449, null), 0);
    long l2 = bf.Nz();
    if ((l1 > 0L) && (l2 - l1 >= 86400L)) {
      bDB();
    }
    for (;;)
    {
      GMTrace.o(840605630464L, 6263);
      return null;
      ap.yY();
      localObject = (String)c.vr().get(8193, null);
      if (!bf.mA((String)localObject)) {
        if (((String)localObject).contains("id=\"setavatar\""))
        {
          bDB();
        }
        else
        {
          if (bf.mA((String)localObject)) {
            break label196;
          }
          paramContext = aT(paramContext, (String)localObject);
          if ((paramContext != null) && (paramContext.size() == 1)) {
            break;
          }
          paramContext = null;
          if (paramContext != null) {
            break label206;
          }
          bDB();
        }
      }
    }
    Object localObject = (a)paramContext.get(0);
    if ((((a)localObject).sFB != null) && (((a)localObject).sFB.size() > 0)) {}
    for (;;)
    {
      if (i != 0)
      {
        paramContext = (Context)localObject;
        if (((a)localObject).Ne()) {
          break;
        }
      }
      label196:
      paramContext = null;
      break;
      i = 0;
    }
    label206:
    GMTrace.o(840605630464L, 6263);
    return paramContext;
  }
  
  public final String toString()
  {
    GMTrace.i(839934541824L, 6258);
    StringBuilder localStringBuilder = new StringBuilder("ad.id=").append(this.id).append(", platform=").append(this.platform).append(", device=").append(this.sFv);
    if (this.sFw)
    {
      str = ", closable";
      localStringBuilder = localStringBuilder.append(str);
      if (!this.sFx) {
        break label108;
      }
    }
    label108:
    for (String str = ", trans-closable";; str = "")
    {
      str = str;
      GMTrace.o(839934541824L, 6258);
      return str;
      str = "";
      break;
    }
  }
  
  public static enum a
  {
    static
    {
      GMTrace.i(841276719104L, 6268);
      sFD = new a("ASSET", 0);
      sFE = new a("DOWNLOAD", 1);
      sFF = new a("ERROR", 2);
      sFG = new a[] { sFD, sFE, sFF };
      GMTrace.o(841276719104L, 6268);
    }
    
    private a()
    {
      GMTrace.i(841142501376L, 6267);
      GMTrace.o(841142501376L, 6267);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/l/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */