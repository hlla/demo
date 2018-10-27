package com.google.android.gms.ads.internal.g;

import android.content.Context;
import com.google.android.gms.ads.internal.q.a.a;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

@a
public final class b
{
  public String a;
  public Context b;
  public String c;
  public ExecutorService d;
  public File e;
  public Map f = new HashMap();
  public LinkedHashMap g = new LinkedHashMap();
  public BlockingQueue h = new ArrayBlockingQueue(100);
  public AtomicBoolean i;
  
  public final f a(String paramString)
  {
    f localf = (f)this.f.get(paramString);
    paramString = localf;
    if (localf == null) {
      paramString = f.b;
    }
    return paramString;
  }
  
  final Map a(Map paramMap1, Map paramMap2)
  {
    paramMap1 = new LinkedHashMap(paramMap1);
    if (paramMap2 != null)
    {
      paramMap2 = paramMap2.entrySet().iterator();
      while (paramMap2.hasNext())
      {
        Object localObject = (Map.Entry)paramMap2.next();
        String str1 = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        String str2 = (String)paramMap1.get(str1);
        paramMap1.put(str1, a(str1).a(str2, (String)localObject));
      }
      return paramMap1;
    }
    return paramMap1;
  }
  
  public final boolean a(l paraml)
  {
    return this.h.offer(paraml);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */