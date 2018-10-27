package com.airbnb.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.v4.g.w;
import com.airbnb.lottie.a.b.q;
import com.airbnb.lottie.c.a.c;
import com.airbnb.lottie.c.a.t;
import com.airbnb.lottie.c.a.v;
import com.airbnb.lottie.c.b.s;
import com.airbnb.lottie.c.f;
import com.airbnb.lottie.d.h;
import com.airbnb.lottie.i;
import com.airbnb.lottie.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class n
  extends a
{
  private com.airbnb.lottie.a.b.a g;
  private final i h;
  private final Map i = new HashMap();
  private final Paint j = new o();
  private final k k;
  private final Matrix l = new Matrix();
  private final RectF m = new RectF();
  private com.airbnb.lottie.a.b.a n;
  private final Paint o = new p();
  private com.airbnb.lottie.a.b.a p;
  private final char[] q = new char[1];
  private final com.airbnb.lottie.a.b.p r;
  private com.airbnb.lottie.a.b.a s;
  
  n(k paramk, g paramg)
  {
    super(paramk, paramg);
    this.k = paramk;
    this.h = paramg.a;
    this.r = ((com.airbnb.lottie.a.b.p)paramg.q.a());
    this.r.a(this);
    a(this.r);
    paramk = paramg.r;
    if (paramk != null)
    {
      paramg = paramk.a;
      if (paramg != null)
      {
        this.g = paramg.a();
        this.g.a(this);
        a(this.g);
      }
    }
    if (paramk != null)
    {
      paramg = paramk.b;
      if (paramg != null)
      {
        this.n = paramg.a();
        this.n.a(this);
        a(this.n);
      }
    }
    if (paramk != null)
    {
      paramg = paramk.c;
      if (paramg != null)
      {
        this.p = paramg.a();
        this.p.a(this);
        a(this.p);
      }
    }
    if (paramk != null)
    {
      paramk = paramk.d;
      if (paramk != null)
      {
        this.s = paramk.a();
        this.s.a(this);
        a(this.s);
      }
    }
  }
  
  private static void a(Path paramPath, Paint paramPaint, Canvas paramCanvas)
  {
    if ((paramPaint.getColor() != 0) && ((paramPaint.getStyle() != Paint.Style.STROKE) || (paramPaint.getStrokeWidth() != 0.0F))) {
      paramCanvas.drawPath(paramPath, paramPaint);
    }
  }
  
  private static void a(char[] paramArrayOfChar, Paint paramPaint, Canvas paramCanvas)
  {
    if ((paramPaint.getColor() != 0) && ((paramPaint.getStyle() != Paint.Style.STROKE) || (paramPaint.getStrokeWidth() != 0.0F))) {
      paramCanvas.drawText(paramArrayOfChar, 0, 1, 0.0F, 0.0F, paramPaint);
    }
  }
  
  final void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    paramCanvas.save();
    if (!this.k.c()) {
      paramCanvas.setMatrix(paramMatrix);
    }
    com.airbnb.lottie.c.d locald = (com.airbnb.lottie.c.d)this.r.a();
    Object localObject2 = (f)this.h.e.get(locald.b);
    if (localObject2 == null)
    {
      paramCanvas.restore();
      return;
    }
    Object localObject1 = this.g;
    if (localObject1 != null) {
      this.j.setColor(((Integer)((com.airbnb.lottie.a.b.a)localObject1).a()).intValue());
    }
    for (;;)
    {
      localObject1 = this.n;
      if (localObject1 != null) {
        this.o.setColor(((Integer)((com.airbnb.lottie.a.b.a)localObject1).a()).intValue());
      }
      for (;;)
      {
        paramInt = ((Integer)this.f.b.a()).intValue() * 255 / 100;
        this.j.setAlpha(paramInt);
        this.o.setAlpha(paramInt);
        localObject1 = this.p;
        if (localObject1 != null) {
          this.o.setStrokeWidth(((Float)((com.airbnb.lottie.a.b.a)localObject1).a()).floatValue());
        }
        for (;;)
        {
          float f3;
          if (this.k.c())
          {
            f2 = locald.c / 100.0F;
            f3 = h.a(paramMatrix);
            str = locald.g;
            paramInt = 0;
            while (paramInt < str.length())
            {
              int i2 = com.airbnb.lottie.c.g.a(str.charAt(paramInt), ((f)localObject2).a, ((f)localObject2).c);
              localObject3 = (com.airbnb.lottie.c.g)this.h.b.a(i2, null);
              if (localObject3 == null)
              {
                paramInt += 1;
              }
              else
              {
                if (this.i.containsKey(localObject3)) {
                  localObject1 = (List)this.i.get(localObject3);
                }
                for (;;)
                {
                  i2 = 0;
                  if (i2 < ((List)localObject1).size())
                  {
                    localObject4 = ((com.airbnb.lottie.a.a.d)((List)localObject1).get(i2)).e();
                    ((Path)localObject4).computeBounds(this.m, false);
                    this.l.set(paramMatrix);
                    this.l.preScale(f2, f2);
                    ((Path)localObject4).transform(this.l);
                    if (locald.e)
                    {
                      a((Path)localObject4, this.j, paramCanvas);
                      a((Path)localObject4, this.o, paramCanvas);
                    }
                    for (;;)
                    {
                      i2 += 1;
                      break;
                      a((Path)localObject4, this.o, paramCanvas);
                      a((Path)localObject4, this.j, paramCanvas);
                    }
                  }
                  float f4 = (float)((com.airbnb.lottie.c.g)localObject3).b;
                  float f5 = this.h.c;
                  f1 = locald.h / 10.0F;
                  localObject1 = this.s;
                  if (localObject1 != null) {
                    f1 = ((Float)((com.airbnb.lottie.a.b.a)localObject1).a()).floatValue() + f1;
                  }
                  for (;;)
                  {
                    paramCanvas.translate(f1 * f3 + f4 * f2 * f5 * f3, 0.0F);
                    break;
                  }
                  Object localObject4 = ((com.airbnb.lottie.c.g)localObject3).a;
                  int i3 = ((List)localObject4).size();
                  localObject1 = new ArrayList(i3);
                  i2 = 0;
                  while (i2 < i3)
                  {
                    s locals = (s)((List)localObject4).get(i2);
                    ((List)localObject1).add(new com.airbnb.lottie.a.a.d(this.k, this, locals));
                    i2 += 1;
                  }
                  this.i.put(localObject3, localObject1);
                }
              }
            }
            paramCanvas.restore();
            return;
          }
          float f2 = h.a(paramMatrix);
          paramMatrix = this.k;
          String str = ((f)localObject2).a;
          Object localObject3 = ((f)localObject2).c;
          if (paramMatrix.getCallback() != null) {
            if (paramMatrix.h == null) {
              paramMatrix.h = new com.airbnb.lottie.b.a(paramMatrix.getCallback(), paramMatrix.g);
            }
          }
          for (localObject2 = paramMatrix.h;; localObject2 = null)
          {
            boolean bool2;
            if (localObject2 != null)
            {
              paramMatrix = ((com.airbnb.lottie.b.a)localObject2).f;
              paramMatrix.a = str;
              paramMatrix.b = localObject3;
              localObject1 = (Typeface)((com.airbnb.lottie.b.a)localObject2).e.get(paramMatrix);
              paramMatrix = (Matrix)localObject1;
              if (localObject1 == null)
              {
                localObject1 = (Typeface)((com.airbnb.lottie.b.a)localObject2).d.get(str);
                paramMatrix = (Matrix)localObject1;
                if (localObject1 == null)
                {
                  paramMatrix = ((com.airbnb.lottie.b.a)localObject2).c;
                  if (paramMatrix != null) {
                    break label1261;
                  }
                  if (paramMatrix != null) {
                    break label1269;
                  }
                  paramMatrix = new StringBuilder();
                  paramMatrix.append("fonts/");
                  paramMatrix.append(str);
                  paramMatrix.append(((com.airbnb.lottie.b.a)localObject2).b);
                  paramMatrix = paramMatrix.toString();
                  paramMatrix = Typeface.createFromAsset(((com.airbnb.lottie.b.a)localObject2).a, paramMatrix);
                  ((com.airbnb.lottie.b.a)localObject2).d.put(str, paramMatrix);
                }
                boolean bool1 = ((String)localObject3).contains("Italic");
                bool2 = ((String)localObject3).contains("Bold");
                if (bool1) {
                  break label1177;
                }
                label873:
                if (!bool1) {
                  break label1162;
                }
                paramInt = 2;
                label880:
                localObject1 = paramMatrix;
                if (paramMatrix.getStyle() != paramInt) {
                  localObject1 = Typeface.create(paramMatrix, paramInt);
                }
                ((com.airbnb.lottie.b.a)localObject2).e.put(((com.airbnb.lottie.b.a)localObject2).f, localObject1);
              }
            }
            for (paramMatrix = (Matrix)localObject1;; paramMatrix = null)
            {
              if (paramMatrix == null) {
                break label1190;
              }
              localObject1 = locald.g;
              if (this.k.o != null) {
                break label1277;
              }
              this.j.setTypeface(paramMatrix);
              this.j.setTextSize(locald.c * this.h.c);
              this.o.setTypeface(this.j.getTypeface());
              this.o.setTextSize(this.j.getTextSize());
              paramInt = 0;
              label1001:
              int i1;
              if (paramInt < ((String)localObject1).length())
              {
                i1 = ((String)localObject1).charAt(paramInt);
                paramMatrix = this.q;
                paramMatrix[0] = i1;
                if (!locald.e) {
                  break label1138;
                }
                a(paramMatrix, this.j, paramCanvas);
                a(this.q, this.o, paramCanvas);
              }
              for (;;)
              {
                paramMatrix = this.q;
                paramMatrix[0] = i1;
                f3 = this.j.measureText(paramMatrix, 0, 1);
                f1 = locald.h / 10.0F;
                paramMatrix = this.s;
                if (paramMatrix != null) {
                  f1 = ((Float)paramMatrix.a()).floatValue() + f1;
                }
                for (;;)
                {
                  paramCanvas.translate(f1 * f2 + f3, 0.0F);
                  paramInt += 1;
                  break label1001;
                  break;
                }
                label1138:
                a(paramMatrix, this.o, paramCanvas);
                a(this.q, this.j, paramCanvas);
              }
              label1162:
              if (bool2)
              {
                paramInt = 1;
                break label880;
              }
              paramInt = 0;
              break label880;
              label1177:
              if (!bool2) {
                break label873;
              }
              paramInt = 3;
              break label880;
            }
            label1190:
            break;
          }
          float f1 = h.a(paramMatrix);
          this.o.setStrokeWidth(f1 * (locald.f * this.h.c));
        }
        this.o.setColor(locald.d);
      }
      this.j.setColor(locald.a);
    }
    label1261:
    throw new NoSuchMethodError();
    label1269:
    throw new NoSuchMethodError();
    label1277:
    throw new NoSuchMethodError();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/c/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */