package android.support.design.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.a.c;
import android.support.design.a.e;
import android.support.design.internal.m;
import android.support.design.internal.p;
import android.support.v4.view.ac;
import android.support.v7.c.a.l;
import android.util.StateSet;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.List;

class b
{
  public static final TimeInterpolator a = android.support.design.a.a.b;
  public static final int[] b = new int[0];
  public static final int[] c;
  public static final int[] d;
  public static final int[] e;
  public static final int[] f;
  public static final int[] g = { 16842919, 16842910 };
  private float A = 1.0F;
  private final android.support.design.internal.k B;
  private final Matrix C = new Matrix();
  private final Rect D = new Rect();
  private final RectF E = new RectF();
  private final RectF F = new RectF();
  public int h = 0;
  public android.support.design.internal.b i;
  public Drawable j;
  public Animator k;
  public e l;
  public e m;
  public float n;
  public e o;
  public float p;
  public int q;
  public ViewTreeObserver.OnPreDrawListener r;
  public float s;
  public Drawable t;
  public float u;
  public android.support.design.f.a v;
  public final android.support.design.f.b w;
  public Drawable x;
  public e y;
  public final p z;
  
  static
  {
    f = new int[] { 16843623, 16842908, 16842910 };
    d = new int[] { 16842908, 16842910 };
    e = new int[] { 16843623, 16842910 };
    c = new int[] { 16842910 };
  }
  
  b(p paramp, android.support.design.f.b paramb)
  {
    this.z = paramp;
    this.w = paramb;
    this.B = new android.support.design.internal.k();
    this.B.a(g, a(new h(this)));
    this.B.a(f, a(new g(this)));
    this.B.a(d, a(new g(this)));
    this.B.a(e, a(new g(this)));
    this.B.a(c, a(new j(this)));
    this.B.a(b, a(new f(this)));
    this.u = this.z.getRotation();
  }
  
  private static ValueAnimator a(k paramk)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(a);
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener(paramk);
    localValueAnimator.addUpdateListener(paramk);
    localValueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
    return localValueAnimator;
  }
  
  private final void a(float paramFloat, Matrix paramMatrix)
  {
    paramMatrix.reset();
    Drawable localDrawable = this.z.getDrawable();
    if ((localDrawable != null) && (this.q != 0))
    {
      RectF localRectF1 = this.E;
      RectF localRectF2 = this.F;
      localRectF1.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      float f1 = this.q;
      localRectF2.set(0.0F, 0.0F, f1, f1);
      paramMatrix.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.CENTER);
      f1 = this.q / 2.0F;
      paramMatrix.postScale(paramFloat, paramFloat, f1, f1);
    }
  }
  
  float a()
  {
    return this.n;
  }
  
  final AnimatorSet a(e parame, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ArrayList localArrayList = new ArrayList();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.z, View.ALPHA, new float[] { paramFloat1 });
    parame.a("opacity").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.z, View.SCALE_X, new float[] { paramFloat2 });
    parame.a("scale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.z, View.SCALE_Y, new float[] { paramFloat2 });
    parame.a("scale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    a(paramFloat3, this.C);
    localObjectAnimator = ObjectAnimator.ofObject(this.z, new c(), new android.support.design.a.d(), new Matrix[] { new Matrix(this.C) });
    parame.a("iconScale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    parame = new AnimatorSet();
    android.support.design.a.b.a(parame, localArrayList);
    return parame;
  }
  
  final android.support.design.internal.b a(int paramInt, ColorStateList paramColorStateList)
  {
    Context localContext = this.z.getContext();
    android.support.design.internal.b localb = g();
    int i1 = android.support.v4.content.d.c(localContext, 2131099778);
    int i2 = android.support.v4.content.d.c(localContext, 2131099777);
    int i3 = android.support.v4.content.d.c(localContext, 2131099775);
    int i4 = android.support.v4.content.d.c(localContext, 2131099776);
    localb.i = i1;
    localb.h = i2;
    localb.c = i3;
    localb.b = i4;
    float f1 = paramInt;
    if (localb.a != f1)
    {
      localb.a = f1;
      localb.e.setStrokeWidth(f1 * 1.3333F);
      localb.d = true;
      localb.invalidateSelf();
    }
    localb.a(paramColorStateList);
    return localb;
  }
  
  final void a(float paramFloat)
  {
    if (this.n != paramFloat)
    {
      this.n = paramFloat;
      a(this.n, this.p, this.s);
    }
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    android.support.design.f.a locala = this.v;
    if (locala != null)
    {
      locala.a(paramFloat1, this.s + paramFloat1);
      e();
    }
  }
  
  void a(ColorStateList paramColorStateList)
  {
    Drawable localDrawable = this.t;
    if (localDrawable != null) {
      android.support.v4.a.a.a.a(localDrawable, android.support.design.e.a.a(paramColorStateList));
    }
  }
  
  void a(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    this.x = android.support.v4.a.a.a.f(h());
    android.support.v4.a.a.a.a(this.x, paramColorStateList1);
    if (paramMode != null) {
      android.support.v4.a.a.a.a(this.x, paramMode);
    }
    this.t = android.support.v4.a.a.a.f(h());
    android.support.v4.a.a.a.a(this.t, android.support.design.e.a.a(paramColorStateList2));
    if (paramInt > 0)
    {
      this.i = a(paramInt, paramColorStateList1);
      paramColorStateList1 = new Drawable[3];
      paramColorStateList1[0] = this.i;
      paramColorStateList1[1] = this.x;
      paramColorStateList1[2] = this.t;
    }
    for (;;)
    {
      this.j = new LayerDrawable(paramColorStateList1);
      paramColorStateList1 = this.z.getContext();
      paramMode = this.j;
      float f1 = this.w.a();
      float f2 = this.n;
      this.v = new android.support.design.f.a(paramColorStateList1, paramMode, f1, f2, this.s + f2);
      paramColorStateList1 = this.v;
      paramColorStateList1.a = false;
      paramColorStateList1.invalidateSelf();
      this.w.a(this.v);
      return;
      this.i = null;
      paramColorStateList1 = new Drawable[2];
      paramColorStateList1[0] = this.x;
      paramColorStateList1[1] = this.t;
    }
  }
  
  void a(Rect paramRect)
  {
    this.v.getPadding(paramRect);
  }
  
  void a(int[] paramArrayOfInt)
  {
    android.support.design.internal.k localk = this.B;
    int i2 = localk.c.size();
    int i1 = 0;
    while (i1 < i2)
    {
      m localm2 = (m)localk.c.get(i1);
      localm1 = localm2;
      if (StateSet.stateSetMatches(localm2.b, paramArrayOfInt)) {
        break label62;
      }
      i1 += 1;
    }
    m localm1 = null;
    label62:
    paramArrayOfInt = localk.a;
    if (localm1 != paramArrayOfInt)
    {
      if (paramArrayOfInt != null)
      {
        paramArrayOfInt = localk.b;
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt.cancel();
          localk.b = null;
        }
      }
      localk.a = localm1;
      if (localm1 != null)
      {
        localk.b = localm1.a;
        localk.b.start();
      }
    }
  }
  
  final void b()
  {
    d(this.A);
  }
  
  final void b(float paramFloat)
  {
    if (this.p != paramFloat)
    {
      this.p = paramFloat;
      a(this.n, this.p, this.s);
    }
  }
  
  void b(Rect paramRect) {}
  
  void c()
  {
    android.support.design.internal.k localk = this.B;
    ValueAnimator localValueAnimator = localk.b;
    if (localValueAnimator != null)
    {
      localValueAnimator.end();
      localk.b = null;
    }
  }
  
  final void c(float paramFloat)
  {
    if (this.s != paramFloat)
    {
      this.s = paramFloat;
      a(this.n, this.p, this.s);
    }
  }
  
  void d() {}
  
  final void d(float paramFloat)
  {
    this.A = paramFloat;
    Matrix localMatrix = this.C;
    a(paramFloat, localMatrix);
    this.z.setImageMatrix(localMatrix);
  }
  
  final void e()
  {
    Rect localRect = this.D;
    a(localRect);
    b(localRect);
    this.w.a(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  boolean f()
  {
    return true;
  }
  
  android.support.design.internal.b g()
  {
    return new android.support.design.internal.b();
  }
  
  final GradientDrawable h()
  {
    GradientDrawable localGradientDrawable = i();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(-1);
    return localGradientDrawable;
  }
  
  GradientDrawable i()
  {
    return new GradientDrawable();
  }
  
  final boolean j()
  {
    return (ac.I(this.z)) && (!this.z.isInEditMode());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/floatingactionbutton/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */