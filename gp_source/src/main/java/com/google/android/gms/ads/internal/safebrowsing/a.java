package com.google.android.gms.ads.internal.safebrowsing;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.util.a.aa;
import com.google.android.gms.ads.internal.util.a.v;
import com.google.android.gms.ads.internal.util.ax;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.l;
import com.google.android.gms.common.internal.z;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@com.google.android.gms.ads.internal.q.a.a
public final class a
  implements k
{
  public static List c = Collections.synchronizedList(new ArrayList());
  private static ScheduledExecutorService n = Executors.newSingleThreadScheduledExecutor();
  public final Object a = new Object();
  public final com.google.o.a.a.a.a.a b;
  private HashSet d = new HashSet();
  private final List e = new ArrayList();
  private final Context f;
  private final List g = new ArrayList();
  private boolean h = false;
  private boolean i;
  private final LinkedHashMap j;
  private final SafeBrowsingConfigParcel k;
  private final m l;
  private boolean m = false;
  
  public a(Context paramContext, VersionInfoParcel paramVersionInfoParcel, SafeBrowsingConfigParcel paramSafeBrowsingConfigParcel, String paramString, m paramm)
  {
    z.a(paramSafeBrowsingConfigParcel, "SafeBrowsing config is not present.");
    Context localContext = paramContext;
    if (paramContext.getApplicationContext() != null) {
      localContext = paramContext.getApplicationContext();
    }
    this.f = localContext;
    this.j = new LinkedHashMap();
    this.l = paramm;
    this.k = paramSafeBrowsingConfigParcel;
    paramContext = this.k.a.iterator();
    while (paramContext.hasNext())
    {
      paramSafeBrowsingConfigParcel = (String)paramContext.next();
      this.d.add(paramSafeBrowsingConfigParcel.toLowerCase(Locale.ENGLISH));
    }
    this.d.remove("cookie".toLowerCase(Locale.ENGLISH));
    paramContext = new com.google.o.a.a.a.a.a();
    paramContext.i = Integer.valueOf(8);
    paramContext.j = paramString;
    paramContext.e = paramString;
    paramContext.c = new com.google.o.a.a.a.a.b();
    paramContext.c.a = this.k.c;
    paramSafeBrowsingConfigParcel = new com.google.o.a.a.a.a.h();
    paramSafeBrowsingConfigParcel.a = paramVersionInfoParcel.a;
    paramVersionInfoParcel = this.f;
    paramSafeBrowsingConfigParcel.c = Boolean.valueOf(com.google.android.gms.common.b.c.a.a(paramVersionInfoParcel).a());
    long l1 = com.google.android.gms.common.d.d(this.f);
    if (l1 > 0L) {
      paramSafeBrowsingConfigParcel.b = Long.valueOf(l1);
    }
    paramContext.b = paramSafeBrowsingConfigParcel;
    this.b = paramContext;
    paramContext = this.k.h;
    new n();
  }
  
  private final com.google.o.a.a.a.a.g b(String paramString)
  {
    synchronized (this.a)
    {
      paramString = (com.google.o.a.a.a.a.g)this.j.get(paramString);
      return paramString;
    }
  }
  
  private final v f()
  {
    boolean bool = this.i;
    if (((bool) && (this.k.d)) || ((this.h) && (this.k.b))) {}
    while ((!bool) && (this.k.e)) {
      for (;;)
      {
        Object localObject4;
        int i1;
        synchronized (this.a)
        {
          this.b.h = new com.google.o.a.a.a.a.g[this.j.size()];
          this.j.values().toArray(this.b.h);
          this.b.d = ((String[])this.g.toArray(new String[0]));
          this.b.f = ((String[])this.e.toArray(new String[0]));
          if (!j.a())
          {
            localObject2 = com.google.protobuf.nano.g.a(this.b);
            localObject4 = this.k.f;
            new ax(this.f);
            localObject2 = ax.a(1, (String)localObject4, null, (byte[])localObject2);
            if (j.a()) {
              ((v)localObject2).a(new f(), l.c);
            }
            localObject2 = com.google.android.gms.ads.internal.util.a.h.a((v)localObject2, c.a, aa.a);
            return (v)localObject2;
          }
          localObject4 = this.b;
          Object localObject2 = ((com.google.o.a.a.a.a.a)localObject4).j;
          localObject4 = ((com.google.o.a.a.a.a.a)localObject4).a;
          localStringBuilder = new StringBuilder(String.valueOf(localObject2).length() + 53 + String.valueOf(localObject4).length());
          localStringBuilder.append("Sending SB report\n  url: ");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("\n  clickUrl: ");
          localStringBuilder.append((String)localObject4);
          localStringBuilder.append("\n  resources: \n");
          localObject2 = new StringBuilder(localStringBuilder.toString());
          localObject4 = this.b.h;
          int i2 = localObject4.length;
          i1 = 0;
          if (i1 >= i2) {
            j.a(((StringBuilder)localObject2).toString());
          }
        }
        StringBuilder localStringBuilder = localObject4[i1];
        ((StringBuilder)localObject3).append("    [");
        ((StringBuilder)localObject3).append(localStringBuilder.c.length);
        ((StringBuilder)localObject3).append("] ");
        ((StringBuilder)localObject3).append(localStringBuilder.e);
        i1 += 1;
      }
    }
    return com.google.android.gms.ads.internal.util.a.h.a(null);
  }
  
  public final SafeBrowsingConfigParcel a()
  {
    return this.k;
  }
  
  public final void a(View paramView)
  {
    if ((this.k.g) && (!this.m))
    {
      localObject = bt.A.e;
      if (paramView == null) {
        break label73;
      }
      Bitmap localBitmap = com.google.android.gms.ads.internal.util.n.c(paramView);
      localObject = localBitmap;
      if (localBitmap != null) {}
    }
    label73:
    for (Object localObject = com.google.android.gms.ads.internal.util.n.b(paramView);; localObject = null)
    {
      if (localObject != null)
      {
        this.m = true;
        com.google.android.gms.ads.internal.util.n.a(new d(this, (Bitmap)localObject));
        return;
      }
      j.a("Failed to capture the webview bitmap.");
      return;
    }
  }
  
  public final void a(String paramString)
  {
    synchronized (this.a)
    {
      this.b.a = paramString;
      return;
    }
  }
  
  public final void a(String paramString, Map paramMap, int paramInt)
  {
    Object localObject2 = this.a;
    if (paramInt == 3) {}
    ArrayList localArrayList;
    try
    {
      this.h = true;
      if (this.j.containsKey(paramString)) {
        break label328;
      }
      com.google.o.a.a.a.a.g localg = new com.google.o.a.a.a.a.g();
      localg.a = Integer.valueOf(paramInt);
      localg.b = Integer.valueOf(this.j.size());
      localg.e = paramString;
      localg.d = new com.google.o.a.a.a.a.d();
      if (this.d.size() <= 0) {}
      Iterator localIterator;
      for (;;)
      {
        this.j.put(paramString, localg);
        return;
        if (paramMap != null)
        {
          localArrayList = new ArrayList();
          localIterator = paramMap.entrySet().iterator();
          if (localIterator.hasNext()) {
            break;
          }
          paramMap = new com.google.o.a.a.a.a.c[localArrayList.size()];
          localArrayList.toArray(paramMap);
          localg.d.a = paramMap;
        }
      }
      localObject1 = (Map.Entry)localIterator.next();
    }
    finally {}
    for (;;)
    {
      try
      {
        if (((Map.Entry)localObject1).getKey() != null) {
          break label314;
        }
        paramMap = "";
        if (((Map.Entry)localObject1).getValue() != null) {
          break label299;
        }
        localObject1 = "";
        Object localObject3 = paramMap.toLowerCase(Locale.ENGLISH);
        if (!this.d.contains(localObject3)) {
          break;
        }
        localObject3 = new com.google.o.a.a.a.a.c();
        ((com.google.o.a.a.a.a.c)localObject3).a = paramMap.getBytes("UTF-8");
        ((com.google.o.a.a.a.a.c)localObject3).b = ((String)localObject1).getBytes("UTF-8");
        localArrayList.add(localObject3);
      }
      catch (UnsupportedEncodingException paramMap)
      {
        j.a("Cannot convert string to bytes, skip header.");
      }
      break;
      label299:
      Object localObject1 = (String)((Map.Entry)localObject1).getValue();
      continue;
      label314:
      paramMap = (String)((Map.Entry)localObject1).getKey();
    }
    label328:
    if (paramInt == 3) {
      ((com.google.o.a.a.a.a.g)this.j.get(paramString)).a = Integer.valueOf(paramInt);
    }
  }
  
  public final boolean b()
  {
    return (com.google.android.gms.common.util.h.b()) && (this.k.g) && (!this.m);
  }
  
  public final void c() {}
  
  public final void d()
  {
    synchronized (this.a)
    {
      Object localObject2 = this.l;
      this.j.keySet();
      localObject2 = com.google.android.gms.ads.internal.util.a.h.a(((m)localObject2).a(), new b(this), aa.a);
      v localv = com.google.android.gms.ads.internal.util.a.h.a((v)localObject2, 10L, TimeUnit.SECONDS, n);
      com.google.android.gms.ads.internal.util.a.h.a((v)localObject2, new e(localv), aa.a);
      c.add(localv);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/safebrowsing/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */