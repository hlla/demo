package com.google.android.gms.ads.internal.w;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.g.j;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.au;
import com.google.android.gms.ads.internal.util.av;
import com.google.android.gms.ads.internal.util.aw;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@a
public final class ae
{
  public boolean a;
  private final com.google.android.gms.ads.internal.g.l b;
  private l c;
  private final j d;
  private boolean e = false;
  private final Context f;
  private boolean g = false;
  private final au h = new au(new aw().a("min_1", Double.MIN_VALUE, 1.0D).a("1_5", 1.0D, 5.0D).a("5_10", 5.0D, 10.0D).a("10_20", 10.0D, 20.0D).a("20_30", 20.0D, 30.0D).a("30_max", 30.0D, Double.MAX_VALUE));
  private final String[] i;
  private final long[] j;
  private boolean k;
  private long l = -1L;
  private boolean m = false;
  private boolean n = false;
  private boolean o;
  private final String p;
  private final VersionInfoParcel q;
  
  public ae(Context paramContext, VersionInfoParcel paramVersionInfoParcel, String paramString, com.google.android.gms.ads.internal.g.l paraml, j paramj)
  {
    this.f = paramContext;
    this.q = paramVersionInfoParcel;
    this.p = paramString;
    this.b = paraml;
    this.d = paramj;
    paramContext = (String)com.google.android.gms.ads.internal.f.n.cj.a();
    if (paramContext == null)
    {
      this.i = new String[0];
      this.j = new long[0];
      return;
    }
    paramContext = TextUtils.split(paramContext, ",");
    int i1 = paramContext.length;
    this.i = new String[i1];
    this.j = new long[i1];
    i1 = 0;
    while (i1 < paramContext.length) {
      try
      {
        this.j[i1] = Long.parseLong(paramContext[i1]);
        i1 += 1;
      }
      catch (NumberFormatException paramVersionInfoParcel)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.util.e.e("Unable to parse frame hash target time number.", paramVersionInfoParcel);
          this.j[i1] = -1L;
        }
      }
    }
  }
  
  public final void a()
  {
    if ((this.e) && (!this.n))
    {
      com.google.android.gms.ads.internal.g.e.a(this.b, this.d, new String[] { "vfr2" });
      this.n = true;
    }
  }
  
  public final void a(l paraml)
  {
    com.google.android.gms.ads.internal.g.e.a(this.b, this.d, new String[] { "vpc2" });
    this.e = true;
    com.google.android.gms.ads.internal.g.l locall = this.b;
    if (locall != null) {
      locall.a("vpn", paraml.getPlayerName());
    }
    this.c = paraml;
  }
  
  public final void b()
  {
    if ((((Boolean)com.google.android.gms.ads.internal.f.n.ck.a()).booleanValue()) && (!this.o))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("type", "native-player-metrics");
      localBundle.putString("request", this.p);
      localBundle.putString("player", this.c.getPlayerName());
      Object localObject1 = this.h;
      Object localObject2 = new ArrayList(((au)localObject1).d.length);
      int i1 = 0;
      Object localObject3;
      for (;;)
      {
        localObject3 = ((au)localObject1).d;
        if (i1 >= localObject3.length) {
          break;
        }
        localObject3 = localObject3[i1];
        double d1 = localObject1.c[i1];
        double d2 = localObject1.b[i1];
        i2 = localObject1.a[i1];
        ((List)localObject2).add(new av((String)localObject3, d1, d2, i2 / ((au)localObject1).e, i2));
        i1 += 1;
      }
      int i2 = ((List)localObject2).size();
      i1 = 0;
      if (i1 < i2)
      {
        localObject3 = (av)((List)localObject2).get(i1);
        localObject1 = String.valueOf("fps_c_");
        String str = String.valueOf(((av)localObject3).b);
        if (str.length() == 0) {}
        for (localObject1 = new String((String)localObject1);; localObject1 = ((String)localObject1).concat(str))
        {
          localBundle.putString((String)localObject1, Integer.toString(((av)localObject3).a));
          localObject1 = String.valueOf("fps_p_");
          str = String.valueOf(((av)localObject3).b);
          if (str.length() == 0) {}
          for (localObject1 = new String((String)localObject1);; localObject1 = ((String)localObject1).concat(str))
          {
            localBundle.putString((String)localObject1, Double.toString(((av)localObject3).c));
            i1 += 1;
            break;
          }
        }
      }
      i1 = 0;
      for (;;)
      {
        localObject2 = this.j;
        if (i1 >= localObject2.length) {
          break;
        }
        localObject1 = this.i[i1];
        if (localObject1 != null)
        {
          localObject2 = String.valueOf(Long.valueOf(localObject2[i1]));
          localObject3 = new StringBuilder(String.valueOf(localObject2).length() + 3);
          ((StringBuilder)localObject3).append("fh_");
          ((StringBuilder)localObject3).append((String)localObject2);
          localBundle.putString(((StringBuilder)localObject3).toString(), (String)localObject1);
        }
        i1 += 1;
      }
      localObject1 = bt.A.e;
      com.google.android.gms.ads.internal.util.n.a(this.f, this.q.a, "gmob-apps", localBundle, true);
      this.o = true;
    }
  }
  
  public final void b(l paraml)
  {
    if ((this.m) && (!this.g))
    {
      if ((com.google.android.gms.ads.internal.util.e.a()) && (!this.g)) {
        com.google.android.gms.ads.internal.util.e.a("VideoMetricsMixin first frame");
      }
      com.google.android.gms.ads.internal.g.e.a(this.b, this.d, new String[] { "vff2" });
      this.g = true;
    }
    long l1 = bt.A.l.c();
    long l2;
    long l3;
    Object localObject1;
    double d1;
    int i1;
    if ((this.a) && (this.k) && (this.l != -1L))
    {
      l2 = TimeUnit.SECONDS.toNanos(1L);
      l3 = this.l;
      localObject1 = this.h;
      d1 = l2 / (l1 - l3);
      ((au)localObject1).e += 1;
      i1 = 0;
    }
    for (;;)
    {
      Object localObject2 = ((au)localObject1).c;
      if (i1 < localObject2.length)
      {
        double d2 = localObject2[i1];
        if ((d2 <= d1) && (d1 < localObject1.b[i1]))
        {
          localObject2 = ((au)localObject1).a;
          localObject2[i1] += 1;
        }
        if (d2 <= d1) {}
      }
      else
      {
        this.k = this.a;
        this.l = l1;
        l1 = ((Long)com.google.android.gms.ads.internal.f.n.ci.a()).longValue();
        l2 = paraml.getCurrentPosition();
        i1 = 0;
        for (;;)
        {
          localObject1 = this.i;
          int i2;
          if (i1 < localObject1.length)
          {
            if ((localObject1[i1] == null) && (l1 > Math.abs(l2 - this.j[i1])))
            {
              localObject1 = this.i;
              paraml = paraml.getBitmap(8, 8);
              i2 = 0;
              l2 = 0L;
              l1 = 63L;
            }
          }
          else {
            for (;;)
            {
              if (i2 >= 8)
              {
                localObject1[i1] = String.format("%016X", new Object[] { Long.valueOf(l2) });
                return;
              }
              int i3 = 0;
              l3 = l1;
              l1 = l2;
              l2 = l3;
              if (i3 < 8)
              {
                int i4 = paraml.getPixel(i3, i2);
                int i5 = Color.blue(i4);
                int i6 = Color.red(i4);
                if (Color.green(i4) + (i5 + i6) > 128) {}
                for (l3 = 1L;; l3 = 0L)
                {
                  l1 |= l3 << (int)l2;
                  l2 -= 1L;
                  i3 += 1;
                  break;
                }
              }
              i2 += 1;
              l3 = l1;
              l1 = l2;
              l2 = l3;
            }
          }
          i1 += 1;
        }
      }
      i1 += 1;
    }
  }
  
  public final void c()
  {
    this.a = true;
    if ((this.n) && (!this.m))
    {
      com.google.android.gms.ads.internal.g.e.a(this.b, this.d, new String[] { "vfp2" });
      this.m = true;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */