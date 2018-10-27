package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.b;
import com.airbnb.lottie.a.b.q;
import com.airbnb.lottie.c.a.w;
import com.airbnb.lottie.c.b.s;
import com.airbnb.lottie.k;
import java.util.ArrayList;
import java.util.List;

public final class d
  implements e, m, b
{
  private final List a;
  private final k b;
  private final Matrix c = new Matrix();
  private final String d;
  private final Path e = new Path();
  private List f;
  private final RectF g = new RectF();
  private q h;
  
  public d(k paramk, com.airbnb.lottie.c.c.a parama, s params) {}
  
  d(k paramk, com.airbnb.lottie.c.c.a parama, String paramString, List paramList, w paramw)
  {
    this.d = paramString;
    this.b = paramk;
    this.a = paramList;
    if (paramw != null)
    {
      this.h = paramw.a();
      this.h.a(parama);
      this.h.a(this);
    }
    paramk = new ArrayList();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      parama = (c)paramList.get(i);
      if (!(parama instanceof j)) {}
      for (;;)
      {
        i -= 1;
        break;
        paramk.add((j)parama);
      }
    }
    i = paramk.size() - 1;
    while (i >= 0)
    {
      ((j)paramk.get(i)).a(paramList.listIterator(paramList.size()));
      i -= 1;
    }
  }
  
  public final void a()
  {
    this.b.invalidateSelf();
  }
  
  public final void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.c.set(paramMatrix);
    paramMatrix = this.h;
    int i = paramInt;
    if (paramMatrix != null)
    {
      this.c.preConcat(paramMatrix.a());
      i = (int)(((Integer)this.h.b.a()).intValue() / 100.0F * paramInt / 255.0F * 255.0F);
    }
    paramInt = this.a.size() - 1;
    if (paramInt >= 0)
    {
      paramMatrix = this.a.get(paramInt);
      if (!(paramMatrix instanceof e)) {}
      for (;;)
      {
        paramInt -= 1;
        break;
        ((e)paramMatrix).a(paramCanvas, this.c, i);
      }
    }
  }
  
  public final void a(RectF paramRectF, Matrix paramMatrix)
  {
    this.c.set(paramMatrix);
    paramMatrix = this.h;
    if (paramMatrix != null) {
      this.c.preConcat(paramMatrix.a());
    }
    this.g.set(0.0F, 0.0F, 0.0F, 0.0F);
    int i = this.a.size() - 1;
    if (i >= 0)
    {
      paramMatrix = (c)this.a.get(i);
      if ((paramMatrix instanceof e))
      {
        ((e)paramMatrix).a(this.g, this.c);
        if (!paramRectF.isEmpty()) {
          break label116;
        }
        paramRectF.set(this.g);
      }
      for (;;)
      {
        i -= 1;
        break;
        label116:
        paramRectF.set(Math.min(paramRectF.left, this.g.left), Math.min(paramRectF.top, this.g.top), Math.max(paramRectF.right, this.g.right), Math.max(paramRectF.bottom, this.g.bottom));
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    int i = 0;
    if (i < this.a.size())
    {
      c localc = (c)this.a.get(i);
      if (!(localc instanceof e)) {}
      for (;;)
      {
        i += 1;
        break;
        e locale = (e)localc;
        if ((paramString2 == null) || (paramString2.equals(localc.b()))) {
          locale.a(paramString1, null, paramColorFilter);
        } else {
          locale.a(paramString1, paramString2, paramColorFilter);
        }
      }
    }
  }
  
  public final void a(List paramList1, List paramList2)
  {
    paramList2 = new ArrayList(paramList1.size() + this.a.size());
    paramList2.addAll(paramList1);
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      paramList1 = (c)this.a.get(i);
      paramList1.a(paramList2, this.a.subList(0, i));
      paramList2.add(paramList1);
      i -= 1;
    }
  }
  
  public final String b()
  {
    return this.d;
  }
  
  final List c()
  {
    if (this.f == null)
    {
      this.f = new ArrayList();
      int i = 0;
      if (i < this.a.size())
      {
        c localc = (c)this.a.get(i);
        if (!(localc instanceof m)) {}
        for (;;)
        {
          i += 1;
          break;
          this.f.add((m)localc);
        }
      }
    }
    return this.f;
  }
  
  final Matrix d()
  {
    q localq = this.h;
    if (localq != null) {
      return localq.a();
    }
    this.c.reset();
    return this.c;
  }
  
  public final Path e()
  {
    this.c.reset();
    Object localObject = this.h;
    if (localObject != null) {
      this.c.set(((q)localObject).a());
    }
    this.e.reset();
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      localObject = (c)this.a.get(i);
      if ((localObject instanceof m)) {
        this.e.addPath(((m)localObject).e(), this.c);
      }
      i -= 1;
    }
    return this.e;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */