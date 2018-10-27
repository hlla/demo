package com.google.android.finsky.ap;

import com.google.android.finsky.af.c;
import com.google.android.finsky.utils.bg;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

public final class a
{
  public final g a;
  public final Map b;
  public final c c;
  public final List d;
  
  public a(g paramg, com.google.android.finsky.af.d paramd)
  {
    this.a = paramg;
    this.b = new ConcurrentHashMap();
    this.d = new ArrayList();
    this.c = paramd.a(Executors.newFixedThreadPool(((Integer)com.google.android.finsky.ag.d.w.b()).intValue(), bg.a("AppDataUsageStatsCache-%d")));
  }
  
  public final e a(String paramString)
  {
    return (e)this.b.get(paramString);
  }
  
  public final boolean a()
  {
    return this.b.isEmpty() ^ true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ap/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */