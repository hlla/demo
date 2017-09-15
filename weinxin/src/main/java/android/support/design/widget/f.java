package android.support.design.widget;

import android.content.Context;
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
import android.support.design.a.i;
import android.support.v4.d.d;
import android.support.v4.d.e;
import android.support.v4.view.z;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;

final class f
{
  private static final boolean fG;
  private static final Paint fH;
  private boolean fI;
  float fJ;
  private final Rect fK;
  private final Rect fL;
  private final RectF fM;
  private int fN = 16;
  private int fO = 16;
  float fP = 15.0F;
  float fQ = 15.0F;
  int fR;
  int fS;
  private float fT;
  private float fU;
  private float fV;
  private float fW;
  private float fX;
  private float fY;
  Typeface fZ;
  Typeface ga;
  private Typeface gb;
  private CharSequence gc;
  private boolean gd;
  private boolean ge;
  private Bitmap gf;
  private Paint gg;
  private float gh;
  private float gi;
  private float gj;
  private float gk;
  private boolean gl;
  private final TextPaint gm;
  Interpolator gn;
  private Interpolator go;
  private float gp;
  private float gq;
  private float gr;
  private int gs;
  private float gt;
  private float gu;
  private float gv;
  private int gw;
  CharSequence mText;
  private final View mView;
  
  static
  {
    if (Build.VERSION.SDK_INT < 18) {}
    for (boolean bool = true;; bool = false)
    {
      fG = bool;
      fH = null;
      return;
    }
  }
  
  public f(View paramView)
  {
    this.mView = paramView;
    this.gm = new TextPaint(129);
    this.fL = new Rect();
    this.fK = new Rect();
    this.fM = new RectF();
  }
  
  private void L()
  {
    if ((this.fL.width() > 0) && (this.fL.height() > 0) && (this.fK.width() > 0) && (this.fK.height() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.fI = bool;
      return;
    }
  }
  
  private void M()
  {
    f(this.fJ);
  }
  
  private void O()
  {
    if (this.gf != null)
    {
      this.gf.recycle();
      this.gf = null;
    }
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, Interpolator paramInterpolator)
  {
    float f = paramFloat3;
    if (paramInterpolator != null) {
      f = paramInterpolator.getInterpolation(paramFloat3);
    }
    return a.b(paramFloat1, paramFloat2, f);
  }
  
  private static boolean a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramRect.left == paramInt1) && (paramRect.top == paramInt2) && (paramRect.right == paramInt3) && (paramRect.bottom == paramInt4);
  }
  
  private static int b(int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = 1.0F - paramFloat;
    float f2 = Color.alpha(paramInt1);
    float f3 = Color.alpha(paramInt2);
    float f4 = Color.red(paramInt1);
    float f5 = Color.red(paramInt2);
    float f6 = Color.green(paramInt1);
    float f7 = Color.green(paramInt2);
    float f8 = Color.blue(paramInt1);
    float f9 = Color.blue(paramInt2);
    return Color.argb((int)(f2 * f1 + f3 * paramFloat), (int)(f4 * f1 + f5 * paramFloat), (int)(f6 * f1 + f7 * paramFloat), (int)(f1 * f8 + f9 * paramFloat));
  }
  
  private static boolean c(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 0.001F;
  }
  
  private void f(float paramFloat)
  {
    this.fM.left = a(this.fK.left, this.fL.left, paramFloat, this.gn);
    this.fM.top = a(this.fT, this.fU, paramFloat, this.gn);
    this.fM.right = a(this.fK.right, this.fL.right, paramFloat, this.gn);
    this.fM.bottom = a(this.fK.bottom, this.fL.bottom, paramFloat, this.gn);
    this.fX = a(this.fV, this.fW, paramFloat, this.gn);
    this.fY = a(this.fT, this.fU, paramFloat, this.gn);
    g(a(this.fP, this.fQ, paramFloat, this.go));
    if (this.fS != this.fR) {
      this.gm.setColor(b(this.fR, this.fS, paramFloat));
    }
    for (;;)
    {
      this.gm.setShadowLayer(a(this.gt, this.gp, paramFloat, null), a(this.gu, this.gq, paramFloat, null), a(this.gv, this.gr, paramFloat, null), b(this.gw, this.gs, paramFloat));
      z.F(this.mView);
      return;
      this.gm.setColor(this.fS);
    }
  }
  
  private void g(float paramFloat)
  {
    h(paramFloat);
    boolean bool;
    if ((fG) && (this.gj != 1.0F))
    {
      bool = true;
      this.ge = bool;
      if ((this.ge) && (this.gf == null) && (!this.fK.isEmpty()) && (!TextUtils.isEmpty(this.gc))) {
        break label77;
      }
    }
    for (;;)
    {
      z.F(this.mView);
      return;
      bool = false;
      break;
      label77:
      f(0.0F);
      this.gh = this.gm.ascent();
      this.gi = this.gm.descent();
      int i = Math.round(this.gm.measureText(this.gc, 0, this.gc.length()));
      int j = Math.round(this.gi - this.gh);
      if ((i > 0) && (j > 0))
      {
        this.gf = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        new Canvas(this.gf).drawText(this.gc, 0, this.gc.length(), 0.0F, j - this.gm.descent(), this.gm);
        if (this.gg == null) {
          this.gg = new Paint(3);
        }
      }
    }
  }
  
  private void h(float paramFloat)
  {
    int k = 1;
    if (this.mText == null) {
      return;
    }
    float f1;
    int i;
    if (c(paramFloat, this.fQ))
    {
      f1 = this.fL.width();
      paramFloat = this.fQ;
      this.gj = 1.0F;
      if (this.gb == this.fZ) {
        break label362;
      }
      this.gb = this.fZ;
      i = 1;
    }
    for (;;)
    {
      int j = i;
      label97:
      Object localObject;
      boolean bool;
      label164:
      label227:
      label237:
      float f2;
      if (f1 > 0.0F)
      {
        if ((this.gk != paramFloat) || (this.gl) || (i != 0))
        {
          i = 1;
          this.gk = paramFloat;
          this.gl = false;
          j = i;
        }
      }
      else
      {
        if ((this.gc != null) && (j == 0)) {
          break;
        }
        this.gm.setTextSize(this.gk);
        this.gm.setTypeface(this.gb);
        localObject = this.gm;
        if (this.gj == 1.0F) {
          break label336;
        }
        bool = true;
        ((TextPaint)localObject).setLinearText(bool);
        localObject = TextUtils.ellipsize(this.mText, this.gm, f1, TextUtils.TruncateAt.END);
        if (TextUtils.equals((CharSequence)localObject, this.gc)) {
          break;
        }
        this.gc = ((CharSequence)localObject);
        CharSequence localCharSequence = this.gc;
        if (z.J(this.mView) != 1) {
          break label342;
        }
        i = k;
        if (i == 0) {
          break label348;
        }
        localObject = e.vB;
        this.gd = ((d)localObject).a(localCharSequence, localCharSequence.length());
        return;
        f1 = this.fK.width();
        f2 = this.fP;
        if (this.gb == this.ga) {
          break label356;
        }
        this.gb = this.ga;
      }
      label336:
      label342:
      label348:
      label356:
      for (i = 1;; i = 0)
      {
        if (c(paramFloat, this.fP))
        {
          this.gj = 1.0F;
          paramFloat = f2;
          break;
        }
        this.gj = (paramFloat / this.fP);
        paramFloat = f2;
        break;
        i = 0;
        break label97;
        bool = false;
        break label164;
        i = 0;
        break label227;
        localObject = e.vA;
        break label237;
      }
      label362:
      i = 0;
    }
  }
  
  private Typeface q(int paramInt)
  {
    TypedArray localTypedArray = this.mView.getContext().obtainStyledAttributes(paramInt, new int[] { 16843692 });
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
  
  public final void N()
  {
    int j = 1;
    float f2 = 0.0F;
    float f3;
    float f1;
    int i;
    if ((this.mView.getHeight() > 0) && (this.mView.getWidth() > 0))
    {
      f3 = this.gk;
      h(this.fQ);
      if (this.gc == null) {
        break label402;
      }
      f1 = this.gm.measureText(this.gc, 0, this.gc.length());
      int k = this.fO;
      if (!this.gd) {
        break label407;
      }
      i = 1;
      label83:
      i = android.support.v4.view.f.getAbsoluteGravity(k, i);
      switch (i & 0x70)
      {
      default: 
        this.fU = ((this.gm.descent() - this.gm.ascent()) / 2.0F - this.gm.descent() + this.fL.centerY());
        label162:
        switch (i & 0x800007)
        {
        default: 
          this.fW = this.fL.left;
          label208:
          h(this.fP);
          f1 = f2;
          if (this.gc != null) {
            f1 = this.gm.measureText(this.gc, 0, this.gc.length());
          }
          k = this.fN;
          if (this.gd)
          {
            i = j;
            label264:
            i = android.support.v4.view.f.getAbsoluteGravity(k, i);
            switch (i & 0x70)
            {
            default: 
              this.fT = ((this.gm.descent() - this.gm.ascent()) / 2.0F - this.gm.descent() + this.fK.centerY());
              label342:
              switch (i & 0x800007)
              {
              default: 
                this.fV = this.fK.left;
              }
              break;
            }
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      O();
      g(f3);
      M();
      return;
      label402:
      f1 = 0.0F;
      break;
      label407:
      i = 0;
      break label83;
      this.fU = this.fL.bottom;
      break label162;
      this.fU = (this.fL.top - this.gm.ascent());
      break label162;
      this.fW = (this.fL.centerX() - f1 / 2.0F);
      break label208;
      this.fW = (this.fL.right - f1);
      break label208;
      i = 0;
      break label264;
      this.fT = this.fK.bottom;
      break label342;
      this.fT = (this.fK.top - this.gm.ascent());
      break label342;
      this.fV = (this.fK.centerX() - f1 / 2.0F);
      continue;
      this.fV = (this.fK.right - f1);
    }
  }
  
  final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a(this.fK, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.fK.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.gl = true;
      L();
    }
  }
  
  final void a(Interpolator paramInterpolator)
  {
    this.go = paramInterpolator;
    N();
  }
  
  final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a(this.fL, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.fL.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.gl = true;
      L();
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    int j = paramCanvas.save();
    float f4;
    int i;
    float f1;
    label64:
    float f2;
    if ((this.gc != null) && (this.fI))
    {
      f4 = this.fX;
      float f3 = this.fY;
      if ((!this.ge) || (this.gf == null)) {
        break label128;
      }
      i = 1;
      if (i == 0) {
        break label134;
      }
      f1 = this.gh * this.gj;
      f2 = f3;
      if (i != 0) {
        f2 = f3 + f1;
      }
      if (this.gj != 1.0F) {
        paramCanvas.scale(this.gj, this.gj, f4, f2);
      }
      if (i == 0) {
        break label155;
      }
      paramCanvas.drawBitmap(this.gf, f4, f2, this.gg);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(j);
      return;
      label128:
      i = 0;
      break;
      label134:
      this.gm.ascent();
      f1 = 0.0F;
      this.gm.descent();
      break label64;
      label155:
      paramCanvas.drawText(this.gc, 0, this.gc.length(), f4, f2, this.gm);
    }
  }
  
  final void e(float paramFloat)
  {
    float f;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    for (;;)
    {
      if (f != this.fJ)
      {
        this.fJ = f;
        M();
      }
      return;
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
    }
  }
  
  final void l(int paramInt)
  {
    if (this.fS != paramInt)
    {
      this.fS = paramInt;
      N();
    }
  }
  
  final void m(int paramInt)
  {
    if (this.fN != paramInt)
    {
      this.fN = paramInt;
      N();
    }
  }
  
  final void n(int paramInt)
  {
    if (this.fO != paramInt)
    {
      this.fO = paramInt;
      N();
    }
  }
  
  final void o(int paramInt)
  {
    TypedArray localTypedArray = this.mView.getContext().obtainStyledAttributes(paramInt, a.i.dk);
    if (localTypedArray.hasValue(a.i.dp)) {
      this.fS = localTypedArray.getColor(a.i.dp, this.fS);
    }
    if (localTypedArray.hasValue(a.i.dq)) {
      this.fQ = localTypedArray.getDimensionPixelSize(a.i.dq, (int)this.fQ);
    }
    this.gs = localTypedArray.getInt(a.i.dl, 0);
    this.gq = localTypedArray.getFloat(a.i.dm, 0.0F);
    this.gr = localTypedArray.getFloat(a.i.dn, 0.0F);
    this.gp = localTypedArray.getFloat(a.i.do, 0.0F);
    localTypedArray.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.fZ = q(paramInt);
    }
    N();
  }
  
  final void p(int paramInt)
  {
    TypedArray localTypedArray = this.mView.getContext().obtainStyledAttributes(paramInt, a.i.dk);
    if (localTypedArray.hasValue(a.i.dp)) {
      this.fR = localTypedArray.getColor(a.i.dp, this.fR);
    }
    if (localTypedArray.hasValue(a.i.dq)) {
      this.fP = localTypedArray.getDimensionPixelSize(a.i.dq, (int)this.fP);
    }
    this.gw = localTypedArray.getInt(a.i.dl, 0);
    this.gu = localTypedArray.getFloat(a.i.dm, 0.0F);
    this.gv = localTypedArray.getFloat(a.i.dn, 0.0F);
    this.gt = localTypedArray.getFloat(a.i.do, 0.0F);
    localTypedArray.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.ga = q(paramInt);
    }
    N();
  }
  
  final void setText(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (!paramCharSequence.equals(this.mText)))
    {
      this.mText = paramCharSequence;
      this.gc = null;
      O();
      N();
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */