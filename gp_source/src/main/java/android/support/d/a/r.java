package android.support.d.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.Shader;
import android.support.v4.a.d;
import android.support.v4.content.a.b;
import android.support.v4.g.a;
import android.support.v4.g.v;
import java.util.ArrayList;

final class r
{
  public static final Matrix a = new Matrix();
  public float b = 0.0F;
  public float c = 0.0F;
  public Paint d;
  public Boolean e = null;
  public final o f;
  public String g = null;
  public Paint h;
  public final a i = new a();
  public float j = 0.0F;
  public float k = 0.0F;
  private int l;
  private final Matrix m = new Matrix();
  private final Path n;
  private PathMeasure o;
  private final Path p;
  private int q = 255;
  
  public r()
  {
    this.f = new o();
    this.n = new Path();
    this.p = new Path();
  }
  
  public r(r paramr)
  {
    this.f = new o(paramr.f, this.i);
    this.n = new Path(paramr.n);
    this.p = new Path(paramr.p);
    this.c = paramr.c;
    this.b = paramr.b;
    this.k = paramr.k;
    this.j = paramr.j;
    this.l = paramr.l;
    this.q = paramr.q;
    this.g = paramr.g;
    String str = paramr.g;
    if (str != null) {
      this.i.put(str, this);
    }
    this.e = paramr.e;
  }
  
  final void a(o paramo, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
  {
    paramo.j.set(paramMatrix);
    paramo.j.preConcat(paramo.d);
    paramCanvas.save();
    int i1 = 0;
    if (i1 < paramo.b.size())
    {
      paramMatrix = (p)paramo.b.get(i1);
      if ((paramMatrix instanceof o)) {
        a((o)paramMatrix, paramo.j, paramCanvas, paramInt1, paramInt2, paramColorFilter);
      }
      label868:
      label908:
      label930:
      for (;;)
      {
        i1 += 1;
        break;
        if ((paramMatrix instanceof q))
        {
          paramMatrix = (q)paramMatrix;
          float f1 = paramInt1 / this.k;
          float f3 = paramInt2 / this.j;
          float f2 = Math.min(f1, f3);
          Object localObject1 = paramo.j;
          this.m.set((Matrix)localObject1);
          this.m.postScale(f1, f3);
          Object localObject2 = new float[4];
          localObject2[0] = 0.0F;
          localObject2[1] = 1.0F;
          localObject2[2] = 1.0F;
          localObject2[3] = 0.0F;
          ((Matrix)localObject1).mapVectors((float[])localObject2);
          f1 = localObject2[0];
          f3 = localObject2[1];
          double d1 = Math.hypot(f1, f3);
          f1 = localObject2[2];
          f3 = localObject2[3];
          double d2 = Math.hypot(f1, f3);
          f1 = localObject2[0];
          f3 = localObject2[1];
          float f4 = localObject2[2];
          float f5 = localObject2[3];
          float f6 = Math.max((float)d1, (float)d2);
          if (f6 > 0.0F) {}
          for (f1 = Math.abs(f5 * f1 - f3 * f4) / f6;; f1 = 0.0F)
          {
            if (f1 == 0.0F) {
              break label930;
            }
            localObject1 = this.n;
            ((Path)localObject1).reset();
            localObject2 = paramMatrix.o;
            if (localObject2 != null) {
              d.a((d[])localObject2, (Path)localObject1);
            }
            localObject2 = this.n;
            this.p.reset();
            if (paramMatrix.a())
            {
              this.p.addPath((Path)localObject2, this.m);
              paramCanvas.clipPath(this.p);
              break;
            }
            localObject1 = (n)paramMatrix;
            f6 = ((n)localObject1).m;
            if ((f6 != 0.0F) || (((n)localObject1).k != 1.0F))
            {
              f4 = ((n)localObject1).l;
              f5 = ((n)localObject1).k;
              if (this.o == null) {
                this.o = new PathMeasure();
              }
              this.o.setPath(this.n, false);
              f3 = this.o.getLength();
              f6 = (f6 + f4) % 1.0F * f3;
              f4 = (f4 + f5) % 1.0F * f3;
              ((Path)localObject2).reset();
              if (f6 <= f4) {
                break label908;
              }
              this.o.getSegment(f6, f3, (Path)localObject2, true);
              this.o.getSegment(0.0F, f4, (Path)localObject2, true);
            }
            for (;;)
            {
              ((Path)localObject2).rLineTo(0.0F, 0.0F);
              this.p.addPath((Path)localObject2, this.m);
              if (((n)localObject1).b.c())
              {
                paramMatrix = ((n)localObject1).b;
                if (this.d == null)
                {
                  this.d = new Paint(1);
                  this.d.setStyle(Paint.Style.FILL);
                }
                localObject2 = this.d;
                if (paramMatrix.a()) {
                  break label868;
                }
                ((Paint)localObject2).setColor(l.a(paramMatrix.a, ((n)localObject1).a));
              }
              for (;;)
              {
                ((Paint)localObject2).setColorFilter(paramColorFilter);
                Object localObject3 = this.p;
                if (((n)localObject1).c != 0) {}
                for (paramMatrix = Path.FillType.EVEN_ODD;; paramMatrix = Path.FillType.WINDING)
                {
                  ((Path)localObject3).setFillType(paramMatrix);
                  paramCanvas.drawPath(this.p, (Paint)localObject2);
                  if (!((n)localObject1).e.c()) {
                    break;
                  }
                  localObject2 = ((n)localObject1).e;
                  if (this.h == null)
                  {
                    this.h = new Paint(1);
                    this.h.setStyle(Paint.Style.STROKE);
                  }
                  paramMatrix = this.h;
                  localObject3 = ((n)localObject1).g;
                  if (localObject3 != null) {
                    paramMatrix.setStrokeJoin((Paint.Join)localObject3);
                  }
                  localObject3 = ((n)localObject1).f;
                  if (localObject3 != null) {
                    paramMatrix.setStrokeCap((Paint.Cap)localObject3);
                  }
                  paramMatrix.setStrokeMiter(((n)localObject1).h);
                  if (!((b)localObject2).a()) {
                    paramMatrix.setColor(l.a(((b)localObject2).a, ((n)localObject1).d));
                  }
                  for (;;)
                  {
                    paramMatrix.setColorFilter(paramColorFilter);
                    paramMatrix.setStrokeWidth(((n)localObject1).i * (f2 * f1));
                    paramCanvas.drawPath(this.p, paramMatrix);
                    break;
                    localObject2 = ((b)localObject2).b;
                    ((Shader)localObject2).setLocalMatrix(this.m);
                    paramMatrix.setShader((Shader)localObject2);
                    paramMatrix.setAlpha(Math.round(((n)localObject1).d * 255.0F));
                  }
                }
                paramMatrix = paramMatrix.b;
                paramMatrix.setLocalMatrix(this.m);
                ((Paint)localObject2).setShader(paramMatrix);
                ((Paint)localObject2).setAlpha(Math.round(((n)localObject1).a * 255.0F));
              }
              this.o.getSegment(f6, f4, (Path)localObject2, true);
            }
          }
        }
      }
    }
    paramCanvas.restore();
  }
  
  public final float getAlpha()
  {
    return getRootAlpha() / 255.0F;
  }
  
  public final int getRootAlpha()
  {
    return this.q;
  }
  
  public final void setAlpha(float paramFloat)
  {
    setRootAlpha((int)(255.0F * paramFloat));
  }
  
  public final void setRootAlpha(int paramInt)
  {
    this.q = paramInt;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/d/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */