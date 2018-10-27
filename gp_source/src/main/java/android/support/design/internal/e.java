package android.support.design.internal;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.v4.f.f;
import android.support.v4.view.ac;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;

public final class e
{
  private static final boolean D;
  public Paint A;
  public boolean B;
  public final View C;
  private float E;
  private float F;
  private int G = 16;
  private final RectF H;
  private float I;
  private Typeface J;
  private float K;
  private float L;
  private Typeface M;
  private boolean N;
  private float O;
  private final TextPaint P;
  public boolean a;
  public final Rect b;
  public int c;
  public float d;
  public float e;
  public float f;
  public ColorStateList g;
  public float h = 15.0F;
  public Typeface i;
  public float j;
  public float k;
  public boolean l;
  public final Rect m;
  public float n;
  public ColorStateList o;
  public int p = 16;
  public float q = 15.0F;
  public Bitmap r;
  public TimeInterpolator s;
  public float t;
  public int[] u;
  public CharSequence v;
  public final TextPaint w;
  public TimeInterpolator x;
  public CharSequence y;
  public float z;
  
  static
  {
    if (Build.VERSION.SDK_INT < 18) {}
    for (boolean bool = true;; bool = false)
    {
      D = bool;
      return;
    }
  }
  
  public e(View paramView)
  {
    this.C = paramView;
    this.w = new TextPaint(129);
    this.P = new TextPaint(this.w);
    this.b = new Rect();
    this.m = new Rect();
    this.H = new RectF();
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, TimeInterpolator paramTimeInterpolator)
  {
    float f1 = paramFloat3;
    if (paramTimeInterpolator != null) {
      f1 = paramTimeInterpolator.getInterpolation(paramFloat3);
    }
    return android.support.design.a.a.a(paramFloat1, paramFloat2, f1);
  }
  
  private static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = 1.0F - paramFloat;
    return Color.argb((int)(Color.alpha(paramInt1) * f1 + Color.alpha(paramInt2) * paramFloat), (int)(Color.red(paramInt1) * f1 + Color.red(paramInt2) * paramFloat), (int)(Color.green(paramInt1) * f1 + Color.green(paramInt2) * paramFloat), (int)(f1 * Color.blue(paramInt1) + Color.blue(paramInt2) * paramFloat));
  }
  
  private final void a(TextPaint paramTextPaint)
  {
    paramTextPaint.setTextSize(this.h);
    paramTextPaint.setTypeface(this.i);
  }
  
  private static boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 0.001F;
  }
  
  public static boolean a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramRect.left == paramInt1) && (paramRect.top == paramInt2) && (paramRect.right == paramInt3) && (paramRect.bottom == paramInt4);
  }
  
  private final void b(float paramFloat)
  {
    this.H.left = a(this.m.left, this.b.left, paramFloat, this.s);
    this.H.top = a(this.L, this.F, paramFloat, this.s);
    this.H.right = a(this.m.right, this.b.right, paramFloat, this.s);
    this.H.bottom = a(this.m.bottom, this.b.bottom, paramFloat, this.s);
    this.j = a(this.K, this.E, paramFloat, this.s);
    this.k = a(this.L, this.F, paramFloat, this.s);
    c(a(this.q, this.h, paramFloat, this.x));
    Object localObject = this.g;
    ColorStateList localColorStateList = this.o;
    int i1;
    if (localObject != localColorStateList)
    {
      localObject = this.w;
      int[] arrayOfInt = this.u;
      if (arrayOfInt != null)
      {
        i1 = localColorStateList.getColorForState(arrayOfInt, 0);
        ((TextPaint)localObject).setColor(a(i1, g(), paramFloat));
      }
    }
    for (;;)
    {
      this.w.setShadowLayer(a(0.0F, this.f, paramFloat, null), a(0.0F, this.d, paramFloat, null), a(0.0F, this.e, paramFloat, null), a(0, this.c, paramFloat));
      ac.e(this.C);
      return;
      i1 = localColorStateList.getDefaultColor();
      break;
      this.w.setColor(g());
    }
  }
  
  private final void c(float paramFloat)
  {
    d(paramFloat);
    boolean bool;
    if (D) {
      if (this.t != 1.0F) {
        bool = true;
      }
    }
    for (;;)
    {
      this.B = bool;
      if ((this.B) && (this.r == null) && (!this.m.isEmpty()) && (!TextUtils.isEmpty(this.y)))
      {
        b(0.0F);
        this.z = this.w.ascent();
        this.O = this.w.descent();
        Object localObject = this.w;
        CharSequence localCharSequence = this.y;
        int i1 = Math.round(((TextPaint)localObject).measureText(localCharSequence, 0, localCharSequence.length()));
        int i2 = Math.round(this.O - this.z);
        if ((i1 > 0) && (i2 > 0))
        {
          this.r = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
          localObject = new Canvas(this.r);
          localCharSequence = this.y;
          ((Canvas)localObject).drawText(localCharSequence, 0, localCharSequence.length(), 0.0F, i2 - this.w.descent(), this.w);
          if (this.A == null) {
            this.A = new Paint(3);
          }
        }
      }
      ac.e(this.C);
      return;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  private final void d(float paramFloat)
  {
    boolean bool = true;
    float f2;
    float f3;
    if (this.v != null)
    {
      f2 = this.b.width();
      f3 = this.m.width();
      if (!a(paramFloat, this.h)) {
        break label268;
      }
      f1 = this.h;
      this.t = 1.0F;
      localObject = this.J;
      localTypeface = this.i;
      if (localObject == localTypeface) {
        break label260;
      }
      this.J = localTypeface;
      i1 = 1;
    }
    for (paramFloat = f2;; paramFloat = f2)
    {
      int i2 = i1;
      if (paramFloat > 0.0F)
      {
        if (this.I != f1) {
          break label254;
        }
        if (!this.a) {
          break label237;
        }
        i1 = 1;
      }
      for (;;)
      {
        this.I = f1;
        this.a = false;
        i2 = i1;
        if (this.y == null) {}
        for (;;)
        {
          this.w.setTextSize(this.I);
          this.w.setTypeface(this.J);
          localObject = this.w;
          if (this.t != 1.0F)
          {
            ((TextPaint)localObject).setLinearText(bool);
            localObject = TextUtils.ellipsize(this.v, this.w, paramFloat, TextUtils.TruncateAt.END);
            if (!TextUtils.equals((CharSequence)localObject, this.y))
            {
              this.y = ((CharSequence)localObject);
              this.N = a(this.y);
            }
          }
          do
          {
            return;
            bool = false;
            break;
          } while (i2 == 0);
        }
        label237:
        if (i1 == 0)
        {
          i1 = 0;
        }
        else
        {
          i1 = 1;
          continue;
          label254:
          i1 = 1;
        }
      }
      label260:
      i1 = 0;
    }
    label268:
    float f1 = this.q;
    Object localObject = this.J;
    Typeface localTypeface = this.M;
    if (localObject != localTypeface) {
      this.J = localTypeface;
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (a(paramFloat, f1)) {}
      for (this.t = 1.0F;; this.t = (paramFloat / this.q))
      {
        paramFloat = this.h / this.q;
        if (f3 * paramFloat > f2)
        {
          paramFloat = Math.min(f2 / paramFloat, f3);
          break;
        }
        paramFloat = f3;
        break;
      }
    }
  }
  
  private final void f()
  {
    b(this.n);
  }
  
  private final int g()
  {
    int[] arrayOfInt = this.u;
    if (arrayOfInt != null) {
      return this.g.getColorForState(arrayOfInt, 0);
    }
    return this.g.getDefaultColor();
  }
  
  public final float a()
  {
    if (this.v != null)
    {
      a(this.P);
      TextPaint localTextPaint = this.P;
      CharSequence localCharSequence = this.v;
      return localTextPaint.measureText(localCharSequence, 0, localCharSequence.length());
    }
    return 0.0F;
  }
  
  public final void a(float paramFloat)
  {
    paramFloat = android.support.v4.d.a.a(paramFloat);
    if (paramFloat != this.n)
    {
      this.n = paramFloat;
      f();
    }
  }
  
  public final void a(int paramInt)
  {
    if (this.G != paramInt)
    {
      this.G = paramInt;
      d();
    }
  }
  
  public final void a(ColorStateList paramColorStateList)
  {
    if (this.g != paramColorStateList)
    {
      this.g = paramColorStateList;
      d();
    }
  }
  
  public final void a(Typeface paramTypeface)
  {
    this.M = paramTypeface;
    this.i = paramTypeface;
    d();
  }
  
  public final boolean a(CharSequence paramCharSequence)
  {
    if (ac.h(this.C) == 1) {}
    for (android.support.v4.f.e locale = f.b;; locale = f.a) {
      return locale.a(paramCharSequence, paramCharSequence.length());
    }
  }
  
  public final float b()
  {
    a(this.P);
    return -this.P.ascent();
  }
  
  public final Typeface b(int paramInt)
  {
    TypedArray localTypedArray = this.C.getContext().obtainStyledAttributes(paramInt, new int[] { 16843692 });
    try
    {
      Object localObject1 = localTypedArray.getString(0);
      if (localObject1 != null)
      {
        localObject1 = Typeface.create((String)localObject1, 0);
        return (Typeface)localObject1;
      }
      return null;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
  
  public final void b(ColorStateList paramColorStateList)
  {
    if (this.o != paramColorStateList)
    {
      this.o = paramColorStateList;
      d();
    }
  }
  
  public final void c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.b.width() > 0)
    {
      bool1 = bool2;
      if (this.b.height() > 0)
      {
        bool1 = bool2;
        if (this.m.width() > 0)
        {
          bool1 = bool2;
          if (this.m.height() > 0) {
            bool1 = true;
          }
        }
      }
    }
    this.l = bool1;
  }
  
  public final void d()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public final void e()
  {
    Bitmap localBitmap = this.r;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.r = null;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */