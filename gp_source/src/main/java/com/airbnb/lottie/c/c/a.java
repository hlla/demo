package com.airbnb.lottie.c.c;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.airbnb.lottie.a.a.e;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.a.b.q;
import com.airbnb.lottie.c.a.w;
import com.airbnb.lottie.d.f;
import com.airbnb.lottie.i;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t;
import com.airbnb.lottie.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class a
  implements e, com.airbnb.lottie.a.b.b
{
  public final Matrix a = new Matrix();
  public final g b;
  public final k c;
  public a d;
  public a e;
  public final q f;
  private final List g = new ArrayList();
  private final Paint h = new Paint();
  private final Paint i = new Paint(1);
  private com.airbnb.lottie.a.b.h j;
  private final RectF k = new RectF();
  private final Paint l = new Paint(1);
  private final Matrix m = new Matrix();
  private final RectF n = new RectF();
  private final Paint o = new Paint(1);
  private List p;
  private final Path q = new Path();
  private final RectF r = new RectF();
  private final RectF s = new RectF();
  private boolean t = true;
  
  a(k paramk, g paramg)
  {
    this.c = paramk;
    this.b = paramg;
    paramk = new StringBuilder();
    paramk.append(paramg.d);
    paramk.append("#draw");
    this.h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    if (paramg.g == j.b) {
      this.o.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }
    for (;;)
    {
      this.f = paramg.u.a();
      this.f.a(this);
      this.f.a(this);
      paramk = paramg.f;
      if (paramk == null) {}
      for (;;)
      {
        if (!this.b.b.isEmpty())
        {
          paramk = new com.airbnb.lottie.a.b.d(this.b.b);
          paramk.a = true;
          paramk.a(new b(this, paramk));
          if (((Float)paramk.a()).floatValue() == 1.0F) {}
          for (boolean bool = true;; bool = false)
          {
            a(bool);
            a(paramk);
            return;
          }
        }
        a(true);
        return;
        if (!paramk.isEmpty())
        {
          this.j = new com.airbnb.lottie.a.b.h(paramg.f);
          paramk = this.j.a.iterator();
          while (paramk.hasNext())
          {
            paramg = (com.airbnb.lottie.a.b.a)paramk.next();
            a(paramg);
            paramg.a(this);
          }
          paramk = this.j.c.iterator();
          while (paramk.hasNext())
          {
            paramg = (com.airbnb.lottie.a.b.a)paramk.next();
            a(paramg);
            paramg.a(this);
          }
        }
      }
      this.o.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }
  }
  
  private final void a(Canvas paramCanvas)
  {
    paramCanvas.drawRect(this.r.left - 1.0F, -1.0F + this.r.top, this.r.right + 1.0F, 1.0F + this.r.bottom, this.h);
    com.airbnb.lottie.d.a();
  }
  
  private final void b(float paramFloat)
  {
    t localt = this.c.d.l;
    String str = this.b.d;
    if (localt.a)
    {
      f localf = (f)localt.c.get(str);
      Object localObject = localf;
      if (localf == null)
      {
        localObject = new f();
        localt.c.put(str, localObject);
      }
      ((f)localObject).b += paramFloat;
      ((f)localObject).a += 1;
      int i1 = ((f)localObject).a;
      if (i1 == Integer.MAX_VALUE)
      {
        ((f)localObject).b /= 2.0F;
        ((f)localObject).a = (i1 / 2);
      }
      if (str.equals("root"))
      {
        localObject = localt.b.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((v)((Iterator)localObject).next()).a();
        }
      }
    }
  }
  
  private final boolean c()
  {
    return this.d != null;
  }
  
  private final boolean d()
  {
    com.airbnb.lottie.a.b.h localh = this.j;
    return (localh != null) && (!localh.a.isEmpty());
  }
  
  public final void a()
  {
    this.c.invalidateSelf();
  }
  
  void a(float paramFloat)
  {
    float f2 = this.b.t;
    float f1 = paramFloat;
    if (f2 != 0.0F) {
      f1 = paramFloat / f2;
    }
    a locala = this.d;
    int i1;
    if (locala != null)
    {
      locala.a(f1);
      i1 = 0;
    }
    while (i1 < this.g.size())
    {
      ((com.airbnb.lottie.a.b.a)this.g.get(i1)).a(f1);
      i1 += 1;
      continue;
      i1 = 0;
    }
  }
  
  @SuppressLint({"WrongConstant"})
  public final void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    if (!this.t)
    {
      com.airbnb.lottie.d.a();
      return;
    }
    if (this.p == null)
    {
      if (this.e != null) {
        break label1073;
      }
      this.p = Collections.emptyList();
    }
    for (;;)
    {
      this.m.reset();
      this.m.set(paramMatrix);
      int i1 = this.p.size() - 1;
      for (;;)
      {
        if (i1 < 0)
        {
          com.airbnb.lottie.d.a();
          float f1 = paramInt / 255.0F;
          i1 = (int)(((Integer)this.f.b.a()).intValue() * f1 / 100.0F * 255.0F);
          if ((!c()) && (!d()))
          {
            this.m.preConcat(this.f.a());
            b(paramCanvas, this.m, i1);
            com.airbnb.lottie.d.a();
            b(com.airbnb.lottie.d.a());
            return;
          }
          this.r.set(0.0F, 0.0F, 0.0F, 0.0F);
          a(this.r, this.m);
          localObject1 = this.r;
          Object localObject2 = this.m;
          if ((c()) && (this.b.g != j.b))
          {
            this.d.a(this.n, (Matrix)localObject2);
            ((RectF)localObject1).set(Math.max(((RectF)localObject1).left, this.n.left), Math.max(((RectF)localObject1).top, this.n.top), Math.min(((RectF)localObject1).right, this.n.right), Math.min(((RectF)localObject1).bottom, this.n.bottom));
          }
          this.m.preConcat(this.f.a());
          localObject1 = this.r;
          localObject2 = this.m;
          this.k.set(0.0F, 0.0F, 0.0F, 0.0F);
          int i2;
          Object localObject3;
          if (d())
          {
            i2 = this.j.b.size();
            paramInt = 0;
            if (paramInt < i2)
            {
              localObject3 = (com.airbnb.lottie.c.b.h)this.j.b.get(paramInt);
              Path localPath = (Path)((com.airbnb.lottie.a.b.a)this.j.a.get(paramInt)).a();
              this.q.set(localPath);
              this.q.transform((Matrix)localObject2);
            }
            switch (c.a[localObject3.a.ordinal()])
            {
            default: 
              this.q.computeBounds(this.s, false);
              if (paramInt == 0) {
                this.k.set(this.s);
              }
              for (;;)
              {
                paramInt += 1;
                break;
                localObject3 = this.k;
                ((RectF)localObject3).set(Math.min(((RectF)localObject3).left, this.s.left), Math.min(this.k.top, this.s.top), Math.max(this.k.right, this.s.right), Math.max(this.k.bottom, this.s.bottom));
              }
              ((RectF)localObject1).set(Math.max(((RectF)localObject1).left, this.k.left), Math.max(((RectF)localObject1).top, this.k.top), Math.min(((RectF)localObject1).right, this.k.right), Math.min(((RectF)localObject1).bottom, this.k.bottom));
            }
          }
          this.r.set(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight());
          com.airbnb.lottie.d.a();
          paramCanvas.saveLayer(this.r, this.i, 31);
          com.airbnb.lottie.d.a();
          a(paramCanvas);
          b(paramCanvas, this.m, i1);
          com.airbnb.lottie.d.a();
          if (d())
          {
            localObject1 = this.m;
            paramCanvas.saveLayer(this.r, this.l, 19);
            com.airbnb.lottie.d.a();
            a(paramCanvas);
            i2 = this.j.b.size();
            paramInt = 0;
            if (paramInt < i2)
            {
              localObject2 = (com.airbnb.lottie.c.b.h)this.j.b.get(paramInt);
              localObject3 = (Path)((com.airbnb.lottie.a.b.a)this.j.a.get(paramInt)).a();
              this.q.set((Path)localObject3);
              this.q.transform((Matrix)localObject1);
              switch (c.a[localObject2.a.ordinal()])
              {
              default: 
                this.q.setFillType(Path.FillType.WINDING);
              }
              for (;;)
              {
                localObject2 = (com.airbnb.lottie.a.b.a)this.j.c.get(paramInt);
                int i3 = this.i.getAlpha();
                this.i.setAlpha((int)(((Integer)((com.airbnb.lottie.a.b.a)localObject2).a()).intValue() * 2.55F));
                paramCanvas.drawPath(this.q, this.i);
                this.i.setAlpha(i3);
                paramInt += 1;
                break;
                this.q.setFillType(Path.FillType.INVERSE_WINDING);
              }
            }
            paramCanvas.restore();
            com.airbnb.lottie.d.a();
            com.airbnb.lottie.d.a();
          }
          if (c())
          {
            paramCanvas.saveLayer(this.r, this.o, 19);
            com.airbnb.lottie.d.a();
            a(paramCanvas);
            this.d.a(paramCanvas, paramMatrix, i1);
            paramCanvas.restore();
            com.airbnb.lottie.d.a();
            com.airbnb.lottie.d.a();
          }
          paramCanvas.restore();
          com.airbnb.lottie.d.a();
          b(com.airbnb.lottie.d.a());
          return;
        }
        this.m.preConcat(((a)this.p.get(i1)).f.a());
        i1 -= 1;
      }
      label1073:
      this.p = new ArrayList();
      for (Object localObject1 = this.e; localObject1 != null; localObject1 = ((a)localObject1).e) {
        this.p.add(localObject1);
      }
    }
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    this.a.set(paramMatrix);
    this.a.preConcat(this.f.a());
  }
  
  public final void a(com.airbnb.lottie.a.b.a parama)
  {
    if (!(parama instanceof o)) {
      this.g.add(parama);
    }
  }
  
  public void a(String paramString1, String paramString2, ColorFilter paramColorFilter) {}
  
  public final void a(List paramList1, List paramList2) {}
  
  final void a(boolean paramBoolean)
  {
    if (paramBoolean != this.t)
    {
      this.t = paramBoolean;
      this.c.invalidateSelf();
    }
  }
  
  public final String b()
  {
    return this.b.d;
  }
  
  abstract void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt);
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */