package com.google.android.finsky.dm;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class c
  implements b
{
  private static final ExecutorService e = Executors.newSingleThreadExecutor(new com.google.android.finsky.utils.c());
  public final b a;
  public Map b = null;
  public final Handler c;
  public final List d = new ArrayList();
  
  public c(b paramb)
  {
    this.a = paramb;
    this.c = new Handler(Looper.getMainLooper());
  }
  
  private static void c()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("Tried to access data off of the main thread.");
    }
  }
  
  private final void d()
  {
    if (!b()) {
      throw new IllegalStateException("Tried to access data before initializing.");
    }
    c();
  }
  
  public final Map a()
  {
    d();
    if (this.b.isEmpty()) {
      return Collections.emptyMap();
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, Collections.unmodifiableMap((Map)this.b.get(str)));
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public final void a(Runnable paramRunnable)
  {
    
    if (b()) {
      this.c.post(paramRunnable);
    }
    do
    {
      return;
      this.d.add(paramRunnable);
    } while (this.d.size() != 1);
    e.submit(new f(this));
  }
  
  public final void a(String paramString)
  {
    d();
    this.b.remove(paramString);
    paramString = new d(this, paramString);
    e.submit(paramString);
  }
  
  public final void a(String paramString, Map paramMap)
  {
    d();
    this.b.put(paramString, paramMap);
    paramString = new e(this, paramString, new HashMap(paramMap));
    e.submit(paramString);
  }
  
  public final boolean b()
  {
    return this.b != null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dm/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */