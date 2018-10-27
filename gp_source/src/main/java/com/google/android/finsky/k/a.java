package com.google.android.finsky.k;

import android.os.Handler;
import android.os.Looper;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.e.af;
import com.google.android.finsky.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a
{
  public final boolean a;
  public final Handler b;
  public final List c = new ArrayList();
  public final Map d = new ConcurrentHashMap();
  private final ThreadPoolExecutor e;
  
  public a()
  {
    int i = ((Integer)com.google.android.finsky.ag.d.Q.b()).intValue();
    this.e = new ThreadPoolExecutor(i, i, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    this.b = new Handler(Looper.getMainLooper());
    this.a = true;
  }
  
  public final long a(String paramString)
  {
    paramString = (e)this.d.get(paramString);
    if (paramString != null) {
      return paramString.b;
    }
    return -1L;
  }
  
  public final void a(com.google.android.finsky.em.a parama, af paramaf, List paramList)
  {
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      String str = ((Document)paramList.next()).cC();
      e locale = (e)this.d.get(str);
      if (locale == null) {}
      for (;;)
      {
        this.e.execute(new d(this, parama, paramaf, str));
        break;
        long l = ((Long)com.google.android.finsky.ag.d.P.b()).longValue();
        if (locale.a >= i.a() - l) {
          break;
        }
      }
    }
  }
  
  public final void a(b paramb)
  {
    this.c.add(paramb);
  }
  
  public final boolean a()
  {
    Map localMap = this.d;
    return (localMap != null) && (!localMap.isEmpty());
  }
  
  public final void b(b paramb)
  {
    this.c.remove(paramb);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/k/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */