package com.google.android.gms.ads.internal.webview;

import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.bp;
import com.google.android.gms.ads.internal.client.br;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.a.aa;
import com.google.android.gms.ads.internal.w.ad;
import com.google.android.gms.common.util.c;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

@a
public final class w
  extends bp
{
  public float a;
  public br b;
  public float c;
  public float d;
  public boolean e;
  public boolean f = true;
  public final Object g = new Object();
  public int h;
  public final ad i;
  private final boolean j;
  private boolean k;
  private final boolean l;
  private boolean m;
  
  public w(ad paramad, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.i = paramad;
    this.d = paramFloat;
    this.l = paramBoolean1;
    this.j = paramBoolean2;
  }
  
  private final void a(String paramString, Map paramMap)
  {
    if (paramMap != null) {}
    for (paramMap = new HashMap(paramMap);; paramMap = new HashMap())
    {
      paramMap.put("action", paramString);
      aa.b.execute(new x(this, paramMap));
      return;
    }
  }
  
  public final void a()
  {
    a("play", null);
  }
  
  public final void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    aa.b.execute(new y(this, paramInt1, paramInt2, paramBoolean1, paramBoolean2));
  }
  
  public final void a(VideoOptionsParcel paramVideoOptionsParcel)
  {
    a(paramVideoOptionsParcel.c, paramVideoOptionsParcel.b, paramVideoOptionsParcel.a);
  }
  
  public final void a(br parambr)
  {
    synchronized (this.g)
    {
      this.b = parambr;
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = "unmute";; str = "mute")
    {
      a(str, null);
      return;
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    synchronized (this.g)
    {
      this.m = paramBoolean2;
      this.k = paramBoolean3;
      if (!paramBoolean1)
      {
        ??? = "0";
        if (!paramBoolean2) {}
        for (String str1 = "0";; str1 = "1")
        {
          if (!paramBoolean3) {}
          for (String str2 = "0";; str2 = "1")
          {
            Map localMap = c.a(3);
            localMap.put("muteStart", ???);
            localMap.put("customControlsRequested", str1);
            localMap.put("clickToExpandRequested", str2);
            a("initialState", Collections.unmodifiableMap(localMap));
            return;
          }
        }
      }
      ??? = "1";
    }
  }
  
  public final void b()
  {
    a("pause", null);
  }
  
  public final boolean c()
  {
    synchronized (this.g)
    {
      boolean bool = this.f;
      return bool;
    }
  }
  
  public final int d()
  {
    synchronized (this.g)
    {
      int n = this.h;
      return n;
    }
  }
  
  public final float e()
  {
    synchronized (this.g)
    {
      float f1 = this.d;
      return f1;
    }
  }
  
  public final float f()
  {
    synchronized (this.g)
    {
      float f1 = this.c;
      return f1;
    }
  }
  
  public final float g()
  {
    synchronized (this.g)
    {
      float f1 = this.a;
      return f1;
    }
  }
  
  public final boolean h()
  {
    boolean bool2 = false;
    Object localObject1 = this.g;
    boolean bool1 = bool2;
    try
    {
      if (this.l)
      {
        bool1 = bool2;
        if (this.m) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public final br i()
  {
    synchronized (this.g)
    {
      br localbr = this.b;
      return localbr;
    }
  }
  
  public final boolean j()
  {
    boolean bool2 = false;
    boolean bool3 = h();
    Object localObject1 = this.g;
    boolean bool1 = bool2;
    if (!bool3) {
      bool1 = bool2;
    }
    try
    {
      if (this.k)
      {
        bool1 = bool2;
        if (this.j) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/webview/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */