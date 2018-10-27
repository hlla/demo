package com.airbnb.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.v4.g.h;
import android.util.Log;
import com.airbnb.lottie.c.a.c;
import com.airbnb.lottie.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d
  extends a
{
  private final List g = new ArrayList();
  private final RectF h = new RectF();
  private final RectF i = new RectF();
  private final com.airbnb.lottie.a.b.a j;
  
  public d(com.airbnb.lottie.k paramk, g paramg, List paramList, i parami)
  {
    super(paramk, paramg);
    paramg = paramg.s;
    if (paramg != null)
    {
      this.j = paramg.a();
      a(this.j);
      this.j.a(this);
    }
    for (;;)
    {
      h localh = new h(parami.h.size());
      int k = paramList.size() - 1;
      g localg1 = null;
      if (k >= 0)
      {
        g localg2 = (g)paramList.get(k);
        switch (c.b[localg2.e.ordinal()])
        {
        default: 
          paramg = new StringBuilder();
          paramg.append("Unknown layer type ");
          paramg.append(localg2.e);
          Log.w("LOTTIE", paramg.toString());
          paramg = null;
        }
        for (;;)
        {
          if (paramg != null)
          {
            localh.b(paramg.b.c, paramg);
            if (localg1 == null)
            {
              this.g.add(0, paramg);
              switch (e.a[localg2.g.ordinal()])
              {
              default: 
                paramg = localg1;
              }
            }
          }
          for (;;)
          {
            k -= 1;
            localg1 = paramg;
            break;
            continue;
            localg1.d = paramg;
            paramg = null;
            continue;
            paramg = localg1;
          }
          paramg = new n(paramk, localg2);
          continue;
          paramg = new k(paramk, localg2);
          continue;
          paramg = new f(paramk, localg2, parami.c);
          continue;
          paramg = new m(paramk, localg2);
          continue;
          paramg = localg2.k;
          paramg = new d(paramk, localg2, (List)parami.m.get(paramg), parami);
          continue;
          paramg = new l(paramk, localg2);
        }
      }
      k = 0;
      if (k >= localh.a()) {
        break;
      }
      paramk = (a)localh.a(localh.a(k), null);
      paramg = (a)localh.a(paramk.b.h, null);
      if (paramg == null) {}
      for (;;)
      {
        k += 1;
        break;
        paramk.e = paramg;
      }
      this.j = null;
    }
  }
  
  public final void a(float paramFloat)
  {
    super.a(paramFloat);
    if (this.j != null)
    {
      long l = this.c.d.a();
      paramFloat = (float)(((Float)this.j.a()).floatValue() * 1000.0F) / (float)l;
    }
    g localg = this.b;
    float f2 = localg.t;
    float f1 = paramFloat;
    if (f2 != 0.0F) {
      f1 = paramFloat / f2;
    }
    paramFloat = localg.p;
    int k = this.g.size() - 1;
    while (k >= 0)
    {
      ((a)this.g.get(k)).a(f1 - paramFloat);
      k -= 1;
    }
  }
  
  public final void a(RectF paramRectF, Matrix paramMatrix)
  {
    super.a(paramRectF, paramMatrix);
    this.i.set(0.0F, 0.0F, 0.0F, 0.0F);
    int k = this.g.size() - 1;
    if (k >= 0)
    {
      ((a)this.g.get(k)).a(this.i, this.a);
      if (paramRectF.isEmpty()) {
        paramRectF.set(this.i);
      }
      for (;;)
      {
        k -= 1;
        break;
        paramRectF.set(Math.min(paramRectF.left, this.i.left), Math.min(paramRectF.top, this.i.top), Math.max(paramRectF.right, this.i.right), Math.max(paramRectF.bottom, this.i.bottom));
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    int k = 0;
    if (k < this.g.size())
    {
      a locala = (a)this.g.get(k);
      String str = locala.b.d;
      if (paramString1 == null) {
        locala.a(null, null, paramColorFilter);
      }
      for (;;)
      {
        k += 1;
        break;
        if (str.equals(paramString1)) {
          locala.a(paramString1, paramString2, paramColorFilter);
        }
      }
    }
  }
  
  final void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    paramCanvas.save();
    RectF localRectF = this.h;
    g localg = this.b;
    localRectF.set(0.0F, 0.0F, localg.j, localg.i);
    paramMatrix.mapRect(this.h);
    int k = this.g.size() - 1;
    while (k >= 0)
    {
      if ((this.h.isEmpty()) || (paramCanvas.clipRect(this.h))) {
        ((a)this.g.get(k)).a(paramCanvas, paramMatrix, paramInt);
      }
      k -= 1;
    }
    paramCanvas.restore();
    com.airbnb.lottie.d.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */