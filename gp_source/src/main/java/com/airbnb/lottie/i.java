package com.airbnb.lottie;

import android.graphics.Rect;
import android.support.v4.g.w;
import android.util.Log;
import com.airbnb.lottie.c.c.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class i
{
  public final Rect a;
  public final w b = new w();
  public final float c;
  public final long d;
  public final Map e = new HashMap();
  public final Map f = new HashMap();
  public final android.support.v4.g.h g = new android.support.v4.g.h();
  public final List h = new ArrayList();
  public final int i;
  public final int j;
  public final int k;
  public final t l = new t();
  public final Map m = new HashMap();
  public final long n;
  private final float o;
  private final HashSet p = new HashSet();
  
  i(Rect paramRect, long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramRect;
    this.n = paramLong1;
    this.d = paramLong2;
    this.o = paramFloat1;
    this.c = paramFloat2;
    this.i = paramInt1;
    this.j = paramInt2;
    this.k = paramInt3;
    if (!com.airbnb.lottie.d.h.a(this, 5)) {
      a("Lottie only supports bodymovin >= 4.5.0");
    }
  }
  
  public final long a()
  {
    return ((float)(this.d - this.n) / this.o * 1000.0F);
  }
  
  public final g a(long paramLong)
  {
    return (g)this.g.a(paramLong, null);
  }
  
  public final void a(String paramString)
  {
    Log.w("LOTTIE", paramString);
    this.p.add(paramString);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.l.a = paramBoolean;
  }
  
  public final float b()
  {
    return (float)a() * this.o / 1000.0F;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LottieComposition:\n");
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((g)localIterator.next()).a("\t"));
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */