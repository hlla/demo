package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.b;
import com.airbnb.lottie.c.a.c;
import com.airbnb.lottie.c.a.w;
import com.airbnb.lottie.c.b.o;
import com.airbnb.lottie.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public final class q
  implements e, j, m, b
{
  private d a;
  private final com.airbnb.lottie.a.b.a b;
  private final com.airbnb.lottie.c.c.a c;
  private final k d;
  private final Matrix e = new Matrix();
  private final String f;
  private final com.airbnb.lottie.a.b.a g;
  private final Path h = new Path();
  private final com.airbnb.lottie.a.b.q i;
  
  public q(k paramk, com.airbnb.lottie.c.c.a parama, o paramo)
  {
    this.d = paramk;
    this.c = parama;
    this.f = paramo.b;
    this.b = paramo.a.a();
    parama.a(this.b);
    this.b.a(this);
    this.g = paramo.c.a();
    parama.a(this.g);
    this.g.a(this);
    this.i = paramo.d.a();
    this.i.a(parama);
    this.i.a(this);
  }
  
  public final void a()
  {
    this.d.invalidateSelf();
  }
  
  public final void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    float f1 = ((Float)this.b.a()).floatValue();
    float f2 = ((Float)this.g.a()).floatValue();
    float f3 = ((Float)this.i.c.a()).floatValue() / 100.0F;
    float f4 = ((Float)this.i.a.a()).floatValue() / 100.0F;
    int j = (int)f1 - 1;
    while (j >= 0)
    {
      this.e.set(paramMatrix);
      float f5 = j;
      this.e.preConcat(this.i.a(f5 + f2));
      d locald = this.a;
      Matrix localMatrix = this.e;
      float f6 = paramInt;
      locald.a(paramCanvas, localMatrix, (int)((f5 / f1 * (f4 - f3) + f3) * f6));
      j -= 1;
    }
  }
  
  public final void a(RectF paramRectF, Matrix paramMatrix)
  {
    this.a.a(paramRectF, paramMatrix);
  }
  
  public final void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    this.a.a(paramString1, paramString2, paramColorFilter);
  }
  
  public final void a(List paramList1, List paramList2)
  {
    this.a.a(paramList1, paramList2);
  }
  
  public final void a(ListIterator paramListIterator)
  {
    if (this.a == null)
    {
      while ((paramListIterator.hasPrevious()) && (paramListIterator.previous() != this)) {}
      ArrayList localArrayList = new ArrayList();
      while (paramListIterator.hasPrevious())
      {
        localArrayList.add(paramListIterator.previous());
        paramListIterator.remove();
      }
      Collections.reverse(localArrayList);
      this.a = new d(this.d, this.c, "Repeater", localArrayList, null);
    }
  }
  
  public final String b()
  {
    return this.f;
  }
  
  public final Path e()
  {
    Path localPath = this.a.e();
    this.h.reset();
    float f1 = ((Float)this.b.a()).floatValue();
    float f2 = ((Float)this.g.a()).floatValue();
    int j = (int)f1 - 1;
    while (j >= 0)
    {
      this.e.set(this.i.a(j + f2));
      this.h.addPath(localPath, this.e);
      j -= 1;
    }
    return this.h;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/a/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */