package com.tencent.mm.i;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.cg;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class e
{
  private HashMap<String, String> gTd;
  private boolean gTe;
  
  public e()
  {
    GMTrace.i(13611690885120L, 101415);
    this.gTd = new HashMap();
    this.gTe = false;
    GMTrace.o(13611690885120L, 101415);
  }
  
  private void a(Map<String, String> paramMap, boolean paramBoolean)
  {
    GMTrace.i(13612764626944L, 101423);
    if (paramMap == null)
    {
      GMTrace.o(13612764626944L, 101423);
      return;
    }
    if (!paramBoolean) {
      this.gTd.clear();
    }
    int i = 0;
    if (i < 10000)
    {
      Object localObject2;
      label64:
      String str1;
      HashMap localHashMap;
      String str2;
      if (paramBoolean)
      {
        localObject2 = new StringBuilder(".sysmsg.dynacfg_split.Item");
        if (i == 0)
        {
          localObject1 = "";
          localObject1 = localObject1;
          str1 = (String)localObject1 + ".$key";
          localObject2 = (String)paramMap.get(localObject1);
          str1 = (String)paramMap.get(str1);
          if ((str1 == null) || (bf.mA(str1.trim()))) {
            break label262;
          }
          localHashMap = this.gTd;
          str2 = str1.trim();
          if (localObject2 == null) {
            break label255;
          }
        }
      }
      label255:
      for (Object localObject1 = localObject2;; localObject1 = "")
      {
        localHashMap.put(str2, localObject1);
        v.d("MicroMsg.DynamicConfig", "put %s %s", new Object[] { str1.trim(), localObject2 });
        i += 1;
        break;
        localObject1 = Integer.valueOf(i);
        break label64;
        localObject2 = new StringBuilder(".sysmsg.dynacfg.Item");
        if (i == 0) {}
        for (localObject1 = "";; localObject1 = Integer.valueOf(i))
        {
          localObject1 = localObject1;
          break;
        }
      }
    }
    label262:
    v.d("MicroMsg.DynamicConfig", "All dynamicConfig:%s", new Object[] { this.gTd.toString() });
    GMTrace.o(13612764626944L, 101423);
  }
  
  private void i(String paramString, boolean paramBoolean)
  {
    GMTrace.i(13612630409216L, 101422);
    a(bg.q(paramString, "sysmsg"), paramBoolean);
    GMTrace.o(13612630409216L, 101422);
  }
  
  public final void a(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        GMTrace.i(13612496191488L, 101421);
        if (bf.mA(paramString))
        {
          GMTrace.o(13612496191488L, 101421);
          return;
        }
        v.i("MicroMsg.DynamicConfig", "update dynacfg. increment:%b, md5:%s", new Object[] { Boolean.valueOf(paramBoolean), g.aV(paramString) });
        if (paramBoolean)
        {
          h.vJ();
          h.vI().vr().set(278530, paramString);
          if (paramMap == null) {
            break label151;
          }
          a(paramMap, paramBoolean);
          paramString = new cg();
          a.uql.m(paramString);
          GMTrace.o(13612496191488L, 101421);
          continue;
        }
        h.vJ();
      }
      finally {}
      h.vI().vr().set(278529, paramString);
      h.vJ();
      h.vI().vr().set(278530, "");
      continue;
      label151:
      i(paramString, paramBoolean);
    }
  }
  
  public final List<String> dC(String paramString)
  {
    ArrayList localArrayList;
    try
    {
      GMTrace.i(13612093538304L, 101418);
      if (!this.gTe)
      {
        v.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
        sL();
      }
      localArrayList = new ArrayList();
      if (!bf.mA(paramString))
      {
        Iterator localIterator = this.gTd.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str.matches(paramString)) {
            localArrayList.add(this.gTd.get(str));
          }
        }
      }
    }
    finally {}
    tmp117_114[0] = paramString;
    Object[] tmp121_117 = tmp117_114;
    tmp121_117[1] = Integer.valueOf(localArrayList.size());
    v.d("MicroMsg.DynamicConfig", "searchValues, entry:%s, size:%d", tmp121_117);
    GMTrace.o(13612093538304L, 101418);
    return localArrayList;
  }
  
  public final int getInt(String paramString, int paramInt)
  {
    GMTrace.i(13611959320576L, 101417);
    try
    {
      int i = Integer.parseInt(getValue(paramString));
      paramInt = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.e("MicroMsg.DynamicConfig", "parseInt failed, val: " + paramString);
      }
    }
    GMTrace.o(13611959320576L, 101417);
    return paramInt;
  }
  
  public final String getValue(String paramString)
  {
    try
    {
      GMTrace.i(13611825102848L, 101416);
      if (!this.gTe)
      {
        v.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
        sL();
      }
      v.d("MicroMsg.DynamicConfig", "get configs.get(config) %s %s", new Object[] { paramString.trim(), this.gTd.get(paramString) });
      paramString = (String)this.gTd.get(paramString);
      GMTrace.o(13611825102848L, 101416);
      return paramString;
    }
    finally {}
  }
  
  @Deprecated
  public final void put(String paramString1, String paramString2)
  {
    try
    {
      GMTrace.i(13612227756032L, 101419);
      if ((paramString1 != null) && (paramString2 != null))
      {
        v.d("MicroMsg.DynamicConfig", "put configs.put(key,value) %s %s", new Object[] { paramString1.trim(), paramString2 });
        this.gTd.put(paramString1, paramString2);
      }
      GMTrace.o(13612227756032L, 101419);
      return;
    }
    finally {}
  }
  
  public final void sL()
  {
    try
    {
      GMTrace.i(13612361973760L, 101420);
      h.vJ();
      if (h.vI() != null)
      {
        h.vJ();
        if (h.vI().vr() != null)
        {
          this.gTe = true;
          h.vJ();
          i((String)h.vI().vr().get(278529, null), false);
        }
      }
      h.vJ();
      if (h.vI() != null)
      {
        h.vJ();
        if (h.vI().vr() != null)
        {
          this.gTe = true;
          h.vJ();
          i((String)h.vI().vr().get(278530, null), true);
        }
      }
      GMTrace.o(13612361973760L, 101420);
      return;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/i/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */