package com.google.android.gms.ads.internal.mediation.client;

import android.location.Location;
import com.google.android.gms.ads.formats.f;
import com.google.android.gms.ads.formats.g;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.mediation.n;
import com.google.android.gms.ads.p;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@a
public final class ac
  implements n
{
  private final Date a;
  private final int b;
  private final boolean c;
  private final boolean d;
  private final Set e;
  private final Location f;
  private final NativeAdOptionsParcel g;
  private final Map h;
  private final List i;
  private final int j;
  
  public ac(Date paramDate, int paramInt1, Set paramSet, Location paramLocation, boolean paramBoolean1, int paramInt2, NativeAdOptionsParcel paramNativeAdOptionsParcel, List paramList, boolean paramBoolean2)
  {
    this.a = paramDate;
    this.b = paramInt1;
    this.e = paramSet;
    this.f = paramLocation;
    this.d = paramBoolean1;
    this.j = paramInt2;
    this.g = paramNativeAdOptionsParcel;
    this.c = paramBoolean2;
    this.i = new ArrayList();
    this.h = new HashMap();
    if (paramList != null)
    {
      paramDate = paramList.iterator();
      while (paramDate.hasNext())
      {
        paramSet = (String)paramDate.next();
        if (paramSet.startsWith("custom:"))
        {
          paramSet = paramSet.split(":", 3);
          if (paramSet.length == 3) {
            if ("true".equals(paramSet[2])) {
              this.h.put(paramSet[1], Boolean.valueOf(true));
            } else if ("false".equals(paramSet[2])) {
              this.h.put(paramSet[1], Boolean.valueOf(false));
            }
          }
        }
        else
        {
          this.i.add(paramSet);
        }
      }
    }
  }
  
  @Deprecated
  public final Date a()
  {
    return this.a;
  }
  
  @Deprecated
  public final int b()
  {
    return this.b;
  }
  
  public final Set c()
  {
    return this.e;
  }
  
  public final Location d()
  {
    return this.f;
  }
  
  public final boolean e()
  {
    return this.d;
  }
  
  public final int f()
  {
    return this.j;
  }
  
  @Deprecated
  public final boolean g()
  {
    return this.c;
  }
  
  public final f h()
  {
    if (this.g != null)
    {
      g localg = new g();
      Object localObject = this.g;
      localg.d = ((NativeAdOptionsParcel)localObject).d;
      localg.b = ((NativeAdOptionsParcel)localObject).b;
      localg.c = ((NativeAdOptionsParcel)localObject).c;
      int k = ((NativeAdOptionsParcel)localObject).e;
      if (k >= 2) {
        localg.a = ((NativeAdOptionsParcel)localObject).a;
      }
      if (k >= 3)
      {
        localObject = ((NativeAdOptionsParcel)localObject).f;
        if (localObject != null) {
          localg.e = new p((VideoOptionsParcel)localObject);
        }
      }
      return localg.a();
    }
    return null;
  }
  
  public final boolean i()
  {
    boolean bool3 = true;
    boolean bool2 = false;
    List localList = this.i;
    boolean bool1 = bool2;
    if (localList != null)
    {
      if (localList.contains("2")) {
        break label49;
      }
      bool1 = bool3;
      if (this.i.contains("6")) {}
    }
    label49:
    for (bool1 = bool2;; bool1 = true) {
      return bool1;
    }
  }
  
  public final boolean j()
  {
    List localList = this.i;
    return (localList != null) && (localList.contains("6"));
  }
  
  public final boolean k()
  {
    boolean bool3 = true;
    boolean bool2 = false;
    List localList = this.i;
    boolean bool1 = bool2;
    if (localList != null)
    {
      if (localList.contains("1")) {
        break label49;
      }
      bool1 = bool3;
      if (this.i.contains("6")) {}
    }
    label49:
    for (bool1 = bool2;; bool1 = true) {
      return bool1;
    }
  }
  
  public final boolean l()
  {
    List localList = this.i;
    return (localList != null) && (localList.contains("3"));
  }
  
  public final Map m()
  {
    return this.h;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/client/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */