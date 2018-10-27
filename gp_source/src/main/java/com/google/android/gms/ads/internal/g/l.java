package com.google.android.gms.ads.internal.g;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.q.a.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@a
public final class l
{
  public boolean a;
  public final Object b = new Object();
  public String c;
  private final Map d = new LinkedHashMap();
  private l e;
  private final List f = new LinkedList();
  
  public l(boolean paramBoolean, String paramString1, String paramString2)
  {
    this.a = paramBoolean;
    this.d.put("action", paramString1);
    this.d.put("ad_format", paramString2);
  }
  
  public final j a()
  {
    return a(bt.A.l.b());
  }
  
  public final j a(long paramLong)
  {
    if (this.a) {
      return new j(paramLong, null, null);
    }
    return null;
  }
  
  public final void a(l paraml)
  {
    synchronized (this.b)
    {
      this.e = paraml;
      return;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((this.a) && (!TextUtils.isEmpty(paramString2)))
    {
      Object localObject2 = bt.A.i.a();
      if (localObject2 != null) {
        synchronized (this.b)
        {
          localObject2 = ((b)localObject2).a(paramString1);
          Map localMap = this.d;
          localMap.put(paramString1, ((f)localObject2).a((String)localMap.get(paramString1), paramString2));
          return;
        }
      }
    }
  }
  
  public final boolean a(j paramj, long paramLong, String... paramVarArgs)
  {
    synchronized (this.b)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        j localj = new j(paramLong, paramVarArgs[i], paramj);
        this.f.add(localj);
        i += 1;
      }
      return true;
    }
  }
  
  public final boolean a(j paramj, String... paramVarArgs)
  {
    if ((this.a) && (paramj != null)) {
      return a(paramj, bt.A.l.b(), paramVarArgs);
    }
    return false;
  }
  
  public final String b()
  {
    Object localObject2 = new StringBuilder();
    for (;;)
    {
      Iterator localIterator;
      synchronized (this.b)
      {
        localIterator = this.f.iterator();
        if (localIterator.hasNext()) {
          break label115;
        }
        this.f.clear();
        if (TextUtils.isEmpty(this.c))
        {
          if (((StringBuilder)localObject2).length() <= 0)
          {
            localObject2 = ((StringBuilder)localObject2).toString();
            return (String)localObject2;
          }
          ((StringBuilder)localObject2).setLength(((StringBuilder)localObject2).length() - 1);
        }
      }
      ((StringBuilder)localObject3).append(this.c);
      continue;
      label115:
      j localj = (j)localIterator.next();
      long l1 = localj.c;
      String str = localj.a;
      localj = localj.b;
      if ((localj != null) && (l1 > 0L))
      {
        long l2 = localj.c;
        ((StringBuilder)localObject3).append(str);
        ((StringBuilder)localObject3).append('.');
        ((StringBuilder)localObject3).append(l1 - l2);
        ((StringBuilder)localObject3).append(',');
      }
    }
  }
  
  final Map c()
  {
    synchronized (this.b)
    {
      Object localObject2 = bt.A.i.a();
      if (localObject2 == null) {}
      l locall;
      do
      {
        localObject2 = this.d;
        return (Map)localObject2;
        locall = this.e;
      } while (locall == null);
      localObject2 = ((b)localObject2).a(this.d, locall.c());
      return (Map)localObject2;
    }
  }
  
  public final j d()
  {
    synchronized (this.b)
    {
      return null;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/g/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */