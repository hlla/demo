package com.google.android.finsky.dn.a.a;

import android.content.Context;
import com.google.android.gms.phenotype.core.b.a.o;
import com.google.android.gms.phenotype.core.common.c;
import com.google.android.gms.phenotype.core.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class m
{
  private final String a;
  private final Context b;
  private final i[] c;
  private final String d;
  private final c e;
  
  public m(c paramc, Context paramContext, String paramString1, Map paramMap, String paramString2)
  {
    this.e = paramc;
    this.b = paramContext;
    this.d = paramString1;
    paramContext = new i[paramMap.size()];
    paramString1 = paramMap.entrySet().iterator();
    int i = 0;
    if (paramString1.hasNext())
    {
      paramMap = (Entry)paramString1.next();
      paramc = (String)paramMap.getKey();
      paramMap = paramMap.getValue();
      if ((paramMap instanceof String)) {
        paramc = new i(paramc, (String)paramMap, 0);
      }
      for (;;)
      {
        paramContext[i] = paramc;
        i += 1;
        break;
        if ((paramMap instanceof Long)) {
          paramc = new i(paramc, ((Long)paramMap).longValue(), 0);
        } else if ((paramMap instanceof Integer)) {
          paramc = new i(paramc, ((Integer)paramMap).longValue(), 0);
        } else if ((paramMap instanceof Double)) {
          paramc = new i(paramc, ((Double)paramMap).doubleValue(), 0);
        } else if ((paramMap instanceof Boolean)) {
          paramc = new i(paramc, ((Boolean)paramMap).booleanValue(), 0);
        } else if ((paramMap instanceof byte[])) {
          paramc = new i(paramc, (byte[])paramMap, 0);
        } else {
          paramc = null;
        }
      }
    }
    this.c = paramContext;
    this.a = paramString2;
  }
  
  public final void a()
  {
    new o(this.d, this.a, this.c, "com.android.vending").a(this.b, this.e);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/a/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */