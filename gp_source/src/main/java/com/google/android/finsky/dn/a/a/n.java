package com.google.android.finsky.dn.a.a;

import android.content.Context;
import com.google.android.finsky.dn.a.h;
import com.google.android.finsky.dn.a.l;
import com.google.android.finsky.utils.ai;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class n
  extends a
{
  private final com.google.android.finsky.i.c a;
  private final com.google.android.finsky.dn.a.i b;
  private final com.google.android.finsky.dn.a.q c;
  
  public n(p paramp, com.google.android.gms.phenotype.core.common.c paramc, g paramg, Context paramContext, String paramString1, String[] paramArrayOfString, int paramInt, String paramString2, byte[] paramArrayOfByte, com.google.android.finsky.dn.a.i parami, com.google.android.finsky.i.c paramc1, com.google.android.finsky.dn.a.q paramq, com.google.android.finsky.e.i parami1, com.google.android.finsky.bo.c paramc2)
  {
    super(paramp, paramc, paramContext, paramString1, paramArrayOfString, paramInt, paramString2, paramArrayOfByte, parami1, paramc2);
    this.b = parami;
    this.a = paramc1;
    this.c = paramq;
  }
  
  protected final int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1000;
    case 4: 
      return 2507;
    case 3: 
      return 2506;
    case 2: 
      return 2505;
    case 1: 
      return 2504;
    }
    return 0;
  }
  
  protected final String a(String paramString)
  {
    paramString = this.b.a();
    if (paramString != null) {
      return paramString.e;
    }
    return null;
  }
  
  protected final boolean a(h paramh, com.google.android.play.b.a.c paramc, String paramString)
  {
    if (l.a(paramh, paramc, this.b.a.a.getFilesDir(), "experiment-flags-process-stable") != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Object localObject;
      if (bool1)
      {
        com.google.android.finsky.ag.c.av.a(Boolean.valueOf(true));
        paramString = com.google.android.finsky.ag.c.at;
        localObject = this.c;
        paramc = this.b.a();
        if (paramc == null) {
          break label338;
        }
      }
      label338:
      for (paramc = paramc.c;; paramc = Collections.emptyMap())
      {
        HashMap localHashMap = new HashMap();
        com.google.android.finsky.dn.a.g[] arrayOfg = paramh.c();
        int k = arrayOfg.length;
        int i = 0;
        while (i < k)
        {
          com.google.android.finsky.dn.a.n[] arrayOfn = arrayOfg[i].a();
          int m = arrayOfn.length;
          int j = 0;
          if (j < m)
          {
            paramh = arrayOfn[j];
            String str = paramh.a();
            switch (paramh.g())
            {
            default: 
              paramh = null;
            }
            for (;;)
            {
              localHashMap.put(str, paramh);
              j += 1;
              break;
              paramh = Boolean.valueOf(paramh.c());
              continue;
              paramh = paramh.f();
              continue;
              paramh = paramh.e();
              continue;
              paramh = Double.valueOf(paramh.d());
              continue;
              paramh = Long.valueOf(paramh.b());
            }
          }
          i += 1;
        }
        paramh = ((com.google.android.finsky.dn.a.q)localObject).a.iterator();
        do
        {
          if (!paramh.hasNext()) {
            break;
          }
          localObject = (String)paramh.next();
        } while (ai.a(localHashMap.get(localObject), paramc.get(localObject)));
        for (boolean bool2 = true;; bool2 = false)
        {
          paramString.a(Boolean.valueOf(bool2));
          this.a.a();
          return bool1;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/a/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */