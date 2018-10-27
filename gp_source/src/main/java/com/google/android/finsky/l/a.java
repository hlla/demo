package com.google.android.finsky.l;

import android.accounts.Account;
import android.os.Looper;
import com.google.android.finsky.af.e;
import com.google.android.finsky.cg.k;
import com.google.android.finsky.library.f;
import com.google.android.finsky.library.g;
import com.google.android.finsky.utils.FinskyLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public final class a
{
  public final com.google.android.finsky.dh.a a;
  public final k b;
  private final com.google.android.finsky.accounts.c c;
  private final String d;
  
  public a(String paramString, k paramk, com.google.android.finsky.dh.a parama, com.google.android.finsky.accounts.c paramc)
  {
    this.d = paramString;
    this.b = paramk;
    this.a = parama;
    this.c = paramc;
  }
  
  private static String[] a(com.google.android.finsky.dh.b paramb)
  {
    if (paramb != null) {
      return paramb.a;
    }
    return null;
  }
  
  public static Map b(com.google.android.finsky.library.c paramc, Collection paramCollection)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = paramc.f().iterator();
    while (((Iterator)localObject1).hasNext()) {
      localHashMap.put(((com.google.android.finsky.library.a)((Iterator)localObject1).next()).a().name, new LinkedHashSet());
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      localObject1 = (b)paramCollection.next();
      Object localObject2 = a(((b)localObject1).c);
      localObject2 = paramc.b(((b)localObject1).d, (String[])localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Set)localHashMap.get(((f)((Iterator)localObject2).next()).e)).add(((b)localObject1).d);
      }
    }
    return localHashMap;
  }
  
  public final b a(String paramString, boolean paramBoolean)
  {
    com.google.android.finsky.cg.c localc = this.b.a(paramString);
    com.google.android.finsky.dh.b localb = this.a.a(paramString, paramBoolean);
    if ((localc != null) || (localb != null)) {
      return new b(paramString, this.d, localb, localc);
    }
    return null;
  }
  
  public final Collection a(boolean paramBoolean, List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null) {}
    for (paramList = new HashSet(paramList);; paramList = new HashSet())
    {
      Object localObject1 = new HashMap();
      Object localObject2 = this.b.a().iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.google.android.finsky.cg.c)((Iterator)localObject2).next();
        ((Map)localObject1).put(((com.google.android.finsky.cg.c)localObject3).F, localObject3);
      }
      localObject2 = this.a.a().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.google.android.finsky.dh.b)((Iterator)localObject2).next();
        com.google.android.finsky.cg.c localc = (com.google.android.finsky.cg.c)((Map)localObject1).remove(((com.google.android.finsky.dh.b)localObject3).o);
        localObject3 = new b(((com.google.android.finsky.dh.b)localObject3).o, this.d, (com.google.android.finsky.dh.b)localObject3, localc);
        localArrayList.add(localObject3);
        paramList.remove(((b)localObject3).d);
      }
      if (!paramBoolean)
      {
        localObject1 = ((Map)localObject1).values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.google.android.finsky.cg.c)((Iterator)localObject1).next();
          localObject2 = new b(((com.google.android.finsky.cg.c)localObject2).F, this.d, null, (com.google.android.finsky.cg.c)localObject2);
          localArrayList.add(localObject2);
          paramList.remove(((b)localObject2).d);
        }
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (String)paramList.next();
        localObject1 = this.a.a((String)localObject1);
        if (localObject1 != null) {
          localArrayList.add(new b(((com.google.android.finsky.dh.b)localObject1).o, this.d, (com.google.android.finsky.dh.b)localObject1, null));
        }
      }
    }
    return localArrayList;
  }
  
  public final Map a(com.google.android.finsky.library.c paramc, boolean paramBoolean)
  {
    return b(paramc, a(paramBoolean, null));
  }
  
  public final Set a(com.google.android.finsky.library.c paramc, Collection paramCollection)
  {
    LinkedHashSet localLinkedHashSet1 = new LinkedHashSet();
    LinkedHashSet localLinkedHashSet2 = new LinkedHashSet();
    Iterator localIterator = this.c.cQ().iterator();
    while (localIterator.hasNext()) {
      localLinkedHashSet2.add(((Account)localIterator.next()).name);
    }
    localIterator = paramCollection.iterator();
    label226:
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramCollection = a(str, false);
      if (paramCollection != null)
      {
        Object localObject = paramCollection.c;
        if (localObject != null)
        {
          localObject = a((com.google.android.finsky.dh.b)localObject);
          paramCollection = paramc.b(paramCollection.d, (String[])localObject);
        }
      }
      for (;;)
      {
        if (paramCollection == null) {
          break label226;
        }
        if (paramCollection.isEmpty())
        {
          localLinkedHashSet1.add(str);
          break;
        }
        paramCollection = paramCollection.iterator();
        for (;;)
        {
          if (paramCollection.hasNext()) {
            if (localLinkedHashSet2.contains(((f)paramCollection.next()).e)) {
              break;
            }
          }
        }
        localLinkedHashSet1.add(str);
        break;
        paramCollection = null;
        continue;
        paramCollection = null;
      }
    }
    return localLinkedHashSet1;
  }
  
  public final void a()
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      FinskyLog.e("blockingLoad should not be called on the main thread, as it can cause a deadlock", new Object[0]);
    }
    try
    {
      this.b.d().get();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      FinskyLog.c("Thread interrupted", new Object[0]);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      FinskyLog.a(localExecutionException, "Failed to fetch libraries blocking", new Object[0]);
    }
  }
  
  public final List b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.a().iterator();
    while (localIterator.hasNext())
    {
      com.google.android.finsky.cg.c localc = (com.google.android.finsky.cg.c)localIterator.next();
      if (localc.n != -1)
      {
        com.google.android.finsky.dh.b localb = this.a.a(localc.F, true);
        localArrayList.add(new b(localc.F, this.d, localb, localc));
      }
    }
    return localArrayList;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/l/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */